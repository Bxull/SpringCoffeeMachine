package com.coffee.machine.controller;

import com.coffee.machine.model.Drink;
import com.coffee.machine.service.DrinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @PostMapping("/{id}/prepare")
    public String prepareDrink(@PathVariable Long id) {
        return drinkService.prepareDrink(id);
    }
}
