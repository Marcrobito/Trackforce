package dev.eighteendev.trackforce.domain.model;

/**
 * Represents the duration or accumulated precipitation for a 3-hour weather forecast window.
 */
public class WeatherDuration {
    private Double threeHoursForecast;

    /**
     * Constructs a new {@code WeatherDuration} object.
     *
     * @param threeHoursForecast The precipitation volume or duration forecasted over a 3-hour period.
     */
    public WeatherDuration(Double threeHoursForecast) {
        this.threeHoursForecast = threeHoursForecast;
    }

    /**
     * @return The forecasted precipitation or duration value over a 3-hour window.
     */
    public Double getThreeHoursForecast() {
        return threeHoursForecast;
    }

    /**
     * Sets the forecasted precipitation or duration value for a 3-hour window.
     *
     * @param threeHoursForecast The value to set.
     */
    public void setThreeHoursForecast(Double threeHoursForecast) {
        this.threeHoursForecast = threeHoursForecast;
    }
}