package com.kursach.OOPProject.Controllers;

import com.kursach.OOPProject.Services.SumCombinationService;
import com.kursach.OOPProject.models.AllProducts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CaloriesNormController
{

    @FXML
    private Button breakfastButton;

    @FXML
    private Button lunchButton;

    @FXML
    private Button dinnerButton;

    @Autowired
    SumCombinationService sumCombinationService;

    @Autowired
    CartTextAreaController cartTextAreaController;

    public void getMorningCombination()
    {
        List<Double> caloriesList=new ArrayList<>();
        List<AllProducts>  listForCaloriesNorm=cartTextAreaController.getCustomersProducts();
        for(AllProducts allProducts:listForCaloriesNorm)
        {
            caloriesList.add(allProducts.getCalories());
        }
        System.out.println(sumCombinationService.combinationSum(caloriesList,400));

    }

    @FXML
    void initialize() {


    }
}
