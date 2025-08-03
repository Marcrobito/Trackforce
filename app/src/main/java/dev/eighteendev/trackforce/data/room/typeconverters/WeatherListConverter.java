package dev.eighteendev.trackforce.data.room.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import dev.eighteendev.trackforce.data.room.entities.WeatherEntity;

/**
 * TypeConverter class for converting a List of {@link WeatherEntity} objects
 * to and from a JSON String for Room database storage.
 * <p>
 * Since Room doesn't support storing Lists of custom objects directly, this converter
 * serializes the List into a JSON String and deserializes it back to a List when reading from the database.
 */
public class WeatherListConverter {

    /**
     * Converts a {@link List} of {@link WeatherEntity} objects into a JSON {@link String}.
     *
     * @param list the {@link List} of WeatherEntity objects to be serialized.
     * @return a JSON {@link String} representing the list.
     */
    @TypeConverter
    public String fromList(List<WeatherEntity> list) {
        return new Gson().toJson(list);
    }

    /**
     * Converts a JSON {@link String} back into a {@link List} of {@link WeatherEntity} objects.
     *
     * @param json the JSON {@link String} representing the list of WeatherEntity.
     * @return a {@link List} of {@link WeatherEntity} objects.
     */
    @TypeConverter
    public List<WeatherEntity> toList(String json) {
        Type type = new TypeToken<List<WeatherEntity>>() {}.getType();
        return new Gson().fromJson(json, type);
    }
}