package gui;

import java.net.URL;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

	

public class FxmlLoader {
	private Pane view;
	
	public Pane getPage(String nameOfFxmlFile) {
		
		try {
			URL fxmlLocation = Main.class.getResource("/gui/"+nameOfFxmlFile+".fxml");
			
			if(fxmlLocation == null) {
				throw new java.io.FileNotFoundException("FXML file can't be found");
			}
			
			view = new FXMLLoader().load(fxmlLocation);
			
		}catch(Exception e) {
			System.out.println("There is no page: "+nameOfFxmlFile);
		}
		
		return view;
	}
	
}
