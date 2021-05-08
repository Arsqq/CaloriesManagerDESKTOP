package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXTextArea;
import com.kursach.OOPProject.Services.MinorFunctionsService;
import com.kursach.OOPProject.models.AllProducts;
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
    private Button textAreaButton;

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
    void initialize() {

        Alert alert=new Alert(Alert.AlertType.NONE,"YOUR CART WAS FILLED", ButtonType.APPLY);
        textAreaButton.setOnAction(b->alert.show());




    }
}
