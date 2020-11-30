package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	private TableColumn<Conference, String> tcKeywords;

	@FXML
	private Button addfromtablebt;

	@FXML
	void addFromTable(ActionEvent event) {
		Conference fromtable = tvConference.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfBooktitle.setText(fromtable.getBooktitle());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());

		tfVolume.setText(fromtable.getVolume());
		tfPublisher.setText(fromtable.getPublisher());
		tfNumber.setText(fromtable.getNumber());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfOrganization.setText(fromtable.getOrganization());
		tfAddress.setText(fromtable.getAddress());
		tfPages.setText(fromtable.getPages());
		tfSeries.setText(fromtable.getSeries());
		tfEditor.setText(fromtable.getEditor());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Conference toAdd : ClassOfLists.listOfConference) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfConference.clear();
		refresh();
		Main.mainController.changeLabelCountConference(Integer.toString((ClassOfLists.listOfConference.size())));
	}

	@FXML
	void addElementToList(ActionEvent event) {
		Conference conferenceToAdd = createElement();
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

	private Conference createElement() {

		Conference conference = new Conference();

		conference.setAuthor(tfAuthor.getText());
		conference.setBooktitle(tfBooktitle.getText());
		conference.setTitle(tfTitle.getText());
		conference.setYear(tfYear.getText());

		conference.setVolume(tfVolume.getText());
		conference.setPublisher(tfPublisher.getText());
		conference.setNumber(tfNumber.getText());
		conference.setMonth(tfMonth.getText());
		conference.setNote(tfNote.getText());
		conference.setKey(tfKey.getText());
		conference.setOrganization(tfOrganization.getText());
		conference.setAddress(tfAddress.getText());
		conference.setPages(tfPages.getText());
		conference.setSeries(tfSeries.getText());
		conference.setEditor(tfEditor.getText());
		conference.setBibkey(tfBibKey.getText());
		conference.setKeywords(tfkeywords.getText());
		return conference;

	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfConference.clear();
		refresh();
		Main.mainController.changeLabelCountConference(Integer.toString((ClassOfLists.listOfConference.size())));
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Conference conferenceToDel = createElement();
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
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Conference, String>("Keywords"));
		refresh();
	}
}
