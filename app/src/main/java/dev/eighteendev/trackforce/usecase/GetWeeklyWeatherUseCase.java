package dev.eighteendev.trackforce.usecase;

import dev.eighteendev.trackforce.domain.async.AsyncResult;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;
import dev.eighteendev.trackforce.domain.repository.WeatherRepository;
import dev.eighteendev.trackforce.presentation.mapper.WeeklyWeatherUiMapper;
import dev.eighteendev.trackforce.presentation.model.WeeklyWeatherUi;
import io.reactivex.rxjava3.core.Single;

/**
 * Use case responsible for retrieving the weekly weather forecast and mapping it to a UI model.
 * <p>
 * This class orchestrates the retrieval of weather data from the {@link WeatherRepository},
 * handling asynchronous responses through RxJava and converting domain models into
 * presentation models via {@link WeeklyWeatherUiMapper}.
 */
public class GetWeeklyWeatherUseCase {

    private final WeatherRepository repository;

    /**
     * Constructs the use case with the required {@link WeatherRepository} dependency.
     *
     * @param repository the repository responsible for providing weather data.
     */
    public GetWeeklyWeatherUseCase(WeatherRepository repository) {
        this.repository = repository;
    }

    /**
     * Executes the use case to fetch weekly weather data.
     * <p>
     * The result is returned as a {@link Single} emitting a {@link WeeklyWeatherUi} model,
     * which is mapped from the domain layer using {@link WeeklyWeatherUiMapper}.
     * Handles both success and error callbacks from the asynchronous repository operation.
     *
     * @return a {@link Single} emitting the {@link WeeklyWeatherUi} or an error.
     */
    public Single<WeeklyWeatherUi> execute() {
        return Single.create(emitter -> {
            repository.getWeeklyWeather().subscribe(new AsyncResult.Callback<WeeklyWeather>() {
                @Override
                public void onSuccess(WeeklyWeather value) {
                    emitter.onSuccess(WeeklyWeatherUiMapper.fromDomain(value));
                }

                @Override
                public void onError(Throwable error) {
                    emitter.onError(error);
                }
            });
        });
    }
}