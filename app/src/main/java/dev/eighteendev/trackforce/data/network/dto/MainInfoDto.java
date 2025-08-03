package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Data Transfer Object (DTO) representing the main weather information for a given timestamp.
 * <p>
 * This class is used to deserialize the core weather details such as temperature, pressure, and humidity
 * from the API response using Gson.
 */
public class MainInfoDto {

    /**
     * Current temperature in degrees Celsius.
     */
    @SerializedName("temp")
    private Double temperature;

    /**
     * Apparent temperature ("feels like") in degrees Celsius.
     */
    @SerializedName("feels_like")
    private Double apparentTemperature;

    /**
     * Minimum recorded temperature in degrees Celsius.
     */
    @SerializedName("temp_min")
    private Double temperatureMin;

    /**
     * Maximum recorded temperature in degrees Celsius.
     */
    @SerializedName("temp_max")
    private Double temperatureMax;

    /**
     * Atmospheric pressure in hPa (hectopascals).
     */
    @SerializedName("pressure")
    private Integer pressure;

    /**
     * Sea level atmospheric pressure in hPa.
     */
    @SerializedName("sea_level")
    private Integer seaLevel;

    /**
     * Ground level atmospheric pressure in hPa.
     */
    @SerializedName("grnd_level")
    private Integer groundLevel;

    /**
     * Humidity percentage.
     */
    @SerializedName("humidity")
    private Integer humidity;

    /**
     * Temperature difference factor used for adjustments.
     */
    @SerializedName("temp_kf")
    private Double temperatureShift;

    /**
     * Constructs a new {@link MainInfoDto} with the specified weather parameters.
     *
     * @param temperature          the current temperature.
     * @param apparentTemperature  the apparent "feels like" temperature.
     * @param temperatureMin       the minimum temperature.
     * @param temperatureMax       the maximum temperature.
     * @param pressure              atmospheric pressure.
     * @param seaLevel              sea level atmospheric pressure.
     * @param groundLevel           ground level atmospheric pressure.
     * @param humidity              humidity percentage.
     * @param temperatureShift      temperature difference adjustment factor.
     */
    public MainInfoDto(Double temperature, Double apparentTemperature, Double temperatureMin, Double temperatureMax, Integer pressure, Integer seaLevel, Integer groundLevel, Integer humidity, Double temperatureShift) {
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.groundLevel = groundLevel;
        this.humidity = humidity;
        this.temperatureShift = temperatureShift;
    }

    // Getters and Setters...

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Integer seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Integer getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(Integer groundLevel) {
        this.groundLevel = groundLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getTemperatureShift() {
        return temperatureShift;
    }

    public void setTemperatureShift(Double temperatureShift) {
        this.temperatureShift = temperatureShift;
    }
}