package dev.eighteendev.trackforce.data.room.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

import dev.eighteendev.trackforce.data.room.typeconverters.WeatherListConverter;

/**
 * Entity class representing detailed weather information for a specific timestamp,
 * to be stored in the Room database.
 * <p>
 * This entity includes various embedded sub-entities and lists, such as main weather info,
 * weather conditions, clouds, wind, system info, rain, and snow.
 */
@Entity(tableName = "weather_detail")
public class WeatherDetailEntity {

    /** Unique timestamp of the weather forecast entry (epoch seconds). */
    @PrimaryKey
    private Long timestamp;

    /** Main atmospheric data such as temperature, humidity, and pressure. */
    @Embedded(prefix = "main_")
    private MainInfoEntity mainInfo;

    /** List of weather conditions (e.g., clear sky, rain, snow). */
    @TypeConverters(WeatherListConverter.class)
    private List<WeatherEntity> weather;

    /** Cloud coverage information. */
    @Embedded(prefix = "clouds_")
    private CloudsEntity clouds;

    /** Wind conditions including speed, degree, and gust. */
    @Embedded(prefix = "wind_")
    private WindEntity wind;

    /** Visibility in meters. */
    private Integer visibility;

    /** Probability of precipitation (0.0 - 1.0). */
    private Double probabilityOfPrecipitation;

    /** System-related info like part of the day ("d" for day, "n" for night). */
    @Embedded(prefix = "sys_")
    private SysInfoEntity sysInfo;

    /** Human-readable date/time string for the forecast (e.g., "2025-08-01 18:00:00"). */
    private String date;

    /** Rain volume over a 3-hour period (nullable). */
    @Embedded(prefix = "rain_")
    private WeatherDurationEntity rain;

    /** Snow volume over a 3-hour period (nullable). */
    @Embedded(prefix = "snow_")
    private WeatherDurationEntity snow;

    /**
     * Constructs a {@link WeatherDetailEntity} with the specified weather details.
     *
     * @param timestamp                  Forecast timestamp.
     * @param mainInfo                   Main atmospheric information.
     * @param weather                    List of weather conditions.
     * @param clouds                     Cloud coverage information.
     * @param wind                       Wind information.
     * @param visibility                 Visibility in meters.
     * @param probabilityOfPrecipitation Probability of precipitation (0.0 - 1.0).
     * @param sysInfo                    System information (part of the day).
     * @param date                       Forecast date as string.
     * @param rain                       Rain volume information.
     * @param snow                       Snow volume information.
     */
    public WeatherDetailEntity(Long timestamp, MainInfoEntity mainInfo, List<WeatherEntity> weather,
                               CloudsEntity clouds, WindEntity wind, Integer visibility,
                               Double probabilityOfPrecipitation, SysInfoEntity sysInfo,
                               String date, WeatherDurationEntity rain, WeatherDurationEntity snow) {
        this.timestamp = timestamp;
        this.mainInfo = mainInfo;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
        this.sysInfo = sysInfo;
        this.date = date;
        this.rain = rain;
        this.snow = snow;
    }

    // Getters and Setters...

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public MainInfoEntity getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfoEntity mainInfo) {
        this.mainInfo = mainInfo;
    }

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherEntity> weather) {
        this.weather = weather;
    }

    public CloudsEntity getClouds() {
        return clouds;
    }

    public void setClouds(CloudsEntity clouds) {
        this.clouds = clouds;
    }

    public WindEntity getWind() {
        return wind;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Double getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    public void setProbabilityOfPrecipitation(Double probabilityOfPrecipitation) {
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    }

    public SysInfoEntity getSysInfo() {
        return sysInfo;
    }

    public void setSysInfo(SysInfoEntity sysInfo) {
        this.sysInfo = sysInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherDurationEntity getRain() {
        return rain;
    }

    public void setRain(WeatherDurationEntity rain) {
        this.rain = rain;
    }

    public WeatherDurationEntity getSnow() {
        return snow;
    }

    public void setSnow(WeatherDurationEntity snow) {
        this.snow = snow;
    }
}
