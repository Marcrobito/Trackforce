package dev.eighteendev.trackforce.domain.model;

import java.util.List;

public class WeatherDetail {
    private Long timestamp;
    private MainInfo mainInfo;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Integer visibility;
    private Double probabilityOfPrecipitation;
    private SysInfo sysInfo;
    private String date;
    private WeatherDuration rain;
    private WeatherDuration snow;

    public WeatherDetail(Long timestamp, MainInfo mainInfo, List<Weather> weather, Clouds clouds, Wind wind, Integer visibility, Double probabilityOfPrecipitation, SysInfo sysInfo, String date, WeatherDuration rain, WeatherDuration snow) {
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

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
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

    public SysInfo getSysInfo() {
        return sysInfo;
    }

    public void setSysInfo(SysInfo sysInfo) {
        this.sysInfo = sysInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherDuration getRain() {
        return rain;
    }

    public void setRain(WeatherDuration rain) {
        this.rain = rain;
    }

    public WeatherDuration getSnow() {
        return snow;
    }

    public void setSnow(WeatherDuration snow) {
        this.snow = snow;
    }
}
