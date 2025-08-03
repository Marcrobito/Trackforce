package dev.eighteendev.trackforce.data.network.dto;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Data Transfer Object (DTO) representing detailed weather forecast information for a specific time slot.
 * <p>
 * This class is used to deserialize JSON responses from weather APIs, capturing granular weather data
 * such as temperature, wind, clouds, precipitation probability, and more.
 */
public class WeatherDetailDto {

    /**
     * Timestamp of the forecasted data in UNIX epoch seconds.
     */
    @SerializedName("dt")
    private Long timestamp;

    /**
     * Main weather information such as temperature, humidity, and pressure.
     */
    @SerializedName("main")
    private MainInfoDto mainInfo;

    /**
     * List of weather conditions (e.g., rain, clouds) for the forecasted time.
     */
    @SerializedName("weather")
    private List<WeatherDto> weather;

    /**
     * Cloud coverage information.
     */
    @SerializedName("clouds")
    private CloudsDto clouds;

    /**
     * Wind information including speed, degree, and gusts.
     */
    @SerializedName("wind")
    private WindDto wind;

    /**
     * Visibility distance in meters.
     */
    @SerializedName("visibility")
    private int visibility;

    /**
     * Probability of precipitation (POP), ranging from 0.0 to 1.0.
     */
    @SerializedName("pop")
    private Double probabilityOfPrecipitation;

    /**
     * System information, typically indicates part of the day (day/night).
     */
    @SerializedName("sys")
    private SysInfoDto sysInfo;

    /**
     * Readable date and time of the forecasted data (e.g., "2025-08-02 06:00:00").
     */
    @SerializedName("dt_txt")
    private String date;

    /**
     * Rain volume for the last 3 hours, if available.
     */
    @SerializedName("rain")
    @Nullable
    private WeatherDurationDto rain;

    /**
     * Snow volume for the last 3 hours, if available.
     */
    @SerializedName("snow")
    @Nullable
    private WeatherDurationDto snow;

    public WeatherDetailDto(Long timestamp, MainInfoDto mainInfo, List<WeatherDto> weather, CloudsDto clouds, WindDto wind, int visibility, Double probabilityOfPrecipitation, SysInfoDto sysInfo, String date, @Nullable WeatherDurationDto rain, @Nullable WeatherDurationDto snow) {
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public MainInfoDto getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfoDto mainInfo) {
        this.mainInfo = mainInfo;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public CloudsDto getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDto clouds) {
        this.clouds = clouds;
    }

    public WindDto getWind() {
        return wind;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Double getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    public void setProbabilityOfPrecipitation(Double probabilityOfPrecipitation) {
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    }

    public SysInfoDto getSysInfo() {
        return sysInfo;
    }

    public void setSysInfo(SysInfoDto sysInfo) {
        this.sysInfo = sysInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Nullable
    public WeatherDurationDto getRain() {
        return rain;
    }

    public void setRain(@Nullable WeatherDurationDto rain) {
        this.rain = rain;
    }

    @Nullable
    public WeatherDurationDto getSnow() {
        return snow;
    }

    public void setSnow(@Nullable WeatherDurationDto snow) {
        this.snow = snow;
    }
}