package dev.eighteendev.trackforce.common;

/**
 * Immutable data class representing a geographic location with latitude and longitude coordinates.
 */
public class Location {
    private final double latitude;
    private final double longitude;

    /**
     * Constructs a {@code Location} instance with the specified latitude and longitude.
     *
     * @param latitude  the latitude coordinate.
     * @param longitude the longitude coordinate.
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns the latitude coordinate of this location.
     *
     * @return the latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude coordinate of this location.
     *
     * @return the longitude.
     */
    public double getLongitude() {
        return longitude;
    }
}