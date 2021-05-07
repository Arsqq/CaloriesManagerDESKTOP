package com.kursach.OOPProject.Controllers;

import com.kursach.OOPProject.Services.MajorFunctionsService;
import com.kursach.OOPProject.Services.MinorFunctionsService;
import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.CustomersProducts;
import com.kursach.OOPProject.models.Dishes;
import com.kursach.OOPProject.repo.DishesRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.util.*;

@Component
public class MainSceneController
{
    List<Label> listOfLabels=new ArrayList<>();
    List<CustomersProducts> listOfProducts=new ArrayList<>();


    @Autowired
    MinorFunctionsService calculatorService;


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
    private Button bodyMassIndexButton;

    @FXML
    private ImageView imgView;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private Button randomButton;

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

        @Value("classpath:/xml/InfoWindowController.fxml")
        private Resource sceneResourse;
        @FXML
        void handleButtonAction(ActionEvent event)
        {
            try
            {
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

        @Value("classpath:/xml/cartTextArea.fxml")
        private Resource sceneResourseForCart;
        @FXML
        void handleCartButton(ActionEvent event)
        {
            try
            {
                FXMLLoader loader=new FXMLLoader(sceneResourseForCart.getURL());
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

    @Value("classpath:/xml/CaloriesDiary.fxml")
    private Resource sceneResourseForDiary;
    @FXML
    void handleDiaryButton(ActionEvent event)
    {
        try
        {
            FXMLLoader loader=new FXMLLoader(sceneResourseForDiary.getURL());
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






        @FXML
        void handleChangeModeButton(ActionEvent event)
        {
            Collections.addAll(listOfLabels,modeLabel,lightLabel,themeLabel,caloriesLabel,managerLabel,quoteLabel);
            changeMode();
        }


        public void setBodyMassLabels()
        {
            Alert alert=new Alert(Alert.AlertType.NONE,"BMI ="+calculatorService.bmiCalculation(weightTextField.getText(),heightTextField.getText()), ButtonType.APPLY);
            alert.show();
        }

        @Autowired
        Optional<Dishes> dishes;

        @Autowired
        CartTextAreaController cartTextAreaController;

        @Autowired
         DishesRepository dishesRepository;

        @Autowired
        MajorFunctionsService majorFunctionsService;

         public void getRandomDish()
         {
             dishes=calculatorService.getRandomDish();
             System.out.println(dishes.get().getDishName());
         }



    @FXML
    void initialize()
    {

    }


}
