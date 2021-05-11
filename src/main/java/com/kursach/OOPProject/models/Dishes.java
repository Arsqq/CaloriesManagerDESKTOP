package com.kursach.OOPProject.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Data
@Entity
public class Dishes
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String dishName,composition;
    private double proteins,fats,carbohydrates,calories;

    public double getCalories() {
        return calories;
    }

}
