package dev.eighteendev.trackforce.data.mappers.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.eighteendev.trackforce.data.room.entities.WeatherDetailEntity;
import dev.eighteendev.trackforce.data.room.entities.WeeklyWeatherEntity;
import dev.eighteendev.trackforce.domain.model.WeatherDetail;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

/**
 * Mapper class for converting {@link WeeklyWeatherEntity} database entities to {@link WeeklyWeather} domain models.
 * <p>
 * This class handles the transformation of weekly weather forecast data from the persistence layer into domain models.
 */
public class WeeklyWeatherEntityMapper {

    /**
     * Maps a {@link WeeklyWeatherEntity} object to a {@link WeeklyWeather} domain model.
     *
     * @param entity the {@link WeeklyWeatherEntity} containing weekly forecast data from the database.
     * @return a {@link WeeklyWeather} domain model.
     */
    public static WeeklyWeather toDomain(WeeklyWeatherEntity entity){
        Log.d("EntityMapper", "Starting mapping of WeeklyWeatherEntity...");

        Log.d("EntityMapper", "City: " + entity.getCity().getName());
        Log.d("EntityMapper", "WeatherDetails Raw Size: " +
                (entity.getWeekWeatherDetail() != null ? entity.getWeekWeatherDetail().size() : "NULL"));

        List<WeatherDetail> weatherDetails = new ArrayList<>();
        if (entity.getWeekWeatherDetail() != null) {
            for (int i = 0; i < entity.getWeekWeatherDetail().size(); i++) {
                Log.d("EntityMapper", "Mapping WeatherDetail at index: " + i);
                WeatherDetailEntity detailEntity = entity.getWeekWeatherDetail().get(i);

                if (detailEntity.getWeather() == null) {
                    Log.e("EntityMapper", "Weather list is NULL at index: " + i);
                } else if (detailEntity.getWeather().isEmpty()) {
                    Log.e("EntityMapper", "Weather list is EMPTY at index: " + i);
                } else {
                    Log.d("EntityMapper", "Weather list size: " + detailEntity.getWeather().size());
                }

                weatherDetails.add(WeatherDetailEntityMapper.toDomain(detailEntity));
            }
        } else {
            Log.e("EntityMapper", "WeekWeatherDetail is NULL");
        }

        Log.d("EntityMapper", "Finished mapping. Total WeatherDetails mapped: " + weatherDetails.size());


        return new WeeklyWeather(
                entity.getResponseStatus(),
                entity.getMessage(),
                entity.getResultCount(),
                WeatherDetailEntityMapper.toDomain(entity.getWeekWeatherDetail()),
                CityEntityMapper.toDomain(entity.getCity())
        );
    }
}