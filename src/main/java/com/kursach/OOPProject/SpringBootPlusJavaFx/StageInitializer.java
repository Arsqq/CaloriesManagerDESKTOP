package com.kursach.OOPProject.SpringBootPlusJavaFx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import  com.kursach.OOPProject.SpringBootPlusJavaFx.JavaFxApplicationSupport.StageReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent>
{
    @Value("classpath:/xml/main-scene.fxml")
    private Resource sceneResourse;

    private final ApplicationContext springContext;

    private final String applicationTitle;
    Parent parent;


    @Override
    public void onApplicationEvent(StageReadyEvent event)
    {

        try {
            FXMLLoader fxmlLoader= new FXMLLoader(sceneResourse.getURL());

            fxmlLoader.setControllerFactory(springContext::getBean);
            parent=fxmlLoader.load();

            Stage stage=event.getStage();
            Scene scene=new Scene(parent);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("css/style.css")).toExternalForm());
            stage.setScene(scene);
            stage.setTitle(applicationTitle);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StageInitializer(ApplicationContext springContext, @Value("${spring.application.ui.title}") String applicationTitle)
    {
        this.springContext = springContext;
        this.applicationTitle=applicationTitle;
    }
}
