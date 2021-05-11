package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.kursach.OOPProject.Services.MinorFunctionsService;
import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.Dishes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.Popup;
import org.fxmisc.richtext.GenericStyledArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CartTextAreaController {

    @Autowired
    private AllProducts allProducts;
    @Autowired
    private MinorFunctionsService calculatorService;





    @FXML
    private JFXTextArea productTextArea;

    @FXML
    private JFXTextArea dishTextArea;

    @FXML
    private Button textAreaButton;

    @FXML
    private JFXButton textAreaButtonForDishes;

    @FXML
    public List<AllProducts> getCustomersProducts()
    {
        List<AllProducts> listOfCustomersProducts=new ArrayList<>();
        List<String> listOfProductLines=new ArrayList<>();

       String buffer=productTextArea.getText();
       String[] splits=buffer.split("\n");
       Collections.addAll(listOfProductLines,splits);
        for (String productName:listOfProductLines)
        {
            listOfCustomersProducts.add(calculatorService.getProductInfo(productName));
        }
        return listOfCustomersProducts;
    }
    @FXML
    public List<Dishes> getCustomersDishes()
    {
        List<Dishes> listOfCustomersDishes=new ArrayList<>();
        List<String> listOfDishesLines=new ArrayList<>();
        String buffer=dishTextArea.getText();
        String[] splits=buffer.split("\n");
        Collections.addAll(listOfDishesLines,splits);
        for (String productName:listOfDishesLines)
        {
            listOfCustomersDishes.add(calculatorService.getDishInfo(productName));
        }
        return listOfCustomersDishes;
    }



    @FXML
    void initialize() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Alert");
        alert.setHeaderText(null);
        alert.setContentText("Cart has been filled!");
        textAreaButton.setOnAction(b->alert.show());
        textAreaButtonForDishes.setOnAction(b->alert.show());





    }
}
