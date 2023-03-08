package com.example.unittests.task2;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CitiesSearchTests {

    private final CitiesSearch citiesSearch = new CitiesSearch();

    @Test
    public void shouldNotFindAnyCityWhenInputTextIsNull() {
        // given
        String inputText = null;

        // when
        Set<String> foundCities = citiesSearch.search(inputText);

        // then
        assertEquals(Set.of(), foundCities);
    }

    @Test
    public void shouldNotFindAnyCityWhenInputTextIsTooShort() {
        // given
        String inputText = "B";

        // when
        Set<String> foundCities = citiesSearch.search(inputText);

        // then
        assertEquals(Set.of(), foundCities);
    }

    @Test
    public void shouldFindCitiesThatStartWithInputText() {
        // given
        String cityToSearch = "Va";

        // when
        Set<String> foundCities = citiesSearch.search(cityToSearch);

        // then
        assertEquals(Set.of("Vancouver", "Valencia"), foundCities);
    }

    @Test
    public void shouldFindCitiesThatContainInputText() {
        // given
        String cityToSearch = "ape";

        // when
        Set<String> foundCities = citiesSearch.search(cityToSearch);

        // then
        assertEquals(Set.of("Budapest"), foundCities);
    }

    @Test
    public void shouldFindCitiesThatEndWithInputText() {
        // given
        String cityToSearch = "rdam";

        // when
        Set<String> foundCities = citiesSearch.search(cityToSearch);

        // then
        assertEquals(Set.of("Rotterdam", "Amsterdam"), foundCities);
    }

    @Test
    public void shouldFindCitiesWithoutCaseSensitivity() {
        // given
        String cityToSearch = "vA";

        // when
        Set<String> foundCities = citiesSearch.search(cityToSearch);

        // then
        assertEquals(Set.of("Vancouver", "Valencia"), foundCities);
    }

}
