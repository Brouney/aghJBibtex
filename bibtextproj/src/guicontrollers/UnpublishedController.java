package guicontrollers;

import entities.Unpublished;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UnpublishedController {

    @FXML
    private TextField tfAuthor;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfNote;

    @FXML
    private TextField tfYear;

    @FXML
    private TextField tfMonth;

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
    private TableView<Unpublished> tvUnpublished;

    @FXML
    private TableColumn<Unpublished,String> tcAuthor;

    @FXML
    private TableColumn<Unpublished,String> tcTitle;

    @FXML
    private TableColumn<Unpublished,String> tcNote;

    @FXML
    private TableColumn<Unpublished,String> tcYear;

    @FXML
    private TableColumn<Unpublished,String> tcMonth;

    @FXML
    private TableColumn<Unpublished,String> tcKey;

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
