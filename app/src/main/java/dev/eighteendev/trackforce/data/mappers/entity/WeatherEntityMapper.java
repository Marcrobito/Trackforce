package dev.eighteendev.trackforce.data.mappers.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.eighteendev.trackforce.data.room.entities.WeatherEntity;
import dev.eighteendev.trackforce.domain.model.Weather;

/**
 * Mapper class for converting {@link WeatherEntity} database entities to {@link Weather} domain models.
 * <p>
 * This class is responsible for transforming weather condition data from the persistence layer into domain models.
 */
public class WeatherEntityMapper {

    /**
     * Maps a single {@link WeatherEntity} object to a {@link Weather} domain model.
     *
     * @param entity the {@link WeatherEntity} containing weather condition data from the database.
     * @return a {@link Weather} domain model.
     */
    public static Weather toDomain(WeatherEntity entity){
        return new Weather(entity.getId(), entity.getMainWeather(), entity.getDescription(), entity.getIcon());
    }

    /**
     * Maps a list of {@link WeatherEntity} objects to a list of {@link Weather} domain models.
     * <p>
     * If the input list is null, returns an empty list.
     *
     * @param entityList the list of {@link WeatherEntity} objects to be mapped.
     * @return a list of {@link Weather} domain models.
     */
    public static List<Weather> toDomain(List<WeatherEntity> entityList){
        if (entityList == null) return new ArrayList<>();
        return entityList.stream().map(WeatherEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}