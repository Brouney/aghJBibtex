package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entities.Book;
import entities.Booklet;
import entities.Booklet;
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

public class BookletController implements Initializable {
	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfHowpublished;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfYear;

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
	private TableView<Booklet> tvBooklet;

    @FXML
    private TableColumn<Booklet, String> tcBibKey;
	
	@FXML
	private TableColumn<Booklet, String> tcTitle;

	@FXML
	private TableColumn<Booklet, String> tcAuthor;

	@FXML
	private TableColumn<Booklet, String> tcHowpublished;

	@FXML
	private TableColumn<Booklet, String> tcAddress;

	@FXML
	private TableColumn<Booklet, String> tcYear;

	@FXML
	private TableColumn<Booklet, String> tcMonth;

	@FXML
	private TableColumn<Booklet, String> tcNote;

	@FXML
	private TableColumn<Booklet, String> tcKey;

	@FXML
	void addAllToDB(ActionEvent event) {

	}

	@FXML
	void addElementToList(ActionEvent event) {
		Booklet bookletToAdd = new Booklet();

		System.out.println("po try");

		bookletToAdd.setAuthor(tfAuthor.getText());
		bookletToAdd.setTitle(tfTitle.getText());
		bookletToAdd.setYear(tfYear.getText());
		bookletToAdd.setMonth(tfMonth.getText());
		bookletToAdd.setNote(tfNote.getText());
		bookletToAdd.setKey(tfKey.getText());
		bookletToAdd.setAddress(tfAddress.getText());
		bookletToAdd.setHowpublished(tfHowpublished.getText());
		bookletToAdd.setBibkey(tfBibKey.getText());
		ClassOfLists.listOfBooklet.add(bookletToAdd);
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfBooklet.size())));
	}

	void refresh() {
		ObservableList<Booklet> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfBooklet);

		tvBooklet.setItems(tableViewList);
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
		tfHowpublished.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfBooklet.size())));
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfBooklet.clear();
		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfBooklet.size())));

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Booklet bookletToDel = new Booklet();

		System.out.println("po try");

		bookletToDel.setAuthor(tfAuthor.getText());
		bookletToDel.setTitle(tfTitle.getText());
		bookletToDel.setYear(tfYear.getText());
		bookletToDel.setMonth(tfMonth.getText());
		bookletToDel.setNote(tfNote.getText());
		bookletToDel.setKey(tfKey.getText());
		bookletToDel.setAddress(tfAddress.getText());
		bookletToDel.setHowpublished(tfHowpublished.getText());
		bookletToDel.setBibkey(tfBibKey.getText());
		int toDelInLoop = 0;
		for (Booklet art : ClassOfLists.listOfBooklet) {
			if (bookletToDel.myequals(art)) {
				ClassOfLists.listOfBooklet.remove(toDelInLoop);
				break;
			}
			toDelInLoop+=1;
		}

		refresh();
		Main.mainController.changeLabelCountIncollection(Integer.toString((ClassOfLists.listOfBooklet.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Author"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Key"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Address"));
		tcHowpublished.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Howpublished"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Booklet, String>("Bibkey"));
	}
}
