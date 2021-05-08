package com.kursach.OOPProject.Services;

import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.repo.AllProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SumCombinationService
{
    @Autowired
    AllProductsRepository allProductsRepository;



    public Map<String,List<Double>> combinationSum(List<Double> candidates,double target)
    {
        Map<String,List<Double>> result=new HashMap<>();
        Collections.sort(candidates);
        findCombinations(candidates,0,target, new ArrayList<>(),result);
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
}
