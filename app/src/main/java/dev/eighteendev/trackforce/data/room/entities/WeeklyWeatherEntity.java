package dev.eighteendev.trackforce.data.room.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

import dev.eighteendev.trackforce.data.room.typeconverters.WeatherDetailListConverter;

/**
 * Entity class representing a weekly weather forecast in the local Room database.
 * <p>
 * This class stores metadata about the forecast response, a list of detailed weather entries,
 * and city information.
 */
@Entity(tableName = "weekly_weather")
public class WeeklyWeatherEntity {

    /** Auto-generated primary key for local database identification. */
    @PrimaryKey(autoGenerate = true)
    private int id;

    /** API response status code (e.g., "200" for success). */
    private String responseStatus;

    /** Message field (can represent processing time or additional info from API). */
    private Double message;

    /** Number of forecast entries returned in the response. */
    private Integer resultCount;

    /** List of weather forecast details for the week. */
    @TypeConverters(WeatherDetailListConverter.class)
    private List<WeatherDetailEntity> weekWeatherDetail;

    /** Embedded city information related to this weather forecast. */
    @Embedded(prefix = "city_")
    private CityEntity city;

    /**
     * Full constructor used by Room when reconstructing objects from the database.
     *
     * @param id                 Auto-generated local ID.
     * @param responseStatus     API response status code.
     * @param message            API message field.
     * @param resultCount        Number of forecast entries.
     * @param weekWeatherDetail  List of weather forecast details.
     * @param city               City information.
     */
    public WeeklyWeatherEntity(int id, String responseStatus, Double message, Integer resultCount, List<WeatherDetailEntity> weekWeatherDetail, CityEntity city) {
        this.id = id;
        this.responseStatus = responseStatus;
        this.message = message;
        this.resultCount = resultCount;
        this.weekWeatherDetail = weekWeatherDetail;
        this.city = city;
    }

    /**
     * Convenience constructor without ID, used when inserting new entries.
     *
     * @param responseStatus     API response status code.
     * @param message            API message field.
     * @param resultCount        Number of forecast entries.
     * @param weekWeatherDetail  List of weather forecast details.
     * @param city               City information.
     */
    @Ignore
    public WeeklyWeatherEntity(String responseStatus, Double message, Integer resultCount, List<WeatherDetailEntity> weekWeatherDetail, CityEntity city) {
        this.responseStatus = responseStatus;
        this.message = message;
        this.resultCount = resultCount;
        this.weekWeatherDetail = weekWeatherDetail;
        this.city = city;
    }

    /**
     * Returns the auto-generated ID.
     *
     * @return an {@link Integer} representing the local ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the local ID.
     *
     * @param id an {@link Integer} representing the local ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the API response status code.
     *
     * @return a {@link String} representing the response status.
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the API response status code.
     *
     * @param responseStatus a {@link String} representing the response status.
     */
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * Returns the API message field.
     *
     * @return a {@link Double} representing the message field.
     */
    public Double getMessage() {
        return message;
    }

    /**
     * Sets the API message field.
     *
     * @param message a {@link Double} representing the message field.
     */
    public void setMessage(Double message) {
        this.message = message;
    }

    /**
     * Returns the number of forecast entries.
     *
     * @return an {@link Integer} representing the count of forecast results.
     */
    public Integer getResultCount() {
        return resultCount;
    }

    /**
     * Sets the number of forecast entries.
     *
     * @param resultCount an {@link Integer} representing the count of forecast results.
     */
    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * Returns the list of weather forecast details.
     *
     * @return a {@link List} of {@link WeatherDetailEntity} objects.
     */
    public List<WeatherDetailEntity> getWeekWeatherDetail() {
        return weekWeatherDetail;
    }

    /**
     * Sets the list of weather forecast details.
     *
     * @param weekWeatherDetail a {@link List} of {@link WeatherDetailEntity} objects.
     */
    public void setWeekWeatherDetail(List<WeatherDetailEntity> weekWeatherDetail) {
        this.weekWeatherDetail = weekWeatherDetail;
    }

    /**
     * Returns the city associated with the forecast.
     *
     * @return a {@link CityEntity} object containing city details.
     */
    public CityEntity getCity() {
        return city;
    }

    /**
     * Sets the city associated with the forecast.
     *
     * @param city a {@link CityEntity} object containing city details.
     */
    public void setCity(CityEntity city) {
        this.city = city;
    }
}