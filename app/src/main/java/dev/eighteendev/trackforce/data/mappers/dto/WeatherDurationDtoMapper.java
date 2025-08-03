package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.WeatherDurationDto;
import dev.eighteendev.trackforce.domain.model.WeatherDuration;

/**
 * Mapper class for converting {@link WeatherDurationDto} Data Transfer Objects to {@link WeatherDuration} domain models.
 * <p>
 * This class is responsible for transforming duration-related weather data from the data layer into domain models.
 */
public class WeatherDurationDtoMapper {

    /**
     * Maps a {@link WeatherDurationDto} object to a {@link WeatherDuration} domain model.
     * <p>
     * If the input DTO is null, returns null.
     *
     * @param dto the {@link WeatherDurationDto} object containing duration forecast data.
     * @return a {@link WeatherDuration} domain model or null if the input is null.
     */
    public static WeatherDuration toDomain(WeatherDurationDto dto){
        if (dto == null) return null;
        return new WeatherDuration(dto.getThreeHoursForecast());
    }
}