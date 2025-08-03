package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing cloudiness information from the weather API.
 * <p>
 * This class is used to deserialize JSON cloud data into Java objects using Gson.
 */
public class CloudsDto {

    /**
     * Cloudiness percentage (0-100).
     */
    @SerializedName("all")
    private Integer all;

    /**
     * Constructs a new {@link CloudsDto} with the given cloudiness percentage.
     *
     * @param all cloudiness percentage (0-100).
     */
    public CloudsDto(Integer all) {
        this.all = all;
    }

    /**
     * Gets the cloudiness percentage.
     *
     * @return the cloudiness percentage (0-100).
     */
    public Integer getAll() {
        return all;
    }

    /**
     * Sets the cloudiness percentage.
     *
     * @param all cloudiness percentage (0-100).
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}