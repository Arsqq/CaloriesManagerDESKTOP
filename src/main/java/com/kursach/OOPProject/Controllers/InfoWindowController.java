package com.kursach.OOPProject.Controllers;



import com.kursach.OOPProject.Services.CaloriesCalculatorService;
import com.kursach.OOPProject.models.AllProducts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class InfoWindowController {

    @FXML
    private Label caloriesInfoLabelName;

    @FXML
    private Label caloriesInfoLabelCalories;

    @FXML
    private Label caloriesInfoLabelProteins;

    @FXML
    private Label caloriesInfoLabelFats;

    @FXML
    private Label caloriesInfoLabelCarbo;


    @Autowired
    private AllProducts allProducts;
    @Autowired
    private  CaloriesCalculatorService calculatorService;
    @Autowired
    private MainSceneController mainSceneController;




    @FXML
    void initialize()
    {
        allProducts=calculatorService.getProductInfo(mainSceneController.getProductTextField().getText());
        caloriesInfoLabelName.setText(allProducts.getAnyProductName());

    }
}
