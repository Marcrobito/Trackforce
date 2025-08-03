package dev.eighteendev.trackforce.data.room.entities;

/**
 * Entity class representing cloud coverage information in the local Room database.
 * <p>
 * This class holds data about cloudiness percentage, typically used in weather forecasts.
 */
public class CloudsEntity {

    /** Cloudiness percentage (0 - 100%). */
    private Integer all;

    /**
     * Constructs a {@link CloudsEntity} with the specified cloudiness percentage.
     *
     * @param all the percentage of cloud cover.
     */
    public CloudsEntity(Integer all) {
        this.all = all;
    }

    /**
     * Returns the cloudiness percentage.
     *
     * @return an {@link Integer} representing cloud cover (0 - 100%).
     */
    public Integer getAll() {
        return all;
    }

    /**
     * Sets the cloudiness percentage.
     *
     * @param all an {@link Integer} representing cloud cover (0 - 100%).
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}