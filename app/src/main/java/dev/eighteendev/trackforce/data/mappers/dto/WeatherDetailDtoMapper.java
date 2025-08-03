package dev.eighteendev.trackforce.data.mappers.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.eighteendev.trackforce.data.network.dto.WeatherDetailDto;
import dev.eighteendev.trackforce.domain.model.WeatherDetail;

/**
 * Mapper class for converting {@link WeatherDetailDto} Data Transfer Objects to {@link WeatherDetail} domain models.
 * <p>
 * Responsible for transforming detailed weather information from API responses into domain layer models.
 */
public class WeatherDetailDtoMapper {

    /**
     * Maps a {@link WeatherDetailDto} object to a {@link WeatherDetail} domain model.
     *
     * @param dto the {@link WeatherDetailDto} object containing weather detail data.
     * @return a {@link WeatherDetail} domain model populated with data from the DTO.
     */
    public static WeatherDetail toDomain(WeatherDetailDto dto){
        return new WeatherDetail(
                dto.getTimestamp(),
                MainInfoDtoMapper.toDomain(dto.getMainInfo()),
                WeatherDtoMapper.toDomain(dto.getWeather()),
                CloudsDtoMapper.toDomain(dto.getClouds()),
                WindDtoMapper.toDomain(dto.getWind()),
                dto.getVisibility(),
                dto.getProbabilityOfPrecipitation(),
                SysInfoDtoMapper.toDomain(dto.getSysInfo()),
                dto.getDate(),
                WeatherDurationDtoMapper.toDomain(dto.getRain()),
                WeatherDurationDtoMapper.toDomain(dto.getSnow())
        );
    }

    /**
     * Maps a list of {@link WeatherDetailDto} objects to a list of {@link WeatherDetail} domain models.
     * <p>
     * If the input list is null, returns an empty list.
     *
     * @param dtoList a list of {@link WeatherDetailDto} objects.
     * @return a list of {@link WeatherDetail} domain models.
     */
    public static List<WeatherDetail> toDomain(List<WeatherDetailDto> dtoList){
        if (dtoList == null) return new ArrayList<>();

        return dtoList.stream()
                .map(WeatherDetailDtoMapper::toDomain)
                .collect(Collectors.toList());
    }
}