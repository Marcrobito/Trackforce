package dev.eighteendev.trackforce.data.room.entities;

/**
 * Entity class representing main weather information for a specific forecast timestamp.
 * <p>
 * This class holds temperature-related data, pressure, humidity, and related metrics,
 * and is stored in the local Room database.
 */
public class MainInfoEntity {

    /** Current temperature in Celsius. */
    private Double temperature;

    /** Feels-like temperature in Celsius. */
    private Double apparentTemperature;

    /** Minimum temperature observed during the period. */
    private Double temperatureMin;

    /** Maximum temperature observed during the period. */
    private Double temperatureMax;

    /** Atmospheric pressure in hPa (hectopascals). */
    private Integer pressure;

    /** Atmospheric pressure at sea level in hPa. */
    private Integer seaLevel;

    /** Atmospheric pressure at ground level in hPa. */
    private Integer groundLevel;

    /** Humidity percentage (0 - 100%). */
    private Integer humidity;

    /** Temperature adjustment coefficient (used for fine-grained forecast modeling). */
    private Double temperatureShift;

    /**
     * Constructs a {@link MainInfoEntity} with all main weather metrics.
     *
     * @param temperature          current temperature.
     * @param apparentTemperature  feels-like temperature.
     * @param temperatureMin       minimum temperature.
     * @param temperatureMax       maximum temperature.
     * @param pressure              atmospheric pressure.
     * @param seaLevel              sea level pressure.
     * @param groundLevel           ground level pressure.
     * @param humidity              humidity percentage.
     * @param temperatureShift      temperature adjustment coefficient.
     */
    public MainInfoEntity(Double temperature, Double apparentTemperature, Double temperatureMin, Double temperatureMax,
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

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getApparentTemperature() { return apparentTemperature; }
    public void setApparentTemperature(Double apparentTemperature) { this.apparentTemperature = apparentTemperature; }

    public Double getTemperatureMin() { return temperatureMin; }
    public void setTemperatureMin(Double temperatureMin) { this.temperatureMin = temperatureMin; }

    public Double getTemperatureMax() { return temperatureMax; }
    public void setTemperatureMax(Double temperatureMax) { this.temperatureMax = temperatureMax; }

    public Integer getPressure() { return pressure; }
    public void setPressure(Integer pressure) { this.pressure = pressure; }

    public Integer getSeaLevel() { return seaLevel; }
    public void setSeaLevel(Integer seaLevel) { this.seaLevel = seaLevel; }

    public Integer getGroundLevel() { return groundLevel; }
    public void setGroundLevel(Integer groundLevel) { this.groundLevel = groundLevel; }

    public Integer getHumidity() { return humidity; }
    public void setHumidity(Integer humidity) { this.humidity = humidity; }

    public Double getTemperatureShift() { return temperatureShift; }
    public void setTemperatureShift(Double temperatureShift) { this.temperatureShift = temperatureShift; }
}