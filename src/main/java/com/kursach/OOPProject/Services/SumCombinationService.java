package com.kursach.OOPProject.Services;

import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.Dishes;
import com.kursach.OOPProject.repo.AllProductsRepository;
import com.kursach.OOPProject.repo.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SumCombinationService
{
    @Autowired
    AllProductsRepository allProductsRepository;

    @Autowired
    DishesRepository dishesRepository;



    public Map<String,List<Double>> combinationSum(List<Double> candidates,double target)
    {
        Map<String,List<Double>> result=new HashMap<>();
        Collections.sort(candidates);
        findCombinations(candidates,0,target, new ArrayList<>(),result);
        return result;
    }

    public Map<String,List<Double>> combinationSumForDishes(List<Double> candidates,double target)
    {
        Map<String,List<Double>> result=new HashMap<>();
        Collections.sort(candidates);
        findCombinationsForDishes(candidates,0,target, new ArrayList<>(),result);
        return result;
    }


    public void findCombinations(List<Double> candidates,int index,Double target,List<Double> current,Map<String,List<Double>> result)
    {
        List<AllProducts> listOfProducts=new ArrayList<>();
        if(target==0 || target<10 && target>=0)
        {
            for(Double value:new ArrayList<>(current))
            {
                listOfProducts.add(allProductsRepository.findByCalories(value));
            }

            List<String>listOfProductCombinations=new ArrayList<>();
            for(AllProducts allProducts:listOfProducts)
            {
                listOfProductCombinations.add(allProducts.getAnyProductName());
            }
            for(AllProducts allProducts:listOfProducts)
            {
              result.put(listOfProductCombinations.toString(),new ArrayList<>(current));
            }


            return;
        }

        if(target<0)
        {
            return;
        }

        for(int i =index;i<candidates.size();i++)
        {
            if(i==index || !candidates.get(i).equals(candidates.get(i - 1)))
            {
                current.add(candidates.get(i));
                findCombinations(candidates, i+1, target-candidates.get(i), current, result);
                current.remove(current.size()-1);

            }
        }
    }
    public void findCombinationsForDishes(List<Double> candidates,int index,Double target,List<Double> current,Map<String,List<Double>> result)
    {
        List<Dishes> listOfDishes=new ArrayList<>();
        if(target==0 || target<100 && target>=-100)
        {
            for(Double value:new ArrayList<>(current))
            {
                listOfDishes.add(dishesRepository.findByCalories(value));
            }
            List<String>listOfDishCombinations=new ArrayList<>();
            for(Dishes dishes:listOfDishes)
            {
                listOfDishCombinations.add(dishes.getDishName());
            }
            for(Dishes dishes:listOfDishes)
            {
                result.put(listOfDishCombinations.toString(),new ArrayList<>(current));
            }


            return;
        }

        if(target<0)
        {
            return;
        }

        for(int i =index;i<candidates.size();i++)
        {
            if(i==index || !candidates.get(i).equals(candidates.get(i - 1)))
            {
                current.add(candidates.get(i));
                findCombinationsForDishes(candidates, i+1, target-candidates.get(i), current, result);
                current.remove(current.size()-1);

            }
        }
    }

}
