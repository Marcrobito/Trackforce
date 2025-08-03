package dev.eighteendev.trackforce.data.mappers.dto;

import dev.eighteendev.trackforce.data.network.dto.MainInfoDto;
import dev.eighteendev.trackforce.domain.model.MainInfo;

/**
 * Mapper class for converting {@link MainInfoDto} Data Transfer Objects to {@link MainInfo} domain models.
 * <p>
 * This class is responsible for transforming main weather information such as temperature,
 * pressure, and humidity from network responses into domain models for business logic processing.
 */
public class MainInfoDtoMapper {

    /**
     * Converts a {@link MainInfoDto} to a {@link MainInfo} domain model.
     *
     * @param dto the {@link MainInfoDto} containing main weather details.
     * @return a {@link MainInfo} domain model populated with the corresponding weather data.
     */
    public static MainInfo toDomain(MainInfoDto dto){
        return new MainInfo(
                dto.getTemperature(),
                dto.getApparentTemperature(),
                dto.getTemperatureMin(),
                dto.getTemperatureMax(),
                dto.getPressure(),
                dto.getSeaLevel(),
                dto.getGroundLevel(),
                dto.getHumidity(),
                dto.getTemperatureShift()
        );
    }
}