package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.kursach.OOPProject.Services.MajorFunctionsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    private Button intakeButton;




    @FXML
    void initialize()
    {
        ObservableList<String> physActivity = FXCollections.observableArrayList("Low","Medium","High");
        activityBox.setItems(physActivity);
        activityBox.setValue("Low");

         intakeButton.setOnAction(b->
                 System.out.println((majorFunctionsService.getDailyIntake(ageTextField,weightTextField,heightTextFiield,maleBox,femaleBox,activityBox))));
    }

}
