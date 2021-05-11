package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXTextArea;
import com.kursach.OOPProject.Services.SumCombinationService;
import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.Dishes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CaloriesNormController
{


    @FXML
    private Button breakfastButton;

    @FXML
    private Button lunchButton;

    @FXML
    private Button dinnerButton;

    @FXML
    private JFXTextArea normTextArea;


    @Autowired
    SumCombinationService sumCombinationService;

    @Autowired
    CartTextAreaController cartTextAreaController;

    public void getMorningCombination()
    {
        normTextArea.clear();
        final int MORNING_NORM=400;
        List<Double> caloriesList=new ArrayList<>();
        List<AllProducts>  listForCaloriesNorm=cartTextAreaController.getCustomersProducts();
        for(AllProducts allProducts:listForCaloriesNorm)
        {
            caloriesList.add(allProducts.getCalories());
        }
        Map<String,List<Double>> resMap=(sumCombinationService.combinationSum(caloriesList, MORNING_NORM));
        String buffer= String.valueOf(resMap.keySet());
        String bufferForAppending=buffer.replace("[","Набор:").replaceFirst("Набор:","").replace("],","\n")
                .replace("]","").replaceFirst(""," ");
        normTextArea.appendText("Цель:"+MORNING_NORM+"\n\n");
        normTextArea.appendText(bufferForAppending);
    }


    public void getLunchCombination()
    {
        normTextArea.clear();
        int LUNCH_NORM = 600;
        getLunchOrDinnerCombination(LUNCH_NORM);
    }

    public void getDinnerCombination()
    {
        normTextArea.clear();
        int DINNER_NORM = 700;
        getLunchOrDinnerCombination(DINNER_NORM);
    }
    private void getLunchOrDinnerCombination(int norm) {
        List<Double> caloriesList=new ArrayList<>();
        List<Dishes>  listForCaloriesNorm=cartTextAreaController.getCustomersDishes();
        for(Dishes dishes:listForCaloriesNorm)
        {
            caloriesList.add(dishes.getCalories());
        }
        Map<String,List<Double>> resMap=(sumCombinationService.combinationSumForDishes(caloriesList,norm));
        String buffer= String.valueOf(resMap.keySet());
        String bufferForAppending=buffer.replace("[","Набор:").replaceFirst("Набор:","").replace("],","\n")
                .replace("]","").replaceFirst(""," ");
        normTextArea.appendText("Цель:"+ norm +"\n\n");
        normTextArea.appendText(bufferForAppending);
    }


    @FXML
    void initialize() {


    }
}
