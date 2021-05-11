package com.kursach.OOPProject.Services;


import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.Dishes;
import com.kursach.OOPProject.repo.AllProductsRepository;
import com.kursach.OOPProject.repo.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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

    @Autowired
    Dishes dishesTwo;

    public AllProducts getProductInfo(String buf)
    {
        allProducts= allProductsRepository.findByAnyProductNameIgnoreCase(buf);
        return allProducts;
    }

    public Dishes getDishInfo(String buf)
    {
        dishesTwo=(dishesRepository.findByDishNameIgnoreCase(buf));
        return dishesTwo;
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

    public Map<String,String> setRandomImage()
    {
        Map<String, String> imageMap=new HashMap<>();
        imageMap.put("Яичница с беконом","Pictures/kisspng-bacon-egg-and-cheese-sandwich-breakfast-fried-egg-love-breakfast-5a8fa93802a434.3142003315193644080108.png");
        imageMap.put("Гуляш из говядины","Pictures/gulyash_iz_tuhenki.png");
        imageMap.put("Семга на пару","Pictures/65.jpg");
        imageMap.put("Солянка мясная сборная","Pictures/unnamed.png");
        imageMap.put("Грибной крем-суп","Pictures/супец.jpg");
        imageMap.put("Салат греческий","Pictures/салат-греческий-png-1-Transparent-Images.png");
        imageMap.put("Салат Цезарь","Pictures/imgbin_chicken-salad-caesar-salad-vinaigrette-healthy-diet-png.png");
        imageMap.put("Мясо по-французски","Pictures/img_5c082515c304e.png");
        imageMap.put("Минтай жареный в кляре","Pictures/31a34bc7ddbd78b0a71caa60b6566713.png");
        imageMap.put("Куриное филе","Pictures/ptimjas017.png");




        return imageMap;
    }

}