package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Misc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MiscController  implements Initializable{

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
    private TableView<Misc> tvMisc;

    @FXML
    private TableColumn<Misc, String> tcAuthor;

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
