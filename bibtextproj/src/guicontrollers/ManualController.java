package guicontrollers;

import entities.Manual;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManualController {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfAuthor;

    @FXML
    private TextField tfYear;

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
    private TextField tfEdition;

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
    private TableView<Manual> tvManual;

    @FXML
    private TableColumn<Manual, String> tcTitle;

    @FXML
    private TableColumn<Manual, String> tcYear;

    @FXML
    private TableColumn<Manual, String> tcAuthor;

    @FXML
    private TableColumn<Manual, String> tcAddress;

    @FXML
    private TableColumn<Manual, String> tcOrganization;

    @FXML
    private TableColumn<Manual, String> tcMonth;

    @FXML
    private TableColumn<Manual, String> tcNote;

    @FXML
    private TableColumn<Manual, String> tcKey;

    @FXML
    private TableColumn<Manual, String> tcEdition;

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

}
