package dev.eighteendev.trackforce.data.room.entities;

import androidx.room.Embedded;
import androidx.room.PrimaryKey;

/**
 * Entity class representing a city in the local Room database.
 * <p>
 * This class maps city-related information, including geographic coordinates,
 * population data, and timezone details, to the corresponding table in the database.
 */
public class CityEntity {

    /** Unique identifier for the city (Primary Key). */
    @PrimaryKey
    private Integer id;

    /** Name of the city. */
    private String name;

    /** Geographical coordinates of the city. Embedded as a separate object with prefixed columns. */
    @Embedded(prefix = "coord_")
    private CoordinateEntity coordinate;

    /** Country code (ISO 3166-1 alpha-2) where the city is located. */
    private String country;

    /** Population of the city. */
    private Long population;

    /** Timezone offset in seconds from UTC. */
    private Long timezone;

    /** Unix timestamp for sunrise time in the city. */
    private Long sunrise;

    /** Unix timestamp for sunset time in the city. */
    private Long sunset;

    /**
     * Constructs a {@link CityEntity} with all properties.
     *
     * @param id         the unique identifier of the city.
     * @param name       the name of the city.
     * @param coordinate the geographical coordinates of the city.
     * @param country    the country code of the city.
     * @param population the population count.
     * @param timezone   the timezone offset from UTC.
     * @param sunrise    the sunrise time as Unix timestamp.
     * @param sunset     the sunset time as Unix timestamp.
     */
    public CityEntity(Integer id, String name, CoordinateEntity coordinate, String country, Long population, Long timezone, Long sunrise, Long sunset) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
        this.country = country;
        this.population = population;
        this.timezone = timezone;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordinateEntity getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(CoordinateEntity coordinate) {
        this.coordinate = coordinate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}