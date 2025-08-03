package dev.eighteendev.trackforce.presentation.model;

/**
 * UI model representing a summary of weather data for a specific day.
 * <p>
 * This class is designed to be a lightweight data holder for displaying
 * daily weather summaries in horizontal lists (e.g., min/max temperatures, day name, and icon).
 * It acts as a simplified version of detailed weather data, focusing on key visual elements for quick overview.
 */
public class DailyWeatherSummary {

    /**
     * The minimum temperature recorded for the day (°C).
     */
    private Integer minTemperature;

    /**
     * The maximum temperature recorded for the day (°C).
     */
    private Integer maxTemperature;

    /**
     * The name of the day (e.g., "Lunes", "Martes").
     */
    private String day;

    /**
     * The weather icon code (e.g., "04d", "10n") used to fetch the corresponding weather image.
     */
    private String icon;

    /**
     * A UNIX timestamp (in seconds) used for ordering and reference.
     * Represents a representative time of the day (typically closest to noon).
     */
    private Long timestamp;

    /**
     * Constructs a {@link DailyWeatherSummary} object with all necessary fields.
     *
     * @param minTemperature the minimum temperature of the day.
     * @param maxTemperature the maximum temperature of the day.
     * @param day            the name of the day.
     * @param icon           the weather icon code.
     * @param timestamp      the timestamp representing the day's reference point.
     */
    public DailyWeatherSummary(Integer minTemperature, Integer maxTemperature, String day, String icon, Long timestamp) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.day = day;
        this.icon = icon;
        this.timestamp = timestamp;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}