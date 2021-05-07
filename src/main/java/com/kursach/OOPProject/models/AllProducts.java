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
public class AllProducts
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String anyProductName;

    private double proteins,fats,carbohydrates,calories;

    public double getCalories() {
        return calories;
    }
}
