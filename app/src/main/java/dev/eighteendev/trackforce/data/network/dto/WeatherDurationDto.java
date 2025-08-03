package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing the precipitation volume for a 3-hour period.
 * <p>
 * This class is used to deserialize rain or snow volume data from the API response.
 */
public class WeatherDurationDto {

    /**
     * Volume of rain or snow in millimeters for the last 3 hours.
     * This field is mapped from the JSON key "3h".
     */
    @SerializedName("3h")
    private Double threeHoursForecast;

    /**
     * Constructs a new {@link WeatherDurationDto} with the specified 3-hour forecast volume.
     *
     * @param threeHoursForecast the precipitation volume for a 3-hour period (in millimeters).
     */
    public WeatherDurationDto(Double threeHoursForecast) {
        this.threeHoursForecast = threeHoursForecast;
    }

    /**
     * Gets the precipitation volume for a 3-hour period.
     *
     * @return the volume in millimeters.
     */
    public Double getThreeHoursForecast() {
        return threeHoursForecast;
    }

    /**
     * Sets the precipitation volume for a 3-hour period.
     *
     * @param threeHoursForecast the volume in millimeters.
     */
    public void setThreeHoursForecast(Double threeHoursForecast) {
        this.threeHoursForecast = threeHoursForecast;
    }
}