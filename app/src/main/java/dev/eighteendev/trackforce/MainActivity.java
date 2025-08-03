package dev.eighteendev.trackforce;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dagger.hilt.android.AndroidEntryPoint;
import dev.eighteendev.trackforce.common.UiState;
import dev.eighteendev.trackforce.databinding.ActivityMainBinding;
import dev.eighteendev.trackforce.presentation.DailyDetailAdapter;
import dev.eighteendev.trackforce.presentation.DailyWeatherSummaryAdapter;
import dev.eighteendev.trackforce.presentation.WeeklyWeatherViewModel;
import dev.eighteendev.trackforce.presentation.model.DailyWeatherUi;
import dev.eighteendev.trackforce.presentation.model.WeeklyWeatherUi;

/**
 * MainActivity is the entry point of the application, responsible for displaying the current weather,
 * a summary of the weekly forecast, and the detailed forecast for a selected day.
 * <p>
 * It handles:
 * <ul>
 *     <li>Requesting location permissions</li>
 *     <li>Observing UI state changes from the ViewModel</li>
 *     <li>Initializing RecyclerViews for daily summaries and details</li>
 *     <li>Updating UI based on user interactions</li>
 * </ul>
 */
@AndroidEntryPoint
public class MainActivity extends ComponentActivity implements DailyWeatherSummaryAdapter.OnDaySelectedListener {

    private ActivityMainBinding binding;
    // Launcher for requesting location permission at runtime.
    private ActivityResultLauncher<String> locationPermissionLauncher;
    // Holds the weather details grouped by day (key = Day Name, value = List of details for that day).
    private Map<String, List<DailyWeatherUi>> dailyDetailsPerDay = new HashMap<>();
    // Adapter for displaying hourly weather details of the selected day.
    private DailyDetailAdapter dailyDetailAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // View Binding initialization.
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ViewModel initialization using Hilt for dependency injection.
        WeeklyWeatherViewModel viewModel = new ViewModelProvider(this).get(WeeklyWeatherViewModel.class);

        // Observing the UI state to react accordingly.
        viewModel.state.observe(this, uiState -> {
            if (uiState instanceof UiState.Loading) {
                binding.loader.setVisibility(View.VISIBLE);
            } else if (uiState instanceof UiState.Success) {
                binding.loader.setVisibility(View.GONE);
                WeeklyWeatherUi data = ((UiState.Success<WeeklyWeatherUi>) uiState).data;
                dailyDetailsPerDay = data.getDailyDetailsPerDay();
                updateWeatherInfo(data);
            } else if (uiState instanceof UiState.Error) {
                binding.loader.setVisibility(View.GONE);
                binding.txtError.setVisibility(View.VISIBLE);
                binding.txtError.setText(getString(R.string.error_fetching_weather));
            } else if (uiState instanceof UiState.Empty) {
                binding.loader.setVisibility(View.GONE);
                binding.btnRequestPermissions.setVisibility(View.VISIBLE);
            }
        });

        // Registering the permission launcher to handle location permission result.
        locationPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        viewModel.fetchWeeklyWeather();
                    } else {
                        showLocationPermissionDialog();
                    }
                }
        );

        // Handling the permission request button click.
        binding.btnRequestPermissions.setOnClickListener(v -> {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
        });

        // Automatically request location permission if not already granted.
        if (!hasLocationPermission()) {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
        } else {
            viewModel.fetchWeeklyWeather();
        }
    }

    /**
     * Updates the UI components with the fetched weather data.
     * Displays actual weather, daily summaries (horizontal list), and detailed hourly forecast (vertical list).
     *
     * @param data WeeklyWeatherUi containing all weather information for the current location.
     */
    private void updateWeatherInfo(WeeklyWeatherUi data) {
        DailyWeatherUi actualWeather = data.getActualWeather();

        // Populate main weather summary.
        binding.txtLocation.setText(data.getCity());
        binding.txtTemperature.setText(String.valueOf(actualWeather.getTemperature()));
        binding.txtDegreeIndicator.setVisibility(View.VISIBLE);
        binding.txtWeatherType.setText(actualWeather.getWeatherState());
        binding.txtHumidity.setText(getString(R.string.humidity_label, actualWeather.getHumidity()));
        binding.txtApparentTemperature.setText(getString(R.string.apparent_temperature_label, actualWeather.getApparentTemperature()));
        binding.txtWindSpeed.setText(getString(R.string.wind_speed_label, actualWeather.getWindSpeed()));

        String iconUrl = "https://openweathermap.org/img/wn/" + actualWeather.getIcon() + "@2x.png";
        Glide.with(this).load(iconUrl).into(binding.weatherIcon);

        // Initialize and populate RecyclerView for daily summaries (horizontal list).
        RecyclerView weekDetailRecyclerView = binding.weekDetailsRecycler;
        DailyWeatherSummaryAdapter adapter = new DailyWeatherSummaryAdapter(data.getDailyWeatherSummaryList(), this);
        weekDetailRecyclerView.setAdapter(adapter);
        weekDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Initialize RecyclerView for detailed forecast (vertical list) for the first day.
        RecyclerView dailyDetailRecyclerView = binding.dailyDetailRecycler;
        String currentDay = data.getDailyWeatherSummaryList().get(0).getDay();
        binding.txtDayIndicator.setText(currentDay);
        dailyDetailAdapter = new DailyDetailAdapter(data.getDailyDetailsPerDay().get(currentDay));
        dailyDetailRecyclerView.setAdapter(dailyDetailAdapter);
        dailyDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    /**
     * Checks whether location permission has been granted.
     *
     * @return true if ACCESS_FINE_LOCATION is granted, false otherwise.
     */
    private boolean hasLocationPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Displays a dialog prompting the user to grant location permission.
     */
    private void showLocationPermissionDialog() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.location_permission_title))
                .setMessage(getString(R.string.location_permission_message))
                .setPositiveButton(getString(R.string.allow), (dialog, which) -> {
                    locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
                    binding.btnRequestPermissions.setVisibility(View.GONE);
                })
                .setNegativeButton(getString(R.string.cancel), (dialog, which) -> {
                    dialog.dismiss();
                    binding.btnRequestPermissions.setVisibility(View.VISIBLE);
                })
                .setCancelable(false)
                .show();
    }

    /**
     * Callback triggered when a day is selected in the daily summary RecyclerView.
     * Updates the detailed forecast list below.
     *
     * @param day The name of the selected day.
     */
    @Override
    public void onDaySelected(String day) {
        binding.txtDayIndicator.setText(day);
        dailyDetailAdapter.updateItems(dailyDetailsPerDay.get(day));
        binding.dailyDetailRecycler.scrollToPosition(0);
    }
}
