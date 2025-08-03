package dev.eighteendev.trackforce.data.mappers.entity;

import dev.eighteendev.trackforce.data.room.entities.WeatherDurationEntity;
import dev.eighteendev.trackforce.domain.model.WeatherDuration;

/**
 * Mapper class for converting {@link WeatherDurationEntity} database entities to {@link WeatherDuration} domain models.
 * <p>
 * This class is responsible for transforming duration-based weather forecast data from the persistence layer into domain models.
 */
public class WeatherDurationEntityMapper {

    /**
     * Maps a {@link WeatherDurationEntity} object to a {@link WeatherDuration} domain model.
     *
     * @param entity the {@link WeatherDurationEntity} containing forecast duration data from the database.
     * @return a {@link WeatherDuration} domain model.
     */
    public static WeatherDuration toDomain(WeatherDurationEntity entity){
        return new WeatherDuration(entity.getThreeHoursForecast());
    }
}