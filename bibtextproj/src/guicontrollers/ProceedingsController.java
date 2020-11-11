package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Proceedings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProceedingsController implements Initializable {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfYear;

    @FXML
    private TextField tfPublisher;

    @FXML
    private TextField tfEditor;

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
    private TextField tfOrganization;

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
    private TableView<Proceedings> tvProceedings;

    @FXML
    private TableColumn<Proceedings, String> tcAuthor;

    @FXML
    private TableColumn<Proceedings, String> tcEditor;

    @FXML
    private TableColumn<Proceedings, String> tcTitle;

    @FXML
    private TableColumn<Proceedings, String> tcYear;

    @FXML
    private TableColumn<Proceedings, String> tcPublisher;

    @FXML
    private TableColumn<Proceedings, String> tcVolume;

    @FXML
    private TableColumn<Proceedings, String> tcNumber;

    @FXML
    private TableColumn<Proceedings, String> tcSeries;

    @FXML
    private TableColumn<Proceedings, String> tcAddress;

    @FXML
    private TableColumn<Proceedings, String> tcEdition;

    @FXML
    private TableColumn<Proceedings, String> tcMonth;

    @FXML
    private TableColumn<Proceedings, String> tcNote;

    @FXML
    private TableColumn<Proceedings, String> tcKey;

    @FXML
    private TableColumn<Proceedings, String> tcUrl;

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
