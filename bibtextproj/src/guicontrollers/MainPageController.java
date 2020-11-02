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

public class MainPageController implements Initializable{

    @FXML
    private Button Bookbt;

    @FXML
    private BorderPane mainBorderPane;
    
    @FXML
    private Label bookCount;
    
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
	
	public void changeLabelCount(String count) {
		bookCount.setText(count);
	}

}

