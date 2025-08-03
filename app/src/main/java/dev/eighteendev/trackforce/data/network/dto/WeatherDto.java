package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing a specific weather condition.
 * <p>
 * This class is used to deserialize weather condition details from the API response,
 * such as the weather type (rain, clouds), description, and associated icon.
 */
public class WeatherDto {

    /**
     * Weather condition ID. Can be used to map to weather codes defined by the API.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Group of weather parameters (Rain, Snow, Clear, Clouds, etc.).
     */
    @SerializedName("main")
    private String mainWeather;

    /**
     * Weather condition within the group, providing a human-readable description.
     */
    @SerializedName("description")
    private String description;

    /**
     * Icon ID used to fetch corresponding weather icons from the API.
     */
    @SerializedName("icon")
    private String icon;

    /**
     * Constructs a new {@link WeatherDto} with the specified parameters.
     *
     * @param id          the weather condition ID.
     * @param mainWeather the main weather group.
     * @param description the detailed weather description.
     * @param icon        the icon ID representing this weather condition.
     */
    public WeatherDto(Integer id, String mainWeather, String description, String icon) {
        this.id = id;
        this.mainWeather = mainWeather;
        this.description = description;
        this.icon = icon;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}