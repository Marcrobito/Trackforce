package dev.eighteendev.trackforce.data.mappers.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.eighteendev.trackforce.data.network.dto.WeatherDto;
import dev.eighteendev.trackforce.domain.model.Weather;

/**
 * Mapper class for converting {@link WeatherDto} Data Transfer Objects to {@link Weather} domain models.
 * <p>
 * This class provides methods to transform weather condition data from API responses into domain layer models.
 */
public class WeatherDtoMapper {

    /**
     * Maps a {@link WeatherDto} object to a {@link Weather} domain model.
     *
     * @param dto the {@link WeatherDto} object containing weather condition data.
     * @return a {@link Weather} domain model populated with data from the DTO.
     */
    public static Weather toDomain(WeatherDto dto) {
        return new Weather(dto.getId(), dto.getMainWeather(), dto.getDescription(), dto.getIcon());
    }

    /**
     * Maps a list of {@link WeatherDto} objects to a list of {@link Weather} domain models.
     * <p>
     * If the input list is null, returns an empty list.
     *
     * @param dtoList a list of {@link WeatherDto} objects.
     * @return a list of {@link Weather} domain models.
     */
    public static List<Weather> toDomain(List<WeatherDto> dtoList){
        if (dtoList == null) return new ArrayList<>();
        return dtoList.stream()
                .map(WeatherDtoMapper::toDomain)
                .collect(Collectors.toList());
    }
}