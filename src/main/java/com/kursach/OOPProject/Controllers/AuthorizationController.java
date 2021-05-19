package com.kursach.OOPProject.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.kursach.OOPProject.models.UsersIndInfo;
import com.kursach.OOPProject.repo.RegistrationRepository;
import com.kursach.OOPProject.repo.UsersInfoRepository;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.awt.event.MouseEvent;
import java.io.IOException;

@Component
public class AuthorizationController {

    @Autowired
    MainSceneController mainSceneController;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    UsersIndInfo usersIndInfo;

    @Autowired
    UsersInfoRepository usersInfoRepository;

    @FXML
    private TextField loginAuthorizationField;

    @FXML
    private PasswordField passwordAuthorizationField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXCheckBox passwordCheckBox;

    @FXML
    private JFXButton registrationButton;

    @Value("classpath:/xml/main-scene.fxml")
    private Resource sceneResourse;

    @Value("classpath:/xml/Registration.fxml")
    private Resource registrationResource;

    private  String CURRENT_USER=null;
    private Tooltip toolTip;

    @FXML
    private void handleLoginButton()
    {
        Stage stage=(Stage) loginButton.getScene().getWindow();

        if(registrationRepository.existsByNameAndPassword(loginAuthorizationField.getText(),passwordAuthorizationField.getText()))
        {
            mainSceneController.generateFXML(sceneResourse);
            stage.close();




            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("AUTHORIZATION INFORMATION");
            alert.setHeaderText(null);
            alert.setContentText("YOU HAVE SUCCESSFULLY LOG ON");
            alert.show();

            CURRENT_USER=loginAuthorizationField.getText();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AUTHORIZATION ERROR!");
            alert.setHeaderText(null);
            alert.setContentText("INVALID LOGIN OR PASSWORD.TRY AGAIN");
            loginAuthorizationField.clear();
            passwordAuthorizationField.clear();
            alert.show();
        }

    }

    @FXML
    private void handleRegistrationButton()
    {
        Stage stage=(Stage) registrationButton.getScene().getWindow();
        mainSceneController.generateFXML(registrationResource);
        stage.close();

    }
    private void showPassword(){
        Stage stage=(Stage) passwordAuthorizationField.getScene().getWindow();
        Point2D p = passwordAuthorizationField.localToScene(passwordAuthorizationField.getBoundsInLocal().getMaxX(),
                passwordAuthorizationField.getBoundsInLocal().getMaxY());
        toolTip.setText(passwordAuthorizationField.getText());
        toolTip.show(passwordAuthorizationField,
                p.getX() + stage.getScene().getX() + stage.getX(),
                p.getY() + stage.getScene().getY() + stage.getY());
    }
    private void hidePassword(){
        toolTip.setText("");
        toolTip.hide();
    }

    @FXML
    void initialize() {
         SimpleBooleanProperty showPassword=new SimpleBooleanProperty();
         showPassword.addListener((observable, oldValue, newValue) -> {
            if(newValue){
                showPassword();
            }else{
                hidePassword();
            }
        });

        toolTip = new Tooltip();
        toolTip.setShowDelay(Duration.ZERO);
        toolTip.setAutoHide(false);
        toolTip.setMinWidth(50);
        passwordAuthorizationField.setOnKeyTyped(e->{
    if ( showPassword.get() ) {
            showPassword();
        }
    });

        showPassword.bind(passwordCheckBox.selectedProperty());
    }

    public String getCURRENT_USER() {
        return CURRENT_USER;
    }
}



