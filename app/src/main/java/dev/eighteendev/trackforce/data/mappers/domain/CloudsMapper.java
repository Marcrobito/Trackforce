package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.CloudsEntity;
import dev.eighteendev.trackforce.domain.model.Clouds;

/**
 * Mapper class for converting a {@link Clouds} domain model to a {@link CloudsEntity} database entity.
 * <p>
 * This class provides a utility method to map domain models used in the business logic layer
 * to entities suitable for persistence in the local database.
 */
public class CloudsMapper {

    /**
     * Converts a {@link Clouds} domain model to a {@link CloudsEntity}.
     *
     * @param clouds the {@link Clouds} domain model to be converted.
     * @return a {@link CloudsEntity} representing the database entity of the given clouds data.
     */
    public static CloudsEntity toEntity(Clouds clouds){
        return new CloudsEntity(clouds.getAll());
    }
}