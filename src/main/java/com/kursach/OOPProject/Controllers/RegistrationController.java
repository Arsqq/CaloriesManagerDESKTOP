package com.kursach.OOPProject.Controllers;

import com.kursach.OOPProject.models.Users;
import com.kursach.OOPProject.models.UsersIndInfo;
import com.kursach.OOPProject.repo.RegistrationRepository;
import com.kursach.OOPProject.repo.UsersInfoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class RegistrationController {

    @Autowired
    MainSceneController mainSceneController;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    Users users;

    @Autowired
    UsersIndInfo usersIndInfo;

    @Autowired
    UsersInfoRepository usersInfoRepository;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField mailTextField;

    @FXML
    private Button registrationButton;

    @Value("classpath:/xml/Authorization.fxml")
    private Resource sceneResourceForAuthorization;

    @FXML
    private void handleRegistrationButton()
    {
        Stage stage=(Stage) registrationButton.getScene().getWindow();
        mainSceneController.generateFXML(sceneResourceForAuthorization);
        stage.close();

        users.setMail(mailTextField.getText());
        users.setName(loginTextField.getText());
        users.setPassword(passwordTextField.getText());
        registrationRepository.save(users);

        usersIndInfo.setUserName(loginTextField.getText());
        usersInfoRepository.save(usersIndInfo);




        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("REGISTRATION INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("YOU HAVE SUCCESSFULLY REGISTERED");
        alert.show();
    }

    @FXML
    void initialize() {

    }
}