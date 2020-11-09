package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Conference;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConferenceController implements Initializable{
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
    private TextField tfOrhanization;

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
    private TableView<Conference> tvConference;

    @FXML
    private TableColumn<Conference, String> tcAuthor;

    @FXML
    private TableColumn<Conference, String> tcBooktitle;

    @FXML
    private TableColumn<Conference, String> tcTitle;

    @FXML
    private TableColumn<Conference, String> tcYear;

    @FXML
    private TableColumn<Conference, String> tcPublisher;

    @FXML
    private TableColumn<Conference, String> tcPages;

    @FXML
    private TableColumn<Conference, String> tcVolume;

    @FXML
    private TableColumn<Conference, String> tcNumber;

    @FXML
    private TableColumn<Conference, String> tcSeries;

    @FXML
    private TableColumn<Conference, String> tcAddress;

    @FXML
    private TableColumn<Conference, String> tcOrganization;

    @FXML
    private TableColumn<Conference, String> tcMonth;

    @FXML
    private TableColumn<Conference, String> tcNote;

    @FXML
    private TableColumn<Conference, String> tcKey;

    @FXML
    private TableColumn<Conference, String> tcEditor;

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
