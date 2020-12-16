package guicontrollers;

import application.Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jbibtex.ParseException;
import org.jbibtex.TokenMgrException;

import entities.Article;
import entities.Book;
import entities.EntryTypes;
import gui.MyAlertClass;
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

public class BookController implements Initializable {

	public static List<EntryTypes> mainListOfTypes = new ArrayList<EntryTypes>();

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
	private TableView<Book> tvBooks;

	@FXML
	private TableColumn<Book, String> tcBibKey;

	@FXML
	private TableColumn<Book, String> tcAuthor;

	@FXML
	private TableColumn<Book, String> tcEditor;

	@FXML
	private TableColumn<Book, String> tcTitle;

	@FXML
	private TableColumn<Book, String> tcYear;

	@FXML
	private TableColumn<Book, String> tcPublisher;

	@FXML
	private TableColumn<Book, String> tcVolume;

	@FXML
	private TableColumn<Book, String> tcNumber;

	@FXML
	private TableColumn<Book, String> tcSeries;

	@FXML
	private TableColumn<Book, String> tcAddress;

	@FXML
	private TableColumn<Book, String> tcEdition;

	@FXML
	private TableColumn<Book, String> tcMonth;

	@FXML
	private TableColumn<Book, String> tcNote;

	@FXML
	private TableColumn<Book, String> tcKey;

	@FXML
	private TableColumn<Book, String> tcUrl;

	@FXML
	private TableColumn<Book, String> tcKeywords;

	@FXML
	private Button addfromtablebt;
	MyAlertClass myAlertClass;

	@FXML
	void addFromTable(ActionEvent event) {
		Book fromtable = tvBooks.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfAddress.setText(fromtable.getAddress());
		tfEditor.setText(fromtable.getEditor());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfPublisher.setText(fromtable.getPublisher());

		tfVolume.setText(fromtable.getVolume());
		tfNumber.setText(fromtable.getNumber());
		tfSeries.setText(fromtable.getSeries());
		tfEdition.setText(fromtable.getEdition());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfUrl.setText(fromtable.getUrl());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	@FXML
	void addAllToDB(ActionEvent event) throws TokenMgrException, ParseException {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Book toAdd : ClassOfLists.listOfBooks) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfBooks.clear();
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfBooks.size())));

		myAlertClass.addedToDB();
	}

	@FXML
	void addElementToList(ActionEvent event) {

		System.out.println("przed try");
		try {
			Book bookToAdd = createElement();
			ClassOfLists.listOfBooks.add(bookToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfBooks.size())));

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
		ClassOfLists.listOfBooks.clear();
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfBooks.size())));
	}

	private void validate() {

		if (tfAuthor.getText() == null)
			tfAuthor.setText("");
		if (tfAddress.getText() == null)
			tfAddress.setText("");
		if (tfEditor.getText() == null)
			tfEditor.setText("");
		if (tfTitle.getText() == null)
			tfTitle.setText("");
		if (tfYear.getText() == null)
			tfYear.setText("");
		if (tfPublisher.getText() == null)
			tfPublisher.setText("");

		if (tfVolume.getText() == null)
			tfVolume.setText("");
		if (tfNumber.getText() == null)
			tfNumber.setText("");
		if (tfSeries.getText() == null)
			tfSeries.setText("");
		if (tfEdition.getText() == null)
			tfEdition.setText("");
		if (tfMonth.getText() == null)
			tfMonth.setText("");
		if (tfNote.getText() == null)
			tfNote.setText("");
		if (tfKey.getText() == null)
			tfKey.setText("");
		if (tfUrl.getText() == null)
			tfUrl.setText("");
		if (tfBibKey.getText() == null)
			tfBibKey.setText("");
		if (tfkeywords.getText() == null)
			tfkeywords.setText("");

		boolean badValidation = false;
		if (tfTitle.getText().isEmpty() || tfYear.getText().isEmpty() || tfPublisher.getText().isEmpty()) {
			badValidation = true;

		}
		if (tfAuthor.getText().isEmpty() && tfEditor.getText().isEmpty()) {
			badValidation = true;
		}
		if (!tfAuthor.getText().isEmpty() && !tfEditor.getText().isEmpty()) {
			badValidation = true;
		}
		if (badValidation) {
			myAlertClass.objectErrorAlert();

		}

	}

	private Book createElement() {
		validate();
		Book book = new Book();
		book.setAuthor(tfAuthor.getText());
		book.setAddress(tfAddress.getText());
		book.setEditor(tfEditor.getText());
		book.setTitle(tfTitle.getText());
		book.setYear(tfYear.getText());
		book.setPublisher(tfPublisher.getText());

		book.setVolume(tfVolume.getText());
		book.setNumber(tfNumber.getText());
		book.setSeries(tfSeries.getText());
		book.setEdition(tfEdition.getText());
		book.setMonth(tfMonth.getText());
		book.setNote(tfNote.getText());
		book.setKey(tfKey.getText());
		book.setUrl(tfUrl.getText());
		book.setBibkey(tfBibKey.getText());
		book.setKeywords(tfkeywords.getText());
		return book;

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Book bookToDelete = createElement();

		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Book book : ClassOfLists.listOfBooks) {
			if (bookToDelete.myequals(book)) {
				ClassOfLists.listOfBooks.remove(toDelInLoop);
				break;
			}
			toDelInLoop += 1;
		}
		System.out.println("przed refresh");
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfBooks.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Book, String>("Address"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Book, String>("Editor"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Book, String>("Year"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Book, String>("Publisher"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Book, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Book, String>("Number"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Book, String>("Series"));
		tcEdition.setCellValueFactory(new PropertyValueFactory<Book, String>("Edition"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Book, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Book, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Book, String>("Key"));
		tcUrl.setCellValueFactory(new PropertyValueFactory<Book, String>("Url"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Book, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Book, String>("Keywords"));
		myAlertClass = new MyAlertClass();
		refresh();
	}

	void refresh() {

		ObservableList<Book> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfBooks);

		tvBooks.setItems(tableViewList);
	}

}
