package com.kursach.OOPProject.Controllers;



import com.kursach.OOPProject.Services.MinorFunctionsService;
import com.kursach.OOPProject.models.AllProducts;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MinorFunctionsService calculatorService;
    @Autowired
    private MainSceneController mainSceneController;




    @FXML
    void initialize()
    {
        allProducts=calculatorService.getProductInfo(mainSceneController.getProductTextField().getText());
        caloriesInfoLabelName.setText(allProducts.getAnyProductName());
        caloriesInfoLabelCalories.setText(String.valueOf(allProducts.getCalories()));
        caloriesInfoLabelCarbo.setText(String.valueOf(allProducts.getCarbohydrates()));
        caloriesInfoLabelProteins.setText(String.valueOf(allProducts.getProteins()));
        caloriesInfoLabelFats.setText(String.valueOf(allProducts.getFats()));


    }
}
