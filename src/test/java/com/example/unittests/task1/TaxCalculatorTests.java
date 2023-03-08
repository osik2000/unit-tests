package com.example.unittests.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxCalculatorTests {

    private final TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    public void shouldThrowExceptionWhenAmountIsNull() {
        // given
        BigDecimal amount = null;

        // when
        Executable actualTax = () -> taxCalculator.calculateTax(amount);

        // then
        RuntimeException actualException = assertThrows(RuntimeException.class, actualTax);
        assertEquals("Amount value should be greater than or equal to zero", actualException.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenAmountIsLessThanZero() {
    }

    @Test
    public void shouldNotChargeTaxWhenAmountIsZero() {

    }

    @Test
    public void shouldNotChargeTaxWhenAmountIsTooLow() {

    }

    @Test
    public void shouldChargeStandardTaxWhenAmountIsBetweenFirstAndSecondTaxBracket() {

    }

    @Test
    public void shouldChargeHigherTaxWhenAmountIsAboveSecondTaxBracket() {

    }

    private BigDecimal rounded(BigDecimal value) {
        return value.setScale(2, HALF_UP);
    }

}
