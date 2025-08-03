package dev.eighteendev.trackforce.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import dev.eighteendev.trackforce.data.room.dao.WeeklyWeatherDao;
import dev.eighteendev.trackforce.data.room.entities.WeeklyWeatherEntity;
import dev.eighteendev.trackforce.data.room.typeconverters.WeatherDetailListConverter;
import dev.eighteendev.trackforce.data.room.typeconverters.WeatherListConverter;

/**
 * Main Room database class for the application.
 * <p>
 * This class defines the database configuration and serves as the main access point
 * to the persisted data using DAOs.
 * <p>
 * It includes type converters for handling complex types such as lists of custom entities.
 */
@Database(
        entities = { WeeklyWeatherEntity.class },
        version = 1,
        exportSchema = false
)

@TypeConverters({ WeatherDetailListConverter.class, WeatherListConverter.class })
public abstract class AppDatabase extends RoomDatabase {

    /**
     * Provides access to the {@link WeeklyWeatherDao} for performing database operations
     * related to weekly weather forecasts.
     *
     * @return an instance of {@link WeeklyWeatherDao}.
     */
    public abstract WeeklyWeatherDao weeklyWeatherDao();
}