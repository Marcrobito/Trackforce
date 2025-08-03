package dev.eighteendev.trackforce.domain.repository;

import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

/**
 * Repository interface that provides weather-related data operations.
 *
 * This repository abstracts the data source (remote, local, etc.) and provides
 * an asynchronous method to fetch the weekly weather forecast.
 */
public interface WeatherRepository {

    /**
     * Retrieves the weekly weather forecast.
     *
     * @return An {@link AsyncResult} containing a {@link WeeklyWeather} object with the forecast data.
     */
    AsyncResult<WeeklyWeather> getWeeklyWeather();
}