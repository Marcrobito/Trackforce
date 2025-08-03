package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.SysInfoEntity;
import dev.eighteendev.trackforce.domain.model.SysInfo;

/**
 * Mapper class for converting a {@link SysInfo} domain model to a {@link SysInfoEntity} database entity.
 * <p>
 * This mapper transforms system-related weather information, such as part of the day (day/night),
 * from the domain layer into a format suitable for database storage.
 */
public class SysInfoMapper {

    /**
     * Converts a {@link SysInfo} domain model to a {@link SysInfoEntity}.
     *
     * @param sysInfo the {@link SysInfo} domain model containing system weather information.
     * @return a {@link SysInfoEntity} representing the database entity of the given system information.
     */
    public static SysInfoEntity toEntity(SysInfo sysInfo) {
        return new SysInfoEntity(sysInfo.getPartOfTheDay());
    }
}