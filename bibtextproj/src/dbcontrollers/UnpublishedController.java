package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
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
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Unpublished toAdd : ClassOfLists.listOfUnpublished) {
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
		Unpublished unpublishedToAdd = new Unpublished();

		unpublishedToAdd.setAuthor(tfAuthor.getText());
		unpublishedToAdd.setTitle(tfTitle.getText());
		unpublishedToAdd.setYear(tfYear.getText());
		unpublishedToAdd.setMonth(tfMonth.getText());
		unpublishedToAdd.setNote(tfNote.getText());
		unpublishedToAdd.setKey(tfKey.getText());
		unpublishedToAdd.setBibkey(tfBibKey.getText());

		System.out.println("przed add");

		ClassOfLists.listOfUnpublished.add(unpublishedToAdd);

		refresh();
		Main.mainController.changeLabelCountUnpublished(Integer.toString((ClassOfLists.listOfUnpublished.size())));

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

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Unpublished unpublishedToDel = new Unpublished();

		unpublishedToDel.setAuthor(tfAuthor.getText());
		unpublishedToDel.setTitle(tfTitle.getText());
		unpublishedToDel.setYear(tfYear.getText());
		unpublishedToDel.setMonth(tfMonth.getText());
		unpublishedToDel.setNote(tfNote.getText());
		unpublishedToDel.setKey(tfKey.getText());
		unpublishedToDel.setBibkey(tfBibKey.getText());

		int toDelInLoop = 0;
		for (Unpublished todel : ClassOfLists.listOfUnpublished) {
			if (unpublishedToDel.myequals(todel)) {
				ClassOfLists.listOfUnpublished.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}
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
