package com.example.unittests.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
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
        // given
        BigDecimal amount = valueOf(-1);

        // when
        Executable actualTax = () -> taxCalculator.calculateTax(amount);

        // then
        RuntimeException actualException = assertThrows(RuntimeException.class, actualTax);
        assertEquals("Amount value should be greater than or equal to zero", actualException.getMessage());
    }

    @Test
    public void shouldNotChargeTaxWhenAmountIsZero() {
        // given
        BigDecimal amount = BigDecimal.ZERO;

        // when
        BigDecimal actualTax = taxCalculator.calculateTax(amount);

        // then
        assertEquals(rounded(BigDecimal.ZERO), actualTax);
    }

    @Test
    public void shouldNotChargeTaxWhenAmountIsTooLow() {
        // given
        BigDecimal amount = valueOf(500);

        // when
        BigDecimal actualTax = taxCalculator.calculateTax(amount);

        // then
        assertEquals(rounded(BigDecimal.ZERO), actualTax);
    }

    @Test
    public void shouldChargeStandardTaxWhenAmountIsBetweenFirstAndSecondTaxBracket() {
        // given
        BigDecimal amount = valueOf(1723);

        // when
        BigDecimal actualTax = taxCalculator.calculateTax(amount);

        // then
        assertEquals(rounded(valueOf(516.9)), actualTax);
    }

    @Test
    public void shouldChargeHigherTaxWhenAmountIsAboveSecondTaxBracket() {
        // given
        BigDecimal amount = valueOf(5100);

        // when
        BigDecimal actualTax = taxCalculator.calculateTax(amount);

        // then
        assertEquals(rounded(valueOf(2550)), actualTax);
    }

    private BigDecimal rounded(BigDecimal value) {
        return value.setScale(2, HALF_UP);
    }

}
