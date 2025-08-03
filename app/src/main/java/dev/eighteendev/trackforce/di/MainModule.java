package dev.eighteendev.trackforce.di;

import android.content.Context;

import androidx.room.Room;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import dev.eighteendev.trackforce.common.AndroidLocationProvider;
import dev.eighteendev.trackforce.common.LocationProvider;
import dev.eighteendev.trackforce.data.NetworkStatusCheckerImpl;
import dev.eighteendev.trackforce.data.WeeklyWeatherLocalDataSourceImpl;
import dev.eighteendev.trackforce.data.network.NetworkService;
import dev.eighteendev.trackforce.data.network.OpenWeatherApi;
import dev.eighteendev.trackforce.data.repository.WeatherRepositoryImpl;
import dev.eighteendev.trackforce.data.room.AppDatabase;
import dev.eighteendev.trackforce.data.source.LocalSourceStrategy;
import dev.eighteendev.trackforce.data.source.RemoteSourceStrategy;
import dev.eighteendev.trackforce.domain.NetworkStatusChecker;
import dev.eighteendev.trackforce.domain.WeeklyWeatherLocalDataSource;
import dev.eighteendev.trackforce.domain.repository.WeatherRepository;
import dev.eighteendev.trackforce.usecase.GetWeeklyWeatherUseCase;

import javax.inject.Singleton;

/**
 * Dagger Hilt Module that provides singleton-scoped dependencies for the application.
 * <p>
 * This module sets up database access, network services, location providers, strategies, repositories,
 * and use cases, adhering to the Clean Architecture layers.
 */
@Module
@InstallIn(SingletonComponent.class)
public class MainModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "weather-db").build();
    }

    @Provides
    @Singleton
    public NetworkService provideNetworkService() {
        return NetworkService.getInstance();
    }

    @Provides
    @Singleton
    public OpenWeatherApi provideOpenWeatherApi(NetworkService networkService) {
        return networkService.getApi();
    }

    @Provides
    @Singleton
    public LocalSourceStrategy provideLocalSourceStrategy(AppDatabase database) {
        return new LocalSourceStrategy(database.weeklyWeatherDao());
    }

    @Provides
    @Singleton
    public LocationProvider provideLocationProvider(@ApplicationContext Context context) {
        return new AndroidLocationProvider(context);
    }

    @Provides
    @Singleton
    public RemoteSourceStrategy provideRemoteSourceStrategy(OpenWeatherApi api, LocationProvider locationProvider) {
        return new RemoteSourceStrategy(api, locationProvider);
    }

    @Provides
    @Singleton
    public WeeklyWeatherLocalDataSource provideWeeklyWeatherLocalDataSource(AppDatabase database) {
        return new WeeklyWeatherLocalDataSourceImpl(database.weeklyWeatherDao());
    }

    @Provides
    @Singleton
    public NetworkStatusChecker provideNetworkStatusChecker(@ApplicationContext Context context) {
        return new NetworkStatusCheckerImpl(context);
    }

    @Provides
    @Singleton
    public WeatherRepository provideWeatherRepository(
            LocalSourceStrategy localSource,
            RemoteSourceStrategy remoteSource,
            NetworkStatusChecker networkChecker,
            WeeklyWeatherLocalDataSource localDataSource
    ) {
        return new WeatherRepositoryImpl(localSource, remoteSource, networkChecker, localDataSource);
    }

    @Provides
    @Singleton
    public GetWeeklyWeatherUseCase provideGetWeeklyWeatherUseCase(WeatherRepository repository) {
        return new GetWeeklyWeatherUseCase(repository);
    }
}