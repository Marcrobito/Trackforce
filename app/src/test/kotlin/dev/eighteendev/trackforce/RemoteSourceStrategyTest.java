package dev.eighteendev.trackforce;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockedStatic;

import dev.eighteendev.trackforce.common.Location;
import dev.eighteendev.trackforce.common.LocationProvider;
import dev.eighteendev.trackforce.data.network.OpenWeatherApi;
import dev.eighteendev.trackforce.data.network.dto.WeeklyWeatherDto;
import dev.eighteendev.trackforce.data.source.RemoteSourceStrategy;
import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

import io.reactivex.rxjava3.core.Single;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.Assert.*;

public class RemoteSourceStrategyTest {

    @Mock
    private OpenWeatherApi api;

    @Mock
    private LocationProvider locationProvider;

    private RemoteSourceStrategy remoteSourceStrategy;

    private WeeklyWeatherDto mockDto;
    private WeeklyWeather expectedWeather;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        remoteSourceStrategy = new RemoteSourceStrategy(api, locationProvider);

        mockDto = Mockito.mock(WeeklyWeatherDto.class);
        expectedWeather = Mockito.mock(WeeklyWeather.class);
    }

    @Test
    public void getWeeklyWeather_success() {
        // Arrange
        Location mockLocation = new Location(10.0, 20.0);

        Mockito.when(locationProvider.getLastKnownLocation())
                .thenReturn(Single.just(mockLocation));

        Mockito.when(api.getWeatherByCoordinates(anyDouble(), anyDouble(), anyString(), anyString()))
                .thenReturn(Single.just(mockDto));

        try (MockedStatic<dev.eighteendev.trackforce.data.mappers.dto.WeeklyWeatherDtoMapper> mockedMapper =
                     Mockito.mockStatic(dev.eighteendev.trackforce.data.mappers.dto.WeeklyWeatherDtoMapper.class)) {

            mockedMapper.when(() -> dev.eighteendev.trackforce.data.mappers.dto.WeeklyWeatherDtoMapper.toDomain(mockDto))
                    .thenReturn(expectedWeather);

            // Act & Assert
            remoteSourceStrategy.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
                @Override
                public void onSuccess(WeeklyWeather result) {
                    assertEquals(expectedWeather, result);
                }

                @Override
                public void onError(Throwable error) {
                    fail("Should not reach onError: " + error.getMessage());
                }
            });
        }
    }

    @Test
    public void getWeeklyWeather_locationFails_shouldReturnError() {
        // Arrange
        Throwable expectedError = new RuntimeException("Location error");

        Mockito.when(locationProvider.getLastKnownLocation())
                .thenReturn(Single.error(expectedError));

        // Act & Assert
        remoteSourceStrategy.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
            @Override
            public void onSuccess(WeeklyWeather result) {
                fail("Should not succeed");
            }

            @Override
            public void onError(Throwable error) {
                assertEquals(expectedError, error);
            }
        });
    }

    @Test
    public void getWeeklyWeather_apiFails_shouldReturnError() {
        // Arrange
        Location mockLocation = new Location(10.0, 20.0);
        Throwable expectedError = new RuntimeException("API fail");

        Mockito.when(locationProvider.getLastKnownLocation())
                .thenReturn(Single.just(mockLocation));

        Mockito.when(api.getWeatherByCoordinates(anyDouble(), anyDouble(), anyString(), anyString()))
                .thenReturn(Single.error(expectedError));

        // Act & Assert
        remoteSourceStrategy.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
            @Override
            public void onSuccess(WeeklyWeather result) {
                fail("Should not succeed");
            }

            @Override
            public void onError(Throwable error) {
                assertEquals(expectedError, error);
            }
        });
    }
}