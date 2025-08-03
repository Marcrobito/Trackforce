package dev.eighteendev.trackforce.data.mappers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.eighteendev.trackforce.data.room.entities.WeatherEntity;
import dev.eighteendev.trackforce.domain.model.Weather;

/**
 * Mapper class for converting {@link Weather} domain models to {@link WeatherEntity} database entities.
 * <p>
 * This class is responsible for mapping weather condition details (e.g., main weather type, description, icon)
 * from the domain layer to the corresponding Room database entity structure.
 */
public class WeatherMapper {

    /**
     * Converts a {@link Weather} domain model to a {@link WeatherEntity}.
     *
     * @param weather the {@link Weather} domain model containing weather condition details.
     * @return a {@link WeatherEntity} representing the database entity of the given weather condition.
     */
    public static WeatherEntity toEntity(Weather weather) {
        return new WeatherEntity(weather.getId(), weather.getMainWeather(), weather.getMainWeather(), weather.getIcon());
    }

    /**
     * Converts a list of {@link Weather} domain models to a list of {@link WeatherEntity} entities.
     *
     * @param weatherlList the list of {@link Weather} domain models.
     * @return a list of {@link WeatherEntity} objects mapped from the given domain models.
     *         Returns an empty list if the input is {@code null}.
     */
    public static List<WeatherEntity> toEntity(List<Weather> weatherlList){
        if (weatherlList == null) return new ArrayList<>();

        return weatherlList.stream()
                .map(WeatherMapper::toEntity)
                .collect(Collectors.toList());
    }
}