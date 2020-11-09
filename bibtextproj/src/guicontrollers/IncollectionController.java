package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Incollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class IncollectionController implements Initializable{

    @FXML
    private Label tfType;

    @FXML
    private Label tfEditor;

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
    private TextField tfChapter;

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
    private TextField tfPages;

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
    private TableView<Incollection> tvIncollection;

    @FXML
    private TableColumn<Incollection,String> tcAuthor;

    @FXML
    private TableColumn<Incollection,String> tcTitle;

    @FXML
    private TableColumn<Incollection,String> tcYear;

    @FXML
    private TableColumn<Incollection,String> tcPublisher;

    @FXML
    private TableColumn<Incollection,String> tcEditor;

    @FXML
    private TableColumn<Incollection,String> tcVolume;

    @FXML
    private TableColumn<Incollection,String> tcNumber;

    @FXML
    private TableColumn<Incollection,String> tcSeries;

    @FXML
    private TableColumn<Incollection,String> tcAddress;

    @FXML
    private TableColumn<Incollection,String> tcEdition;

    @FXML
    private TableColumn<Incollection,String> tcMonth;

    @FXML
    private TableColumn<Incollection,String> tcNote;

    @FXML
    private TableColumn<Incollection,String> tcKey;

    @FXML
    private TableColumn<Incollection,String> tcPages;

    @FXML
    private TableColumn<Incollection,String> tcType;

    @FXML
    private TableColumn<Incollection,String> tcChapter;

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
