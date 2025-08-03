package dev.eighteendev.trackforce.data.mappers.entity;

import dev.eighteendev.trackforce.data.room.entities.CityEntity;
import dev.eighteendev.trackforce.domain.model.City;

/**
 * Mapper class for converting {@link CityEntity} database entities to {@link City} domain models.
 * <p>
 * This class handles the transformation of city-related data retrieved from the local database into domain models.
 */
public class CityEntityMapper {

    /**
     * Maps a {@link CityEntity} object to a {@link City} domain model.
     * <p>
     * Converts all city attributes including coordinates, population, and timezone.
     *
     * @param entity the {@link CityEntity} object representing a city stored in the local database.
     * @return a {@link City} domain model with the corresponding values.
     */
    public static City toDomain(CityEntity entity){
        return new City(
                entity.getId(),
                entity.getName(),
                CoordinateEntityMapper.toDomain(entity.getCoordinate()),
                entity.getCountry(),
                entity.getPopulation(),
                entity.getTimezone(),
                entity.getSunrise(),
                entity.getSunset()
        );
    }
}