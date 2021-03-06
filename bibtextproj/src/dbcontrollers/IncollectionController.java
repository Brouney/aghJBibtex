package dbcontrollers;

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

import application.Main;
import entities.Article;
import entities.Book;
import entities.Inbook;
import entities.Incollection;
import gui.MyAlertClass;
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
	private Button addfromtablebt;

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
	private TableColumn<Incollection, String> tcKeywords;

	MyAlertClass myAlertClass;

	@FXML
	void addFromTable(ActionEvent event) {
		Incollection fromtable = tvIncollection.getSelectionModel().getSelectedItem();

		tfAuthor.setText(fromtable.getAuthor());
		tfBooktitle.setText(fromtable.getBibkey());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfPublisher.setText(fromtable.getPublisher());

		tfVolume.setText(fromtable.getVolume());
		tfNumber.setText(fromtable.getNumber());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfChapter.setText(fromtable.getChapter());
		tfAddress.setText(fromtable.getAddress());
		tfPages.setText(fromtable.getPages());
		tfSeries.setText(fromtable.getSeries());
		tfEditor.setText(fromtable.getEditor());
		tfEdition.setText(fromtable.getEdition());
		tfType.setText(fromtable.getType());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	@FXML
	void addElementToFile(ActionEvent event) {

		validate();

		Incollection tofile = new Incollection();
		editelement(tofile);
		System.out.println(tofile);

		try {
			FileWriter fw = new FileWriter(guicontrollers.MainPageController.fileToExport.getAbsolutePath(), true);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(tofile.toString());
			out.close();
			myAlertClass.addedToFileAlert();
		} catch (Exception e) {
			myAlertClass.fileErrorAlert();
		}

	}

	@FXML
	void searchdbfunc(ActionEvent event) {
		Incollection tofind = new Incollection();
		editelement(tofind);

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			List<Incollection> Incollectionitems = em.createQuery(tofind.generateQuery()).getResultList();
			dbcontrollers.ClassOfLists.listOfIncollection = new ArrayList<Incollection>(Incollectionitems);
			Main.mainController.changeLabelCountIncollection(
					Integer.toString(dbcontrollers.ClassOfLists.listOfIncollection.size()));
			refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Incollection fromdbobj : ClassOfLists.listOfIncollection) {

			Incollection infunc = em.find(Incollection.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfIncollection.clear();
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfIncollection.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Incollection fromtable = tvIncollection.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Incollection fromdbobj = em.find(Incollection.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfIncollection.remove(tvIncollection.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfIncollection.size())));

	}

	private void editelement(Incollection incollection) {
		incollection.setAuthor(tfAuthor.getText());
		incollection.setBooktitle(tfBooktitle.getText());
		incollection.setTitle(tfTitle.getText());
		incollection.setYear(tfYear.getText());
		incollection.setPublisher(tfPublisher.getText());

		incollection.setVolume(tfVolume.getText());
		incollection.setNumber(tfNumber.getText());
		incollection.setMonth(tfMonth.getText());
		incollection.setNote(tfNote.getText());
		incollection.setKey(tfKey.getText());
		incollection.setChapter(tfChapter.getText());
		incollection.setAddress(tfAddress.getText());
		incollection.setPages(tfPages.getText());
		incollection.setSeries(tfSeries.getText());
		incollection.setEditor(tfEditor.getText());
		incollection.setType(tfType.getText());
		incollection.setEdition(tfEdition.getText());
		incollection.setBibkey(tfBibKey.getText());
		incollection.setKeywords(tfkeywords.getText());
	}

	private void validate() {

		boolean badValidation = false;

		if (tfAuthor.getText().isEmpty() || tfBooktitle.getText().isEmpty() || tfTitle.getText().isEmpty()
				|| tfYear.getText().isEmpty() || tfPublisher.getText().isEmpty()) {
			badValidation = true;

		}

		if (!tfVolume.getText().isEmpty() && !tfNumber.getText().isEmpty()) {
			badValidation = true;
		}
		if (badValidation) {
			myAlertClass.objectErrorAlert();

		}

	}

	@FXML
	void editElementInDB(ActionEvent event) {

		validate();

		Incollection fromtable = tvIncollection.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Incollection fromdbobj = em.find(Incollection.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();
		try {
			List<Incollection> Incollectionitems = em.createQuery("select f from fields f where bibitem = 'Incollection'")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfIncollection = new ArrayList<Incollection>(Incollectionitems);
			Main.mainController.changeLabelCountIncollection(
					Integer.toString(dbcontrollers.ClassOfLists.listOfIncollection.size()));
			refresh();

			myAlertClass.editedInDB();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		em.close();
		emf.close();

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

	void refresh() {
		ObservableList<Incollection> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfIncollection);

		tvIncollection.setItems(tableViewList);
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
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Incollection, String>("Keywords"));

		myAlertClass = new MyAlertClass();
		refresh();
	}

}
