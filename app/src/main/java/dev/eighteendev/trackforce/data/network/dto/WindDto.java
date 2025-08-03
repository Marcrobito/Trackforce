package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing wind information from the weather API.
 * <p>
 * This class is used to parse and transport wind-related data from the API response.
 */
public class WindDto {

    /**
     * The wind speed in meters per second (m/s).
     * Mapped from the JSON key "speed".
     */
    @SerializedName("speed")
    private Double speed;

    /**
     * The wind direction in degrees (meteorological).
     * Mapped from the JSON key "deg".
     */
    @SerializedName("deg")
    private Integer degree;

    /**
     * The wind gust speed in meters per second (m/s).
     * Mapped from the JSON key "gust".
     */
    @SerializedName("gust")
    private Double gust;

    /**
     * Constructs a new {@link WindDto} instance with wind details.
     *
     * @param speed  wind speed in m/s.
     * @param degree wind direction in degrees.
     * @param gust   wind gust speed in m/s.
     */
    public WindDto(Double speed, Integer degree, Double gust) {
        this.speed = speed;
        this.degree = degree;
        this.gust = gust;
    }

    /**
     * @return the wind speed in m/s.
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Sets the wind speed in m/s.
     *
     * @param speed wind speed.
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * @return the wind direction in degrees.
     */
    public Integer getDegree() {
        return degree;
    }

    /**
     * Sets the wind direction in degrees.
     *
     * @param degree wind direction.
     */
    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    /**
     * @return the wind gust speed in m/s.
     */
    public Double getGust() {
        return gust;
    }

    /**
     * Sets the wind gust speed in m/s.
     *
     * @param gust gust speed.
     */
    public void setGust(Double gust) {
        this.gust = gust;
    }
}