package com.example.unittests.task1;

import java.math.BigDecimal;
import java.util.Optional;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

class TaxCalculator2 {

    private static final BigDecimal NO_TAX = valueOf(0.0);
    private static final BigDecimal STANDARD_TAX = valueOf(0.3);
    private static final BigDecimal HIGHER_TAX = valueOf(0.5);
    private static final BigDecimal AMOUNT_LEVEL_FOR_STANDARD_TAX = valueOf(1000);
    private static final BigDecimal AMOUNT_LEVEL_FOR_HIGHER_TAX = valueOf(5000);

    BigDecimal calculateTax(BigDecimal amount) {
        return Optional.ofNullable(amount)
                .filter(this::isGreaterThanOrEqualToZero)
                .map(this::determineTaxPercent)
                .map(taxPercent -> calculateTax(amount, taxPercent))
                .orElseThrow(this::illegalAmountException);
    }

    private boolean isGreaterThanOrEqualToZero(BigDecimal value) {
        return value.compareTo(ZERO) >= 0;
    }

    private BigDecimal determineTaxPercent(BigDecimal amount) {
        if (amountQualifiesForStandardTax(amount)) {
            return STANDARD_TAX;
        }
        if (amountQualifiesForHigherTax(amount)) {
            return HIGHER_TAX;
        }
        return NO_TAX;
    }

    private BigDecimal calculateTax(BigDecimal amount, BigDecimal taxPercent) {
        return amount.multiply(taxPercent).setScale(2, HALF_UP);
    }

    private boolean amountQualifiesForStandardTax(BigDecimal amount) {
        return amount.compareTo(AMOUNT_LEVEL_FOR_STANDARD_TAX) >= 0 && amount.compareTo(AMOUNT_LEVEL_FOR_HIGHER_TAX) < 0;
    }

    private boolean amountQualifiesForHigherTax(BigDecimal amount) {
        return amount.compareTo(AMOUNT_LEVEL_FOR_HIGHER_TAX) >= 0;
    }

    private RuntimeException illegalAmountException() {
        return new RuntimeException("Amount value should be greater than or equal to zero");
    }

}
