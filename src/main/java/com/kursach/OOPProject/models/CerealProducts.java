package com.kursach.OOPProject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class CerealProducts
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String cerealProductName;

    private double proteins,fats,carbohydrates,calories;
}
