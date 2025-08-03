package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.CloudsDto;
import dev.eighteendev.trackforce.domain.model.Clouds;

/**
 * Mapper class for converting {@link CloudsDto} Data Transfer Objects to {@link Clouds} domain models.
 * <p>
 * This class is responsible for transforming cloud-related data received from network responses
 * into domain layer models used throughout the application's business logic.
 */
public class CloudsDtoMapper {

    /**
     * Converts a {@link CloudsDto} to a {@link Clouds} domain model.
     *
     * @param dto the {@link CloudsDto} containing cloud data from the network.
     * @return a {@link Clouds} domain model with the corresponding data.
     */
    public static Clouds toDomain(CloudsDto dto) {
        return new Clouds(dto.getAll());
    }
}