package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.WeeklyWeatherDto;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

/**
 * Mapper class for converting {@link WeeklyWeatherDto} Data Transfer Objects to {@link WeeklyWeather} domain models.
 * <p>
 * This class is responsible for transforming weekly weather forecast data retrieved from the network
 * into domain models that can be used by the application’s business logic.
 */
public class WeeklyWeatherDtoMapper {

    /**
     * Maps a {@link WeeklyWeatherDto} object to a {@link WeeklyWeather} domain model.
     * <p>
     * It handles the conversion of nested objects such as {@code WeatherDetailDto} and {@code CityDto}
     * by delegating to their respective mapper classes.
     *
     * @param dto the {@link WeeklyWeatherDto} object containing the raw API weather forecast data.
     * @return a {@link WeeklyWeather} domain model with the structured weekly forecast information.
     */
    public static WeeklyWeather toDomain(WeeklyWeatherDto dto){
        return new WeeklyWeather(
                dto.getResponseStatus(),
                dto.getMessage(),
                dto.getResultCount(),
                WeatherDetailDtoMapper.toDomain(dto.getWeekWeatherDetail()),
                CityDtoMapper.toDomain(dto.getCity())
        );
    }
}