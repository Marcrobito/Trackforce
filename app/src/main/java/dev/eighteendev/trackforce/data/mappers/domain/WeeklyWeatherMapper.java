package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.WeeklyWeatherEntity;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

/**
 * Mapper class for converting {@link WeeklyWeather} domain models to {@link WeeklyWeatherEntity} database entities.
 * <p>
 * This class is responsible for transforming weekly weather forecast data from the domain layer
 * into the corresponding Room database entity representation for local storage.
 */
public class WeeklyWeatherMapper {

    /**
     * Converts a {@link WeeklyWeather} domain model to a {@link WeeklyWeatherEntity}.
     *
     * @param weeklyWeather the {@link WeeklyWeather} domain model containing weekly forecast details.
     * @return a {@link WeeklyWeatherEntity} representing the database entity of the given weekly weather data.
     */
    public static WeeklyWeatherEntity toEntity(WeeklyWeather weeklyWeather) {
        return new WeeklyWeatherEntity(
                weeklyWeather.getResponseStatus(),
                weeklyWeather.getMessage(),
                weeklyWeather.getResultCount(),
                WeatherDetailMapper.toEntity(weeklyWeather.getWeekWeather()),
                CityMapper.toEntity(weeklyWeather.getCity())
        );
    }

}