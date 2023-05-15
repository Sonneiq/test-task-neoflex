package ru.neoflex.testtaskneoflex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neoflex.testtaskneoflex.models.VacationCalculator;

@Controller
public class VacationCalculatorsController {

    private final VacationCalculator vacationCalculator;

    @Autowired
    public VacationCalculatorsController(VacationCalculator vacationCalculator) {
        this.vacationCalculator = vacationCalculator;
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "salary") double salary,
                            @RequestParam(value = "days") int days, Model model) {

        double vacationPay = vacationCalculator.getVacationPay(salary, days);
        model.addAttribute("pay", String.format("%.2f", vacationPay));
        return "vacationcalculator";
    }
}
