package com.kursach.OOPProject.SpringBootPlusJavaFx;

import com.kursach.OOPProject.OopProjectApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;


  public class JavaFxApplicationSupport extends Application
{



    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {

       springContext = new SpringApplicationBuilder(OopProjectApplication.class).run();
    }

    @Override
    public void stop() {
        springContext.close();
        Platform.exit();
    }


    @Override
    public void start(Stage stage)
    {
        springContext.publishEvent(new StageReadyEvent(stage));
    }

    static class StageReadyEvent extends ApplicationEvent
    {


        public StageReadyEvent(Stage stage)
        {
            super(stage);
        }

        public Stage getStage()
        {
            return (Stage) getSource();
        }
    }

}

