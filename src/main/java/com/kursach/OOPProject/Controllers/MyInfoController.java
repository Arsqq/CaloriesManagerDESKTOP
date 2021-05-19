package com.kursach.OOPProject.Controllers;

import com.kursach.OOPProject.models.UsersIndInfo;
import com.kursach.OOPProject.repo.UsersInfoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyInfoController
{

    @Autowired
    UsersInfoRepository usersInfoRepository;

    @Autowired
    UsersIndInfo usersIndInfo;

    @Autowired
    AuthorizationController authorizationController;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label bodyMassIndexLabel;

    @FXML
    private Label dailyCaloriesIntakeLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label weightLabel;

    public void handleIndividualUserLabels()
    {
        usersIndInfo=usersInfoRepository.findByUserName(authorizationController.getCURRENT_USER());
        userNameLabel.setText(usersIndInfo.getUserName());
        bodyMassIndexLabel.setText(String.valueOf(usersIndInfo.getBodyMassIndex()));
        dailyCaloriesIntakeLabel.setText(String.valueOf(usersIndInfo.getDailyCaloriesIntake()));
        heightLabel.setText(String.valueOf(usersIndInfo.getHeight()));
        weightLabel.setText(String.valueOf(usersIndInfo.getWeight()));
    }

    @FXML
    void initialize() {
    handleIndividualUserLabels();

    }
}
