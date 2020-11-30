package guicontrollers;

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
	private TableColumn<Techreport, String> tcKeywords;


	@FXML
	private Button addfromtablebt;
	

	@FXML
	void addFromTable(ActionEvent event) {
		Techreport fromtable = tvTechreport.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfAddress.setText(fromtable.getAddress());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfType.setText(fromtable.getType());
		tfInstitution.setText(fromtable.getInstitution());
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
	void addElementToList(ActionEvent event) {
		System.out.println("przed try");
		try {
			Techreport techreportToAdd = createElement();

			ClassOfLists.listOfTechreport.add(techreportToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		refresh();
		
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

	private Techreport createElement() {

		Techreport techreport = new Techreport();

		techreport.setAuthor(tfAuthor.getText());
		techreport.setAddress(tfAddress.getText());
		techreport.setTitle(tfTitle.getText());
		techreport.setYear(tfYear.getText());
		techreport.setMonth(tfMonth.getText());
		techreport.setNote(tfNote.getText());
		techreport.setKey(tfKey.getText());
		techreport.setInstitution(tfInstitution.getText());
		techreport.setType(tfType.getText());
		techreport.setBibkey(tfBibKey.getText());

		techreport.setKeywords(tfkeywords.getText());
		return techreport;
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Techreport techreportToDel = createElement();

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
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Keywords"));
		refresh();

	}

}
