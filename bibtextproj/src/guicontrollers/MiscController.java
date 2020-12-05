package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Book;
import entities.Mastersthesis;
import entities.Misc;
import gui.MyAlertClass;
import entities.Misc;
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

public class MiscController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfHowpublished;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfYear;

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
	private TableView<Misc> tvMisc;

	@FXML
	private TableColumn<Misc, String> tcAuthor;

	@FXML
	private TableColumn<Misc, String> tcBibKey;

	@FXML
	private TableColumn<Misc, String> tcTitle;

	@FXML
	private TableColumn<Misc, String> tcHowpublished;

	@FXML
	private TableColumn<Misc, String> tcMonth;

	@FXML
	private TableColumn<Misc, String> tcYear;

	@FXML
	private TableColumn<Misc, String> tcNote;

	@FXML
	private TableColumn<Misc, String> tcKey;

	@FXML
	private TableColumn<Misc, String> tcKeywords;

	@FXML
	private Button addfromtablebt;
	
	MyAlertClass myAlertClass = new MyAlertClass();
	
	@FXML
	void addFromTable(ActionEvent event) {
		Misc fromtable = tvMisc.getSelectionModel().getSelectedItem();

		tfAuthor.setText(fromtable.getAuthor());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfHowpublished.setText(fromtable.getHowpublished());
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

		for (Misc toAdd : ClassOfLists.listOfMisc) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfMisc.clear();
		refresh();
		Main.mainController.changeLabelCountMisc(Integer.toString((ClassOfLists.listOfMisc.size())));
		myAlertClass.addedToDB();
	}

	@FXML
	void addElementToList(ActionEvent event) {
		
		try {
			Misc miscToAdd = createElement();

			ClassOfLists.listOfMisc.add(miscToAdd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		refresh();
	
		Main.mainController.changeLabelCountMisc(Integer.toString((ClassOfLists.listOfMisc.size())));

	}

	void refresh() {

		ObservableList<Misc> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfMisc);

		tvMisc.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfHowpublished.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfMisc.clear();
		refresh();
		Main.mainController.changeLabelCountMisc(Integer.toString((ClassOfLists.listOfMisc.size())));

	}

	private Misc createElement() {

		Misc misc = new Misc();

		misc.setAuthor(tfAuthor.getText());
		misc.setTitle(tfTitle.getText());
		misc.setYear(tfYear.getText());
		misc.setMonth(tfMonth.getText());
		misc.setNote(tfNote.getText());
		misc.setKey(tfKey.getText());
		misc.setHowpublished(tfHowpublished.getText());
		misc.setBibkey(tfBibKey.getText());

		misc.setKeywords(tfkeywords.getText());
		
		
		return misc;
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Misc miscToDel = createElement();

		int toDelInLoop = 0;
		for (Misc todel : ClassOfLists.listOfMisc) {
			if (miscToDel.myequals(todel)) {
				ClassOfLists.listOfMisc.remove(toDelInLoop);
				System.out.println("usunieto");
				break;

			}
			toDelInLoop += 1;
		}

		refresh();
		Main.mainController.changeLabelCountMisc(Integer.toString((ClassOfLists.listOfMisc.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Misc, String>("Author"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Misc, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Misc, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Misc, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Misc, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Misc, String>("Key"));
		tcHowpublished.setCellValueFactory(new PropertyValueFactory<Misc, String>("Howpublished"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Misc, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Misc, String>("Keywords"));
		refresh();
	}

}
