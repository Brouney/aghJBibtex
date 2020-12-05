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
import entities.Mastersthesis;
import entities.Misc;
import entities.Phdthesis;
import gui.MyAlertClass;
import entities.Phdthesis;
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

public class PhdthesisController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfSchool;

	@FXML
	private TextField tfType;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

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
	private TableView<Phdthesis> tvPhdthesis;

	@FXML
	private TableColumn<Phdthesis, String> tcAuthor;

	@FXML
	private TableColumn<Phdthesis, String> tcBibKey;

	@FXML
	private TableColumn<Phdthesis, String> tcTitle;

	@FXML
	private TableColumn<Phdthesis, String> tcYear;

	@FXML
	private TableColumn<Phdthesis, String> tcSchool;

	@FXML
	private TableColumn<Phdthesis, String> tcType;

	@FXML
	private TableColumn<Phdthesis, String> tcAddress;

	@FXML
	private TableColumn<Phdthesis, String> tcMonth;

	@FXML
	private TableColumn<Phdthesis, String> tcNote;

	@FXML
	private TableColumn<Phdthesis, String> tcKey;

	@FXML
	private TableColumn<Phdthesis, String> tcKeywords;

	MyAlertClass myAlertClass;

	@FXML
	void addFromTable(ActionEvent event) {
		Phdthesis fromtable = tvPhdthesis.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfAddress.setText(fromtable.getAddress());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfType.setText(fromtable.getType());
		tfSchool.setText(fromtable.getSchool());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	@FXML
	void addElementToFile(ActionEvent event) {

		validate();

		Phdthesis tofile = new Phdthesis();
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

	private void validate() {

		if (tfAuthor.getText().isEmpty() || tfSchool.getText().isEmpty() || tfTitle.getText().isEmpty()
				|| tfYear.getText().isEmpty()) {

			myAlertClass.objectErrorAlert();

		}

	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Phdthesis fromdbobj : ClassOfLists.listOfPhdthesis) {

			Phdthesis infunc = em.find(Phdthesis.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfPhdthesis.clear();
		refresh();
		Main.mainController.changeLabelCountPhdthesis(Integer.toString((ClassOfLists.listOfPhdthesis.size())));

	}

	private void editelement(Phdthesis phdthesis) {

		phdthesis.setAuthor(tfAuthor.getText());
		phdthesis.setAddress(tfAddress.getText());
		phdthesis.setTitle(tfTitle.getText());
		phdthesis.setYear(tfYear.getText());
		phdthesis.setMonth(tfMonth.getText());
		phdthesis.setNote(tfNote.getText());
		phdthesis.setKey(tfKey.getText());
		phdthesis.setSchool(tfSchool.getText());
		phdthesis.setType(tfType.getText());
		phdthesis.setBibkey(tfBibKey.getText());
		phdthesis.setKeywords(tfkeywords.getText());
	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Phdthesis fromtable = tvPhdthesis.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Phdthesis fromdbobj = em.find(Phdthesis.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfPhdthesis.remove(tvPhdthesis.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountPhdthesis(Integer.toString((ClassOfLists.listOfPhdthesis.size())));

	}

	@FXML
	void editElementInDB(ActionEvent event) {

		validate();

		Phdthesis fromtable = tvPhdthesis.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Phdthesis fromdbobj = em.find(Phdthesis.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();
		try {
			List<Phdthesis> Phdthesisitems = em.createQuery("select f from fields f where bibitem = 'Phdthesis'")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfPhdthesis = new ArrayList<Phdthesis>(Phdthesisitems);
			Main.mainController
					.changeLabelCountPhdthesis(Integer.toString(dbcontrollers.ClassOfLists.listOfPhdthesis.size()));
			refresh();
			myAlertClass.editedInDB();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		em.close();
		emf.close();

	}

	@FXML
	void searchdbfunc(ActionEvent event) {

		Phdthesis tofind = new Phdthesis();
		editelement(tofind);

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			List<Phdthesis> Phdthesisitems = em.createQuery(tofind.generateQuery()).getResultList();
			dbcontrollers.ClassOfLists.listOfPhdthesis = new ArrayList<Phdthesis>(Phdthesisitems);
			Main.mainController
					.changeLabelCountPhdthesis(Integer.toString(dbcontrollers.ClassOfLists.listOfPhdthesis.size()));
			refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void refresh() {

		ObservableList<Phdthesis> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfPhdthesis);

		tvPhdthesis.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfAddress.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfType.setText("");
		tfSchool.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfPhdthesis.clear();
		refresh();
		Main.mainController.changeLabelCountPhdthesis(Integer.toString((ClassOfLists.listOfPhdthesis.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Author"));
		tcType.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Type"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Key"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Address"));
		tcSchool.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("School"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Keywords"));
		refresh();
		myAlertClass = new MyAlertClass();

	}

}
