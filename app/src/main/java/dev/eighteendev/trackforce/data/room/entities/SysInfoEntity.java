package dev.eighteendev.trackforce.data.room.entities;

/**
 * Entity class representing system information related to a weather forecast,
 * typically indicating the part of the day (e.g., day or night).
 * <p>
 * This data is stored in the local Room database as part of weather details.
 */
public class SysInfoEntity {

    /** Indicates the part of the day for the forecast (e.g., "d" for day, "n" for night). */
    private String partOfTheDay;

    /**
     * Constructs a {@link SysInfoEntity} with the specified part of the day.
     *
     * @param partOfTheDay a {@link String} representing the part of the day ("d" or "n").
     */
    public SysInfoEntity(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }

    /**
     * Returns the part of the day.
     *
     * @return a {@link String} representing the part of the day ("d" or "n").
     */
    public String getPartOfTheDay() {
        return partOfTheDay;
    }

    /**
     * Sets the part of the day.
     *
     * @param partOfTheDay a {@link String} representing the part of the day ("d" or "n").
     */
    public void setPartOfTheDay(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }
}