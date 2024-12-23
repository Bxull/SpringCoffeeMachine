package com.coffee.machine.model;

import jakarta.persistence.*;

@Entity
public class DrinkStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    private int orderCount;  // Количество заказов для напитка

    // Конструкторы
    public DrinkStatistic() {}

    public DrinkStatistic(Drink drink) {
        this.drink = drink;
        this.orderCount = 0;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    // Методы для увеличения популярности
    public void incrementOrderCount() {
        this.orderCount++;
    }

    // Equals и hashCode
}
