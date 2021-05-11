package com.kursach.OOPProject.Controllers;

import com.kursach.OOPProject.Services.MinorFunctionsService;
import com.kursach.OOPProject.models.Dishes;
import com.kursach.OOPProject.repo.DishesRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Map;
import java.util.Optional;

@Component
public class RandomDishController
{


    @FXML
    private Label randomNameLabel;

    @FXML
    private Label randomCompositionLabel;

    @FXML
    private Label randomCaloriesLabel;


    @FXML
    private ImageView randomImage;


    @Autowired
    Optional<Dishes> dishes;

    @Autowired
    DishesRepository dishesRepository;

    @FXML
    private ScrollBar randomScroll;

    @Autowired
    MinorFunctionsService minorFunctionsService;

    public ImageView getImage()
    {
        return randomImage;
    }

    public void setRandomImage(ImageView imageView)
    {
        dishes=minorFunctionsService.getRandomDish();
        Map<String,String> imageMap=minorFunctionsService.setRandomImage();
        Image image=new Image(imageMap.get(dishes.get().getDishName()));
        imageView.setImage(image);
        randomNameLabel.setText(dishes.get().getDishName());
        randomCompositionLabel.setText(dishes.get().getComposition());
        randomCaloriesLabel.setText(String.valueOf(dishes.get().getCalories()));

    }

    @FXML
    void initialize() {


    }
}
