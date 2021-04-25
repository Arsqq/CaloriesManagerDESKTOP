package com.kursach.OOPProject.Services;


import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.CerealProducts;
import com.kursach.OOPProject.models.CustomersProducts;
import com.kursach.OOPProject.models.MilkProducts;
import com.kursach.OOPProject.repo.AllProductsRepository;
import com.kursach.OOPProject.repo.CerealProductsRepository;
import com.kursach.OOPProject.repo.MilkProductsRepository;
import com.kursach.OOPProject.repo.SeaFoodRepository;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CaloriesCalculatorService
{
    @Autowired
    AllProductsRepository allProductsRepository;


    public void getCaloriesInfo(TextField txt)
    {
        String buffer=txt.getText();
        System.out.println(allProductsRepository.findByAnyProductName(buffer).getAnyProductName()+allProductsRepository.findByAnyProductName(buffer).getCalories());

    }
}

