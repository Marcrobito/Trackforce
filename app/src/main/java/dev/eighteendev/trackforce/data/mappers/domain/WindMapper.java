package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.WindEntity;
import dev.eighteendev.trackforce.domain.model.Wind;

/**
 * Mapper class for converting {@link Wind} domain models to {@link WindEntity} database entities.
 * <p>
 * This class handles the transformation of wind-related data from the domain layer
 * into the Room database entity representation for persistence.
 */
public class WindMapper {

    /**
     * Converts a {@link Wind} domain model to a {@link WindEntity}.
     *
     * @param wind the {@link Wind} domain model containing wind data.
     * @return a {@link WindEntity} representing the database entity of the given wind information.
     */
    public static WindEntity toEntity(Wind wind){
        return new WindEntity(wind.getSpeed(), wind.getDegree(), wind.getGust());
    }
}