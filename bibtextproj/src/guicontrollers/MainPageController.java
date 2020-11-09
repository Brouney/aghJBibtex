package guicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import gui.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainPageController implements Initializable {

	@FXML
	private Button Bookbt;

	@FXML
	private BorderPane mainBorderPane;

	@FXML
	private Label bookCount;

	@FXML
	private Button Articlebt;

	@FXML
	private Button Bookletbt;

	@FXML
	private Button Conferencebt;

	@FXML
	private Button Inbookbt;

	@FXML
	private Button Incollectionbt;

	@FXML
	private Button Inproceedingsbt;

	@FXML
	private Button Manualbt;

	@FXML
	private Button Mastersthesisbt;

	@FXML
	private Button Miscbt;

	@FXML
	private Button Phdthesisbt;

	@FXML
	private Button Proceedingsbt;

	@FXML
	private Button Techreportbt;

	@FXML
	private Button Unpublishedbt;

	@FXML
	private Label articleCount;

	@FXML
	private Label bookletCount;

	@FXML
	private Label conferenceCount;

	@FXML
	private Label inbookCount;

	@FXML
	private Label incollectionCount;

	@FXML
	private Label inproceedingsCount;

	@FXML
	private Label manualCount;

	@FXML
	private Label mastersthesisCount;

	@FXML
	private Label miscCount;

	@FXML
	private Label phdthesisCount;

	@FXML
	private Label proceedingsCount;

	@FXML
	private Label techreportCount;

	@FXML
	private Label unpublishedCount;

	@FXML
	void showArticle(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Article");
    	mainBorderPane.setCenter(view);
	}

	@FXML
	void showBooklet(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Booklet");
    	mainBorderPane.setCenter(view);
	}
	
	@FXML
	void showConference(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Conference");
    	mainBorderPane.setCenter(view);
	}

	@FXML
	void showInbook(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Inbook");
    	mainBorderPane.setCenter(view);
	}

	@FXML
	void showIncollection(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Incollection");
    	mainBorderPane.setCenter(view);
	}

	@FXML
	void showInproceedings(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Inproceedings");
    	mainBorderPane.setCenter(view);
	}

	@FXML
	void showManual(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Manual");
    	mainBorderPane.setCenter(view);
	}

	@FXML
	void showMastersthesis(ActionEvent event) {

	}

	@FXML
	void showMisc(ActionEvent event) {

	}

	@FXML
	void showPhdthesis(ActionEvent event) {

	}

	@FXML
	void showProceedings(ActionEvent event) {

	}

	@FXML
	void showTechreport(ActionEvent event) {

	}

	@FXML
	void showUnpublished(ActionEvent event) {

	}

	public void changeLabelCountBook(String count) {
		bookCount.setText(count);
	}
	
	public void changeLabelCountArticle(String count) {
		articleCount.setText(count);
	}
	
	@FXML
    void showBook(ActionEvent event) {
    	FxmlLoader loader = new FxmlLoader();
    	Pane view = loader.getPage("Book");
    	mainBorderPane.setCenter(view);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
