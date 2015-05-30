/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.andxbes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Andr
 */
public class Example extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

	FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("/FXFrame.fxml"));
	Parent root = null;
	//Controller2 control = new Controller2();
	try {
	    root = fxLoader.load();
	} catch (Exception e) {
	}
	//fxLoader.setController(control);
	Scene scene = new Scene(root);
	primaryStage.setScene(scene);
	//primaryStage.resizableProperty().set(false);
	primaryStage.show();

    }
    
    

}


