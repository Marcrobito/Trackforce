package dev.eighteendev.trackforce.data.mappers.entity;

import dev.eighteendev.trackforce.data.room.entities.SysInfoEntity;
import dev.eighteendev.trackforce.domain.model.SysInfo;

/**
 * Mapper class for converting {@link SysInfoEntity} database entities to {@link SysInfo} domain models.
 * <p>
 * This class handles the transformation of system information related to the part of the day
 * (e.g., day or night) from the persistence layer into domain models.
 */
public class SysInfoEntityMapper {

    /**
     * Maps a {@link SysInfoEntity} object to a {@link SysInfo} domain model.
     *
     * @param entity the {@link SysInfoEntity} containing system info data from the database.
     * @return a {@link SysInfo} domain model representing the part of the day.
     */
    public static SysInfo toDomain(SysInfoEntity entity) {
        return new SysInfo(entity.getPartOfTheDay());
    }
}