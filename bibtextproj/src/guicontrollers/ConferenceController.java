package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entities.Article;
import entities.Book;
import entities.Conference;
import entities.Conference;
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

public class ConferenceController implements Initializable {
	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfBooktitle;

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
	private TextField tfPages;

	@FXML
	private TextField tfOrganization;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfEditor;

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
	private TextField tfBibKey;
	
	@FXML
	private TextField tfkeywords;
	
	@FXML
	private TableColumn<Conference, String> tcBibKey;

	@FXML
	private TableView<Conference> tvConference;

	@FXML
	private TableColumn<Conference, String> tcAuthor;

	@FXML
	private TableColumn<Conference, String> tcBooktitle;

	@FXML
	private TableColumn<Conference, String> tcTitle;

	@FXML
	private TableColumn<Conference, String> tcYear;

	@FXML
	private TableColumn<Conference, String> tcPublisher;

	@FXML
	private TableColumn<Conference, String> tcPages;

	@FXML
	private TableColumn<Conference, String> tcVolume;

	@FXML
	private TableColumn<Conference, String> tcNumber;

	@FXML
	private TableColumn<Conference, String> tcSeries;

	@FXML
	private TableColumn<Conference, String> tcAddress;

	@FXML
	private TableColumn<Conference, String> tcOrganization;

	@FXML
	private TableColumn<Conference, String> tcMonth;

	@FXML
	private TableColumn<Conference, String> tcNote;

	@FXML
	private TableColumn<Conference, String> tcKey;

	@FXML
	private TableColumn<Conference, String> tcEditor;

	@FXML
	void addAllToDB(ActionEvent event) {

	}

	@FXML
	void addElementToList(ActionEvent event) {
		Conference conferenceToAdd = new Conference();

		System.out.println("po try");

		conferenceToAdd.setAuthor(tfAuthor.getText());
		conferenceToAdd.setBooktitle(tfBooktitle.getText());
		conferenceToAdd.setTitle(tfTitle.getText());
		conferenceToAdd.setYear(tfYear.getText());

		conferenceToAdd.setVolume(tfVolume.getText());
		conferenceToAdd.setPublisher(tfPublisher.getText());
		conferenceToAdd.setNumber(tfNumber.getText());
		conferenceToAdd.setMonth(tfMonth.getText());
		conferenceToAdd.setNote(tfNote.getText());
		conferenceToAdd.setKey(tfKey.getText());
		conferenceToAdd.setOrganization(tfOrganization.getText());
		conferenceToAdd.setAddress(tfAddress.getText());
		conferenceToAdd.setPages(tfPages.getText());
		conferenceToAdd.setSeries(tfSeries.getText());
		conferenceToAdd.setEditor(tfEditor.getText());
		conferenceToAdd.setBibkey(tfBibKey.getText());
		ClassOfLists.listOfConference.add(conferenceToAdd);
		refresh();
		Main.mainController.changeLabelCountConference(Integer.toString((ClassOfLists.listOfConference.size())));
	}

	void refresh() {
		ObservableList<Conference> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfConference);

		tvConference.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {

		tfAuthor.setText("");
		tfBooktitle.setText("");
		tfTitle.setText("");
		tfYear.setText("");

		tfVolume.setText("");
		tfPublisher.setText("");
		tfNumber.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfOrganization.setText("");
		tfAddress.setText("");
		tfPages.setText("");
		tfSeries.setText("");
		tfEditor.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfConference.clear();
		refresh();
		Main.mainController.changeLabelCountConference(Integer.toString((ClassOfLists.listOfConference.size())));
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Conference conferenceToDel = new Conference();

		conferenceToDel.setAuthor(tfAuthor.getText());
		conferenceToDel.setBooktitle(tfBooktitle.getText());
		conferenceToDel.setTitle(tfTitle.getText());
		conferenceToDel.setYear(tfYear.getText());

		conferenceToDel.setVolume(tfVolume.getText());
		conferenceToDel.setPublisher(tfPublisher.getText());
		conferenceToDel.setNumber(tfNumber.getText());
		conferenceToDel.setMonth(tfMonth.getText());
		conferenceToDel.setNote(tfNote.getText());
		conferenceToDel.setKey(tfKey.getText());
		conferenceToDel.setOrganization(tfOrganization.getText());
		conferenceToDel.setAddress(tfAddress.getText());
		conferenceToDel.setPages(tfPages.getText());
		conferenceToDel.setSeries(tfSeries.getText());
		conferenceToDel.setEditor(tfEditor.getText());
		conferenceToDel.setBibkey(tfBibKey.getText());
		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Conference art : ClassOfLists.listOfConference) {
			if (conferenceToDel.equals(art)) {
				ClassOfLists.listOfConference.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}
		System.out.println("przed refresh");
		refresh();
		Main.mainController.changeLabelCountConference(Integer.toString((ClassOfLists.listOfConference.size())));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Conference, String>("Author"));
		tcBooktitle.setCellValueFactory(new PropertyValueFactory<Conference, String>("Booktitle"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Conference, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Conference, String>("Year"));
		tcPages.setCellValueFactory(new PropertyValueFactory<Conference, String>("Pages"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Conference, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Conference, String>("Number"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Conference, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Conference, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Conference, String>("Key"));
		tcOrganization.setCellValueFactory(new PropertyValueFactory<Conference, String>("Organization"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Conference, String>("Publisher"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Conference, String>("Address"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Conference, String>("Series"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Conference, String>("Editor"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Conference, String>("Bibkey"));
	}
}
