package dev.eighteendev.trackforce.domain.model;

/**
 * Represents the main weather information for a specific time interval.
 * This includes temperatures, pressure, humidity, and other atmospheric details.
 */
public class MainInfo {
    private Double temperature;
    private Double apparentTemperature;
    private Double temperatureMin;
    private Double temperatureMax;
    private Integer pressure;
    private Integer seaLevel;
    private Integer groundLevel;
    private Integer humidity;
    private Double temperatureShift;

    /**
     * Constructs a new {@code MainInfo} object with the provided weather details.
     *
     * @param temperature         The current temperature (in Celsius).
     * @param apparentTemperature The perceived (feels like) temperature.
     * @param temperatureMin      The minimum temperature within the time period.
     * @param temperatureMax      The maximum temperature within the time period.
     * @param pressure             Atmospheric pressure (in hPa).
     * @param seaLevel             Sea level atmospheric pressure (in hPa).
     * @param groundLevel          Ground level atmospheric pressure (in hPa).
     * @param humidity             Humidity percentage.
     * @param temperatureShift     Internal temperature shift factor (temp_kf).
     */
    public MainInfo(Double temperature, Double apparentTemperature, Double temperatureMin, Double temperatureMax,
                    Integer pressure, Integer seaLevel, Integer groundLevel, Integer humidity, Double temperatureShift) {
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

    /**
     * @return The current temperature (in Celsius).
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * Sets the current temperature.
     *
     * @param temperature The temperature to set.
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return The perceived (feels like) temperature.
     */
    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    /**
     * Sets the apparent temperature.
     *
     * @param apparentTemperature The apparent temperature to set.
     */
    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    /**
     * @return The minimum temperature in the time period.
     */
    public Double getTemperatureMin() {
        return temperatureMin;
    }

    /**
     * Sets the minimum temperature in the time period.
     *
     * @param temperatureMin The minimum temperature to set.
     */
    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    /**
     * @return The maximum temperature in the time period.
     */
    public Double getTemperatureMax() {
        return temperatureMax;
    }

    /**
     * Sets the maximum temperature in the time period.
     *
     * @param temperatureMax The maximum temperature to set.
     */
    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    /**
     * @return Atmospheric pressure (in hPa).
     */
    public Integer getPressure() {
        return pressure;
    }

    /**
     * Sets the atmospheric pressure.
     *
     * @param pressure The pressure to set (in hPa).
     */
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    /**
     * @return Sea level atmospheric pressure (in hPa).
     */
    public Integer getSeaLevel() {
        return seaLevel;
    }

    /**
     * Sets the sea level atmospheric pressure.
     *
     * @param seaLevel The sea level pressure to set (in hPa).
     */
    public void setSeaLevel(Integer seaLevel) {
        this.seaLevel = seaLevel;
    }

    /**
     * @return Ground level atmospheric pressure (in hPa).
     */
    public Integer getGroundLevel() {
        return groundLevel;
    }

    /**
     * Sets the ground level atmospheric pressure.
     *
     * @param groundLevel The ground level pressure to set (in hPa).
     */
    public void setGroundLevel(Integer groundLevel) {
        this.groundLevel = groundLevel;
    }

    /**
     * @return The humidity percentage.
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * Sets the humidity percentage.
     *
     * @param humidity The humidity value to set.
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * @return The internal temperature shift factor (temp_kf).
     */
    public Double getTemperatureShift() {
        return temperatureShift;
    }

    /**
     * Sets the temperature shift factor.
     *
     * @param temperatureShift The temperature shift factor to set.
     */
    public void setTemperatureShift(Double temperatureShift) {
        this.temperatureShift = temperatureShift;
    }
}