package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Phdthesis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PhdthesisController implements Initializable{

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
    private TableView<Phdthesis> tvPhdthesis;

    @FXML
    private TableColumn<Phdthesis, String> tcAuthor;

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
