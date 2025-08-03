package dev.eighteendev.trackforce.data.mappers.entity;

import dev.eighteendev.trackforce.data.room.entities.CoordinateEntity;
import dev.eighteendev.trackforce.domain.model.Coordinate;

/**
 * Mapper class for converting {@link CoordinateEntity} database entities to {@link Coordinate} domain models.
 * <p>
 * Responsible for transforming geographic coordinate data from the persistence layer into domain models.
 */
public class CoordinateEntityMapper {

    /**
     * Maps a {@link CoordinateEntity} object to a {@link Coordinate} domain model.
     *
     * @param entity the {@link CoordinateEntity} object representing location coordinates from the database.
     * @return a {@link Coordinate} domain model with longitude and latitude values.
     */
    public static Coordinate toDomain(CoordinateEntity entity){
        return new Coordinate(entity.getLongitude(), entity.getLatitude());
    }
}