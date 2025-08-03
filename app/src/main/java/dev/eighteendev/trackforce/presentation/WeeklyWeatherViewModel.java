package dev.eighteendev.trackforce.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dev.eighteendev.trackforce.common.UiState;
import dev.eighteendev.trackforce.presentation.model.WeeklyWeatherUi;
import dev.eighteendev.trackforce.usecase.GetWeeklyWeatherUseCase;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jakarta.inject.Inject;

/**
 * ViewModel for managing and exposing the UI state of the weekly weather forecast.
 * <p>
 * This ViewModel interacts with the {@link GetWeeklyWeatherUseCase} to fetch weather data,
 * handling asynchronous operations via RxJava, and exposes a LiveData of {@link UiState}
 * to reflect loading, success, or error states to the UI layer.
 */
@HiltViewModel
public class WeeklyWeatherViewModel extends ViewModel {

    private final GetWeeklyWeatherUseCase useCase;
    private final CompositeDisposable disposables = new CompositeDisposable();

    private final MutableLiveData<UiState<WeeklyWeatherUi>> _state = new MutableLiveData<>();
    /** LiveData representing the current UI state (Loading, Success, Error). */
    public LiveData<UiState<WeeklyWeatherUi>> state = _state;

    /**
     * Constructs the ViewModel and injects the {@link GetWeeklyWeatherUseCase} dependency.
     *
     * @param useCase the use case responsible for fetching weekly weather data.
     */
    @Inject
    public WeeklyWeatherViewModel(GetWeeklyWeatherUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Initiates the fetching of weekly weather data.
     * <p>
     * Updates the {@link #state} LiveData to Loading, then observes the result of the use case
     * and emits either Success with data or Error with an exception.
     */
    public void fetchWeeklyWeather() {
        _state.setValue(new UiState.Loading<>());

        disposables.add(
                useCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                result -> _state.setValue(new UiState.Success<>(result)),
                                throwable -> _state.setValue(new UiState.Error<>(throwable))
                        )
        );
    }

    /**
     * Clears ongoing subscriptions when the ViewModel is no longer used and will be destroyed.
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}