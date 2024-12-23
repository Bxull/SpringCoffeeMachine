package com.coffee.machine.repository;

import com.coffee.machine.model.Drink;
import com.coffee.machine.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByDrink(Drink drink);  // Находим рецепт для конкретного напитка
}