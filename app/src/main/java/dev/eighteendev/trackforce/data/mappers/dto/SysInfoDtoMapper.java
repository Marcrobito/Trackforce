package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.SysInfoDto;
import dev.eighteendev.trackforce.domain.model.SysInfo;

/**
 * Mapper class for converting {@link SysInfoDto} Data Transfer Objects to {@link SysInfo} domain models.
 * <p>
 * This class is responsible for transforming system-related weather information,
 * such as the part of the day (day/night), from network responses into domain models.
 */
public class SysInfoDtoMapper {

    /**
     * Converts a {@link SysInfoDto} to a {@link SysInfo} domain model.
     *
     * @param dto the {@link SysInfoDto} containing system-related weather information.
     * @return a {@link SysInfo} domain model populated with the corresponding system data.
     */
    public static SysInfo toDomain(SysInfoDto dto){
        return new SysInfo(dto.getPartOfTheDay());
    }
}