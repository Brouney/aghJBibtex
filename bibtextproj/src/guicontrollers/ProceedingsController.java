package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entities.Proceedings;
import entities.Proceedings;
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

public class ProceedingsController implements Initializable {

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfPublisher;

	@FXML
	private TextField tfEditor;

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
	private TextField tfOrganization;

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
	private TableView<Proceedings> tvProceedings;

	@FXML
	private TableColumn<Proceedings, String> tcAuthor;

	@FXML
	private TableColumn<Proceedings, String> tcEditor;

	@FXML
	private TableColumn<Proceedings, String> tcTitle;

	@FXML
	private TableColumn<Proceedings, String> tcYear;

	@FXML
	private TableColumn<Proceedings, String> tcPublisher;

	@FXML
	private TableColumn<Proceedings, String> tcVolume;

	@FXML
	private TableColumn<Proceedings, String> tcNumber;

	@FXML
	private TableColumn<Proceedings, String> tcSeries;

	@FXML
	private TableColumn<Proceedings, String> tcAddress;

	@FXML
	private TableColumn<Proceedings, String> tcEdition;

	@FXML
	private TableColumn<Proceedings, String> tcMonth;

	@FXML
	private TableColumn<Proceedings, String> tcNote;

	@FXML
	private TableColumn<Proceedings, String> tcKey;

	@FXML
	private TableColumn<Proceedings, String> tcUrl;

	@FXML
	void addAllToDB(ActionEvent event) {

	}

	@FXML
	void addElementToList(ActionEvent event) {
		Proceedings proceedingsToAdd = new Proceedings();

		System.out.println("po try");

		proceedingsToAdd.setAddress(tfAddress.getText());
		proceedingsToAdd.setEditor(tfEditor.getText());
		proceedingsToAdd.setTitle(tfTitle.getText());
		proceedingsToAdd.setYear(tfYear.getText());
		proceedingsToAdd.setPublisher(tfPublisher.getText());

		proceedingsToAdd.setVolume(tfVolume.getText());
		proceedingsToAdd.setNumber(tfNumber.getText());
		proceedingsToAdd.setSeries(tfSeries.getText());
		proceedingsToAdd.setOrganization(tfOrganization.getText());
		proceedingsToAdd.setMonth(tfMonth.getText());
		proceedingsToAdd.setNote(tfNote.getText());
		proceedingsToAdd.setKey(tfKey.getText());

		System.out.println("przed add");

		ClassOfLists.listOfProceedings.add(proceedingsToAdd);

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountProceedings(Integer.toString((ClassOfLists.listOfProceedings.size())));

	}

	void refresh() {

		ObservableList<Proceedings> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfProceedings);

		tvProceedings.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAddress.setText("");
		tfEditor.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfPublisher.setText("");

		tfVolume.setText("");
		tfNumber.setText("");
		tfSeries.setText("");
		tfOrganization.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");

	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfProceedings.clear();
    	refresh();
		Main.mainController.changeLabelCountProceedings(Integer.toString((ClassOfLists.listOfProceedings.size())));

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Proceedings proceedingsToDel = new Proceedings();

		System.out.println("po try");

		proceedingsToDel.setAddress(tfAddress.getText());
		proceedingsToDel.setEditor(tfEditor.getText());
		proceedingsToDel.setTitle(tfTitle.getText());
		proceedingsToDel.setYear(tfYear.getText());
		proceedingsToDel.setPublisher(tfPublisher.getText());

		proceedingsToDel.setVolume(tfVolume.getText());
		proceedingsToDel.setNumber(tfNumber.getText());
		proceedingsToDel.setSeries(tfSeries.getText());
		proceedingsToDel.setOrganization(tfOrganization.getText());
		proceedingsToDel.setMonth(tfMonth.getText());
		proceedingsToDel.setNote(tfNote.getText());
		proceedingsToDel.setKey(tfKey.getText());
		
		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Proceedings todel : ClassOfLists.listOfProceedings) {
			if (todel.myequals(proceedingsToDel)) {
				ClassOfLists.listOfProceedings.remove(toDelInLoop);
				System.out.println("udalo sie usunac");
				break;
			}
			toDelInLoop +=1;
		}
		
		refresh();
		Main.mainController.changeLabelCountProceedings(Integer.toString((ClassOfLists.listOfProceedings.size())));

		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Author"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Address"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Editor"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Year"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Publisher"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Number"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Series"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Key"));
		
	}

}
