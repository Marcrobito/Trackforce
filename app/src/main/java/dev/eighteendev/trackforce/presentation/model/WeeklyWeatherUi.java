package dev.eighteendev.trackforce.presentation.model;

import java.util.List;
import java.util.Map;

/**
 * UI model representing the complete weather forecast information to be displayed in the weekly weather screen.
 * <p>
 * This class aggregates the city information, the current weather data, a summarized list of daily weather cards,
 * and a detailed map of weather forecasts per day.
 * It serves as the central model for rendering both the main weather overview and the per-day detailed forecasts in the UI.
 */
public class WeeklyWeatherUi {

    /**
     * Name of the city for which the weather forecast applies.
     */
    private String city;

    /**
     * Weather details representing the current or closest upcoming weather condition.
     * Used for the top section of the screen.
     */
    private DailyWeatherUi actualWeather;

    /**
     * List of summarized weather entries for each day (e.g., min/max temperature, icon).
     * These are typically displayed in a horizontal RecyclerView for quick navigation.
     */
    private List<DailyWeatherSummary> dailyWeatherSummaryList;

    /**
     * Map that associates each day (as a string key) with its detailed weather entries.
     * Each value is a list containing multiple {@link DailyWeatherUi} objects for different time slots.
     * Used to populate the vertical RecyclerView when a day is selected.
     */
    private Map<String, List<DailyWeatherUi>> dailyDetailsPerDay;

    /**
     * Constructs a {@link WeeklyWeatherUi} object with all relevant weather presentation data.
     *
     * @param city                   the city name.
     * @param actualWeather          the current weather data.
     * @param dailyWeatherSummaryList list of daily weather summaries for quick overview.
     * @param dailyDetailsPerDay      map of detailed weather data grouped by day.
     */
    public WeeklyWeatherUi(String city, DailyWeatherUi actualWeather, List<DailyWeatherSummary> dailyWeatherSummaryList, Map<String, List<DailyWeatherUi>> dailyDetailsPerDay) {
        this.city = city;
        this.actualWeather = actualWeather;
        this.dailyWeatherSummaryList = dailyWeatherSummaryList;
        this.dailyDetailsPerDay = dailyDetailsPerDay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DailyWeatherUi getActualWeather() {
        return actualWeather;
    }

    public void setActualWeather(DailyWeatherUi actualWeather) {
        this.actualWeather = actualWeather;
    }

    public List<DailyWeatherSummary> getDailyWeatherSummaryList() {
        return dailyWeatherSummaryList;
    }

    public void setDailyWeatherSummaryList(List<DailyWeatherSummary> dailyWeatherSummaryList) {
        this.dailyWeatherSummaryList = dailyWeatherSummaryList;
    }

    public Map<String, List<DailyWeatherUi>> getDailyDetailsPerDay() {
        return dailyDetailsPerDay;
    }

    public void setDailyDetailsPerDay(Map<String, List<DailyWeatherUi>> dailyDetailsPerDay) {
        this.dailyDetailsPerDay = dailyDetailsPerDay;
    }
}