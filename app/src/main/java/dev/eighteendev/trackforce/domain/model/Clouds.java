package dev.eighteendev.trackforce.domain.model;

/**
 * Represents cloud coverage information for a specific time interval.
 * This model is used to indicate the percentage of sky covered by clouds.
 */
public class Clouds {
    private Integer all;

    /**
     * Constructs a new {@code Clouds} instance with the specified cloud coverage.
     *
     * @param all Percentage of cloud coverage (0-100).
     */
    public Clouds(Integer all) {
        this.all = all;
    }

    /**
     * @return Percentage of sky covered by clouds (0-100).
     */
    public Integer getAll() {
        return all;
    }

    /**
     * Sets the percentage of sky covered by clouds.
     *
     * @param all Cloud coverage percentage (0-100).
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}