package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Article;
import entities.Book;
import entities.Manual;
import entities.Mastersthesis;
import entities.Mastersthesis;
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

public class MastersthesisController implements Initializable {

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
	private TableView<Mastersthesis> tvMasterthesis;

	@FXML
	private TableColumn<Mastersthesis, String> tcAuthor;

	@FXML
	private TableColumn<Mastersthesis, String> tcBibKey;

	@FXML
	private TableColumn<Mastersthesis, String> tcTitle;

	@FXML
	private TableColumn<Mastersthesis, String> tcYear;

	@FXML
	private TableColumn<Mastersthesis, String> tcSchool;

	@FXML
	private TableColumn<Mastersthesis, String> tcType;

	@FXML
	private TableColumn<Mastersthesis, String> tcAddress;

	@FXML
	private TableColumn<Mastersthesis, String> tcMonth;

	@FXML
	private TableColumn<Mastersthesis, String> tcNote;

	@FXML
	private TableColumn<Mastersthesis, String> tcKey;

	@FXML
	void addFromTable(ActionEvent event) {
		Mastersthesis fromtable = tvMasterthesis.getSelectionModel().getSelectedItem();
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

		for (Mastersthesis fromdbobj : ClassOfLists.listOfMastersthesis) {

			Mastersthesis infunc = em.find(Mastersthesis.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfMastersthesis.clear();
		refresh();
		Main.mainController.changeLabelCountMastersthesis(Integer.toString((ClassOfLists.listOfMastersthesis.size())));

	}

	private void editelement(Mastersthesis mastersthesis) {

		mastersthesis.setAuthor(tfAuthor.getText());
		mastersthesis.setAddress(tfAddress.getText());
		mastersthesis.setTitle(tfTitle.getText());
		mastersthesis.setYear(tfYear.getText());
		mastersthesis.setMonth(tfMonth.getText());
		mastersthesis.setNote(tfNote.getText());
		mastersthesis.setKey(tfKey.getText());
		mastersthesis.setSchool(tfSchool.getText());
		mastersthesis.setType(tfType.getText());
		mastersthesis.setBibkey(tfBibKey.getText());
		mastersthesis.setKeywords(tfkeywords.getText());
	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Mastersthesis fromtable = tvMasterthesis.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Mastersthesis fromdbobj = em.find(Mastersthesis.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfMastersthesis.remove(tvMasterthesis.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountMastersthesis(Integer.toString((ClassOfLists.listOfMastersthesis.size())));

	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Mastersthesis fromtable = tvMasterthesis.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Mastersthesis fromdbobj = em.find(Mastersthesis.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	void refresh() {

		ObservableList<Mastersthesis> tableViewList = FXCollections
				.observableArrayList(ClassOfLists.listOfMastersthesis);

		tvMasterthesis.setItems(tableViewList);
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
		ClassOfLists.listOfMastersthesis.clear();
		refresh();
		Main.mainController.changeLabelCountMastersthesis(Integer.toString((ClassOfLists.listOfMastersthesis.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Author"));
		tcType.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Type"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Key"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Address"));
		tcSchool.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("School"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Bibkey"));
		refresh();
	}

}
