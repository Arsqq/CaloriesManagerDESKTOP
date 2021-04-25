package com.kursach.OOPProject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SeaFood extends CustomersProducts
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String seaFoodName;
    private double proteins,fats,carbohydrates,calories;


}
