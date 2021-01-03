package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Manual;
import entities.Mastersthesis;
import gui.MyAlertClass;
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
	private TableColumn<Mastersthesis, String> tcKeywords;

	@FXML
	private Button addfromtablebt;

	MyAlertClass myAlertClass = new MyAlertClass();

	private void validate() {

		if (tfAuthor.getText() == null)
			tfAuthor.setText("");
		if (tfAddress.getText() == null)
			tfAddress.setText("");
		if (tfTitle.getText() == null)
			tfTitle.setText("");
		if (tfYear.getText() == null)
			tfYear.setText("");
		if (tfMonth.getText() == null)
			tfMonth.setText("");
		if (tfNote.getText() == null)
			tfNote.setText("");
		if (tfKey.getText() == null)
			tfKey.setText("");
		if (tfType.getText() == null)
			tfType.setText("");
		if (tfSchool.getText() == null)
			tfSchool.setText("");
		if (tfBibKey.getText() == null)
			tfBibKey.setText("");
		if (tfkeywords.getText() == null)
			tfkeywords.setText("");

		if (tfAuthor.getText().isEmpty() || tfSchool.getText().isEmpty() || tfTitle.getText().isEmpty()
				|| tfYear.getText().isEmpty()) {

			myAlertClass.objectErrorAlert();

		}

	}

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
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		

		for (Mastersthesis toAdd : ClassOfLists.listOfMastersthesis) {
			try {
				em.getTransaction().begin();
				em.persist(toAdd);
				em.getTransaction().commit();
				}catch(Exception e) { System.out.println(e.getMessage());}
		}
		

		em.close();
		emf.close();

		ClassOfLists.listOfMastersthesis.clear();
		refresh();
		Main.mainController.changeLabelCountMastersthesis(Integer.toString((ClassOfLists.listOfMastersthesis.size())));
		myAlertClass.addedToDB();
	}

	@FXML
	void addElementToList(ActionEvent event) {

		System.out.println("przed try");
		try {
			Mastersthesis mastersthesisToAdd = createElement();

			System.out.println("przed add");

			ClassOfLists.listOfMastersthesis.add(mastersthesisToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountMastersthesis(Integer.toString((ClassOfLists.listOfMastersthesis.size())));

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

	private Mastersthesis createElement() {
		validate();
		Mastersthesis mastersthesis = new Mastersthesis();
		mastersthesis.setAuthor(tfAuthor.getText());
		mastersthesis.setAddress(tfAddress.getText());
		mastersthesis.setTitle(tfTitle.getText());
		mastersthesis.setYear(tfYear.getText());
		mastersthesis.setSchool(tfSchool.getText());
		mastersthesis.setMonth(tfMonth.getText());
		mastersthesis.setNote(tfNote.getText());
		mastersthesis.setKey(tfKey.getText());
		mastersthesis.setType(tfType.getText());
		mastersthesis.setBibkey(tfBibKey.getText());

		mastersthesis.setKeywords(tfkeywords.getText());
		return mastersthesis;
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Mastersthesis masterthesisToDel = createElement();
		int toDelInLoop = 0;
		for (Mastersthesis todel : ClassOfLists.listOfMastersthesis) {
			if (masterthesisToDel.myequals(todel)) {
				ClassOfLists.listOfMastersthesis.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}
		System.out.println("przed refresh");
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
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Mastersthesis, String>("Keywords"));

		refresh();
	}

}
