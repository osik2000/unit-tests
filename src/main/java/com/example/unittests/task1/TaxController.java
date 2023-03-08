package com.example.unittests.task1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
class TaxController {

    private final TaxCalculator taxCalculator;

    TaxController(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @GetMapping("/tax")
    BigDecimal calculateTax(@RequestParam BigDecimal amount) {
        return taxCalculator.calculateTax(amount);
    }

}
