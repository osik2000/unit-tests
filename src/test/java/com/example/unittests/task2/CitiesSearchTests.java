package com.example.unittests.task2;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CitiesSearchTests {

    @Test
    void shouldNotReturnAnyResultForTooShortInput(){
        // given
        String input = "f";
        CitiesSearch citiesSearch = new CitiesSearch();
        // when
        Set<String> result = citiesSearch.search(input);
        // then
        assertThat(result).isEmpty();
    }

    @Test
    void shouldNotReturnAnyResultForNullInput(){
        // given
        String input = null;
        CitiesSearch citiesSearch = new CitiesSearch();
        // when
        Set<String> result = citiesSearch.search(input);
        // then
        assertThat(result).isEmpty();
    }

    @Test
    void shouldFindTheCityWhichBeginsLikeInput(){
        // given
        String input = "Va";
        CitiesSearch citiesSearch = new CitiesSearch();
        // when
        Set<String> result = citiesSearch.search(input);
        // then
        assertThat(result).isEqualTo(Set.of("Valencia","Vancouver"));
    }

    @Test
    void shouldFindTheCityWhichContainsPartOfTheWord(){
        // given
        String input = "ape";
        CitiesSearch citiesSearch = new CitiesSearch();
        // when
        Set<String> result = citiesSearch.search(input);
        // then
        assertThat(result).isEqualTo(Set.of("Budapest"));
    }

    @Test
    void shouldFindTheCityWithoutCaseSensitivity(){
        // given
        String input = "va"; // instead of "Va"
        CitiesSearch citiesSearch = new CitiesSearch();
        // when
        Set<String> result = citiesSearch.search(input);
        // then
        assertThat(result).isEqualTo(Set.of("Valencia","Vancouver"));
    }

    @Test
    void shouldFindAllTheCitiesWhenInputIsAsterisk(){
        // given
        String input = "*"; // instead of "Va"
        CitiesSearch citiesSearch = new CitiesSearch();
        Set<String> allCities = Set.of(
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
        );
        // when
        Set<String> result = citiesSearch.search(input);
        // then
        assertThat(result).isEqualTo(allCities);
    }

}
