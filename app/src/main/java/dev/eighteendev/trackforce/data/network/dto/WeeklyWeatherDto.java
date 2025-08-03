package dev.eighteendev.trackforce.data.network.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Data Transfer Object (DTO) representing the weekly weather forecast response from the API.
 * <p>
 * This class encapsulates both metadata and a list of detailed weather forecasts for a given city.
 */
public class WeeklyWeatherDto {

    /**
     * Status code returned by the API. Typically "200" indicates a successful response.
     * Mapped from the JSON key "cod".
     */
    @SerializedName("cod")
    private String responseStatus;

    /**
     * Informational message or code provided by the API.
     * Mapped from the JSON key "message".
     */
    @SerializedName("message")
    private Double message;

    /**
     * Number of weather forecast entries returned in the list.
     * Mapped from the JSON key "cnt".
     */
    @SerializedName("cnt")
    private Integer resultCount;

    /**
     * List of detailed weather forecasts for specific timestamps.
     * Mapped from the JSON key "list".
     */
    @SerializedName("list")
    private List<WeatherDetailDto> weekWeatherDetail;

    /**
     * Information about the city for which the forecast applies.
     * Mapped from the JSON key "city".
     */
    @SerializedName("city")
    private CityDto city;

    /**
     * Constructs a new {@link WeeklyWeatherDto} instance with all necessary forecast data.
     *
     * @param responseStatus     the API response status code.
     * @param message             the API informational message or code.
     * @param resultCount         number of forecast entries returned.
     * @param weekWeatherDetail   list of {@link WeatherDetailDto} objects.
     * @param city                {@link CityDto} representing the forecasted city.
     */
    public WeeklyWeatherDto(String responseStatus, Double message, Integer resultCount, List<WeatherDetailDto> weekWeatherDetail, CityDto city) {
        this.responseStatus = responseStatus;
        this.message = message;
        this.resultCount = resultCount;
        this.weekWeatherDetail = weekWeatherDetail;
        this.city = city;
    }

    /**
     * @return the API response status code.
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the API response status code.
     *
     * @param responseStatus status code.
     */
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * @return the API informational message or code.
     */
    public Double getMessage() {
        return message;
    }

    /**
     * Sets the API informational message or code.
     *
     * @param message message value.
     */
    public void setMessage(Double message) {
        this.message = message;
    }

    /**
     * @return number of forecast entries returned.
     */
    public Integer getResultCount() {
        return resultCount;
    }

    /**
     * Sets the number of forecast entries returned.
     *
     * @param resultCount entry count.
     */
    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * @return list of weather forecast details.
     */
    public List<WeatherDetailDto> getWeekWeatherDetail() {
        return weekWeatherDetail;
    }

    /**
     * Sets the list of weather forecast details.
     *
     * @param weekWeatherDetail list of {@link WeatherDetailDto}.
     */
    public void setWeekWeatherDetail(List<WeatherDetailDto> weekWeatherDetail) {
        this.weekWeatherDetail = weekWeatherDetail;
    }

    /**
     * @return the city information associated with this forecast.
     */
    public CityDto getCity() {
        return city;
    }

    /**
     * Sets the city information associated with this forecast.
     *
     * @param city {@link CityDto} object.
     */
    public void setCity(CityDto city) {
        this.city = city;
    }
}