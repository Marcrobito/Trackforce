package dev.eighteendev.trackforce.presentation.model;

/**
 * UI model representing the detailed weather data for a specific time slot within a day.
 * <p>
 * This class is intended for displaying individual weather entries in a vertical list,
 * providing detailed information such as temperature, humidity, wind, and an icon.
 * Typically, multiple instances of this model represent the segmented weather forecast for a selected day.
 */
public class DailyWeatherUi {

    /**
     * Main weather condition (e.g., "Cloudy", "Sunny").
     */
    private String weatherState;

    /**
     * Current temperature in degrees (integer representation).
     */
    private Integer temperature;

    /**
     * Feels-like temperature, perceived by the user.
     */
    private Integer apparentTemperature;

    /**
     * Humidity percentage.
     */
    private Integer humidity;

    /**
     * Wind speed in appropriate units (e.g., m/s, km/h).
     */
    private Integer windSpeed;

    /**
     * Weather icon identifier used for visual representation (e.g., "10d").
     */
    private String icon;

    /**
     * UNIX timestamp (in seconds) indicating the exact time this weather detail applies to.
     * Used for ordering and displaying time-specific data within the day.
     */
    private Long timestamp;

    /**
     * Constructs a {@link DailyWeatherUi} object with all relevant weather presentation data.
     *
     * @param weatherState        the main weather condition (e.g., "Cloudy").
     * @param temperature         the current temperature (°C).
     * @param apparentTemperature the "feels-like" temperature (°C).
     * @param humidity            the humidity percentage.
     * @param windSpeed           the wind speed (in km/h or m/s depending on configuration).
     * @param icon                the weather icon identifier (e.g., "10d").
     * @param timestamp           the UNIX timestamp representing the time of this weather detail.
     */
    public DailyWeatherUi(String weatherState, Integer temperature, Integer apparentTemperature, Integer humidity, Integer windSpeed, String icon, Long timestamp) {
        this.weatherState = weatherState;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.icon = icon;
        this.timestamp = timestamp;
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Integer apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
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