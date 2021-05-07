package com.kursach.OOPProject.Services;


import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.Dishes;
import com.kursach.OOPProject.repo.AllProductsRepository;
import com.kursach.OOPProject.repo.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class MinorFunctionsService
{
    @Autowired
    AllProductsRepository allProductsRepository;

    @Autowired
    DishesRepository dishesRepository;

    @Autowired
    AllProducts allProducts;

    @Autowired
    Optional<Dishes> dishes;

    public AllProducts getProductInfo(String buf)
    {
        allProducts= allProductsRepository.findByAnyProductName(buf);
        return allProducts;
    }

    public double bmiCalculation(String weight,String height)
    {
        double bodyMassIndex;
        bodyMassIndex = Double.parseDouble(weight)/(Double.parseDouble(height)*Double.parseDouble(height)/100/100);
        return bodyMassIndex;
    }

    public Optional<Dishes> getRandomDish()
    {
        dishes=dishesRepository.findById(ThreadLocalRandom.current().nextLong(1, dishesRepository.count()+1));
         return dishes;
    }

}