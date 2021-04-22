package com.kursach.OOPProject.Controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainSceneController {
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
    private BorderPane parent;

    @FXML
    private AnchorPane parentAnchor;


    @FXML
    private ImageView imgView;

    private boolean isLightMode=true;

    public void changeMode(ActionEvent event)
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
        Image image=new Image("Pictures/7-77531_png-file-svg-moon-icon-circle-png.png");
        modeLabel.setText("Light Mode");
        lightLabel.setText("light");
        modeLabel.setTextFill(new Color(0,0,0,1));
        themeLabel.setTextFill(new Color(0,0,0,1));
        lightLabel.setTextFill(new Color(0,0,0,1));
        caloriesLabel.setTextFill(new Color(0,0,0,1));
        managerLabel.setTextFill(new Color(0,0,0,1));
        imgView.setImage(image);
    }

    private void setDarkMode()
    {
        parentAnchor.getStylesheets().remove("css/lightmode.css");
        parentAnchor.getStylesheets().add("css/darkmode.css");
        Image image=new Image("Pictures/sun.png.png");
        modeLabel.setText("Dark Mode");
       lightLabel.setText("dark");
        modeLabel.setTextFill(new Color(1,1,1,1));
        themeLabel.setTextFill(new Color(1,1,1,1));
        lightLabel.setTextFill(new Color(1,1,1,1));
        caloriesLabel.setTextFill(new Color(1,1,1,1));
        managerLabel.setTextFill(new Color(1,1,1,1));
        imgView.setImage(image);
    }

    @FXML
    void initialize()
    {
        switchMode.setOnAction(event -> {
            isLightMode=!isLightMode;
            if(isLightMode)
                setLightMode();
            else
                setDarkMode();
        });
    }


}
