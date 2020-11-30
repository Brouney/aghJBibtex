package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Booklet;
import entities.Inbook;
import entities.Incollection;
import entities.Manual;
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
	private Button addelementtolistid;

	@FXML
	private Button deleteelementfromlistid;

	@FXML
	private Button deleteallfromlistid;

	@FXML
	private Button addalltodbid;

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

	@FXML
	private Button addfromtablebt;

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
	void addElementToList(ActionEvent event) {
		Manual ManualToAdd = createElement();

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

	private Manual createElement() {

		Manual manual = new Manual();

		manual.setAuthor(tfAuthor.getText());
		manual.setTitle(tfTitle.getText());
		manual.setYear(tfYear.getText());
		manual.setMonth(tfMonth.getText());
		manual.setNote(tfNote.getText());
		manual.setKey(tfKey.getText());
		manual.setAddress(tfAddress.getText());
		manual.setEdition(tfEdition.getText());
		manual.setOrganization(tfOrganization.getText());
		manual.setBibkey(tfBibKey.getText());

		manual.setKeywords(tfkeywords.getText());
		return manual;
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Manual manualToDel = createElement();

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
	}

}
