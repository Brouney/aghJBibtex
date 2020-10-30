package gui;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SampleController implements Initializable{

    @FXML
    private Button Bookbt;

    @FXML
    private BorderPane mainBorderPane;
    
    
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

