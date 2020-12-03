package dbcontrollers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Article;
import entities.Book;
import entities.Inproceedings;
import entities.Phdthesis;
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
	private TableView<Proceedings> tvProceedings;

	@FXML
	private TableColumn<Proceedings, String> tcBibKey;

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
	private TableColumn<Proceedings, String> tcMonth;

	@FXML
	private TableColumn<Proceedings, String> tcNote;

	@FXML
	private TableColumn<Proceedings, String> tcKey;

	@FXML
	private TableColumn<Proceedings, String> tcUrl;

	@FXML
	private TableColumn<Proceedings, String> tcKeywords;

	@FXML
	void addFromTable(ActionEvent event) {
		Proceedings fromtable = tvProceedings.getSelectionModel().getSelectedItem();
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

		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	@FXML
	void addElementToFile(ActionEvent event) {
		Proceedings tofile = new Proceedings();
		editelement(tofile);
		System.out.println(tofile);
		
		
		try {
			FileWriter fw = new FileWriter(guicontrollers.MainPageController.fileToExport.getAbsolutePath(),true);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(tofile.toString());
			out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void searchdbfunc(ActionEvent event) {

	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Proceedings fromdbobj : ClassOfLists.listOfProceedings) {

			Proceedings infunc = em.find(Proceedings.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfProceedings.clear();
		refresh();
		Main.mainController.changeLabelCountProceedings(Integer.toString((ClassOfLists.listOfProceedings.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Proceedings fromtable = tvProceedings.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Proceedings fromdbobj = em.find(Proceedings.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfProceedings.remove(tvProceedings.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountProceedings(Integer.toString((ClassOfLists.listOfProceedings.size())));

	}

	private void editelement(Proceedings proceedings) {

		proceedings.setAddress(tfAddress.getText());
		proceedings.setEditor(tfEditor.getText());
		proceedings.setTitle(tfTitle.getText());
		proceedings.setYear(tfYear.getText());
		proceedings.setPublisher(tfPublisher.getText());

		proceedings.setVolume(tfVolume.getText());
		proceedings.setNumber(tfNumber.getText());
		proceedings.setSeries(tfSeries.getText());
		proceedings.setOrganization(tfOrganization.getText());
		proceedings.setMonth(tfMonth.getText());
		proceedings.setNote(tfNote.getText());
		proceedings.setKey(tfKey.getText());

		proceedings.setBibkey(tfBibKey.getText());
		proceedings.setKeywords(tfkeywords.getText());

	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Proceedings fromtable = tvProceedings.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Proceedings fromdbobj = em.find(Proceedings.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

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
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfProceedings.clear();
		refresh();
		Main.mainController.changeLabelCountProceedings(Integer.toString((ClassOfLists.listOfProceedings.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

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
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Proceedings, String>("Keywords"));
		refresh();
	}

}
