package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.kursach.OOPProject.Services.MajorFunctionsService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaloriesDiaryController
{

    @FXML
    private JFXTextArea caloriesDiaryTextArea;

    @FXML
    private JFXButton caloriesDiaryButton;

    @FXML
    private Label sumLabel;

    @Autowired
    MajorFunctionsService majorFunctionsService;

   @FXML
   public void displayCaloriesPerDay()
   {

     var value= majorFunctionsService.getAmountOfCalories(caloriesDiaryTextArea);
      sumLabel.setText(String.valueOf(value));
   }



    @FXML
    void initialize() {


    }
}
