package dev.eighteendev.trackforce.data.room.entities;

/**
 * Entity class representing wind-related information in the local Room database.
 * <p>
 * This class stores data about wind speed, direction, and gusts, typically used in weather forecasts.
 */
public class WindEntity {

    /** Wind speed measured in meters per second (m/s). */
    private Double speed;

    /** Wind direction in degrees (meteorological convention, where 0° = North). */
    private Integer degree;

    /** Wind gust speed measured in meters per second (m/s), if available. */
    private Double gust;

    /**
     * Constructs a {@link WindEntity} with the specified speed, direction, and gust.
     *
     * @param speed  Wind speed in m/s.
     * @param degree Wind direction in degrees.
     * @param gust   Wind gust speed in m/s.
     */
    public WindEntity(Double speed, Integer degree, Double gust) {
        this.speed = speed;
        this.degree = degree;
        this.gust = gust;
    }

    /**
     * Returns the wind speed.
     *
     * @return a {@link Double} representing the wind speed in m/s.
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Sets the wind speed.
     *
     * @param speed a {@link Double} representing the wind speed in m/s.
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * Returns the wind direction.
     *
     * @return an {@link Integer} representing the wind direction in degrees.
     */
    public Integer getDegree() {
        return degree;
    }

    /**
     * Sets the wind direction.
     *
     * @param degree an {@link Integer} representing the wind direction in degrees.
     */
    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    /**
     * Returns the wind gust speed.
     *
     * @return a {@link Double} representing the wind gust speed in m/s.
     */
    public Double getGust() {
        return gust;
    }

    /**
     * Sets the wind gust speed.
     *
     * @param gust a {@link Double} representing the wind gust speed in m/s.
     */
    public void setGust(Double gust) {
        this.gust = gust;
    }
}