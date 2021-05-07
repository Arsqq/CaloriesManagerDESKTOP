package com.kursach.OOPProject.models;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class CustomersProducts
{
    private String productName;

    private double proteins,fats,carbohydrates,calories;
}
