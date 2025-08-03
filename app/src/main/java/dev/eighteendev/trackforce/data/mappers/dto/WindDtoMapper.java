package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.WindDto;
import dev.eighteendev.trackforce.domain.model.Wind;

/**
 * Mapper class for converting {@link WindDto} Data Transfer Objects to {@link Wind} domain models.
 * <p>
 * This class is responsible for transforming wind-related weather data from the data layer into domain models.
 */
public class WindDtoMapper {

    /**
     * Maps a {@link WindDto} object to a {@link Wind} domain model.
     * <p>
     * Transfers all wind attributes such as speed, degree, and gust values.
     *
     * @param dto the {@link WindDto} object containing wind data from the API response.
     * @return a {@link Wind} domain model with the corresponding values.
     */
    public static Wind toDomain(WindDto dto){
        return new Wind(dto.getSpeed(), dto.getDegree(), dto.getGust());
    }
}