package com.kursach.OOPProject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class MilkProducts extends CustomersProducts
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String milkProductName;
    private double proteins,fats,carbohydrates,calories;


}
