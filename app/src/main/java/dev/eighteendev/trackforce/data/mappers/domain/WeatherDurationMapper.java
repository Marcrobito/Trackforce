package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.WeatherDurationEntity;
import dev.eighteendev.trackforce.domain.model.WeatherDuration;

/**
 * Mapper class for converting {@link WeatherDuration} domain models to {@link WeatherDurationEntity} database entities.
 * <p>
 * This class is responsible for mapping precipitation duration data (e.g., rain or snow forecasts over a 3-hour period)
 * from the domain layer to the corresponding Room entity structure.
 */
public class WeatherDurationMapper {

    /**
     * Converts a {@link WeatherDuration} domain model to a {@link WeatherDurationEntity}.
     *
     * @param weatherDuration the {@link WeatherDuration} domain model containing precipitation duration data.
     * @return a {@link WeatherDurationEntity} representing the database entity of the given duration.
     *         Returns {@code null} if the input is {@code null}.
     */
    public static WeatherDurationEntity toEntity(WeatherDuration weatherDuration){
        if (weatherDuration == null) return null;
        return new WeatherDurationEntity(weatherDuration.getThreeHoursForecast());
    }
}