package dev.eighteendev.trackforce.data.room.entities;

/**
 * Entity class representing weather condition information in the local Room database.
 * <p>
 * This class holds data related to the main weather condition, description, and icon identifier.
 * Typically, this is embedded within a {@link dev.eighteendev.trackforce.data.room.entities.WeatherDetailEntity}
 * as part of the weather forecast.
 */
public class WeatherEntity {

    /** Weather condition ID (as defined by OpenWeatherMap). */
    private Integer id;

    /** Group of weather parameters (e.g., Rain, Snow, Clear, Clouds). */
    private String mainWeather;

    /** Detailed description of the weather condition. */
    private String description;

    /** Icon code corresponding to the weather condition (used to fetch weather icons). */
    private String icon;

    /**
     * Constructs a {@link WeatherEntity} with the specified weather attributes.
     *
     * @param id           Weather condition ID.
     * @param mainWeather  Main group of weather parameters (e.g., "Clouds").
     * @param description  Detailed weather description (e.g., "overcast clouds").
     * @param icon         Icon code used for displaying weather icons.
     */
    public WeatherEntity(Integer id, String mainWeather, String description, String icon) {
        this.id = id;
        this.mainWeather = mainWeather;
        this.description = description;
        this.icon = icon;
    }

    /**
     * Returns the weather condition ID.
     *
     * @return an {@link Integer} representing the weather ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the weather condition ID.
     *
     * @param id an {@link Integer} representing the weather ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the main weather category (e.g., "Clear", "Clouds").
     *
     * @return a {@link String} representing the main weather category.
     */
    public String getMainWeather() {
        return mainWeather;
    }

    /**
     * Sets the main weather category.
     *
     * @param mainWeather a {@link String} representing the main weather category.
     */
    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    /**
     * Returns the detailed description of the weather condition.
     *
     * @return a {@link String} representing the weather description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the detailed description of the weather condition.
     *
     * @param description a {@link String} representing the weather description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the icon code corresponding to the weather condition.
     *
     * @return a {@link String} representing the weather icon code.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the icon code corresponding to the weather condition.
     *
     * @param icon a {@link String} representing the weather icon code.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}