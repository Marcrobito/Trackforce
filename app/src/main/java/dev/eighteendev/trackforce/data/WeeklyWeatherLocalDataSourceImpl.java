package dev.eighteendev.trackforce.data;

import dev.eighteendev.trackforce.data.mappers.domain.WeeklyWeatherMapper;
import dev.eighteendev.trackforce.data.room.dao.WeeklyWeatherDao;
import dev.eighteendev.trackforce.data.room.entities.WeeklyWeatherEntity;
import dev.eighteendev.trackforce.domain.WeeklyWeatherLocalDataSource;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;

/**
 * Implementation of {@link WeeklyWeatherLocalDataSource} that interacts with the local Room database.
 * <p>
 * This class is responsible for caching weekly weather data by mapping domain models to entities
 * and storing them via the {@link WeeklyWeatherDao}.
 */
public class WeeklyWeatherLocalDataSourceImpl implements WeeklyWeatherLocalDataSource {
    private final WeeklyWeatherDao dao;

    /**
     * Constructs a {@link WeeklyWeatherLocalDataSourceImpl} with the given DAO.
     *
     * @param dao the {@link WeeklyWeatherDao} used to interact with the local database.
     */
    public WeeklyWeatherLocalDataSourceImpl(WeeklyWeatherDao dao) {
        this.dao = dao;
    }

    /**
     * Caches the provided {@link WeeklyWeather} data in the local database.
     * <p>
     * The method clears existing cached data before inserting the new record.
     *
     * @param weather the {@link WeeklyWeather} domain model to be cached.
     */
    @Override
    public void cacheWeeklyWeather(WeeklyWeather weather) {
        WeeklyWeatherEntity entity = WeeklyWeatherMapper.toEntity(weather);
        dao.deleteAll();
        dao.insertReplace(entity);
    }
}