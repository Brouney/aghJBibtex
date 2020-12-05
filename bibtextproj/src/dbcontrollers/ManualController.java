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
import entities.Booklet;
import entities.Inbook;
import entities.Incollection;
import entities.Manual;
import gui.MyAlertClass;
import entities.Manual;
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

public class ManualController implements Initializable {

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfOrganization;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfEdition;

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
	private TableView<Manual> tvManual;

	@FXML
	private TableColumn<Manual, String> tcBibKey;

	@FXML
	private TableColumn<Manual, String> tcTitle;

	@FXML
	private TableColumn<Manual, String> tcYear;

	@FXML
	private TableColumn<Manual, String> tcAuthor;

	@FXML
	private TableColumn<Manual, String> tcAddress;

	@FXML
	private TableColumn<Manual, String> tcOrganization;

	@FXML
	private TableColumn<Manual, String> tcMonth;

	@FXML
	private TableColumn<Manual, String> tcNote;

	@FXML
	private TableColumn<Manual, String> tcKey;

	@FXML
	private TableColumn<Manual, String> tcEdition;

	@FXML
	private TableColumn<Manual, String> tcKeywords;
	MyAlertClass myAlertClass;

	@FXML
	void addFromTable(ActionEvent event) {
		Manual fromtable = tvManual.getSelectionModel().getSelectedItem();

		tfAuthor.setText(fromtable.getAuthor());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());

		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfAddress.setText(fromtable.getAddress());
		tfOrganization.setText(fromtable.getOrganization());
		tfEdition.setText(fromtable.getEdition());
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

		for (Manual toAdd : ClassOfLists.listOfManual) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfManual.clear();
		refresh();
		Main.mainController.changeLabelCountManual(Integer.toString((ClassOfLists.listOfManual.size())));
	}

	@FXML
	void addElementToFile(ActionEvent event) {

		validate();

		Manual tofile = new Manual();
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
		Manual tofind = new Manual();
		editelement(tofind);

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			List<Manual> Manualitems = em.createQuery(tofind.generateQuery()).getResultList();
			dbcontrollers.ClassOfLists.listOfManual = new ArrayList<Manual>(Manualitems);
			Main.mainController
					.changeLabelCountManual(Integer.toString(dbcontrollers.ClassOfLists.listOfManual.size()));

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

		for (Manual fromdbobj : ClassOfLists.listOfManual) {

			Manual infunc = em.find(Manual.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfManual.clear();
		refresh();
		Main.mainController.changeLabelCountManual(Integer.toString((ClassOfLists.listOfManual.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Manual fromtable = tvManual.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Manual fromdbobj = em.find(Manual.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfManual.remove(tvManual.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountManual(Integer.toString((ClassOfLists.listOfManual.size())));

	}

	@FXML
	void editElementInDB(ActionEvent event) {

		validate();

		Manual fromtable = tvManual.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Manual fromdbobj = em.find(Manual.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();
		try {
			List<Manual> Manualitems = em.createQuery("select f from fields f where bibitem = 'Manual'").getResultList();
			dbcontrollers.ClassOfLists.listOfManual = new ArrayList<Manual>(Manualitems);
			Main.mainController
					.changeLabelCountManual(Integer.toString(dbcontrollers.ClassOfLists.listOfManual.size()));

			refresh();

			myAlertClass.editedInDB();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		em.close();
		emf.close();

	}

	private void validate() {

		if (tfTitle.getText().isEmpty()) {
			myAlertClass.objectErrorAlert();

		}

	}

	private void editelement(Manual manual) {
		manual.setAuthor(tfAuthor.getText());
		manual.setTitle(tfTitle.getText());
		manual.setYear(tfYear.getText());
		manual.setMonth(tfMonth.getText());
		manual.setNote(tfNote.getText());
		manual.setKey(tfKey.getText());
		manual.setAddress(tfAddress.getText());
		manual.setOrganization(tfOrganization.getText());
		manual.setEdition(tfEdition.getText());
		manual.setBibkey(tfBibKey.getText());
	}

	@FXML
	void addElementToList(ActionEvent event) {
		Manual ManualToAdd = new Manual();

		System.out.println("po try");

		ManualToAdd.setAuthor(tfAuthor.getText());
		ManualToAdd.setTitle(tfTitle.getText());
		ManualToAdd.setYear(tfYear.getText());
		ManualToAdd.setMonth(tfMonth.getText());
		ManualToAdd.setNote(tfNote.getText());
		ManualToAdd.setKey(tfKey.getText());
		ManualToAdd.setAddress(tfAddress.getText());
		ManualToAdd.setOrganization(tfOrganization.getText());
		ManualToAdd.setEdition(tfEdition.getText());
		ManualToAdd.setBibkey(tfBibKey.getText());
		ClassOfLists.listOfManual.add(ManualToAdd);
		refresh();
		Main.mainController.changeLabelCountManual(Integer.toString((ClassOfLists.listOfManual.size())));
	}

	void refresh() {
		ObservableList<Manual> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfManual);

		tvManual.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfTitle.setText("");
		tfYear.setText("");

		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfAddress.setText("");
		tfOrganization.setText("");
		tfEdition.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfManual.clear();
		refresh();
		Main.mainController.changeLabelCountManual(Integer.toString((ClassOfLists.listOfManual.size())));

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Manual manualToDel = new Manual();

		manualToDel.setAuthor(tfAuthor.getText());
		manualToDel.setTitle(tfTitle.getText());
		manualToDel.setYear(tfYear.getText());
		manualToDel.setMonth(tfMonth.getText());
		manualToDel.setNote(tfNote.getText());
		manualToDel.setKey(tfKey.getText());
		manualToDel.setAddress(tfAddress.getText());
		manualToDel.setEdition(tfEdition.getText());
		manualToDel.setOrganization(tfOrganization.getText());
		manualToDel.setBibkey(tfBibKey.getText());

		int toDelInLoop = 0;
		System.out.println("przed forem delete");
		for (Manual art : ClassOfLists.listOfManual) {
			if (art.myequals(manualToDel)) {
				ClassOfLists.listOfManual.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}

		refresh();
		Main.mainController.changeLabelCountManual(Integer.toString((ClassOfLists.listOfManual.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Manual, String>("Author"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Manual, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Manual, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Manual, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Manual, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Manual, String>("Key"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Manual, String>("Address"));
		tcOrganization.setCellValueFactory(new PropertyValueFactory<Manual, String>("Organization"));
		tcEdition.setCellValueFactory(new PropertyValueFactory<Manual, String>("Edition"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Manual, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Manual, String>("Keywords"));
		refresh();

		myAlertClass = new MyAlertClass();
	}

}
