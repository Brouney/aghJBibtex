package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MyAlertClass {

	public void objectErrorAlert() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Object error");
		alert.setHeaderText(null);
		alert.setContentText("You didn't fill all required data");
		alert.showAndWait();

	}

	public void addedToFileAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added!");
		alert.setHeaderText(null);
		alert.setContentText("Added to file ");
		alert.showAndWait();
	}

	public void fileErrorAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("File error");
		alert.setHeaderText(null);
		alert.setContentText("Please choose file to Export.");
		alert.showAndWait();

	}
	public void addedToDB() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added!");
		alert.setHeaderText(null);
		alert.setContentText("Added to database.");
		alert.showAndWait();
		
		
		
	}
	public void editedInDB() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Edited!");
		alert.setHeaderText(null);
		alert.setContentText("Edited element in database.");
		alert.showAndWait();
		
		
		
	}
	
	

}
