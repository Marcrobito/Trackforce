package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing system-related information for a weather forecast entry.
 * <p>
 * This class is primarily used to deserialize the part of the day (e.g., day or night) from the API response.
 */
public class SysInfoDto {

    /**
     * Part of the day indicator.
     * Expected values are:
     * <ul>
     *     <li>"d" for day</li>
     *     <li>"n" for night</li>
     * </ul>
     */
    @SerializedName("pod")
    private String partOfTheDay;

    /**
     * Constructs a new {@link SysInfoDto} with the specified part of the day.
     *
     * @param partOfTheDay a string indicating the part of the day ("d" for day, "n" for night).
     */
    public SysInfoDto(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }

    /**
     * Returns the part of the day indicator.
     *
     * @return a string representing the part of the day ("d" or "n").
     */
    public String getPartOfTheDay() {
        return partOfTheDay;
    }

    /**
     * Sets the part of the day indicator.
     *
     * @param partOfTheDay a string representing the part of the day ("d" or "n").
     */
    public void setPartOfTheDay(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }
}