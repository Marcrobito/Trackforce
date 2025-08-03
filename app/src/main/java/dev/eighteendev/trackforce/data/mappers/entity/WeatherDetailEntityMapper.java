package dev.eighteendev.trackforce.data.mappers.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.eighteendev.trackforce.data.room.entities.WeatherDetailEntity;
import dev.eighteendev.trackforce.domain.model.WeatherDetail;

/**
 * Mapper class for converting {@link WeatherDetailEntity} database entities to {@link WeatherDetail} domain models.
 * <p>
 * This class is responsible for transforming detailed weather data, including main info, weather conditions,
 * clouds, wind, precipitation, and system information from the persistence layer into domain models.
 */
public class WeatherDetailEntityMapper {

    /**
     * Maps a {@link WeatherDetailEntity} object to a {@link WeatherDetail} domain model.
     *
     * @param entity the {@link WeatherDetailEntity} containing detailed weather data from the database.
     * @return a {@link WeatherDetail} domain model.
     */
    public static WeatherDetail toDomain(WeatherDetailEntity entity){
        return new WeatherDetail(
                entity.getTimestamp(),
                MainInfoEntityMapper.toDomain(entity.getMainInfo()),
                WeatherEntityMapper.toDomain(entity.getWeather()),
                CloudsEntityMapper.toDomain(entity.getClouds()),
                WindEntityMapper.toDomain(entity.getWind()),
                entity.getVisibility(),
                entity.getProbabilityOfPrecipitation(),
                SysInfoEntityMapper.toDomain(entity.getSysInfo()),
                entity.getDate(),
                entity.getRain() != null ? WeatherDurationEntityMapper.toDomain(entity.getRain()) : null,
                entity.getSnow() != null ? WeatherDurationEntityMapper.toDomain(entity.getSnow()) : null
        );
    }

    /**
     * Maps a list of {@link WeatherDetailEntity} objects to a list of {@link WeatherDetail} domain models.
     * <p>
     * If the input list is null, returns an empty list.
     *
     * @param entityList a list of {@link WeatherDetailEntity} objects.
     * @return a list of {@link WeatherDetail} domain models.
     */
    public static List<WeatherDetail> toDomain(List<WeatherDetailEntity> entityList){
        if (entityList == null) return new ArrayList<>();
        return entityList.stream().map(WeatherDetailEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}