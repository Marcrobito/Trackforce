package dev.eighteendev.trackforce.domain.strategy;

import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

/**
 * Strategy interface for providing weather data from different sources.
 *
 * Implementations of this interface define how the weekly weather forecast is obtained,
 * whether from a remote API, a local database, or any other source.
 */
public interface WeatherSourceStrategy {

    /**
     * Retrieves the weekly weather forecast from the corresponding data source.
     *
     * @return An {@link AsyncResult} containing a {@link WeeklyWeather} object with the forecast data.
     */
    AsyncResult<WeeklyWeather> getWeeklyWeather();
}