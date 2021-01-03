package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Techreport;
import entities.Unpublished;
import gui.MyAlertClass;
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
	private TableColumn<Unpublished, String> tcKeywords;

	@FXML
	private Button addfromtablebt;

	MyAlertClass myAlertClass = new MyAlertClass();

	private void validate() {
		if (tfAuthor.getText() == null)
			tfAuthor.setText("");
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
		if (tfBibKey.getText() == null)
			tfBibKey.setText("");
		if (tfkeywords.getText() == null)
			tfkeywords.setText("");

		if (tfAuthor.getText().isEmpty() || tfTitle.getText().isEmpty() || tfNote.getText().isEmpty()) {

			myAlertClass.objectErrorAlert();

		}

	}

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

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		

		for (Unpublished toAdd : ClassOfLists.listOfUnpublished) {
			try {
				em.getTransaction().begin();
				em.persist(toAdd);
				em.getTransaction().commit();
				}catch(Exception e) { System.out.println(e.getMessage());}
		}
		

		em.close();
		emf.close();

		ClassOfLists.listOfUnpublished.clear();
		refresh();
		Main.mainController.changeLabelCountUnpublished(Integer.toString((ClassOfLists.listOfUnpublished.size())));
		myAlertClass.addedToDB();
	}

	@FXML
	void addElementToList(ActionEvent event) {
		Unpublished unpublishedToAdd = createElement();

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

	private Unpublished createElement() {
		validate();
		Unpublished unpublished = new Unpublished();

		unpublished.setAuthor(tfAuthor.getText());
		unpublished.setTitle(tfTitle.getText());
		unpublished.setYear(tfYear.getText());
		unpublished.setMonth(tfMonth.getText());
		unpublished.setNote(tfNote.getText());
		unpublished.setKey(tfKey.getText());
		unpublished.setBibkey(tfBibKey.getText());
		unpublished.setKeywords(tfkeywords.getText());

		return unpublished;
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Unpublished unpublishedToDel = createElement();

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
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Unpublished, String>("Keywords"));
		refresh();
	}

}
