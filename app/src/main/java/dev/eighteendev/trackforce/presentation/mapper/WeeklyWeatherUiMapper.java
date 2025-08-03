package dev.eighteendev.trackforce.presentation.mapper;

import android.util.Pair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import dev.eighteendev.trackforce.domain.model.Weather;
import dev.eighteendev.trackforce.domain.model.WeatherDetail;
import dev.eighteendev.trackforce.domain.model.WeeklyWeather;
import dev.eighteendev.trackforce.presentation.model.DailyWeatherUi;
import dev.eighteendev.trackforce.presentation.model.DailyWeatherSummary;
import dev.eighteendev.trackforce.presentation.model.WeeklyWeatherUi;

/**
 * Mapper class responsible for transforming the domain model {@link WeeklyWeather}
 * into a UI model {@link WeeklyWeatherUi} suitable for presentation.
 * <p>
 * This class performs:
 * <ul>
 *     <li>Extraction of the current (closest) weather detail</li>
 *     <li>Aggregation of daily summaries (min/max temperatures, icons, etc.)</li>
 *     <li>Grouping of detailed weather data per day for detailed forecasts</li>
 * </ul>
 */
public class WeeklyWeatherUiMapper {

    /**
     * Maps a {@link WeeklyWeather} domain object to a {@link WeeklyWeatherUi} presentation model.
     *
     * @param domain the {@link WeeklyWeather} domain data.
     * @return a fully populated {@link WeeklyWeatherUi} object.
     */
    public static WeeklyWeatherUi fromDomain(WeeklyWeather domain) {
        WeatherDetail closestDetail = findClosestWeatherDetail(domain.getWeekWeather());

        // Mapping the most current weather detail for main display.
        DailyWeatherUi actualWeather = new DailyWeatherUi(
                closestDetail.getWeather().get(0).getMainWeather(),
                (int) closestDetail.getMainInfo().getTemperature().doubleValue(),
                (int) closestDetail.getMainInfo().getApparentTemperature().doubleValue(),
                closestDetail.getMainInfo().getHumidity(),
                closestDetail.getWind().getSpeed().intValue(),
                closestDetail.getWeather().get(0).getIcon(),
                closestDetail.getTimestamp()
        );

        // Generate daily summaries and detailed lists grouped per day.
        Pair<List<DailyWeatherSummary>, Map<String, List<DailyWeatherUi>>> pair = dailyWeatherSummaryFromDomain(domain.getWeekWeather());

        // Build and return the final UI model.
        String city = domain.getCity().getName() + ", " + domain.getCity().getCountry();
        return new WeeklyWeatherUi(city, actualWeather, pair.first, pair.second);
    }

    /**
     * Aggregates weather details into:
     * <ul>
     *     <li>A list of {@link DailyWeatherSummary} for daily overview</li>
     *     <li>A map grouping {@link DailyWeatherUi} lists by day name for detailed display</li>
     * </ul>
     *
     * @param weatherDetails the list of detailed weather data.
     * @return a {@link Pair} containing the daily summary list and a map of detailed forecasts per day.
     */
    private static Pair<List<DailyWeatherSummary>, Map<String, List<DailyWeatherUi>>> dailyWeatherSummaryFromDomain(List<WeatherDetail> weatherDetails) {
        Map<String, List<WeatherDetail>> groupedByDay = weatherDetails.stream()
                .collect(Collectors.groupingBy(detail -> detail.getDate().substring(0, 10)));

        List<DailyWeatherSummary> summaries = new ArrayList<>();
        Map<String, List<DailyWeatherUi>> mapPerDay = new HashMap<>();

        groupedByDay.forEach((date, details) -> {
            long referenceTimestamp = findClosestToNoon(details);

            Integer minTemp = details.stream()
                    .map(detail -> detail.getMainInfo().getTemperatureMin().intValue())
                    .min(Integer::compareTo)
                    .orElse(null);

            Integer maxTemp = details.stream()
                    .map(detail -> detail.getMainInfo().getTemperatureMax().intValue())
                    .max(Integer::compareTo)
                    .orElse(null);

            String mostFrequentIcon = details.stream()
                    .flatMap(detail -> detail.getWeather().stream())
                    .collect(Collectors.groupingBy(Weather::getIcon, Collectors.counting()))
                    .entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            // Format day name based on locale.
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getDefault());
            String dayName = dateFormat.format(new Date(referenceTimestamp * 1000));
            if (!dayName.isEmpty()) {
                dayName = dayName.substring(0, 1).toUpperCase(Locale.getDefault()) + dayName.substring(1);
            }

            // Create and add the daily summary.
            DailyWeatherSummary summary = new DailyWeatherSummary(minTemp, maxTemp, dayName, mostFrequentIcon, referenceTimestamp);
            summaries.add(summary);

            // Create a detailed list of weather data for this day.
            ArrayList<DailyWeatherUi> dailyWeatherUiList = new ArrayList<>();
            details.forEach(detail -> {
                DailyWeatherUi newDetail = new DailyWeatherUi(
                        detail.getWeather().get(0).getMainWeather(),
                        (int) detail.getMainInfo().getTemperature().doubleValue(),
                        (int) detail.getMainInfo().getApparentTemperature().doubleValue(),
                        detail.getMainInfo().getHumidity(),
                        detail.getWind().getSpeed().intValue(),
                        detail.getWeather().get(0).getIcon(),
                        detail.getTimestamp()
                );
                dailyWeatherUiList.add(newDetail);
            });

            // Sort hourly details by timestamp.
            dailyWeatherUiList.sort(Comparator.comparingLong(DailyWeatherUi::getTimestamp));

            // Add to map using day name as key.
            mapPerDay.putIfAbsent(dayName, dailyWeatherUiList);
        });

        // Sort daily summaries by timestamp for chronological display.
        summaries.sort(Comparator.comparingLong(DailyWeatherSummary::getTimestamp));

        return new Pair<>(summaries, mapPerDay);
    }

    /**
     * Finds the {@link WeatherDetail} whose timestamp is closest to the current time.
     *
     * @param details the list of available weather details.
     * @return the {@link WeatherDetail} closest to now.
     */
    private static WeatherDetail findClosestWeatherDetail(List<WeatherDetail> details) {
        long currentTimestamp = System.currentTimeMillis() / 1000;

        WeatherDetail closest = null;
        long minDiff = Long.MAX_VALUE;

        for (WeatherDetail detail : details) {
            long diff = Math.abs(detail.getTimestamp() - currentTimestamp);
            if (diff < minDiff) {
                minDiff = diff;
                closest = detail;
            }
        }

        return closest;
    }

    /**
     * Finds the timestamp from a list of {@link WeatherDetail} that is closest to noon (12 PM).
     * Used for referencing the most representative time of day for summaries.
     *
     * @param details the list of weather details.
     * @return timestamp (in seconds) closest to 12 PM.
     */
    private static long findClosestToNoon(List<WeatherDetail> details) {
        final int NOON_HOUR = 12;

        return details.stream()
                .min((d1, d2) -> {
                    int d1Hour = new Date(d1.getTimestamp() * 1000).getHours();
                    int d2Hour = new Date(d2.getTimestamp() * 1000).getHours();

                    int d1Diff = Math.abs(d1Hour - NOON_HOUR);
                    int d2Diff = Math.abs(d2Hour - NOON_HOUR);

                    return Integer.compare(d1Diff, d2Diff);
                })
                .map(WeatherDetail::getTimestamp)
                .orElse(details.get(0).getTimestamp());
    }

}
