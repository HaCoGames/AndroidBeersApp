package dev.hafnerp.breweryfrontend.model;

import java.io.Serializable;

public class Beer implements Serializable {
    private Integer id = 0;
    private String name = "Name";
    private Double alcohol = 4.8;
    private Double calories = 230.5;
    private Category category = Category.White;

    public Beer(Integer id, String name, Double alcohol, Double calories, Category category) {
        this.id = id;
        this.name = name;
        this.alcohol = alcohol;
        this.calories = calories;
        this.category = category;
    }

    public Beer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alcohol=" + alcohol +
                ", calories=" + calories +
                ", category=" + category +
                '}';
    }
}
