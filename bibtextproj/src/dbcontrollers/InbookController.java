package dbcontrollers;

import application.Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Article;
import entities.Book;
import entities.EntryTypes;
import entities.Inbook;
import gui.MyAlertClass;
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
	private Button addfromtablebt;

	@FXML
	private TextField tfBibKey;

	@FXML
	private TextField tfkeywords;

	@FXML
	private TextField tfchapter;
	@FXML
	private TextField tfpages;

	@FXML
	private TableView<Inbook> tvInbook;

	@FXML
	private TableColumn<Inbook, String> tcBibKey;

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
	private TableColumn<Inbook, String> tcKeywords;
	@FXML
	private TableColumn<Inbook, String> tcPages;
	@FXML
	private TableColumn<Inbook, String> tcChapter;

	MyAlertClass myAlertClass;

	@FXML
	void addElementToFile(ActionEvent event) {

		validate();

		Inbook tofile = new Inbook();
		editelement(tofile);
		System.out.println(tofile);

		try {
			FileWriter fw = new FileWriter(guicontrollers.MainPageController.fileToExport.getAbsolutePath(), true);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(tofile.toString());
			out.close();

			myAlertClass.addedToFileAlert();
		} catch (IOException e) {
			myAlertClass.fileErrorAlert();
		}

	}

	@FXML
	void searchdbfunc(ActionEvent event) {
		Inbook tofind = new Inbook();
		editelement(tofind);

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			List<Inbook> Inbookitems = em.createQuery(tofind.generateQuery()).getResultList();
			dbcontrollers.ClassOfLists.listOfInbook = new ArrayList<Inbook>(Inbookitems);
			Main.mainController
					.changeLabelCountInbook(Integer.toString(dbcontrollers.ClassOfLists.listOfInbook.size()));
			refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	void addFromTable(ActionEvent event) {
		Inbook fromtable = tvInbook.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfAddress.setText(fromtable.getAddress());
		tfEditor.setText(fromtable.getEditor());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfPublisher.setText(fromtable.getPublisher());

		tfVolume.setText(fromtable.getVolume());
		tfNumber.setText(fromtable.getNumber());
		tfSeries.setText(fromtable.getSeries());
		tfEdition.setText(fromtable.getEdition());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfUrl.setText(fromtable.getUrl());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());

		tfchapter.setText(fromtable.getChapter());
		tfpages.setText(fromtable.getPages());
	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Inbook fromdbobj : ClassOfLists.listOfInbook) {

			Inbook infunc = em.find(Inbook.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfInbook.clear();
		refresh();
		Main.mainController.changeLabelCountInbook(Integer.toString((ClassOfLists.listOfInbook.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Inbook fromtable = tvInbook.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Inbook fromdbobj = em.find(Inbook.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfInbook.remove(tvInbook.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountInbook(Integer.toString((ClassOfLists.listOfInbook.size())));

	}

	private void editelement(Inbook inbook) {

		inbook.setAuthor(tfAuthor.getText());
		inbook.setAddress(tfAddress.getText());
		inbook.setEditor(tfEditor.getText());
		inbook.setTitle(tfTitle.getText());
		inbook.setYear(tfYear.getText());
		inbook.setPublisher(tfPublisher.getText());

		inbook.setVolume(tfVolume.getText());
		inbook.setNumber(tfNumber.getText());
		inbook.setSeries(tfSeries.getText());
		inbook.setEdition(tfEdition.getText());
		inbook.setMonth(tfMonth.getText());
		inbook.setNote(tfNote.getText());
		inbook.setKey(tfKey.getText());
		inbook.setUrl(tfUrl.getText());
		inbook.setBibkey(tfBibKey.getText());
		inbook.setKeywords(tfkeywords.getText());
		inbook.setChapter(tfchapter.getText());
		inbook.setPages(tfpages.getText());
	}

	private void validate() {

		boolean badValidation = false;
		if (tfAuthor.getText().isEmpty() && tfEditor.getText().isEmpty()) {
			badValidation = true;
		}
		if (!tfAuthor.getText().isEmpty() && !tfEditor.getText().isEmpty()) {
			badValidation = true;
		}
		if (tfTitle.getText().isEmpty() || tfPublisher.getText().isEmpty() || tfYear.getText().isEmpty()) {

			badValidation = true;

		}
		if (tfchapter.getText().isEmpty() && tfpages.getText().isEmpty()) {
			badValidation = true;
		}

		if (badValidation) {

			myAlertClass.objectErrorAlert();

		}

	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Inbook fromtable = tvInbook.getSelectionModel().getSelectedItem();

		validate();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Inbook fromdbobj = em.find(Inbook.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

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
		tfBibKey.setText("");
		tfkeywords.setText("");
		tfpages.setText("");
		tfchapter.setText("");
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
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Keywords"));
		tcChapter.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Chapter"));
		tcPages.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Pages"));
		refresh();
		myAlertClass = new MyAlertClass();
	}

	void refresh() {

		ObservableList<Inbook> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfInbook);

		tvInbook.setItems(tableViewList);
	}

}
