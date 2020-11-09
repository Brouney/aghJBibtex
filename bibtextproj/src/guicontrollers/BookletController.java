package guicontrollers;

import entities.Booklet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BookletController {
	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfHowpublished;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private Button cleantextid;

	@FXML
	private Button addelementtolistid;

	@FXML
	private Button deleteelementfromlistid;

	@FXML
	private Button deleteallfromlistid;

	@FXML
	private Button addalltodbid;

	@FXML
	private TableView<Booklet> tvBooklet;

	@FXML
	private TableColumn<Booklet, String> tcTitle;

	@FXML
	private TableColumn<Booklet, String> tcAuthor;

	@FXML
	private TableColumn<Booklet, String> tcHowpublished;

	@FXML
	private TableColumn<Booklet, String> tcAddress;

	@FXML
	private TableColumn<Booklet, String> tcYear;

	@FXML
	private TableColumn<Booklet, String> tcMonth;

	@FXML
	private TableColumn<Booklet, String> tcNote;

	@FXML
	private TableColumn<Booklet, String> tcKey;

	@FXML
	void addAllToDB(ActionEvent event) {

	}

	@FXML
	void addElementToList(ActionEvent event) {

	}

	@FXML
	void cleanText(ActionEvent event) {

	}

	@FXML
	void deleteAllFromList(ActionEvent event) {

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {

	}
}
