package com.coffee.machine.service;

import com.coffee.machine.model.Drink;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrinkService {

    public List<Drink> getAllDrinks();

    public String prepareDrink(Long id);
}
