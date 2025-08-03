package dev.eighteendev.trackforce;

import org.junit.Assert;
import org.junit.Test;

import dev.eighteendev.trackforce.data.mappers.domain.CityMapper;
import dev.eighteendev.trackforce.data.room.entities.CityEntity;
import dev.eighteendev.trackforce.domain.model.City;
import dev.eighteendev.trackforce.domain.model.Coordinate;

public class CityMapperTest {

    @Test
    public void toEntity_shouldMapCorrectly() {
        // Arrange
        City city = new City(
                123,
                "TestCity",
                new Coordinate(10.5, 20.5),
                "MX",
                500000L,
                3600L,
                1610000000L,
                1610050000L
        );

        // Act
        CityEntity entity = CityMapper.toEntity(city);

        // Assert
        Assert.assertEquals(city.getId(), entity.getId());
        Assert.assertEquals(city.getName(), entity.getName());
        Assert.assertEquals(city.getCountry(), entity.getCountry());
        Assert.assertEquals(city.getPopulation(), entity.getPopulation());
        Assert.assertEquals(city.getTimezone(), entity.getTimezone());
        Assert.assertEquals(city.getSunrise(), entity.getSunrise());
        Assert.assertEquals(city.getSunset(), entity.getSunset());
        Assert.assertEquals(city.getCoordinate().getLatitude(), entity.getCoordinate().getLatitude(), 0.0001);
        Assert.assertEquals(city.getCoordinate().getLongitude(), entity.getCoordinate().getLongitude(), 0.0001);
    }
}
