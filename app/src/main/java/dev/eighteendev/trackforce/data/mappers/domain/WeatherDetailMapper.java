package dev.eighteendev.trackforce.data.mappers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.eighteendev.trackforce.data.room.entities.WeatherDetailEntity;
import dev.eighteendev.trackforce.domain.model.WeatherDetail;

/**
 * Mapper class for converting {@link WeatherDetail} domain models to {@link WeatherDetailEntity} database entities.
 * <p>
 * This class is responsible for transforming detailed weather information, including temperature,
 * weather conditions, clouds, wind, precipitation, and time data, from the domain layer to a
 * structure compatible with Room database entities.
 */
public class WeatherDetailMapper {

    /**
     * Converts a single {@link WeatherDetail} domain model to a {@link WeatherDetailEntity}.
     *
     * @param weatherDetail the {@link WeatherDetail} domain model containing weather information.
     * @return a {@link WeatherDetailEntity} representing the database entity of the given weather detail.
     */
    public static WeatherDetailEntity toEntity(WeatherDetail weatherDetail){
        return new WeatherDetailEntity(
                weatherDetail.getTimestamp(),
                MainInfoMapper.toEntity(weatherDetail.getMainInfo()),
                WeatherMapper.toEntity(weatherDetail.getWeather()),
                CloudsMapper.toEntity(weatherDetail.getClouds()),
                WindMapper.toEntity(weatherDetail.getWind()),
                weatherDetail.getVisibility(),
                weatherDetail.getProbabilityOfPrecipitation(),
                SysInfoMapper.toEntity(weatherDetail.getSysInfo()),
                weatherDetail.getDate(),
                WeatherDurationMapper.toEntity(weatherDetail.getRain()),
                WeatherDurationMapper.toEntity(weatherDetail.getSnow())
        );
    }

    /**
     * Converts a list of {@link WeatherDetail} domain models to a list of {@link WeatherDetailEntity} entities.
     *
     * @param weatherDetailList a list of {@link WeatherDetail} domain models.
     * @return a list of {@link WeatherDetailEntity} database entities.
     *         If the input list is null, an empty list is returned.
     */
    public static List<WeatherDetailEntity> toEntity(List<WeatherDetail> weatherDetailList){
        if (weatherDetailList == null) return new ArrayList<>();

        return weatherDetailList.stream()
                .map(WeatherDetailMapper::toEntity)
                .collect(Collectors.toList());
    }
}