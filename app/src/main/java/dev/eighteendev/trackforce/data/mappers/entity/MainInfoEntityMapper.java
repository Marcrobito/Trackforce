package dev.eighteendev.trackforce.data.mappers.entity;

import dev.eighteendev.trackforce.data.room.entities.MainInfoEntity;
import dev.eighteendev.trackforce.domain.model.MainInfo;

/**
 * Mapper class for converting {@link MainInfoEntity} database entities to {@link MainInfo} domain models.
 * <p>
 * This class is responsible for mapping detailed main weather information such as temperature,
 * pressure, and humidity from the persistence layer into domain models.
 */
public class MainInfoEntityMapper {

    /**
     * Maps a {@link MainInfoEntity} object to a {@link MainInfo} domain model.
     *
     * @param entity the {@link MainInfoEntity} object containing main weather data from the database.
     * @return a {@link MainInfo} domain model with temperature, pressure, and humidity information.
     */
    public static MainInfo toDomain(MainInfoEntity entity) {
        return new MainInfo(
                entity.getTemperature(),
                entity.getApparentTemperature(),
                entity.getTemperatureMin(),
                entity.getTemperatureMax(),
                entity.getPressure(),
                entity.getSeaLevel(),
                entity.getGroundLevel(),
                entity.getHumidity(),
                entity.getTemperatureShift()
        );
    }
}