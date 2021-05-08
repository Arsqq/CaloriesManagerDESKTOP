package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXTextArea;
import com.kursach.OOPProject.Services.MajorFunctionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaloriesDiaryController
{

    @FXML
    private JFXTextArea caloriesDiaryTextArea;

    @FXML
    private Button caloriesDiaryButton;

    @Autowired
    MajorFunctionsService majorFunctionsService;

   @FXML
   public void displayCaloriesPerDay()
   {

     var value= majorFunctionsService.getAmountOfCalories(caloriesDiaryTextArea);
      System.out.println(value);
   }



    @FXML
    void initialize() {


    }
}
