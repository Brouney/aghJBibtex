package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Inbook;
import entities.Incollection;
import entities.Incollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class IncollectionController implements Initializable {

	@FXML
	private TextField tfType;

	@FXML
	private TextField tfEditor;

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
	private TextField tfChapter;

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
	private TextField tfPages;

    @FXML
    private Button cleantextid;

    @FXML
    private Button editElementInDBbt;

    @FXML
    private Button deleteelementfromDBbt;

    @FXML
    private Button addalltodbid;

    @FXML
    private Button searchbt;

    @FXML
    private Button deleteallfromlistid;

	@FXML
	private TextField tfBibKey;

	@FXML
	private TextField tfkeywords;

	@FXML
	private TableView<Incollection> tvIncollection;

	@FXML
	private TableColumn<Incollection, String> tcBibKey;

	@FXML
	private TableColumn<Incollection, String> tcAuthor;

	@FXML
	private TableColumn<Incollection, String> tcTitle;

	@FXML
	private TableColumn<Incollection, String> tcYear;

	@FXML
	private TableColumn<Incollection, String> tcPublisher;

	@FXML
	private TableColumn<Incollection, String> tcEditor;

	@FXML
	private TableColumn<Incollection, String> tcVolume;

	@FXML
	private TableColumn<Incollection, String> tcNumber;

	@FXML
	private TableColumn<Incollection, String> tcSeries;

	@FXML
	private TableColumn<Incollection, String> tcAddress;

	@FXML
	private TableColumn<Incollection, String> tcEdition;

	@FXML
	private TableColumn<Incollection, String> tcMonth;

	@FXML
	private TableColumn<Incollection, String> tcNote;

	@FXML
	private TableColumn<Incollection, String> tcKey;

	@FXML
	private TableColumn<Incollection, String> tcPages;

	@FXML
	private TableColumn<Incollection, String> tcType;

	@FXML
	private TableColumn<Incollection, String> tcChapter;
	@FXML
	private TableColumn<Incollection, String> tcBooktitle;

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Incollection toAdd : ClassOfLists.listOfIncollection) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfIncollection.clear();
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfIncollection.size())));
	}

	@FXML
	void addElementToFile(ActionEvent event) {

	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {

	}

	@FXML
	void editElementInDB(ActionEvent event) {

	}

	@FXML
	void searchdbfunc(ActionEvent event) {

	}

	@FXML
	void addElementToList(ActionEvent event) {
		Incollection incollectionToAdd = new Incollection();

		System.out.println("po try");

		incollectionToAdd.setAuthor(tfAuthor.getText());
		incollectionToAdd.setBooktitle(tfBooktitle.getText());
		incollectionToAdd.setTitle(tfTitle.getText());
		incollectionToAdd.setYear(tfYear.getText());
		incollectionToAdd.setPublisher(tfPublisher.getText());

		incollectionToAdd.setVolume(tfVolume.getText());
		incollectionToAdd.setNumber(tfNumber.getText());
		incollectionToAdd.setMonth(tfMonth.getText());
		incollectionToAdd.setNote(tfNote.getText());
		incollectionToAdd.setKey(tfKey.getText());
		incollectionToAdd.setChapter(tfChapter.getText());
		incollectionToAdd.setAddress(tfAddress.getText());
		incollectionToAdd.setPages(tfPages.getText());
		incollectionToAdd.setSeries(tfSeries.getText());
		incollectionToAdd.setEditor(tfEditor.getText());
		incollectionToAdd.setType(tfType.getText());
		incollectionToAdd.setEdition(tfEdition.getText());
		incollectionToAdd.setBibkey(tfBibKey.getText());

		ClassOfLists.listOfIncollection.add(incollectionToAdd);
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfIncollection.size())));
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfBooktitle.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfPublisher.setText("");

		tfVolume.setText("");
		tfNumber.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfChapter.setText("");
		tfAddress.setText("");
		tfPages.setText("");
		tfSeries.setText("");
		tfEditor.setText("");
		tfEdition.setText("");
		tfType.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfIncollection.clear();
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfIncollection.size())));
	}

	void refresh() {
		ObservableList<Incollection> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfIncollection);

		tvIncollection.setItems(tableViewList);
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Incollection incollectionToDel = new Incollection();

		incollectionToDel.setAuthor(tfAuthor.getText());
		incollectionToDel.setBooktitle(tfBooktitle.getText());
		incollectionToDel.setTitle(tfTitle.getText());
		incollectionToDel.setYear(tfYear.getText());
		incollectionToDel.setPublisher(tfPublisher.getText());

		incollectionToDel.setVolume(tfVolume.getText());
		incollectionToDel.setNumber(tfNumber.getText());
		incollectionToDel.setMonth(tfMonth.getText());
		incollectionToDel.setNote(tfNote.getText());
		incollectionToDel.setKey(tfKey.getText());
		incollectionToDel.setType(tfType.getText());
		incollectionToDel.setAddress(tfAddress.getText());
		incollectionToDel.setPages(tfPages.getText());
		incollectionToDel.setSeries(tfSeries.getText());
		incollectionToDel.setEdition(tfEdition.getText());
		incollectionToDel.setAddress(tfEditor.getText());
		incollectionToDel.setChapter(tfChapter.getText());
		incollectionToDel.setBibkey(tfBibKey.getText());
		int toDelInLoop = 0;
		System.out.println("przed forem delete");
		for (Incollection art : ClassOfLists.listOfIncollection) {
			if (incollectionToDel.myequals(art)) {
				ClassOfLists.listOfIncollection.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}
		// w incollection editor jest zakomentowany - wtedy działa xd

		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfIncollection.size())));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Author"));
		tcType.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Type"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Year"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Publisher"));

		tcVolume.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Number"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Key"));
		tcChapter.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Chapter"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Address"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Series"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Editor"));
		tcEdition.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Edition"));
		tcPages.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Pages"));
		tcBooktitle.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Booktitle"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Bibkey"));
		refresh();
	}

}
