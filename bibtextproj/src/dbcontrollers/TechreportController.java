package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Proceedings;
import entities.Techreport;
import entities.Techreport;
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

public class TechreportController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfInstitution;

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
	private TextField tfBibKey;

	@FXML
	private TextField tfkeywords;

	@FXML
	private TableView<Techreport> tvTechreport;

	@FXML
	private TableColumn<Techreport, String> tcAuthor;

	@FXML
	private TableColumn<Techreport, String> tcBibKey;

	@FXML
	private TableColumn<Techreport, String> tcTitle;

	@FXML
	private TableColumn<Techreport, String> tcYear;

	@FXML
	private TableColumn<Techreport, String> tcInstitution;

	@FXML
	private TableColumn<Techreport, String> tcType;

	@FXML
	private TableColumn<Techreport, String> tcAddress;

	@FXML
	private TableColumn<Techreport, String> tcMonth;

	@FXML
	private TableColumn<Techreport, String> tcNote;

	@FXML
	private TableColumn<Techreport, String> tcKey;

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Techreport toAdd : ClassOfLists.listOfTechreport) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfTechreport.clear();
		refresh();
		Main.mainController.changeLabelCountTechreport(Integer.toString((ClassOfLists.listOfTechreport.size())));
	}

	@FXML
	void addElementToFile(ActionEvent event) {

	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {

	}

	@FXML
	void editElementInDB(ActionEvent event) {

	}

	@FXML
	void searchdbfunc(ActionEvent event) {

	}

	@FXML
	void addElementToList(ActionEvent event) {
		System.out.println("przed try");
		try {
			Techreport techreportToAdd = new Techreport();

			System.out.println("po try");

			techreportToAdd.setAuthor(tfAuthor.getText());
			techreportToAdd.setAddress(tfAddress.getText());
			techreportToAdd.setTitle(tfTitle.getText());
			techreportToAdd.setYear(tfYear.getText());
			techreportToAdd.setMonth(tfMonth.getText());
			techreportToAdd.setNote(tfNote.getText());
			techreportToAdd.setKey(tfKey.getText());
			techreportToAdd.setInstitution(tfInstitution.getText());
			techreportToAdd.setType(tfType.getText());
			techreportToAdd.setBibkey(tfBibKey.getText());

			System.out.println("przed add");

			ClassOfLists.listOfTechreport.add(techreportToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountTechreport(Integer.toString((ClassOfLists.listOfTechreport.size())));

	}

	void refresh() {

		ObservableList<Techreport> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfTechreport);

		tvTechreport.setItems(tableViewList);
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
		tfInstitution.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");

	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfTechreport.clear();
		refresh();
		Main.mainController.changeLabelCountTechreport(Integer.toString((ClassOfLists.listOfTechreport.size())));

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Techreport techreportToDel = new Techreport();

		System.out.println("po try");

		techreportToDel.setAuthor(tfAuthor.getText());
		techreportToDel.setAddress(tfAddress.getText());
		techreportToDel.setTitle(tfTitle.getText());
		techreportToDel.setYear(tfYear.getText());
		techreportToDel.setMonth(tfMonth.getText());
		techreportToDel.setNote(tfNote.getText());
		techreportToDel.setKey(tfKey.getText());
		techreportToDel.setInstitution(tfInstitution.getText());
		techreportToDel.setType(tfType.getText());
		techreportToDel.setBibkey(tfBibKey.getText());

		int toDelInLoop = 0;
		for (Techreport todel : ClassOfLists.listOfTechreport) {
			if (techreportToDel.myequals(todel)) {
				ClassOfLists.listOfTechreport.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}
		refresh();
		Main.mainController.changeLabelCountTechreport(Integer.toString((ClassOfLists.listOfTechreport.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Author"));
		tcType.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Type"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Key"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Address"));
		tcInstitution.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Institution"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Bibkey"));
		refresh();

	}

}
