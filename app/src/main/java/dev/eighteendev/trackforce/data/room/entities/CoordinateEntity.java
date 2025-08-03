package dev.eighteendev.trackforce.data.room.entities;

/**
 * Entity class representing geographical coordinates (longitude and latitude) in the local Room database.
 * <p>
 * This class is used to store and retrieve location points associated with weather data.
 */
public class CoordinateEntity {

    /** Longitude coordinate in decimal degrees. */
    private Double longitude;

    /** Latitude coordinate in decimal degrees. */
    private Double latitude;

    /**
     * Constructs a {@link CoordinateEntity} with specified longitude and latitude.
     *
     * @param longitude the longitude coordinate.
     * @param latitude  the latitude coordinate.
     */
    public CoordinateEntity(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Returns the longitude coordinate.
     *
     * @return a {@link Double} representing longitude.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude coordinate.
     *
     * @param longitude a {@link Double} representing longitude.
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns the latitude coordinate.
     *
     * @return a {@link Double} representing latitude.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude coordinate.
     *
     * @param latitude a {@link Double} representing latitude.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}