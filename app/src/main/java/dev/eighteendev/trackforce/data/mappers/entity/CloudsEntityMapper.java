package dev.eighteendev.trackforce.data.mappers.entity;

import dev.eighteendev.trackforce.data.room.entities.CloudsEntity;
import dev.eighteendev.trackforce.domain.model.Clouds;

/**
 * Mapper class for converting {@link CloudsEntity} database entities to {@link Clouds} domain models.
 * <p>
 * Responsible for transforming cloud coverage data from the persistence layer into domain models.
 */
public class CloudsEntityMapper {

    /**
     * Maps a {@link CloudsEntity} object to a {@link Clouds} domain model.
     *
     * @param entity the {@link CloudsEntity} object representing cloud coverage data from the database.
     * @return a {@link Clouds} domain model with the corresponding values.
     */
    public static Clouds toDomain(CloudsEntity entity){
        return new Clouds(entity.getAll());
    }
}