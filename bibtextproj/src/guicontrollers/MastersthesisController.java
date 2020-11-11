package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Mastersthesis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MastersthesisController implements Initializable{

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
    private TableView<Mastersthesis> tvMasterthesis;

    @FXML
    private TableColumn<Mastersthesis, String> tcAuthor;

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

    }

    @FXML
    void addElementToList(ActionEvent event) {

    }

    @FXML
    void cleanText(ActionEvent event) {

    }

    @FXML
    void deleteAllFromList(ActionEvent event) {

    }

    @FXML
    void deleteElementFromList(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
