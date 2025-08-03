package dev.eighteendev.trackforce.domain.model;

/**
 * Represents a geographical coordinate with longitude and latitude values.
 * This model is used to specify a location point on Earth's surface.
 */
public class Coordinate {
    private Double longitude;
    private Double latitude;

    /**
     * Constructs a new {@code Coordinate} with the specified longitude and latitude.
     *
     * @param longitude The longitude value of the coordinate.
     * @param latitude  The latitude value of the coordinate.
     */
    public Coordinate(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * @return The longitude value of the coordinate.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude value of the coordinate.
     *
     * @param longitude The longitude value to set.
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return The latitude value of the coordinate.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude value of the coordinate.
     *
     * @param latitude The latitude value to set.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}