package com.example.unittests.task2;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
class CitiesSearch {

    private static final Set<String> AVAILABLE_CITIES = Set.of(
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

    Set<String> search(String inputText) {
        if (inputText == null || inputText.length() < 2) {
            return Set.of();
        }

        return AVAILABLE_CITIES;
    }

}
