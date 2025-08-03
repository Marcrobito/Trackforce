package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.CityDto;
import dev.eighteendev.trackforce.domain.model.City;

/**
 * Mapper class for converting {@link CityDto} Data Transfer Objects to {@link City} domain models.
 * <p>
 * This class is responsible for transforming city-related data received from network responses
 * into domain layer models used throughout the application's business logic.
 */
public class CityDtoMapper {

    /**
     * Converts a {@link CityDto} to a {@link City} domain model.
     *
     * @param dto the {@link CityDto} containing city data from the network.
     * @return a {@link City} domain model with the corresponding data.
     */
    public static City toDomain(CityDto dto){
        return new City(
                dto.getId(),
                dto.getName(),
                CoordinateDtoMapper.toDomain(dto.getCoordinate()),
                dto.getCountry(),
                dto.getPopulation(),
                dto.getTimezone(),
                dto.getSunrise(),
                dto.getSunset()
        );
    }
}