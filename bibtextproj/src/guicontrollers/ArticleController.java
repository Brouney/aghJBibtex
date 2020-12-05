package guicontrollers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Main;
import entities.Article;
import entities.Book;
import gui.MyAlertClass;
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
	private TableColumn<Article, String> tcKeywords;

	@FXML
	private Button addfromtablebt;

	MyAlertClass myAlertClass;

	private void validate() {

		if (tfAuthor.getText().isEmpty() || tfJournal.getText().isEmpty() || tfTitle.getText().isEmpty()
				|| tfYear.getText().isEmpty()) {
			myAlertClass.objectErrorAlert();

		}

	}

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

	@FXML
	void addAllToDB(ActionEvent event) {

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();
		em.getTransaction().begin();

		for (Article toAdd : ClassOfLists.listOfArticles) {
			em.persist(toAdd);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
		ClassOfLists.listOfArticles.clear();
		refresh();
		Main.mainController.changeLabelCountArticle(Integer.toString((ClassOfLists.listOfArticles.size())));
		myAlertClass.addedToDB();
	}

	@FXML
	void addElementToList(ActionEvent event) {
		Article articleToAdd = createElement();

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

	private Article createElement() {
		validate();
		Article article = new Article();

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
		return article;

	}

	@FXML
	void deleteElementFromList(ActionEvent event) {
		Article articleToDel = createElement();
		int toDelInLoop = 0;
		System.out.println("przed forem");
		for (Article art : ClassOfLists.listOfArticles) {
			if (articleToDel.equals(art)) {
				ClassOfLists.listOfArticles.remove(toDelInLoop);
				break;
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
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Article, String>("Keywords"));
		myAlertClass = new MyAlertClass();
		refresh();
	}
}
