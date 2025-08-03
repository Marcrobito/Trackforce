package dev.eighteendev.trackforce.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import dev.eighteendev.trackforce.data.room.entities.WeeklyWeatherEntity;

/**
 * Data Access Object (DAO) interface for performing database operations
 * on the {@link WeeklyWeatherEntity} table.
 * <p>
 * Provides methods to insert, query, and delete weather data records.
 */
@Dao
public interface WeeklyWeatherDao {

    /**
     * Inserts a {@link WeeklyWeatherEntity} into the database.
     * <p>
     * If a conflict occurs (e.g., duplicate primary key), the existing record is ignored.
     *
     * @param entity the {@link WeeklyWeatherEntity} to insert.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertIgnore(WeeklyWeatherEntity entity);

    /**
     * Inserts a {@link WeeklyWeatherEntity} into the database.
     * <p>
     * If a conflict occurs (e.g., duplicate primary key), the existing record is replaced.
     *
     * @param entity the {@link WeeklyWeatherEntity} to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReplace(WeeklyWeatherEntity entity);

    /**
     * Retrieves all {@link WeeklyWeatherEntity} records from the database.
     *
     * @return a list of all {@link WeeklyWeatherEntity} records.
     */
    @Query("SELECT * FROM weekly_weather")
    List<WeeklyWeatherEntity> getAll();

    /**
     * Deletes all records from the {@code weekly_weather} table.
     */
    @Query("DELETE FROM weekly_weather")
    void deleteAll();

    /**
     * Retrieves the latest {@link WeeklyWeatherEntity} record based on descending ID order.
     *
     * @return the most recent {@link WeeklyWeatherEntity} or null if no records exist.
     */
    @Query("SELECT * FROM weekly_weather ORDER BY id DESC LIMIT 1")
    WeeklyWeatherEntity getLatest();
}