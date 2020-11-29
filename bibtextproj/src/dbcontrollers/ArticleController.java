package dbcontrollers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	private TextField tfBibKey;

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
	private TextField tfkeywords;

	@FXML
	private Button cleantextid;

	@FXML
	private Button editElementInDBbt;

	@FXML
	private Button deleteelementfromDBbt;

	@FXML
	private Button addalltodbid;

	@FXML
	private Button searchbt;

	@FXML
	private Button deleteallfromdbid;

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
	private Button addfromtablebt;

	@FXML
	void addFromTable(ActionEvent event) {

		Article fromtable = tvArticles.getSelectionModel().getSelectedItem();

		tfAuthor.setText(fromtable.getAuthor());
		tfJournal.setText(fromtable.getJournal());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfVolume.setText(fromtable.getVolume());

		tfPages.setText(fromtable.getPages());
		tfNumber.setText(fromtable.getNumber());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfDoi.setText(fromtable.getDoi());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());

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
	void searchdbfunc(ActionEvent event) {

		
		
	}

	@FXML
	void addElementToFile(ActionEvent event) {
		
		
		
	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Article fromdbobj : ClassOfLists.listOfArticles) {
			
			Article infunc = em.find(Article.class, fromdbobj.getID());
			
			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfArticles.clear();
		refresh();
		Main.mainController.changeLabelCountArticle(Integer.toString((ClassOfLists.listOfArticles.size())));

	}



	private void editelement(Article article) {
		article.setAuthor(tfAuthor.getText());
		article.setJournal(tfJournal.getText());
		article.setTitle(tfTitle.getText());
		article.setYear(tfYear.getText());
		article.setVolume(tfVolume.getText());

		article.setPages(tfPages.getText());
		article.setNumber(tfNumber.getText());
		article.setMonth(tfMonth.getText());
		article.setNote(tfNote.getText());
		article.setKey(tfKey.getText());
		article.setDoi(tfDoi.getText());
		article.setBibkey(tfBibKey.getText());
		article.setKeywords(tfkeywords.getText());
	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Article fromtable = tvArticles.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Article fromdbobj = em.find(Article.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfArticles.remove(tvArticles.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountArticle(Integer.toString((ClassOfLists.listOfArticles.size())));
	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Article fromtable = tvArticles.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Article fromdbobj = em.find(Article.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();
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
