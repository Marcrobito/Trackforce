package dev.eighteendev.trackforce.data.network;

import dev.eighteendev.trackforce.data.network.dto.WeeklyWeatherDto;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit API interface for OpenWeatherMap forecast endpoints.
 * <p>
 * Defines the HTTP requests and parameters used to fetch weather forecast data.
 */
public interface OpenWeatherApi {

    /**
     * Retrieves the 5-day weather forecast in 3-hour intervals for the specified coordinates.
     * <p>
     * This method calls the "forecast" endpoint of the OpenWeatherMap API and returns
     * the weather data wrapped in a {@link Single} RxJava observable.
     *
     * @param latitude the latitude of the location.
     * @param longitude the longitude of the location.
     * @param apiKey the API key required for authenticating the request.
     * @param units the measurement units for temperature ("metric", "imperial", etc.).
     * @return a {@link Single} emitting a {@link WeeklyWeatherDto} with forecast data.
     */
    @GET("forecast")
    Single<WeeklyWeatherDto> getWeatherByCoordinates(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("appid") String apiKey,
            @Query("units") String units
    );
}