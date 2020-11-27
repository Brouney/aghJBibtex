package dbcontrollers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Article;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ArticleController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfVolume;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfJournal;

	@FXML
	private TextField tfNumber;

	@FXML
	private TextField tfPages;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

	@FXML
	private TextField tfDoi;

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
	private TextField tfBibKey;
	
	@FXML
	private TextField tfkeywords;

	@FXML
	private TableView<Article> tvArticles;
	@FXML
	private TableColumn<Article, String> tcBibKey;
	@FXML
	private TableColumn<Article, String> tcAuthor;

	@FXML
	private TableColumn<Article, String> tcVolume;

	@FXML
	private TableColumn<Article, String> tcTitle;

	@FXML
	private TableColumn<Article, String> tcYear;

	@FXML
	private TableColumn<Article, String> tcJournal;

	@FXML
	private TableColumn<Article, String> tcNumber;

	@FXML
	private TableColumn<Article, String> tcPages;

	@FXML
	private TableColumn<Article, String> tcMonth;

	@FXML
	private TableColumn<Article, String> tcNote;

	@FXML
	private TableColumn<Article, String> tcKey;

	@FXML
	private TableColumn<Article, String> tcDoi;

	@FXML
	void addAllToDB(ActionEvent event) {

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		for(Article toAdd: ClassOfLists.listOfArticles) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();  
	      
	    em.close();  
	    emf.close();  
		
	}

	@FXML
	void addElementToList(ActionEvent event) {
		Article articleToAdd = new Article();

		System.out.println("po try");

		articleToAdd.setAuthor(tfAuthor.getText());
		articleToAdd.setJournal(tfJournal.getText());
		articleToAdd.setTitle(tfTitle.getText());
		articleToAdd.setYear(tfYear.getText());
		articleToAdd.setVolume(tfVolume.getText());

		articleToAdd.setPages(tfPages.getText());
		articleToAdd.setNumber(tfNumber.getText());
		articleToAdd.setMonth(tfMonth.getText());
		articleToAdd.setNote(tfNote.getText());
		articleToAdd.setKey(tfKey.getText());
		articleToAdd.setDoi(tfDoi.getText());
		articleToAdd.setBibkey(tfBibKey.getText());
		
		
		ClassOfLists.listOfArticles.add(articleToAdd);
		refresh();
		Main.mainController.changeLabelCountArticle(Integer.toString((ClassOfLists.listOfArticles.size())));
	}

	void refresh() {
		ObservableList<Article> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfArticles);

		tvArticles.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfJournal.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfVolume.setText("");

		tfPages.setText("");
		tfNumber.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfDoi.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");
	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfArticles.clear();
		refresh();
		Main.mainController.changeLabelCountArticle(Integer.toString((ClassOfLists.listOfArticles.size())));
	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Article articleToDel = new Article();

		articleToDel.setAuthor(tfAuthor.getText());
		articleToDel.setJournal(tfJournal.getText());
		articleToDel.setTitle(tfTitle.getText());
		articleToDel.setYear(tfYear.getText());
		articleToDel.setVolume(tfVolume.getText());

		articleToDel.setPages(tfPages.getText());
		articleToDel.setNumber(tfNumber.getText());
		articleToDel.setMonth(tfMonth.getText());
		articleToDel.setNote(tfNote.getText());
		articleToDel.setKey(tfKey.getText());
		articleToDel.setDoi(tfDoi.getText());
		articleToDel.setBibkey(tfBibKey.getText());
		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Article art : ClassOfLists.listOfArticles) {
			if (articleToDel.equals(art)) {
				ClassOfLists.listOfArticles.remove(toDelInLoop);
			}
			toDelInLoop += 1;
		}
		System.out.println("przed refresh");
		refresh();
		Main.mainController.changeLabelCountArticle(Integer.toString((ClassOfLists.listOfArticles.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Article, String>("Author"));
		tcJournal.setCellValueFactory(new PropertyValueFactory<Article, String>("Journal"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Article, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Article, String>("Year"));
		tcPages.setCellValueFactory(new PropertyValueFactory<Article, String>("Pages"));
		tcVolume.setCellValueFactory(new PropertyValueFactory<Article, String>("Volume"));
		tcNumber.setCellValueFactory(new PropertyValueFactory<Article, String>("Number"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Article, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Article, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Article, String>("Key"));
		tcDoi.setCellValueFactory(new PropertyValueFactory<Article, String>("Doi"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Article, String>("Bibkey"));
		refresh();
	}
}
