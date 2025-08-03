package dev.eighteendev.trackforce.data.room.entities;

/**
 * Entity class representing precipitation volume (rain/snow) over a 3-hour forecast period,
 * to be stored in the Room database.
 * <p>
 * This class is typically used as an embedded object in {@link WeatherDetailEntity} for
 * representing rain or snow volumes in millimeters (mm).
 */
public class WeatherDurationEntity {

    /**
     * Volume of precipitation (rain/snow) in millimeters (mm) for a 3-hour period.
     */
    private Double threeHoursForecast;

    /**
     * Constructs a {@link WeatherDurationEntity} with the specified precipitation volume.
     *
     * @param threeHoursForecast Precipitation volume (mm) for a 3-hour forecast period.
     */
    public WeatherDurationEntity(Double threeHoursForecast) {
        this.threeHoursForecast = threeHoursForecast;
    }

    /**
     * Returns the precipitation volume (mm) for a 3-hour period.
     *
     * @return a {@link Double} representing the precipitation volume.
     */
    public Double getThreeHoursForecast() {
        return threeHoursForecast;
    }

    /**
     * Sets the precipitation volume (mm) for a 3-hour period.
     *
     * @param threeHoursForecast a {@link Double} representing the precipitation volume.
     */
    public void setThreeHoursForecast(Double threeHoursForecast) {
        this.threeHoursForecast = threeHoursForecast;
    }
}