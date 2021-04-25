package com.kursach.OOPProject.Controllers;

import com.kursach.OOPProject.Services.CaloriesCalculatorService;
import com.kursach.OOPProject.models.CustomersProducts;
import com.kursach.OOPProject.repo.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MainSceneController
{
    List<Label> listOfLabels=new ArrayList<>();
    List<CustomersProducts> listOfProducts=new ArrayList<>();

    @Autowired
    private CerealProductsRepository cerealRep;
    @Autowired
    private MilkProductsRepository   milkRep;
    @Autowired
    private VegetablesRepository vegRep;
    @Autowired
    private FruitsRepository fruitsRep;
    @Autowired
    private MeatDishesRepository meatDishesRep;
    @Autowired
    private SeaFoodRepository seaFoodRep;
    @Autowired
    private VeganDishesRepository veganDishRep;
   @Autowired
    private DishesRepository dishRep;

    @Autowired
    CaloriesCalculatorService calculatorService;

    @FXML
    private TextField productTextField;

    @FXML
    private Button cartButton;

    @FXML
    private Button caloriesCalculation;


    @FXML
    private Button calculatorButton;
    @FXML
    private Button switchMode;

    @FXML
    private Label modeLabel;

    @FXML
    private Label themeLabel;

    @FXML
    private Label lightLabel;

    @FXML
    private Label caloriesLabel;

    @FXML
    private Label managerLabel;
    @FXML
    private Label quoteLabel;

    @FXML
    private AnchorPane parentAnchor;

    @FXML
    private VBox rightVbox;


    @FXML
    private ImageView imgView;

    private boolean isLightMode=true;

    public void changeMode()
    {
        isLightMode=!isLightMode;
        if(isLightMode)
            setLightMode();
        else
            setDarkMode();
    }


    private void setLightMode()
    {
        parentAnchor.getStylesheets().remove("css/darkmode.css");
        parentAnchor.getStylesheets().add("css/lightmode.css");
        rightVbox.setStyle(" -fx-background-color: #BAEAC3");
        Image image=new Image("Pictures/moon.png");

        for (Label a:listOfLabels)
           a.setTextFill(new Color(0,0,0,1));

        modeLabel.setText("Light Mode");
        lightLabel.setText("light");
        imgView.setImage(image);
    }

    private void setDarkMode()
    {
        parentAnchor.getStylesheets().remove("css/lightmode.css");
        parentAnchor.getStylesheets().add("css/darkmode.css");
        rightVbox.setStyle("-fx-background-color: #4b4f4f");
        Image image=new Image("Pictures/sun.png");

        for (Label a:listOfLabels)
            a.setTextFill(new Color(1,1,1,1));

        modeLabel.setText("Dark Mode");
        lightLabel.setText("dark");
        imgView.setImage(image);
    }

    private List<CustomersProducts> getCustomersProducts()
    {

        return listOfProducts;
    }


    private void getCaloriesInfo()
    {
        calculatorService.getCaloriesInfo(productTextField);
    }




    @FXML
    void initialize()
    {
        Collections.addAll(listOfLabels,modeLabel,lightLabel,themeLabel,caloriesLabel,managerLabel,quoteLabel);
        switchMode.setOnAction(event -> changeMode());
        calculatorButton.setOnAction(event -> getCaloriesInfo());

    }


}
