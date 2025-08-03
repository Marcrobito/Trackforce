package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing a city as received from the weather API.
 * <p>
 * This class is used to deserialize JSON responses into Java objects using Gson.
 */
public class CityDto {

    /** Unique identifier for the city. */
    @SerializedName("id")
    private Integer id;

    /** Name of the city. */
    @SerializedName("name")
    private String name;

    /** Geographical coordinates of the city. */
    @SerializedName("coord")
    private CoordinateDto coordinate;

    /** Country code (ISO 3166-1 alpha-2) of the city. */
    @SerializedName("country")
    private String country;

    /** Population of the city. */
    @SerializedName("population")
    private Long population;

    /** Timezone offset in seconds from UTC. */
    @SerializedName("timezone")
    private Long timezone;

    /** Sunrise time in Unix UTC timestamp. */
    @SerializedName("sunrise")
    private Long sunrise;

    /** Sunset time in Unix UTC timestamp. */
    @SerializedName("sunset")
    private Long sunset;

    /**
     * Constructor for {@link CityDto}.
     *
     * @param id unique identifier of the city.
     * @param name name of the city.
     * @param coordinate geographical coordinates of the city.
     * @param country country code (ISO 3166-1 alpha-2).
     * @param population population of the city.
     * @param timezone timezone offset in seconds from UTC.
     * @param sunrise sunrise time in Unix timestamp.
     * @param sunset sunset time in Unix timestamp.
     */
    public CityDto(Integer id, String name, CoordinateDto coordinate, String country, Long population, Long timezone, Long sunrise, Long sunset) {
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

    public CoordinateDto getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(CoordinateDto coordinate) {
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