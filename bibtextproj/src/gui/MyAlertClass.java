package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MyAlertClass {

	public void objectErrorAlert() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ostrzeżenie");
		alert.setHeaderText(null);
		alert.setContentText("Nie wypełniono poprawnie danych!");
		alert.showAndWait();

	}

	public void addedToFileAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Dodano!");
		alert.setHeaderText(null);
		alert.setContentText("Dodano do pliku!");
		alert.showAndWait();
	}

	public void fileErrorAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Błąd pliku");
		alert.setHeaderText(null);
		alert.setContentText("Proszę wybrać plik do eksportowania danych!");
		alert.showAndWait();

	}
	public void addedToDB() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Dodano!");
		alert.setHeaderText(null);
		alert.setContentText("Dodano do bazy danych!");
		alert.showAndWait();
		
		
		
	}
	public void editedInDB() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Zedytowano!");
		alert.setHeaderText(null);
		alert.setContentText("Zedytowano element w bazie danych!");
		alert.showAndWait();
		
		
		
	}
	public void openImportFileErrorAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Błąd otwierania pliku");
		alert.setHeaderText(null);
		alert.setContentText("Proszę wybrać pliki .bib do ściągnięcia danych.");
		alert.showAndWait();
	}
	public void openExportFileErrorAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Błąd otwierania pliku");
		alert.setHeaderText(null);
		alert.setContentText("Proszę wybrać jeden plik z rozszerzeniem .bib");
		alert.showAndWait();
	}
	

}
