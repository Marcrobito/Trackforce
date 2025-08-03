package dev.eighteendev.trackforce.data.mappers.domain;

import dev.eighteendev.trackforce.data.room.entities.CityEntity;
import dev.eighteendev.trackforce.domain.model.City;

/**
 * Mapper class for converting a {@link City} domain model to a {@link CityEntity} database entity.
 * <p>
 * This class provides utility methods to map domain models used in the business logic layer
 * to entities suitable for persistence in the local database.
 */
public class CityMapper {

    /**
     * Converts a {@link City} domain model to a {@link CityEntity}.
     *
     * @param city the {@link City} domain model to be converted.
     * @return a {@link CityEntity} representing the database entity of the given city.
     */
    public static CityEntity toEntity(City city) {
        return new CityEntity(
                city.getId(),
                city.getName(),
                CoordinateMapper.toEntity(city.getCoordinate()),
                city.getCountry(),
                city.getPopulation(),
                city.getTimezone(),
                city.getSunrise(),
                city.getSunset()
        );
    }
}