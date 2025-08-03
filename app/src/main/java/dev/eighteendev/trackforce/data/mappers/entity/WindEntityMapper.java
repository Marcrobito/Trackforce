package dev.eighteendev.trackforce.data.mappers.entity;

import dev.eighteendev.trackforce.data.room.entities.WindEntity;
import dev.eighteendev.trackforce.domain.model.Wind;

/**
 * Mapper class for converting {@link WindEntity} database entities to {@link Wind} domain models.
 * <p>
 * This class handles the transformation of wind-related data from the persistence layer into domain models.
 */
public class WindEntityMapper {

    /**
     * Maps a {@link WindEntity} object to a {@link Wind} domain model.
     *
     * @param entity the {@link WindEntity} containing wind data from the database.
     * @return a {@link Wind} domain model.
     */
    public static Wind toDomain(WindEntity entity){
        return new Wind(entity.getSpeed(), entity.getDegree(), entity.getGust());
    }
}