package dev.eighteendev.trackforce.data.source;

import dev.eighteendev.trackforce.common.LocationProvider;
import dev.eighteendev.trackforce.data.RxSingleAsyncResultImpl;
import dev.eighteendev.trackforce.data.mappers.dto.WeeklyWeatherDtoMapper;
import dev.eighteendev.trackforce.data.network.OpenWeatherApi;
import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;
import dev.eighteendev.trackforce.domain.strategy.WeatherSourceStrategy;

/**
 * Remote data source strategy for fetching weather information from the OpenWeather API.
 * <p>
 * Implements {@link WeatherSourceStrategy} to retrieve fresh weather data based on the device's current location.
 * This class interacts with {@link OpenWeatherApi} and {@link LocationProvider} to fetch and map weather data.
 */
public class RemoteSourceStrategy implements WeatherSourceStrategy {

    private static final String UNIT = "metric";
    private static final String API_KEY = "7b9aa400c440b38cad31484d15f1f52f"; // API key for OpenWeather API

    private final OpenWeatherApi api;
    private final LocationProvider locationProvider;

    /**
     * Constructs a {@link RemoteSourceStrategy} with the given API interface and location provider.
     *
     * @param api              the {@link OpenWeatherApi} for making network requests.
     * @param locationProvider the {@link LocationProvider} to retrieve the device's last known location.
     */
    public RemoteSourceStrategy(OpenWeatherApi api, LocationProvider locationProvider) {
        this.api = api;
        this.locationProvider = locationProvider;
    }

    /**
     * Retrieves weekly weather data from the OpenWeather API based on the device's last known location.
     * <p>
     * The method first obtains the location, then performs an API request, maps the response to the domain model,
     * and returns it wrapped in an {@link AsyncResult}. Logs errors if network requests fail.
     *
     * @return an {@link AsyncResult} emitting the {@link WeeklyWeather} data.
     */
    @Override
    public AsyncResult<WeeklyWeather> getWeeklyWeather() {
        return new RxSingleAsyncResultImpl<>(
                locationProvider.getLastKnownLocation()
                        .flatMap(location -> api.getWeatherByCoordinates(
                                location.getLatitude(),
                                location.getLongitude(),
                                API_KEY,
                                UNIT
                        ))
                        .map(WeeklyWeatherDtoMapper::toDomain)
                        .doOnError(error -> android.util.Log.e("RemoteSource", "Error fetching weather data", error))
        );
    }
}