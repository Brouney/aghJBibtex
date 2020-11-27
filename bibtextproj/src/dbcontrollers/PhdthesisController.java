package dbcontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Misc;
import entities.Phdthesis;
import entities.Phdthesis;
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

public class PhdthesisController implements Initializable {

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
	private TableView<Phdthesis> tvPhdthesis;

	@FXML
	private TableColumn<Phdthesis, String> tcAuthor;

    @FXML
    private TableColumn<Phdthesis, String> tcBibKey;
    
	@FXML
	private TableColumn<Phdthesis, String> tcTitle;

	@FXML
	private TableColumn<Phdthesis, String> tcYear;

	@FXML
	private TableColumn<Phdthesis, String> tcSchool;

	@FXML
	private TableColumn<Phdthesis, String> tcType;

	@FXML
	private TableColumn<Phdthesis, String> tcAddress;

	@FXML
	private TableColumn<Phdthesis, String> tcMonth;

	@FXML
	private TableColumn<Phdthesis, String> tcNote;

	@FXML
	private TableColumn<Phdthesis, String> tcKey;

	@FXML
	void addAllToDB(ActionEvent event) {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		for(Phdthesis toAdd: ClassOfLists.listOfPhdthesis) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();  
	      
	    em.close();  
	    emf.close(); 
	    
	    
	    ClassOfLists.listOfPhdthesis.clear();
		refresh();
		Main.mainController.changeLabelCountPhdthesis(Integer.toString((ClassOfLists.listOfPhdthesis.size())));
	}

	@FXML
	void addElementToList(ActionEvent event) {
		System.out.println("przed try");
		try {
			Phdthesis phdthesisToAdd = new Phdthesis();

			System.out.println("po try");

			phdthesisToAdd.setAuthor(tfAuthor.getText());
			phdthesisToAdd.setAddress(tfAddress.getText());
			phdthesisToAdd.setTitle(tfTitle.getText());
			phdthesisToAdd.setYear(tfYear.getText());
			phdthesisToAdd.setMonth(tfMonth.getText());
			phdthesisToAdd.setNote(tfNote.getText());
			phdthesisToAdd.setKey(tfKey.getText());
			phdthesisToAdd.setSchool(tfSchool.getText());
			phdthesisToAdd.setType(tfType.getText());
			phdthesisToAdd.setBibkey(tfBibKey.getText());

			System.out.println("przed add");

			ClassOfLists.listOfPhdthesis.add(phdthesisToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("przed refresh");
		refresh();
		System.out.println("przed zmiana label");
		Main.mainController.changeLabelCountPhdthesis(Integer.toString((ClassOfLists.listOfPhdthesis.size())));

	}

	void refresh() {

		ObservableList<Phdthesis> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfPhdthesis);

		tvPhdthesis.setItems(tableViewList);
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
		ClassOfLists.listOfPhdthesis.clear();
		refresh();
		Main.mainController.changeLabelCountPhdthesis(Integer.toString((ClassOfLists.listOfPhdthesis.size())));

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Phdthesis phdthesisToDel = new Phdthesis();
		phdthesisToDel.setAuthor(tfAuthor.getText());
		phdthesisToDel.setAddress(tfAddress.getText());
		phdthesisToDel.setTitle(tfTitle.getText());
		phdthesisToDel.setYear(tfYear.getText());
		phdthesisToDel.setSchool(tfSchool.getText());
		phdthesisToDel.setMonth(tfMonth.getText());
		phdthesisToDel.setNote(tfNote.getText());
		phdthesisToDel.setKey(tfKey.getText());
		phdthesisToDel.setType(tfType.getText());
		phdthesisToDel.setBibkey(tfBibKey.getText());

		System.out.println("przed forem");
		int toDelInLoop = 0;
		for (Phdthesis todel : ClassOfLists.listOfPhdthesis) {
			if (phdthesisToDel.myequals(todel)) {
				ClassOfLists.listOfPhdthesis.remove(toDelInLoop);
				System.out.println("usunieto");
				break;

			}
			toDelInLoop += 1;
		}
		System.out.println("przed refresh");
		refresh();
		Main.mainController.changeLabelCountPhdthesis(Integer.toString((ClassOfLists.listOfPhdthesis.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Author"));
		tcType.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Type"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Key"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Address"));
		tcSchool.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("School"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Phdthesis, String>("Bibkey"));
		refresh();
	}

}
