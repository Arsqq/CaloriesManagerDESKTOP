package com.kursach.OOPProject.Services;


import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.repo.AllProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class CaloriesCalculatorService
{
    @Autowired
    AllProductsRepository allProductsRepository;

    @Autowired
    AllProducts allProducts;

    public AllProducts getProductInfo(String buf)
    {
        allProducts= allProductsRepository.findByAnyProductName(buf);
        System.out.println(allProducts.getAnyProductName());
        return allProducts;
    }

}