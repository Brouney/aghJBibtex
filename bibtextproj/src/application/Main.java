package application;
	


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;

import entities.Book;
import entities.EntryTypes;
import guicontrollers.MainPageController;

public class Main extends Application {
	
	
	public static MainPageController mainController;
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			FXMLLoader loaderr = new FXMLLoader();
			
			AnchorPane root = (AnchorPane)loaderr.load(getClass().getResource("/gui/Mainpage.fxml").openStream());
			Scene scene = new Scene(root,1320,945);
			scene.getStylesheets().add(getClass().getResource("/gui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			mainController = loaderr.getController();
			//System.out.println(mainController.getClass().getName());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
