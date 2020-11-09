package guicontrollers;

import application.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import entities.EntryTypes;
import entities.Inbook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InbookController implements Initializable {

	public static List<EntryTypes> mainListOfTypes = new ArrayList<EntryTypes>();
	public static List<Inbook> listOfBooks = new ArrayList<Inbook>();

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfEditor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfPublisher;

	@FXML
	private TextField tfVolume;

	@FXML
	private TextField tfNumber;

	@FXML
	private TextField tfSeries;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfEdition;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfUrl;

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
	private TableView<Inbook> tvInbook;

	@FXML
	private TableColumn<Inbook, String> tcAuthor;

	@FXML
	private TableColumn<Inbook, String> tcEditor;

	@FXML
	private TableColumn<Inbook, String> tcTitle;

	@FXML
	private TableColumn<Inbook, String> tcYear;

	@FXML
	private TableColumn<Inbook, String> tcPublisher;

	@FXML
	private TableColumn<Inbook, String> tcVolume;

	@FXML
	private TableColumn<Inbook, String> tcNumber;

	@FXML
	private TableColumn<Inbook, String> tcSeries;

	@FXML
	private TableColumn<Inbook, String> tcAddress;

	@FXML
	private TableColumn<Inbook, String> tcEdition;

	@FXML
	private TableColumn<Inbook, String> tcMonth;

	@FXML
	private TableColumn<Inbook, String> tcNote;

	@FXML
	private TableColumn<Inbook, String> tcKey;

	@FXML
	private TableColumn<Inbook, String> tcUrl;

	@FXML
	void addAllToDB(ActionEvent event) {

	}

	@FXML
	void addElementToList(ActionEvent event) {

		System.out.println("przed try");
		try {
			Inbook bookToAdd = new Inbook();

			System.out.println("po try");

			bookToAdd.setAuthor(tfAuthor.getText());
			bookToAdd.setAddress(tfAddress.getText());
			bookToAdd.setEditor(tfEditor.getText());
			bookToAdd.setTitle(tfTitle.getText());
			bookToAdd.setYear(tfYear.getText());
			bookToAdd.setPublisher(tfPublisher.getText());

			bookToAdd.setVolume(tfVolume.getText());
			bookToAdd.setNumber(tfNumber.getText());
			bookToAdd.setSeries(tfSeries.getText());
			bookToAdd.setEdition(tfEdition.getText());
			bookToAdd.setMonth(tfMonth.getText());
			bookToAdd.setNote(tfNote.getText());
			bookToAdd.setKey(tfKey.getText());
			bookToAdd.setUrl(tfUrl.getText());

			System.out.println("przed add");

			listOfBooks.add(bookToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountBook(Integer.toString((listOfBooks.size())));

	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfAddress.setText("");
		tfEditor.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfPublisher.setText("");

		tfVolume.setText("");
		tfNumber.setText("");
		tfSeries.setText("");
		tfEdition.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfUrl.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		listOfBooks.clear();
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((listOfBooks.size())));
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Inbook bookToDelete = new Inbook();
		bookToDelete.setAuthor(tfAuthor.getText());
		bookToDelete.setAddress(tfAddress.getText());
		bookToDelete.setEditor(tfEditor.getText());
		bookToDelete.setTitle(tfTitle.getText());
		bookToDelete.setYear(tfYear.getText());
		bookToDelete.setPublisher(tfPublisher.getText());

		bookToDelete.setVolume(tfVolume.getText());
		bookToDelete.setNumber(tfNumber.getText());
		bookToDelete.setSeries(tfSeries.getText());
		bookToDelete.setEdition(tfEdition.getText());
		bookToDelete.setMonth(tfMonth.getText());
		bookToDelete.setNote(tfNote.getText());
		bookToDelete.setKey(tfKey.getText());
		bookToDelete.setUrl(tfUrl.getText());
		
		System.out.println("przed forem");
		for (Inbook book : listOfBooks) {
			if (bookToDelete.equals(book)) {
				listOfBooks.remove(book);
			}
		}
		System.out.println("przed refresh");
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((listOfBooks.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Author"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Address"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Editor"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Year"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Publisher"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Number"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Series"));
		tcEdition.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Edition"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Key"));
		tcUrl.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Url"));

	}

	void refresh() {

		ObservableList<Inbook> tableViewList = FXCollections.observableArrayList(listOfBooks);

		tvInbook.setItems(tableViewList);
	}

}
