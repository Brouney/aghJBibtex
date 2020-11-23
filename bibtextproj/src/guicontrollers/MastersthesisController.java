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
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		for(Mastersthesis toAdd: ClassOfLists.listOfMastersthesis) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();  
	      
	    em.close();  
	    emf.close(); 
	    
	    ClassOfLists.listOfMastersthesis.clear();
		refresh();
		Main.mainController.changeLabelCountMastersthesis(Integer.toString((ClassOfLists.listOfMastersthesis.size())));
	}

	@FXML
	void addElementToList(ActionEvent event) {

		System.out.println("przed try");
		try {
			Mastersthesis mastersthesisToAdd = new Mastersthesis();

			System.out.println("po try");

			mastersthesisToAdd.setAuthor(tfAuthor.getText());
			mastersthesisToAdd.setAddress(tfAddress.getText());
			mastersthesisToAdd.setTitle(tfTitle.getText());
			mastersthesisToAdd.setYear(tfYear.getText());
			mastersthesisToAdd.setMonth(tfMonth.getText());
			mastersthesisToAdd.setNote(tfNote.getText());
			mastersthesisToAdd.setKey(tfKey.getText());
			mastersthesisToAdd.setSchool(tfSchool.getText());
			mastersthesisToAdd.setType(tfType.getText());
			mastersthesisToAdd.setBibkey(tfBibKey.getText());

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

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Mastersthesis masterthesisToDel = new Mastersthesis();
		masterthesisToDel.setAuthor(tfAuthor.getText());
		masterthesisToDel.setAddress(tfAddress.getText());
		masterthesisToDel.setTitle(tfTitle.getText());
		masterthesisToDel.setYear(tfYear.getText());
		masterthesisToDel.setSchool(tfSchool.getText());
		masterthesisToDel.setMonth(tfMonth.getText());
		masterthesisToDel.setNote(tfNote.getText());
		masterthesisToDel.setKey(tfKey.getText());
		masterthesisToDel.setType(tfType.getText());
		masterthesisToDel.setBibkey(tfBibKey.getText());

		System.out.println("przed forem");
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

	}

}
