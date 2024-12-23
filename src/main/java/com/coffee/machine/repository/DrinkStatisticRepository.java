package com.coffee.machine.repository;

import com.coffee.machine.model.Drink;
import com.coffee.machine.model.DrinkStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkStatisticRepository extends JpaRepository<DrinkStatistic, Long> {
    // Метод для нахождения самого популярного напитка
    Drink findTopByOrderByPopularityDesc();
}