package dbcontrollers;

import application.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Book;
import entities.EntryTypes;
import entities.Inbook;
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

public class InbookController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfEditor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfPublisher;

	@FXML
	private TextField tfVolume;

	@FXML
	private TextField tfNumber;

	@FXML
	private TextField tfSeries;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfEdition;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfUrl;

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
	private TableView<Inbook> tvInbook;

	@FXML
	private TableColumn<Inbook, String> tcBibKey;

	@FXML
	private TableColumn<Inbook, String> tcAuthor;

	@FXML
	private TableColumn<Inbook, String> tcEditor;

	@FXML
	private TableColumn<Inbook, String> tcTitle;

	@FXML
	private TableColumn<Inbook, String> tcYear;

	@FXML
	private TableColumn<Inbook, String> tcPublisher;

	@FXML
	private TableColumn<Inbook, String> tcVolume;

	@FXML
	private TableColumn<Inbook, String> tcNumber;

	@FXML
	private TableColumn<Inbook, String> tcSeries;

	@FXML
	private TableColumn<Inbook, String> tcAddress;

	@FXML
	private TableColumn<Inbook, String> tcEdition;

	@FXML
	private TableColumn<Inbook, String> tcMonth;

	@FXML
	private TableColumn<Inbook, String> tcNote;

	@FXML
	private TableColumn<Inbook, String> tcKey;

	@FXML
	private TableColumn<Inbook, String> tcUrl;

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Inbook toAdd : ClassOfLists.listOfInbook) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfInbook.clear();
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfInbook.size())));
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
			Inbook inbookToAdd = new Inbook();

			System.out.println("po try");

			inbookToAdd.setAuthor(tfAuthor.getText());
			inbookToAdd.setAddress(tfAddress.getText());
			inbookToAdd.setEditor(tfEditor.getText());
			inbookToAdd.setTitle(tfTitle.getText());
			inbookToAdd.setYear(tfYear.getText());
			inbookToAdd.setPublisher(tfPublisher.getText());

			inbookToAdd.setVolume(tfVolume.getText());
			inbookToAdd.setNumber(tfNumber.getText());
			inbookToAdd.setSeries(tfSeries.getText());
			inbookToAdd.setEdition(tfEdition.getText());
			inbookToAdd.setMonth(tfMonth.getText());
			inbookToAdd.setNote(tfNote.getText());
			inbookToAdd.setKey(tfKey.getText());
			inbookToAdd.setUrl(tfUrl.getText());
			inbookToAdd.setBibkey(tfBibKey.getText());
			System.out.println("przed add");

			ClassOfLists.listOfInbook.add(inbookToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfInbook.size())));

	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfAddress.setText("");
		tfEditor.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfPublisher.setText("");

		tfVolume.setText("");
		tfNumber.setText("");
		tfSeries.setText("");
		tfEdition.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfUrl.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfInbook.clear();
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfInbook.size())));
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Inbook inbookToDelete = new Inbook();
		inbookToDelete.setAuthor(tfAuthor.getText());
		inbookToDelete.setAddress(tfAddress.getText());
		inbookToDelete.setEditor(tfEditor.getText());
		inbookToDelete.setTitle(tfTitle.getText());
		inbookToDelete.setYear(tfYear.getText());
		inbookToDelete.setPublisher(tfPublisher.getText());

		inbookToDelete.setVolume(tfVolume.getText());
		inbookToDelete.setNumber(tfNumber.getText());
		inbookToDelete.setSeries(tfSeries.getText());
		inbookToDelete.setEdition(tfEdition.getText());
		inbookToDelete.setMonth(tfMonth.getText());
		inbookToDelete.setNote(tfNote.getText());
		inbookToDelete.setKey(tfKey.getText());
		inbookToDelete.setUrl(tfUrl.getText());
		inbookToDelete.setBibkey(tfBibKey.getText());
		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Inbook book : ClassOfLists.listOfInbook) {
			if (inbookToDelete.equals(book)) {
				ClassOfLists.listOfInbook.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}
		System.out.println("przed refresh");
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfInbook.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Author"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Address"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Editor"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Year"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Publisher"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Number"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Series"));
		tcEdition.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Edition"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Key"));
		tcUrl.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Url"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Inbook, String>("Bibkey"));
		refresh();
	}

	void refresh() {

		ObservableList<Inbook> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfInbook);

		tvInbook.setItems(tableViewList);
	}

}
