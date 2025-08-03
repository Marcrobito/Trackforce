package dev.eighteendev.trackforce;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import dev.eighteendev.trackforce.data.repository.WeatherRepositoryImpl;
import dev.eighteendev.trackforce.domain.NetworkStatusChecker;
import dev.eighteendev.trackforce.domain.WeeklyWeatherLocalDataSource;
import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;
import dev.eighteendev.trackforce.domain.strategy.WeatherSourceStrategy;

@RunWith(MockitoJUnitRunner.class)
public class WeatherRepositoryImplTest {

    @Mock
    private WeatherSourceStrategy remoteSource;

    @Mock
    private WeatherSourceStrategy localSource;

    @Mock
    private NetworkStatusChecker networkChecker;

    @Mock
    private WeeklyWeatherLocalDataSource dataSource;

    @Mock
    private WeeklyWeather dummyWeather;

    private WeatherRepositoryImpl repository;

    @Before
    public void setup() {
        repository = new WeatherRepositoryImpl(localSource, remoteSource, networkChecker, dataSource);
    }

    @Test
    public void whenOnlineAndRemoteSuccess_shouldReturnRemoteResultAndCache() {
        Mockito.when(networkChecker.isOnline()).thenReturn(true);

        AsyncResult<WeeklyWeather> remoteResult = callback -> callback.onSuccess(dummyWeather);

        Mockito.when(remoteSource.getWeeklyWeather()).thenReturn(remoteResult);

        repository.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
            @Override
            public void onSuccess(WeeklyWeather result) {
                Assert.assertEquals(dummyWeather, result);
                Mockito.verify(dataSource).cacheWeeklyWeather(dummyWeather);
            }

            @Override
            public void onError(Throwable error) {
                Assert.fail("Should not reach onError");
            }
        });
    }

    @Test
    public void whenRemoteFailsLocalSuccess_shouldReturnLocalResult() {
        Mockito.when(networkChecker.isOnline()).thenReturn(true);

        AsyncResult<WeeklyWeather> remoteResult = callback -> callback.onError(new RuntimeException("Remote fail"));
        AsyncResult<WeeklyWeather> localResult = callback -> callback.onSuccess(dummyWeather);

        Mockito.when(remoteSource.getWeeklyWeather()).thenReturn(remoteResult);
        Mockito.when(localSource.getWeeklyWeather()).thenReturn(localResult);

        repository.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
            @Override
            public void onSuccess(WeeklyWeather result) {
                Assert.assertEquals(dummyWeather, result);
            }

            @Override
            public void onError(Throwable error) {
                Assert.fail("Should not reach onError");
            }
        });
    }

    @Test
    public void whenRemoteAndLocalFail_shouldReturnError() {
        Mockito.when(networkChecker.isOnline()).thenReturn(true);

        AsyncResult<WeeklyWeather> remoteResult = callback -> callback.onError(new RuntimeException("Remote fail"));
        AsyncResult<WeeklyWeather> localResult = callback -> callback.onError(new RuntimeException("Local fail"));

        Mockito.when(remoteSource.getWeeklyWeather()).thenReturn(remoteResult);
        Mockito.when(localSource.getWeeklyWeather()).thenReturn(localResult);

        repository.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
            @Override
            public void onSuccess(WeeklyWeather result) {
                Assert.fail("Should not reach onSuccess");
            }

            @Override
            public void onError(Throwable error) {
                Assert.assertEquals("Local fail", error.getMessage());
            }
        });
    }

    @Test
    public void whenOfflineAndLocalSuccess_shouldReturnLocalResult() {
        Mockito.when(networkChecker.isOnline()).thenReturn(false);

        AsyncResult<WeeklyWeather> localResult = callback -> callback.onSuccess(dummyWeather);

        Mockito.when(localSource.getWeeklyWeather()).thenReturn(localResult);

        repository.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
            @Override
            public void onSuccess(WeeklyWeather result) {
                Assert.assertEquals(dummyWeather, result);
            }

            @Override
            public void onError(Throwable error) {
                Assert.fail("Should not reach onError");
            }
        });
    }

    @Test
    public void whenOfflineAndLocalFails_shouldReturnError() {
        Mockito.when(networkChecker.isOnline()).thenReturn(false);

        AsyncResult<WeeklyWeather> localResult = callback -> callback.onError(new RuntimeException("Local fail"));

        Mockito.when(localSource.getWeeklyWeather()).thenReturn(localResult);

        repository.getWeeklyWeather().subscribe(new AsyncResult.Callback<>() {
            @Override
            public void onSuccess(WeeklyWeather result) {
                Assert.fail("Should not reach onSuccess");
            }

            @Override
            public void onError(Throwable error) {
                Assert.assertEquals("Local fail", error.getMessage());
            }
        });
    }
}