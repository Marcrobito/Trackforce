package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.CoordinateDto;
import dev.eighteendev.trackforce.domain.model.Coordinate;

/**
 * Mapper class for converting {@link CoordinateDto} Data Transfer Objects to {@link Coordinate} domain models.
 * <p>
 * This class transforms coordinate data (latitude and longitude) received from network responses
 * into domain layer models used in business logic.
 */
public class CoordinateDtoMapper {

    /**
     * Converts a {@link CoordinateDto} to a {@link Coordinate} domain model.
     *
     * @param dto the {@link CoordinateDto} containing geographic coordinate data.
     * @return a {@link Coordinate} domain model with the corresponding longitude and latitude.
     */
    public static Coordinate toDomain(CoordinateDto dto){
        return new Coordinate(dto.getLongitude(), dto.getLatitude());
    }
}