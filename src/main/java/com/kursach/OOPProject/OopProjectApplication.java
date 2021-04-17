package com.kursach.OOPProject;

import com.kursach.OOPProject.SpringBootPlusJavaFx.JavaFxApplicationSupport;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.kursach.OOPProject.Controllers","com.kursach.OOPProject.SpringBootPlusJavaFx"})
public class OopProjectApplication extends JavaFxApplicationSupport
{
	public static void main( String[] args)
	{
		Application.launch(JavaFxApplicationSupport.class,args);

	}





}



