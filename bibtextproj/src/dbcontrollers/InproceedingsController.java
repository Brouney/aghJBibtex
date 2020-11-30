package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Article;
import entities.Book;
import entities.Inbook;
import entities.Inproceedings;
import entities.Inproceedings;
import entities.Inproceedings;
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

public class InproceedingsController implements Initializable {

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
	private Button editElementInDBbt;

	@FXML
	private Button deleteelementfromDBbt;

	@FXML
	private Button addalltodbid;

	@FXML
	private Button searchbt;

	@FXML
	private Button addfromtablebt;

	@FXML
	private Button deleteallfromlistid;

	@FXML
	private TextField tfBibKey;

	@FXML
	private TextField tfkeywords;

	@FXML
	private TableView<Inproceedings> tvInproceedings;

	@FXML
	private TableColumn<Inproceedings, String> tcBibKey;

	@FXML
	private TableColumn<Inproceedings, String> tcAuthor;

	@FXML
	private TableColumn<Inproceedings, String> tcBooktitle;

	@FXML
	private TableColumn<Inproceedings, String> tcTitle;

	@FXML
	private TableColumn<Inproceedings, String> tcYear;

	@FXML
	private TableColumn<Inproceedings, String> tcPublisher;

	@FXML
	private TableColumn<Inproceedings, String> tcPages;

	@FXML
	private TableColumn<Inproceedings, String> tcVolume;

	@FXML
	private TableColumn<Inproceedings, String> tcNumber;

	@FXML
	private TableColumn<Inproceedings, String> tcSeries;

	@FXML
	private TableColumn<Inproceedings, String> tcAddress;

	@FXML
	private TableColumn<Inproceedings, String> tcOrganization;

	@FXML
	private TableColumn<Inproceedings, String> tcMonth;

	@FXML
	private TableColumn<Inproceedings, String> tcNote;

	@FXML
	private TableColumn<Inproceedings, String> tcKey;

	@FXML
	private TableColumn<Inproceedings, String> tcEditor;

	@FXML
	private TableColumn<Inproceedings, String> tcKeywords;

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Inproceedings toAdd : ClassOfLists.listOfInproceedings) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfInproceedings.clear();
		refresh();
		Main.mainController.changeLabelCountInproceedings(Integer.toString((ClassOfLists.listOfInproceedings.size())));
	}

	@FXML
	void searchdbfunc(ActionEvent event) {

	}

	@FXML
	void addElementToFile(ActionEvent event) {

	}

	@FXML
	void addFromTable(ActionEvent event) {
		Inproceedings fromtable = tvInproceedings.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfAddress.setText(fromtable.getAddress());
		tfEditor.setText(fromtable.getEditor());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfPublisher.setText(fromtable.getPublisher());

		tfVolume.setText(fromtable.getVolume());
		tfNumber.setText(fromtable.getNumber());
		tfSeries.setText(fromtable.getSeries());
		tfOrganization.setText(fromtable.getOrganization());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfPages.setText(fromtable.getPages());
		tfBooktitle.setText(fromtable.getBooktitle());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	private void editelement(Inproceedings inproceedings) {

		inproceedings.setAuthor(tfAuthor.getText());
		inproceedings.setAddress(tfAddress.getText());
		inproceedings.setEditor(tfEditor.getText());
		inproceedings.setTitle(tfTitle.getText());
		inproceedings.setYear(tfYear.getText());
		inproceedings.setPublisher(tfPublisher.getText());

		inproceedings.setVolume(tfVolume.getText());
		inproceedings.setNumber(tfNumber.getText());
		inproceedings.setSeries(tfSeries.getText());
		inproceedings.setOrganization(tfOrganization.getText());
		inproceedings.setMonth(tfMonth.getText());
		inproceedings.setNote(tfNote.getText());
		inproceedings.setKey(tfKey.getText());
		inproceedings.setBooktitle(tfBooktitle.getText());
		inproceedings.setPages(tfPages.getText());
		inproceedings.setBibkey(tfBibKey.getText());
		inproceedings.setKeywords(tfkeywords.getText());

	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Inproceedings fromdbobj : ClassOfLists.listOfInproceedings) {

			Inproceedings infunc = em.find(Inproceedings.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfInproceedings.clear();
		refresh();
		Main.mainController.changeLabelCountInproceedings(Integer.toString((ClassOfLists.listOfInproceedings.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Inproceedings fromtable = tvInproceedings.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Inproceedings fromdbobj = em.find(Inproceedings.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfInproceedings.remove(tvInproceedings.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountInproceedings(Integer.toString((ClassOfLists.listOfInproceedings.size())));

	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Inproceedings fromtable = tvInproceedings.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Inproceedings fromdbobj = em.find(Inproceedings.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	void refresh() {

		ObservableList<Inproceedings> tableViewList = FXCollections
				.observableArrayList(ClassOfLists.listOfInproceedings);

		tvInproceedings.setItems(tableViewList);
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
		tfOrganization.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfPages.setText("");
		tfBooktitle.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Author"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Address"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Editor"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Year"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Publisher"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Number"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Series"));
		tcPages.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Pages"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Key"));
		tcOrganization.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Organization"));
		tcBooktitle.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Booktitle"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Keywords"));
		refresh();
	}

}
