package dev.eighteendev.trackforce.domain;

import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

/**
 * Interface for caching weekly weather data locally.
 * <p>
 * Implementations of this interface should handle storing the provided
 * {@link WeeklyWeather} instance in a local data source, such as a database or in-memory cache.
 */
public interface WeeklyWeatherLocalDataSource {

    /**
     * Caches the given {@link WeeklyWeather} data locally.
     *
     * @param weather the weekly weather data to be cached.
     */
    void cacheWeeklyWeather(WeeklyWeather weather);
}