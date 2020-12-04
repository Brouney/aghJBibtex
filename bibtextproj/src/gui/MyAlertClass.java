package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MyAlertClass {

	public void objectErrorAlert() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Object error");
		alert.setHeaderText(null);
		alert.setContentText("Please fill all required data");
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

}
