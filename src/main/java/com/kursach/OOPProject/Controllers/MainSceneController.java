package com.kursach.OOPProject.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class MainSceneController
{
    List<Label> listOfLabels=new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField productTextField;

    @FXML
    private Button caloriesCalculation;

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
    private AnchorPane parentAnchor;


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
        Image image=new Image("Pictures/sun.png");

        for (Label a:listOfLabels)
            a.setTextFill(new Color(1,1,1,1));

        modeLabel.setText("Dark Mode");
        lightLabel.setText("dark");
        imgView.setImage(image);
    }

    @FXML
    void initialize()
    {
        Collections.addAll(listOfLabels,modeLabel,lightLabel,themeLabel,caloriesLabel,managerLabel);
        switchMode.setOnAction(event -> changeMode());
    }


}
