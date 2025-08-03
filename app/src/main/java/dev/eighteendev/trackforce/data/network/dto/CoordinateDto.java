package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing geographic coordinates.
 * <p>
 * This class is used to deserialize coordinate data from JSON responses using Gson.
 */
public class CoordinateDto {

    /**
     * Longitude value of the coordinate.
     */
    @SerializedName("lon")
    private Double longitude;

    /**
     * Latitude value of the coordinate.
     */
    @SerializedName("lat")
    private Double latitude;

    /**
     * Constructs a new {@link CoordinateDto} with the specified longitude and latitude.
     *
     * @param longitude the longitude value.
     * @param latitude  the latitude value.
     */
    public CoordinateDto(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Gets the longitude value.
     *
     * @return the longitude.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude value.
     *
     * @param longitude the longitude to set.
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the latitude value.
     *
     * @return the latitude.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude value.
     *
     * @param latitude the latitude to set.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}