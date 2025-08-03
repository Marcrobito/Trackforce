package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.MainInfoEntity;
import dev.eighteendev.trackforce.domain.model.MainInfo;

/**
 * Mapper class for converting a {@link MainInfo} domain model to a {@link MainInfoEntity} database entity.
 * <p>
 * This mapper is responsible for transforming weather main information (temperature, pressure, humidity, etc.)
 * from the domain layer into a format suitable for database persistence.
 */
public class MainInfoMapper {

    /**
     * Converts a {@link MainInfo} domain model to a {@link MainInfoEntity}.
     *
     * @param mainInfo the {@link MainInfo} domain model to be converted.
     * @return a {@link MainInfoEntity} representing the database entity of the given main weather information.
     */
    public static MainInfoEntity toEntity(MainInfo mainInfo) {
        return new MainInfoEntity(
                mainInfo.getTemperature(),
                mainInfo.getApparentTemperature(),
                mainInfo.getTemperatureMin(),
                mainInfo.getTemperatureMax(),
                mainInfo.getPressure(),
                mainInfo.getSeaLevel(),
                mainInfo.getGroundLevel(),
                mainInfo.getHumidity(),
                mainInfo.getTemperatureShift()
        );
    }
}