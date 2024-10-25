package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list; /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount(); list.addCity(new City("Estevan", "SK")); assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City testCity = new City("Edmonton", "Alberta");
        assertFalse(cityList.hasCity(testCity));
        cityList.add(testCity);
        assertTrue(cityList.hasCity(testCity));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City testCity = new City("Edmonton", "Alberta");
        cityList.add(testCity);
        assertTrue(cityList.hasCity(testCity));
        cityList.delete(testCity);
        assertFalse(cityList.hasCity(testCity));
        assertThrows(IllegalArgumentException.class, () -> { cityList.delete(testCity); });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        City testCity1 = new City("Edmonton", "Alberta");
        City testCity2 = new City("Vancouver", "British Columbia");
        assertEquals(1, cityList.countCities());
        cityList.add(testCity1);
        assertEquals(2, cityList.countCities());
        cityList.add(testCity2);
        assertEquals(3, cityList.countCities());
        cityList.delete(testCity2);
        assertEquals(2, cityList.countCities());
    }

}
