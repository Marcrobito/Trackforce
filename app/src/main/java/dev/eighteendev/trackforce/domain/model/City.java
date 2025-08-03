package dev.eighteendev.trackforce.domain.model;

/**
 * Represents a city with geographical and timezone information.
 * This model is used within the domain layer to encapsulate city-related data
 * such as coordinates, population, and sunrise/sunset times.
 */
public class City {
    private Integer id;
    private String name;
    private Coordinate coordinate;
    private String country;
    private Long population;
    private Long timezone;
    private Long sunrise;
    private Long sunset;

    /**
     * Constructs a new {@code City} instance with all its attributes.
     *
     * @param id         Unique identifier of the city.
     * @param name       Name of the city.
     * @param coordinate Geographical coordinates (latitude & longitude).
     * @param country    ISO country code (e.g., "MX" for Mexico).
     * @param population Total population of the city.
     * @param timezone   Timezone offset in seconds from UTC.
     * @param sunrise    Sunrise time in Unix timestamp format.
     * @param sunset     Sunset time in Unix timestamp format.
     */
    public City(Integer id, String name, Coordinate coordinate, String country, Long population, Long timezone, Long sunrise, Long sunset) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
        this.country = country;
        this.population = population;
        this.timezone = timezone;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    /**
     * @return Unique identifier of the city.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the city.
     *
     * @param id City ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Name of the city.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the city.
     *
     * @param name City name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Geographical coordinates of the city.
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Sets the geographical coordinates of the city.
     *
     * @param coordinate Coordinate object containing latitude and longitude.
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * @return ISO country code of the city.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the ISO country code of the city.
     *
     * @param country ISO country code.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return Total population of the city.
     */
    public Long getPopulation() {
        return population;
    }

    /**
     * Sets the total population of the city.
     *
     * @param population Population count.
     */
    public void setPopulation(Long population) {
        this.population = population;
    }

    /**
     * @return Timezone offset from UTC in seconds.
     */
    public Long getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone offset from UTC in seconds.
     *
     * @param timezone Timezone offset.
     */
    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    /**
     * @return Sunrise time in Unix timestamp format.
     */
    public Long getSunrise() {
        return sunrise;
    }

    /**
     * Sets the sunrise time in Unix timestamp format.
     *
     * @param sunrise Sunrise timestamp.
     */
    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * @return Sunset time in Unix timestamp format.
     */
    public Long getSunset() {
        return sunset;
    }

    /**
     * Sets the sunset time in Unix timestamp format.
     *
     * @param sunset Sunset timestamp.
     */
    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}