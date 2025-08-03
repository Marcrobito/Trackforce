package dev.eighteendev.trackforce.domain.model;

/**
 * Represents weather condition data for a specific time frame.
 * Includes identifiers, main weather category, a descriptive text, and an icon code.
 */
public class Weather {
    private Integer id;
    private String mainWeather;
    private String description;
    private String icon;

    /**
     * Constructs a new {@code Weather} object.
     *
     * @param id           The unique weather condition ID.
     * @param mainWeather  The main category of the weather condition (e.g., "Rain", "Clouds").
     * @param description  A more detailed description of the weather condition (e.g., "light rain").
     * @param icon         The icon code associated with the weather condition for graphical representation.
     */
    public Weather(Integer id, String mainWeather, String description, String icon) {
        this.id = id;
        this.mainWeather = mainWeather;
        this.description = description;
        this.icon = icon;
    }

    /**
     * @return The unique ID of the weather condition.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique ID of the weather condition.
     *
     * @param id The ID to set.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The main category of the weather condition.
     */
    public String getMainWeather() {
        return mainWeather;
    }

    /**
     * Sets the main weather category.
     *
     * @param mainWeather The main weather category to set.
     */
    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    /**
     * @return The descriptive text of the weather condition.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the weather condition.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The icon code associated with this weather condition.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the icon code for the weather condition.
     *
     * @param icon The icon code to set.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}