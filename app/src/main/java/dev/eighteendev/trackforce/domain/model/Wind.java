package dev.eighteendev.trackforce.domain.model;

/**
 * Represents wind information including speed, direction, and gust strength.
 */
public class Wind {
    private Double speed;
    private Integer degree;
    private Double gust;

    /**
     * Constructs a new {@code Wind} object.
     *
     * @param speed  The wind speed in meters per second (m/s).
     * @param degree The wind direction in degrees (meteorological).
     * @param gust   The wind gust speed in meters per second (m/s).
     */
    public Wind(Double speed, Integer degree, Double gust) {
        this.speed = speed;
        this.degree = degree;
        this.gust = gust;
    }

    /**
     * @return The wind speed in meters per second.
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * Sets the wind speed.
     *
     * @param speed The speed to set in meters per second.
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * @return The wind direction in degrees.
     */
    public Integer getDegree() {
        return degree;
    }

    /**
     * Sets the wind direction.
     *
     * @param degree The direction to set in degrees.
     */
    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    /**
     * @return The wind gust speed in meters per second.
     */
    public Double getGust() {
        return gust;
    }

    /**
     * Sets the wind gust speed.
     *
     * @param gust The gust speed to set in meters per second.
     */
    public void setGust(Double gust) {
        this.gust = gust;
    }
}