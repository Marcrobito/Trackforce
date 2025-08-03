package dev.eighteendev.trackforce.data.room.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import dev.eighteendev.trackforce.data.room.entities.WeatherDetailEntity;

/**
 * TypeConverter class for converting a List of {@link WeatherDetailEntity} objects
 * to and from a JSON String for Room database storage.
 * <p>
 * Room doesn't support complex nested objects like Lists directly, so this converter
 * serializes/deserializes the List into a JSON String using Gson.
 */
public class WeatherDetailListConverter {

    private static final Gson gson = new Gson();

    /**
     * Converts a JSON {@link String} to a {@link List} of {@link WeatherDetailEntity} objects.
     *
     * @param value JSON string representing the list of WeatherDetailEntity.
     * @return a {@link List} of {@link WeatherDetailEntity} objects.
     */
    @TypeConverter
    public static List<WeatherDetailEntity> fromJson(String value) {
        Type listType = new TypeToken<List<WeatherDetailEntity>>() {}.getType();
        return gson.fromJson(value, listType);
    }

    /**
     * Converts a {@link List} of {@link WeatherDetailEntity} objects to a JSON {@link String}.
     *
     * @param list the {@link List} of WeatherDetailEntity to be converted.
     * @return a JSON {@link String} representing the list.
     */
    @TypeConverter
    public static String toJson(List<WeatherDetailEntity> list) {
        return gson.toJson(list);
    }
}