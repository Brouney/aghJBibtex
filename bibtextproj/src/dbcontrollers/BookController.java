package dbcontrollers;

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
	void addAllToDB(ActionEvent event) throws TokenMgrException, ParseException {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		for(Book toAdd: ClassOfLists.listOfBooks) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();  
	      
	    em.close();  
	    emf.close(); 
	    
	    
	    ClassOfLists.listOfBooks.clear();
		refresh();
		Main.mainController.changeLabelCountBook(Integer.toString((ClassOfLists.listOfBooks.size())));
	    
	}

	@FXML
	void addElementToList(ActionEvent event) {

		System.out.println("przed try");
		try {
			Book bookToAdd = new Book();

			System.out.println("po try");

			bookToAdd.setAuthor(tfAuthor.getText());
			bookToAdd.setAddress(tfAddress.getText());
			bookToAdd.setEditor(tfEditor.getText());
			bookToAdd.setTitle(tfTitle.getText());
			bookToAdd.setYear(tfYear.getText());
			bookToAdd.setPublisher(tfPublisher.getText());

			bookToAdd.setVolume(tfVolume.getText());
			bookToAdd.setNumber(tfNumber.getText());
			bookToAdd.setSeries(tfSeries.getText());
			bookToAdd.setEdition(tfEdition.getText());
			bookToAdd.setMonth(tfMonth.getText());
			bookToAdd.setNote(tfNote.getText());
			bookToAdd.setKey(tfKey.getText());
			bookToAdd.setUrl(tfUrl.getText());
			bookToAdd.setBibkey(tfBibKey.getText());
			System.out.println("przed add");

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

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Book bookToDelete = new Book();
		bookToDelete.setAuthor(tfAuthor.getText());
		bookToDelete.setAddress(tfAddress.getText());
		bookToDelete.setEditor(tfEditor.getText());
		bookToDelete.setTitle(tfTitle.getText());
		bookToDelete.setYear(tfYear.getText());
		bookToDelete.setPublisher(tfPublisher.getText());

		bookToDelete.setVolume(tfVolume.getText());
		bookToDelete.setNumber(tfNumber.getText());
		bookToDelete.setSeries(tfSeries.getText());
		bookToDelete.setEdition(tfEdition.getText());
		bookToDelete.setMonth(tfMonth.getText());
		bookToDelete.setNote(tfNote.getText());
		bookToDelete.setKey(tfKey.getText());
		bookToDelete.setUrl(tfUrl.getText());
		bookToDelete.setBibkey(tfBibKey.getText());
		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Book book : ClassOfLists.listOfBooks) {
			if (bookToDelete.equals(book)) {
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
		refresh();
	}

	void refresh() {

		ObservableList<Book> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfBooks);

		tvBooks.setItems(tableViewList);
	}

}