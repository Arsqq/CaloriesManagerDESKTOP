package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.kursach.OOPProject.Services.MajorFunctionsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DailyCaloriesIntakeController
{
    @Autowired
    MajorFunctionsService majorFunctionsService;
    @FXML
    private TextField heightTextFiield;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private JFXCheckBox maleBox;

    @FXML
    private JFXCheckBox femaleBox;

    @FXML
    private JFXComboBox<String> activityBox;

    @FXML
    private JFXButton intakeButton;


    @FXML
    private Label intakeLabel;



    @FXML
    void initialize()
    {
        ObservableList<String> physActivity = FXCollections.observableArrayList("Low","Medium","High");
        activityBox.setItems(physActivity);
        activityBox.setValue("Low");

         intakeButton.setOnAction(b->
                intakeLabel.setText(String.valueOf(((majorFunctionsService.getDailyIntake(ageTextField,weightTextField,heightTextFiield,maleBox,femaleBox,activityBox))))));
    }

}
