package ru.neoflex.testtaskneoflex.models;

import org.springframework.stereotype.Component;

@Component
public class VacationCalculator {
    private final double AVERAGE_DAYS_IN_MONTH = 29.3;

    public double getVacationPay(double salary, int days) {
        if(salary < 0) {
            throw new IllegalArgumentException("Salary < 0");
        } else if(days < 0) {
            throw new IllegalArgumentException("Days of vacation argument is wrong");
        }
        double result = salary / AVERAGE_DAYS_IN_MONTH * days;
        return result;
    }
}
