package com.example.unittests.task2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
class CitiesSearchController {

    private final CitiesSearch citiesSearch;

    CitiesSearchController(CitiesSearch citiesSearch) {
        this.citiesSearch = citiesSearch;
    }

    @GetMapping("/cities")
    Set<String> search(@RequestParam String inputText) {
        return citiesSearch.search(inputText);
    }

}
