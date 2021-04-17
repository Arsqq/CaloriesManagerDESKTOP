package com.kursach.OOPProject.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class MilkProducts
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String milkProductName;
    private double proteins,fats,carbohydrates,calories;


}
