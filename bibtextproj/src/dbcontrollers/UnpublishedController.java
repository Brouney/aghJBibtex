package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Article;
import entities.Book;
import entities.Techreport;
import entities.Unpublished;
import entities.Unpublished;
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

public class UnpublishedController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfMonth;

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
	private TableView<Unpublished> tvUnpublished;

	@FXML
	private TableColumn<Unpublished, String> tcBibKey;

	@FXML
	private TableColumn<Unpublished, String> tcAuthor;

	@FXML
	private TableColumn<Unpublished, String> tcTitle;

	@FXML
	private TableColumn<Unpublished, String> tcNote;

	@FXML
	private TableColumn<Unpublished, String> tcYear;

	@FXML
	private TableColumn<Unpublished, String> tcMonth;

	@FXML
	private TableColumn<Unpublished, String> tcKey;

	@FXML
	void addFromTable(ActionEvent event) {
		Unpublished fromtable = tvUnpublished.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());

		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	private void editelement(Unpublished unpublished) {
		unpublished.setAuthor(tfAuthor.getText());
		unpublished.setTitle(tfTitle.getText());
		unpublished.setYear(tfYear.getText());
		unpublished.setMonth(tfMonth.getText());
		unpublished.setNote(tfNote.getText());
		unpublished.setKey(tfKey.getText());
		unpublished.setBibkey(tfBibKey.getText());
		unpublished.setKeywords(tfkeywords.getText());
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

		for (Unpublished fromdbobj : ClassOfLists.listOfUnpublished) {

			Unpublished infunc = em.find(Unpublished.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfUnpublished.clear();
		refresh();
		Main.mainController.changeLabelCountUnpublished(Integer.toString((ClassOfLists.listOfUnpublished.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Unpublished fromtable = tvUnpublished.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Unpublished fromdbobj = em.find(Unpublished.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfUnpublished.remove(tvUnpublished.getSelectionModel().getSelectedItem());

		refresh();
		Main.mainController.changeLabelCountUnpublished(Integer.toString((ClassOfLists.listOfUnpublished.size())));

	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Unpublished fromtable = tvUnpublished.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Unpublished fromdbobj = em.find(Unpublished.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	void refresh() {

		ObservableList<Unpublished> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfUnpublished);

		tvUnpublished.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfUnpublished.clear();
		refresh();
		Main.mainController.changeLabelCountUnpublished(Integer.toString((ClassOfLists.listOfUnpublished.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Author"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Key"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Bibkey"));
		refresh();
	}

}
