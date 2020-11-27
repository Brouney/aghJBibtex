package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Inbook;
import entities.Inproceedings;
import entities.Inproceedings;
import entities.Inproceedings;
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

public class InproceedingsController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfBooktitle;

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
	private TextField tfPages;

	@FXML
	private TextField tfOrganization;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfEditor;

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
	private TableView<Inproceedings> tvInproceedings;

	@FXML
	private TableColumn<Inproceedings, String> tcBibKey;
	
	
	@FXML
	private TableColumn<Inproceedings, String> tcAuthor;

	@FXML
	private TableColumn<Inproceedings, String> tcBooktitle;

	@FXML
	private TableColumn<Inproceedings, String> tcTitle;

	@FXML
	private TableColumn<Inproceedings, String> tcYear;

	@FXML
	private TableColumn<Inproceedings, String> tcPublisher;

	@FXML
	private TableColumn<Inproceedings, String> tcPages;

	@FXML
	private TableColumn<Inproceedings, String> tcVolume;

	@FXML
	private TableColumn<Inproceedings, String> tcNumber;

	@FXML
	private TableColumn<Inproceedings, String> tcSeries;

	@FXML
	private TableColumn<Inproceedings, String> tcAddress;

	@FXML
	private TableColumn<Inproceedings, String> tcOrganization;

	@FXML
	private TableColumn<Inproceedings, String> tcMonth;

	@FXML
	private TableColumn<Inproceedings, String> tcNote;

	@FXML
	private TableColumn<Inproceedings, String> tcKey;

	@FXML
	private TableColumn<Inproceedings, String> tcEditor;

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		for(Inproceedings toAdd: ClassOfLists.listOfInproceedings) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();  
	      
	    em.close();  
	    emf.close(); 
	    
		ClassOfLists.listOfInproceedings.clear();
		refresh();
		Main.mainController.changeLabelCountInproceedings(Integer.toString((ClassOfLists.listOfInproceedings.size())));
	}

	@FXML
	void addElementToList(ActionEvent event) {
		System.out.println("przed try");
		try {
			Inproceedings inproceedingsToAdd = new Inproceedings();

			System.out.println("po try");

			inproceedingsToAdd.setAuthor(tfAuthor.getText());
			inproceedingsToAdd.setAddress(tfAddress.getText());
			inproceedingsToAdd.setEditor(tfEditor.getText());
			inproceedingsToAdd.setTitle(tfTitle.getText());
			inproceedingsToAdd.setYear(tfYear.getText());
			inproceedingsToAdd.setPublisher(tfPublisher.getText());

			inproceedingsToAdd.setVolume(tfVolume.getText());
			inproceedingsToAdd.setNumber(tfNumber.getText());
			inproceedingsToAdd.setSeries(tfSeries.getText());
			inproceedingsToAdd.setOrganization(tfOrganization.getText());
			inproceedingsToAdd.setMonth(tfMonth.getText());
			inproceedingsToAdd.setNote(tfNote.getText());
			inproceedingsToAdd.setKey(tfKey.getText());
			inproceedingsToAdd.setBooktitle(tfBooktitle.getText());
			inproceedingsToAdd.setPages(tfPages.getText());
			inproceedingsToAdd.setBibkey(tfBibKey.getText());
			System.out.println("przed add");

			ClassOfLists.listOfInproceedings.add(inproceedingsToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountInproceedings(Integer.toString((ClassOfLists.listOfInproceedings.size())));
	}

	void refresh() {

		ObservableList<Inproceedings> tableViewList = FXCollections
				.observableArrayList(ClassOfLists.listOfInproceedings);

		tvInproceedings.setItems(tableViewList);
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
		tfOrganization.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfPages.setText("");
		tfBooktitle.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfInproceedings.clear();
		refresh();
		Main.mainController.changeLabelCountInproceedings(Integer.toString((ClassOfLists.listOfInproceedings.size())));

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Inproceedings inproceedingsToDel = new Inproceedings();
		inproceedingsToDel.setAuthor(tfAuthor.getText());
		inproceedingsToDel.setAddress(tfAddress.getText());
		inproceedingsToDel.setEditor(tfEditor.getText());
		inproceedingsToDel.setTitle(tfTitle.getText());
		inproceedingsToDel.setYear(tfYear.getText());
		inproceedingsToDel.setPublisher(tfPublisher.getText());

		inproceedingsToDel.setVolume(tfVolume.getText());
		inproceedingsToDel.setNumber(tfNumber.getText());
		inproceedingsToDel.setSeries(tfSeries.getText());
		inproceedingsToDel.setPages(tfPages.getText());
		inproceedingsToDel.setMonth(tfMonth.getText());
		inproceedingsToDel.setNote(tfNote.getText());
		inproceedingsToDel.setKey(tfKey.getText());
		inproceedingsToDel.setOrganization(tfOrganization.getText());
		inproceedingsToDel.setBooktitle(tfBooktitle.getText());
		inproceedingsToDel.setBibkey(tfBibKey.getText());

		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Inproceedings todel : ClassOfLists.listOfInproceedings) {
			if (todel.myequals(inproceedingsToDel)) {
				ClassOfLists.listOfInproceedings.remove(toDelInLoop);
				System.out.println("udalo sie usunac");
				break;
			}
			toDelInLoop += 1;
		}

		refresh();
		Main.mainController.changeLabelCountInproceedings(Integer.toString((ClassOfLists.listOfInproceedings.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Author"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Address"));
		tcEditor.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Editor"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Year"));
		tcPublisher.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Publisher"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Number"));
		tcSeries.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Series"));
		tcPages.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Pages"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Key"));
		tcOrganization.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Organization"));
		tcBooktitle.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Booktitle"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Inproceedings, String>("Bibkey"));
		refresh();
	}

}
