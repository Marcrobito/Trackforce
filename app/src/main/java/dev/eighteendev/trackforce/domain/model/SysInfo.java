package dev.eighteendev.trackforce.domain.model;

/**
 * Represents system-related information for a weather data point.
 * Specifically, it holds the part of the day indicator (e.g., "d" for day, "n" for night).
 */
public class SysInfo {
    private String partOfTheDay;

    /**
     * Constructs a new {@code SysInfo} object.
     *
     * @param partOfTheDay The part of the day, typically "d" for day or "n" for night.
     */
    public SysInfo(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }

    /**
     * @return The part of the day indicator ("d" for day, "n" for night).
     */
    public String getPartOfTheDay() {
        return partOfTheDay;
    }

    /**
     * Sets the part of the day indicator.
     *
     * @param partOfTheDay The value to set ("d" for day, "n" for night).
     */
    public void setPartOfTheDay(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }
}