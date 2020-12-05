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
import gui.MyAlertClass;
import entities.Misc;
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

public class MiscController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfHowpublished;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfYear;

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
	private TableView<Misc> tvMisc;

	@FXML
	private TableColumn<Misc, String> tcAuthor;

	@FXML
	private TableColumn<Misc, String> tcBibKey;

	@FXML
	private TableColumn<Misc, String> tcTitle;

	@FXML
	private TableColumn<Misc, String> tcHowpublished;

	@FXML
	private TableColumn<Misc, String> tcMonth;

	@FXML
	private TableColumn<Misc, String> tcYear;

	@FXML
	private TableColumn<Misc, String> tcNote;

	@FXML
	private TableColumn<Misc, String> tcKey;

	@FXML
	private TableColumn<Misc, String> tcKeywords;

	MyAlertClass myAlertClass = new MyAlertClass();

	@FXML
	void addFromTable(ActionEvent event) {
		Misc fromtable = tvMisc.getSelectionModel().getSelectedItem();

		tfAuthor.setText(fromtable.getAuthor());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfHowpublished.setText(fromtable.getHowpublished());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	@FXML
	void addElementToFile(ActionEvent event) {
		Misc tofile = new Misc();
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
	void deleteAllFromDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Misc fromdbobj : ClassOfLists.listOfMisc) {

			Misc infunc = em.find(Misc.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfMisc.clear();
		refresh();
		Main.mainController.changeLabelCountMisc(Integer.toString((ClassOfLists.listOfMisc.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Misc fromtable = tvMisc.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Misc fromdbobj = em.find(Misc.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfMisc.remove(tvMisc.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountMisc(Integer.toString((ClassOfLists.listOfMisc.size())));

	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Misc fromtable = tvMisc.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Misc fromdbobj = em.find(Misc.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();
		try {
			List<Misc> Miscitems = em.createQuery("select f from fields f where bibitem = 'Misc'").getResultList();
			dbcontrollers.ClassOfLists.listOfMisc = new ArrayList<Misc>(Miscitems);
			Main.mainController.changeLabelCountMisc(Integer.toString(dbcontrollers.ClassOfLists.listOfMisc.size()));
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
		Misc tofind = new Misc();
		editelement(tofind);

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			List<Misc> Miscitems = em.createQuery(tofind.generateQuery()).getResultList();
			dbcontrollers.ClassOfLists.listOfMisc = new ArrayList<Misc>(Miscitems);
			Main.mainController.changeLabelCountMisc(Integer.toString(dbcontrollers.ClassOfLists.listOfMisc.size()));
			refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void editelement(Misc misc) {
		misc.setAuthor(tfAuthor.getText());
		misc.setTitle(tfTitle.getText());
		misc.setYear(tfYear.getText());
		misc.setMonth(tfMonth.getText());
		misc.setNote(tfNote.getText());
		misc.setKey(tfKey.getText());
		misc.setHowpublished(tfHowpublished.getText());
		misc.setBibkey(tfBibKey.getText());
	}

	void refresh() {

		ObservableList<Misc> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfMisc);

		tvMisc.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfHowpublished.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Misc, String>("Author"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Misc, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Misc, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Misc, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Misc, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Misc, String>("Key"));
		tcHowpublished.setCellValueFactory(new PropertyValueFactory<Misc, String>("Howpublished"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Misc, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Misc, String>("Keywords"));

		refresh();
	}

}
