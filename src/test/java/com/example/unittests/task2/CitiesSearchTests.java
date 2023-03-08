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
        String inputText = "Va";

        // when
        Set<String> foundCities = citiesSearch.search(inputText);

        // then
        assertEquals(Set.of("Vancouver", "Valencia"), foundCities);
    }

    @Test
    public void shouldFindCitiesThatContainInputText() {
        // given
        String inputText = "ape";

        // when
        Set<String> foundCities = citiesSearch.search(inputText);

        // then
        assertEquals(Set.of("Budapest"), foundCities);
    }

    @Test
    public void shouldFindCitiesThatEndWithInputText() {
        // given
        String inputText = "rdam";

        // when
        Set<String> foundCities = citiesSearch.search(inputText);

        // then
        assertEquals(Set.of("Rotterdam", "Amsterdam"), foundCities);
    }

    @Test
    public void shouldFindCitiesWithoutCaseSensitivity() {
        // given
        String inputText = "vA";

        // when
        Set<String> foundCities = citiesSearch.search(inputText);

        // then
        assertEquals(Set.of("Vancouver", "Valencia"), foundCities);
    }

    @Test
    public void shouldFindAllCitiesWhenInputTextIsAsterisk() {
        // given
        String inputText = "*";

        // when
        Set<String> foundCities = citiesSearch.search(inputText);

        // then
        assertEquals(Set.of(
                "Paris",
                "Budapest",
                "Skopje",
                "Rotterdam",
                "Valencia",
                "Vancouver",
                "Amsterdam",
                "Vienna",
                "Sydney",
                "New York City",
                "London",
                "Bangkok",
                "Hong Kong",
                "Dubai",
                "Rome",
                "Istanbul"
        ), foundCities);
    }

}
