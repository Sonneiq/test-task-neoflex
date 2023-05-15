package ru.neoflex.testtaskneoflex.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VacationCalculatorTest {

    @Test
    void getVacationPay() {
        VacationCalculator calculator = new VacationCalculator();

        assertEquals(0.0, calculator.getVacationPay(0,10));
        assertEquals(0.0, calculator.getVacationPay(50000,0));
        assertEquals(10238.9,calculator.getVacationPay(30000,10),5);

        double check = Double.MAX_VALUE / 29.3 * 28;

        assertEquals(check, calculator.getVacationPay(Double.MAX_VALUE, 28), 1);

        try {
            calculator.getVacationPay(-1,28);
        } catch (IllegalArgumentException exception1) {
            assertEquals("Salary < 0", exception1.getMessage());
        }

        try {
            calculator.getVacationPay(50000, -100);
        } catch (IllegalArgumentException exception2) {
            assertEquals("Days of vacation argument is wrong", exception2.getMessage());
        }
    }
}