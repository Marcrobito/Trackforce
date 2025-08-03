package dev.eighteendev.trackforce.data.source;

import android.util.Log;

import com.google.gson.Gson;

import dev.eighteendev.trackforce.data.RxSingleAsyncResultImpl;
import dev.eighteendev.trackforce.data.mappers.entity.WeeklyWeatherEntityMapper;
import dev.eighteendev.trackforce.data.room.dao.WeeklyWeatherDao;
import dev.eighteendev.trackforce.data.room.entities.WeeklyWeatherEntity;
import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;
import dev.eighteendev.trackforce.domain.strategy.WeatherSourceStrategy;
import io.reactivex.rxjava3.core.Single;

/**
 * Local data source strategy for retrieving weather information from the Room database.
 * <p>
 * Implements {@link WeatherSourceStrategy} to fetch cached weather data stored locally.
 * If no cached data is found, an error is emitted.
 */
public class LocalSourceStrategy implements WeatherSourceStrategy {

    private final WeeklyWeatherDao dao;

    /**
     * Constructs a {@link LocalSourceStrategy} with the given DAO for accessing weather data.
     *
     * @param dao the {@link WeeklyWeatherDao} used to query cached weather data.
     */
    public LocalSourceStrategy(WeeklyWeatherDao dao) {
        this.dao = dao;
    }

    /**
     * Retrieves the latest cached weekly weather data from the local Room database.
     * <p>
     * If cached data is found, it is mapped to the domain model and returned.
     * If no data is available, an {@link IllegalStateException} is emitted.
     *
     * @return an {@link AsyncResult} emitting the {@link WeeklyWeather} data.
     */
    @Override
    public AsyncResult<WeeklyWeather> getWeeklyWeather() {
        return new RxSingleAsyncResultImpl<>(
                Single.fromCallable(() -> {
                    WeeklyWeatherEntity entity = dao.getLatest();
                    if (entity != null) {
                        return WeeklyWeatherEntityMapper.toDomain(entity);
                    } else {
                        throw new IllegalStateException("No cached weather data found.");
                    }
                })
        );
    }
}