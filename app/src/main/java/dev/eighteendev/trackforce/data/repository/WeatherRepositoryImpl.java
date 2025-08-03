package dev.eighteendev.trackforce.data.repository;

import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.NetworkStatusChecker;
import dev.eighteendev.trackforce.domain.WeeklyWeatherLocalDataSource;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;
import dev.eighteendev.trackforce.domain.repository.WeatherRepository;
import dev.eighteendev.trackforce.domain.strategy.WeatherSourceStrategy;

/**
 * Implementation of {@link WeatherRepository} that retrieves weekly weather data
 * from either a remote API or a local cache depending on network availability.
 *
 * <p>This repository implements a robust fallback mechanism:
 * <ul>
 *     <li>If the device is online, it will first attempt to fetch data from the remote API.</li>
 *     <li>If the remote fetch is successful, it caches the result locally and returns it.</li>
 *     <li>If the remote fetch fails (e.g., no internet, timeout), it will attempt to fetch data from the local cache.</li>
 *     <li>If the local cache also fails (empty or invalid), it will propagate the error up to the ViewModel/UI.</li>
 *     <li>If the device is offline, it immediately attempts to return data from the local cache.</li>
 * </ul>
 *
 * <p>This ensures that:
 * <ul>
 *     <li>The app gracefully degrades to cached data if the network is unreliable.</li>
 *     <li>Errors are only shown when neither remote nor local data is available.</li>
 * </ul>
 */
public class WeatherRepositoryImpl implements WeatherRepository {

    private final WeatherSourceStrategy localSource;
    private final WeatherSourceStrategy remoteSource;
    private final NetworkStatusChecker networkChecker;
    private final WeeklyWeatherLocalDataSource dataSource;

    /**
     * Constructs a {@link WeatherRepositoryImpl} with the provided data sources and network checker.
     *
     * @param localStrategy the strategy to fetch cached weather data locally.
     * @param networkStrategy the strategy to fetch weather data from the remote API.
     * @param networkStatusChecker the checker to determine if the device has network connectivity.
     * @param dataSource the data source for caching weather data.
     */
    public WeatherRepositoryImpl(WeatherSourceStrategy localStrategy,
                                 WeatherSourceStrategy networkStrategy,
                                 NetworkStatusChecker networkStatusChecker,
                                 WeeklyWeatherLocalDataSource dataSource) {
        this.localSource = localStrategy;
        this.remoteSource = networkStrategy;
        this.networkChecker = networkStatusChecker;
        this.dataSource = dataSource;
    }

    /**
     * Retrieves weekly weather data with a remote-first strategy and local fallback.
     *
     * <p>If online:
     * <ul>
     *     <li>Attempts to fetch from remote API.</li>
     *     <li>If successful, caches the result locally and returns it.</li>
     *     <li>If the remote call fails, attempts to fetch from local cache.</li>
     *     <li>If both fail, propagates the error to the caller.</li>
     * </ul>
     *
     * <p>If offline:
     * <ul>
     *     <li>Immediately attempts to fetch from local cache.</li>
     *     <li>If the cache fails, propagates the error to the caller.</li>
     * </ul>
     *
     * @return an {@link AsyncResult} emitting the {@link WeeklyWeather} data or an error.
     */
    @Override
    public AsyncResult<WeeklyWeather> getWeeklyWeather() {
        return new AsyncResult<WeeklyWeather>() {
            @Override
            public void subscribe(Callback<WeeklyWeather> callback) {
                if (networkChecker.isOnline()) {
                    remoteSource.getWeeklyWeather().subscribe(new Callback<>() {
                        @Override
                        public void onSuccess(WeeklyWeather result) {
                            dataSource.cacheWeeklyWeather(result);
                            callback.onSuccess(result);
                        }

                        @Override
                        public void onError(Throwable error) {
                            localSource.getWeeklyWeather().subscribe(new Callback<>() {
                                @Override
                                public void onSuccess(WeeklyWeather localResult) {
                                    callback.onSuccess(localResult);
                                }

                                @Override
                                public void onError(Throwable localError) {
                                    callback.onError(localError);
                                }
                            });
                        }
                    });
                } else {
                    localSource.getWeeklyWeather().subscribe(callback);
                }
            }
        };
    }
}