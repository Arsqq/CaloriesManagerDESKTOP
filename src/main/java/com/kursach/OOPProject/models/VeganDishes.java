package com.kursach.OOPProject.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class VeganDishes
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String veganDishName,composition;
    private double proteins,fats,carbohydrates,calories;

}
