package dev.eighteendev.trackforce.domain.model;

import java.util.List;

/**
 * Represents a weekly weather forecast response containing overall metadata and detailed weather data.
 */
public class WeeklyWeather {
    private String responseStatus;
    private Double message;
    private Integer resultCount;
    private List<WeatherDetail> weekWeatherDetail;
    private City city;

    /**
     * Constructs a new {@code WeeklyWeather} object.
     *
     * @param responseStatus     The status code or message returned by the weather API.
     * @param message             Additional information or metadata from the API response.
     * @param resultCount         The total number of weather entries returned in the response.
     * @param weekWeatherDetail   A list of detailed weather forecasts for the upcoming days.
     * @param city                The city information associated with this weather forecast.
     */
    public WeeklyWeather(String responseStatus, Double message, Integer resultCount, List<WeatherDetail> weekWeatherDetail, City city) {
        this.responseStatus = responseStatus;
        this.message = message;
        this.resultCount = resultCount;
        this.weekWeatherDetail = weekWeatherDetail;
        this.city = city;
    }

    /**
     * @return The status of the API response.
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the status of the API response.
     *
     * @param responseStatus The status to set.
     */
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * @return Additional message or metadata from the API response.
     */
    public Double getMessage() {
        return message;
    }

    /**
     * Sets additional message or metadata from the API response.
     *
     * @param message The message to set.
     */
    public void setMessage(Double message) {
        this.message = message;
    }

    /**
     * @return The number of weather result entries in the response.
     */
    public Integer getResultCount() {
        return resultCount;
    }

    /**
     * Sets the number of weather result entries in the response.
     *
     * @param resultCount The count to set.
     */
    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * @return The list of weather detail entries for the week.
     */
    public List<WeatherDetail> getWeekWeather() {
        return weekWeatherDetail;
    }

    /**
     * Sets the list of weather detail entries for the week.
     *
     * @param weekWeatherDetail The list of details to set.
     */
    public void setWeekWeather(List<WeatherDetail> weekWeatherDetail) {
        this.weekWeatherDetail = weekWeatherDetail;
    }

    /**
     * @return The city associated with this weather forecast.
     */
    public City getCity() {
        return city;
    }

    /**
     * Sets the city associated with this weather forecast.
     *
     * @param city The city to set.
     */
    public void setCity(City city) {
        this.city = city;
    }
}