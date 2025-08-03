package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.CoordinateEntity;
import dev.eighteendev.trackforce.domain.model.Coordinate;

/**
 * Mapper class for converting a {@link Coordinate} domain model to a {@link CoordinateEntity} database entity.
 * <p>
 * This class provides a utility method to map coordinate data from the domain layer
 * into an entity format suitable for persistence in the local database.
 */
public class CoordinateMapper {

    /**
     * Converts a {@link Coordinate} domain model to a {@link CoordinateEntity}.
     *
     * @param coordinate the {@link Coordinate} domain model to be converted.
     * @return a {@link CoordinateEntity} representing the database entity of the given coordinate.
     */
    public static CoordinateEntity toEntity(Coordinate coordinate){
        return new CoordinateEntity(coordinate.getLongitude(), coordinate.getLatitude());
    }
}