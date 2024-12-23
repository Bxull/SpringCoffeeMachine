package com.coffee.machine.service.Impl;

import com.coffee.machine.model.Drink;
import com.coffee.machine.model.Ingredient;
import com.coffee.machine.model.Recipe;
import com.coffee.machine.repository.DrinkRepository;
import com.coffee.machine.repository.DrinkStatisticRepository;
import com.coffee.machine.repository.IngredientRepository;
import com.coffee.machine.repository.RecipeRepository;
import com.coffee.machine.service.DrinkService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository drinkRepository;
    private final IngredientRepository ingredientRepository;

    private final DrinkStatisticRepository drinkStatisticRepository;
    private final RecipeRepository recipeRepository;
    public DrinkServiceImpl(DrinkRepository drinkRepository, IngredientRepository ingredientRepository, DrinkStatisticRepository drinkStatisticRepository, RecipeRepository recipeRepository) {
        this.drinkRepository = drinkRepository;
        this.ingredientRepository = ingredientRepository;
        this.drinkStatisticRepository = drinkStatisticRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }
    @Transactional
    @Override
    public String prepareDrink(Long id) {
        Optional<Drink> drinkById = drinkRepository.findById(id);
        if (drinkById.isEmpty()){
            return "Кофе не найдено";
        }

        Drink drink = drinkById.get();

        if (!checkIngredients(drink)){
            return "Недостаточно инградинентов для кофе" + drink.getName();
        }

        reduceIngredients(drink);

        updateDrinkPopularity(drink);

        return "Напиток " + drink.getName() + " готов!";
    }

    public Ingredient getIngredient(String name) {
        Optional<Ingredient> ingredient = ingredientRepository.findByName(name);
        return ingredient.orElseThrow(() -> new RuntimeException("Ингредиент " + name + " не найден"));
    }
    private boolean checkIngredients(Drink drink) {
        List<Recipe> recipeList = recipeRepository.findByDrink(drink);

        for (Recipe recipe: recipeList){
            Ingredient ingredient = recipe.getIngredient();
        }
        return true; // Вернем true для упрощения, это нужно детализировать
    }

    private void reduceIngredients(Drink drink) {
        // Логика уменьшения количества ингредиентов
    }

    private void updateDrinkPopularity(Drink drink) {
        drink.setPopularity(drink.getPopularity() + 1);
        drinkRepository.save(drink);

    }
}
