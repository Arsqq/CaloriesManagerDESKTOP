package com.kursach.OOPProject.Controllers;

import com.kursach.OOPProject.Services.CaloriesCalculatorService;
import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.CustomersProducts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class MainSceneController
{
    List<Label> listOfLabels=new ArrayList<>();
    List<CustomersProducts> listOfProducts=new ArrayList<>();


    @Autowired
    CaloriesCalculatorService calculatorService;


    public TextField getProductTextField() {
        return productTextField;
    }

    @FXML
    private TextField productTextField;

    @FXML
    private Button cartButton;



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


    private boolean isLightMode=true;

    public MainSceneController(ApplicationContext springContext)
    {
        this.springContext=springContext;
    }

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
        rightVbox.setStyle(" -fx-background-color: #3e4540");
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

    private final ApplicationContext springContext;

        @Autowired
        AllProducts allProducts;

        @Value("classpath:/xml/CaloriesCalculator.fxml")
        private Resource sceneResourse;
        @FXML
        void handleButtonAction(ActionEvent event)
        {
            try
            {
                String buffer=productTextField.getText();
                FXMLLoader loader=new FXMLLoader(sceneResourse.getURL());
                loader.setControllerFactory(springContext::getBean);
                Parent root=loader.load();
                Stage stage = new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

   /*
        public AllProducts getProductInfo()
        {
           allProducts=calculatorService.getProductInfo(productTextField);
           return allProducts;
        }
    */
        @FXML
        void handleChangeModeButton(ActionEvent event)
        {
            Collections.addAll(listOfLabels,modeLabel,lightLabel,themeLabel,caloriesLabel,managerLabel,quoteLabel);
            changeMode();
        }




    @FXML
    void initialize()
    {

    }


}
