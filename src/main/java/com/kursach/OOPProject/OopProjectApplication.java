package com.kursach.OOPProject;

import com.kursach.OOPProject.SpringBootPlusJavaFx.JavaFxApplicationSupport;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com/kursach/OOPProject/models")
@SpringBootApplication
@ComponentScan({"com.kursach.OOPProject.Controllers","com.kursach.OOPProject.SpringBootPlusJavaFx","com.kursach.OOPProject.repo","com.kursach.OOPProject.Services",
		"com.kursach.OOPProject.models"})

public class OopProjectApplication extends JavaFxApplicationSupport
{
	public static void main( String[] args)
	{
		Application.launch(JavaFxApplicationSupport.class,args);

	}





}



