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
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		for(Manual toAdd: ClassOfLists.listOfManual) {
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
		Manual ManualToAdd = new Manual();

		System.out.println("po try");

		ManualToAdd.setAuthor(tfAuthor.getText());
		ManualToAdd.setTitle(tfTitle.getText());
		ManualToAdd.setYear(tfYear.getText());
		ManualToAdd.setMonth(tfMonth.getText());
		ManualToAdd.setNote(tfNote.getText());
		ManualToAdd.setKey(tfKey.getText());
		ManualToAdd.setAddress(tfAddress.getText());
		ManualToAdd.setOrganization(tfOrganization.getText());
		ManualToAdd.setEdition(tfEdition.getText());
		ManualToAdd.setBibkey(tfBibKey.getText());
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

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Manual manualToDel = new Manual();

		manualToDel.setAuthor(tfAuthor.getText());
		manualToDel.setTitle(tfTitle.getText());
		manualToDel.setYear(tfYear.getText());
		manualToDel.setMonth(tfMonth.getText());
		manualToDel.setNote(tfNote.getText());
		manualToDel.setKey(tfKey.getText());
		manualToDel.setAddress(tfAddress.getText());
		manualToDel.setEdition(tfEdition.getText());
		manualToDel.setOrganization(tfOrganization.getText());
		manualToDel.setBibkey(tfBibKey.getText());

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

	}

}
