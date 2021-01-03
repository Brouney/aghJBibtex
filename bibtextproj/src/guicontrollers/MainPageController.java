package guicontrollers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXObject;
import org.jbibtex.BibTeXParser;
import org.jbibtex.Key;
import org.jbibtex.ParseException;
import org.jbibtex.StringValue;
import org.jbibtex.TokenMgrException;
import org.jbibtex.Value;

import entities.Article;
import entities.*;
import gui.FxmlLoader;
import gui.MyAlertClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
	private Button Loadfilebt;

	@FXML
	private Button downloadDBbt;

	@FXML
	private Button Changebt;

	@FXML
	private Button exportbt;

	public static File fileToExport;

	@FXML
	void chooseFileToExport(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Files");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIB files (*.bib)", "*.bib");
		fileChooser.getExtensionFilters().add(extFilter);

		Stage stage = (Stage) mainBorderPane.getScene().getWindow();

		fileToExport = fileChooser.showOpenDialog(stage);

		if (fileToExport == null) {
			new MyAlertClass().openExportFileErrorAlert();

		}
		System.out.println(fileToExport.getAbsolutePath());
	}

	@FXML
	void downloadDB(ActionEvent event) {

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			List<Article> artitems = em.createQuery("select f from fields f where bibitem = 'Article' ")
					.getResultList();

			for (Article art : artitems) {
				System.out.println(art.getAuthor());
			}

			dbcontrollers.ClassOfLists.listOfArticles = new ArrayList<Article>(artitems);
			changeLabelCountArticle(Integer.toString(dbcontrollers.ClassOfLists.listOfArticles.size()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Book> bookitems = em.createQuery("select f from fields f where bibitem = 'Book' ").getResultList();

			for (Book book : bookitems) {
				System.out.println(book.getAuthor());
			}

			dbcontrollers.ClassOfLists.listOfBooks = new ArrayList<Book>(bookitems);
			changeLabelCountBook(Integer.toString(dbcontrollers.ClassOfLists.listOfBooks.size()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Booklet> bookletitems = em.createQuery("select f from fields f where bibitem = 'Booklet' ")
					.getResultList();

			dbcontrollers.ClassOfLists.listOfBooklet = new ArrayList<Booklet>(bookletitems);
			changeLabelCountBooklet(Integer.toString(dbcontrollers.ClassOfLists.listOfBooklet.size()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Conference> Conferencetitems = em.createQuery("select f from fields f where bibitem = 'Conference' ")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfConference = new ArrayList<Conference>(Conferencetitems);
			changeLabelCountConference(Integer.toString(dbcontrollers.ClassOfLists.listOfConference.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Inbook> Inbookitems = em.createQuery("select f from fields f where bibitem = 'Inbook' ")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfInbook = new ArrayList<Inbook>(Inbookitems);
			changeLabelCountInbook(Integer.toString(dbcontrollers.ClassOfLists.listOfInbook.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Incollection> Incollectionitems = em
					.createQuery("select f from fields f where bibitem = 'Incollection' ").getResultList();
			dbcontrollers.ClassOfLists.listOfIncollection = new ArrayList<Incollection>(Incollectionitems);
			changeLabelCountIncollection(Integer.toString(dbcontrollers.ClassOfLists.listOfIncollection.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Inproceedings> Inproceedingsitems = em
					.createQuery("select f from fields f where bibitem = 'Inproceedings' ").getResultList();
			dbcontrollers.ClassOfLists.listOfInproceedings = new ArrayList<Inproceedings>(Inproceedingsitems);
			changeLabelCountInproceedings(Integer.toString(dbcontrollers.ClassOfLists.listOfInproceedings.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Manual> Manualitems = em.createQuery("select f from fields f where bibitem = 'Manual' ")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfManual = new ArrayList<Manual>(Manualitems);
			changeLabelCountManual(Integer.toString(dbcontrollers.ClassOfLists.listOfManual.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Mastersthesis> Mastersthesisitems = em
					.createQuery("select f from fields f where bibitem = 'Mastersthesis' ").getResultList();
			dbcontrollers.ClassOfLists.listOfMastersthesis = new ArrayList<Mastersthesis>(Mastersthesisitems);
			changeLabelCountMastersthesis(Integer.toString(dbcontrollers.ClassOfLists.listOfMastersthesis.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Misc> Miscitems = em.createQuery("select f from fields f where bibitem = 'Misc' ").getResultList();
			dbcontrollers.ClassOfLists.listOfMisc = new ArrayList<Misc>(Miscitems);
			changeLabelCountMisc(Integer.toString(dbcontrollers.ClassOfLists.listOfMisc.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Phdthesis> Phdthesisitems = em.createQuery("select f from fields f where bibitem = 'Phdthesis' ")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfPhdthesis = new ArrayList<Phdthesis>(Phdthesisitems);
			changeLabelCountPhdthesis(Integer.toString(dbcontrollers.ClassOfLists.listOfPhdthesis.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Proceedings> Proceedingsitems = em.createQuery("select f from fields f where bibitem = 'Proceedings' ")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfProceedings = new ArrayList<Proceedings>(Proceedingsitems);
			changeLabelCountProceedings(Integer.toString(dbcontrollers.ClassOfLists.listOfProceedings.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Techreport> Techreportitems = em.createQuery("select f from fields f where bibitem = 'Techreport' ")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfTechreport = new ArrayList<Techreport>(Techreportitems);
			changeLabelCountTechreport(Integer.toString(dbcontrollers.ClassOfLists.listOfTechreport.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			List<Unpublished> Unpublisheditems = em.createQuery("select f from fields f where bibitem = 'Unpublished' ")
					.getResultList();
			dbcontrollers.ClassOfLists.listOfUnpublished = new ArrayList<Unpublished>(Unpublisheditems);
			changeLabelCountUnpublished(Integer.toString(dbcontrollers.ClassOfLists.listOfUnpublished.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		em.close();
		emf.close();

	}

	public static boolean changeboolean = true;

	@FXML
	void changeAppFunctions(ActionEvent event) {
		changeboolean = changeboolean ? false : true;

		if (changeboolean) {
			downloadDBbt.setDisable(true);
			Loadfilebt.setDisable(false);
			
			
			changeLabelCountArticle(Integer.toString(ClassOfLists.listOfArticles.size()));
			
			changeLabelCountBook(Integer.toString(ClassOfLists.listOfBooks.size()));
			
			changeLabelCountBooklet(Integer.toString(ClassOfLists.listOfBooklet.size()));
			
			changeLabelCountConference(Integer.toString(ClassOfLists.listOfConference.size()));
			
			changeLabelCountInbook(Integer.toString(ClassOfLists.listOfInbook.size()));
		
			changeLabelCountIncollection(Integer.toString(ClassOfLists.listOfIncollection.size()));
			
			changeLabelCountInproceedings(Integer.toString(ClassOfLists.listOfInproceedings.size()));
			
			changeLabelCountManual(Integer.toString(ClassOfLists.listOfManual.size()));
			
			changeLabelCountMastersthesis(Integer.toString(ClassOfLists.listOfMastersthesis.size()));
			
			changeLabelCountMisc(Integer.toString(ClassOfLists.listOfMisc.size()));
			
			changeLabelCountPhdthesis(Integer.toString(ClassOfLists.listOfPhdthesis.size()));
		
			changeLabelCountProceedings(Integer.toString(ClassOfLists.listOfProceedings.size()));
			
			changeLabelCountTechreport(Integer.toString(ClassOfLists.listOfTechreport.size()));
		
			changeLabelCountUnpublished(Integer.toString(ClassOfLists.listOfUnpublished.size()));
			
			
			

		} else {
			Loadfilebt.setDisable(true);
			downloadDBbt.setDisable(false);
		}

	}

	@FXML
	void loadFileMethod(ActionEvent event) throws Exception {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Files");
		Stage stage = (Stage) mainBorderPane.getScene().getWindow();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BIB files (*.bib)", "*.bib");
		fileChooser.getExtensionFilters().add(extFilter);
		List<File> fileList = fileChooser.showOpenMultipleDialog(stage);
		boolean enable = true;
		if (fileList == null) {
			new MyAlertClass().openImportFileErrorAlert();
			
			enable = false;

		}

		// File input = new
		// File("C:\\Users\\Piotrkonto\\Desktop\\INZYNIER\\aghJBibtex\\bibtextproj\\src\\test\\file.bib");

		if (enable)
			for (File input : fileList) {
				try {
					BibTeXDatabase database = parseBibTeX(input);

					List<BibTeXObject> obj = database.getObjects();
					Map<Key, BibTeXEntry> entries = database.getEntries();
					Collection<BibTeXEntry> values = entries.values();
					int i = 0;
					int proceed = 0;
					int book = 0;
					int articlee = 0;
					for (BibTeXEntry entry : values) {

						// System.out.println(entry.getType());
						String toswitch = entry.getType().toString();// System.out.println(i++ + toswitch);
						switch (toswitch) {
						case "article":
						case "Article":
							ClassOfLists.listOfArticles.add(new Article(entry));
							changeLabelCountArticle(Integer.toString(ClassOfLists.listOfArticles.size()));
							articlee++;
							break;
						case "book":
						case "Book":
							book++;
							ClassOfLists.listOfBooks.add(new Book(entry));
							changeLabelCountBook(Integer.toString(ClassOfLists.listOfBooks.size()));
							break;
						case "booklet":
						case "Booklet":
							ClassOfLists.listOfBooklet.add(new Booklet(entry));
							changeLabelCountBooklet(Integer.toString(ClassOfLists.listOfBooklet.size()));
							break;
						case "conference":
						case "Conference":
							ClassOfLists.listOfConference.add(new Conference(entry));
							changeLabelCountConference(Integer.toString(ClassOfLists.listOfConference.size()));
							break;
						case "inbook":
						case "Inbook":
							ClassOfLists.listOfInbook.add(new Inbook(entry));
							changeLabelCountInbook(Integer.toString(ClassOfLists.listOfInbook.size()));
							break;
						case "incollection":
						case "Incollection":
							ClassOfLists.listOfIncollection.add(new Incollection(entry));
							changeLabelCountIncollection(Integer.toString(ClassOfLists.listOfIncollection.size()));
							break;
						case "inproceedings":
						case "InProceedings":
							ClassOfLists.listOfInproceedings.add(new Inproceedings(entry));
							changeLabelCountInproceedings(Integer.toString(ClassOfLists.listOfInproceedings.size()));
							break;
						case "manual":
						case "Manual":
							ClassOfLists.listOfManual.add(new Manual(entry));
							changeLabelCountManual(Integer.toString(ClassOfLists.listOfManual.size()));
							break;
						case "mastersthesis":
						case "MastersThesis":
							ClassOfLists.listOfMastersthesis.add(new Mastersthesis(entry));
							changeLabelCountMastersthesis(Integer.toString(ClassOfLists.listOfMastersthesis.size()));
							break;
						case "misc":
						case "Misc":
							ClassOfLists.listOfMisc.add(new Misc(entry));
							changeLabelCountMisc(Integer.toString(ClassOfLists.listOfMisc.size()));
							break;
						case "phdthesis":
						case "PhdThesis":
							ClassOfLists.listOfPhdthesis.add(new Phdthesis(entry));
							changeLabelCountPhdthesis(Integer.toString(ClassOfLists.listOfPhdthesis.size()));
							break;
						case "proceedings":
						case "Proceedings":
							proceed++;
							ClassOfLists.listOfProceedings.add(new Proceedings(entry));
							changeLabelCountProceedings(Integer.toString(ClassOfLists.listOfProceedings.size()));
							break;
						case "techreport":
						case "TechReport":
							ClassOfLists.listOfTechreport.add(new Techreport(entry));
							changeLabelCountTechreport(Integer.toString(ClassOfLists.listOfTechreport.size()));
							break;

						case "unpublished":
						case "Unpublished":
							ClassOfLists.listOfUnpublished.add(new Unpublished(entry));
							changeLabelCountUnpublished(Integer.toString(ClassOfLists.listOfUnpublished.size()));
							break;

						}

						/*
						 * 
						 * Value str = entry.getField(entry.KEY_ADDRESS); StringValue strval =
						 * (StringValue) str; if(strval!= null) System.out.println(str.toUserString());
						 * 
						 * 
						 * //klucze identyfikatory Key str2 = entry.getKey();
						 * System.out.println(str2.getValue());//kl
						 * 
						 */

					}
					// System.out.println("book: "+book+"\nproceedings: "+proceed+"\narticle:
					// "+articlee);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}

	static public BibTeXDatabase parseBibTeX(File file) throws IOException, ParseException {
		Reader reader = new FileReader(file);

		try {
			BibTeXParser parser = new BibTeXParser();

			return parser.parse(reader);
		} finally {
			reader.close();
		}
	}

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
		FxmlLoader loader = new FxmlLoader();
		Pane view = loader.getPage("Mastersthesis");
		mainBorderPane.setCenter(view);
	}

	@FXML
	void showMisc(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
		Pane view = loader.getPage("Misc");
		mainBorderPane.setCenter(view);
	}

	@FXML
	void showPhdthesis(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
		Pane view = loader.getPage("Phdthesis");
		mainBorderPane.setCenter(view);
	}

	@FXML
	void showProceedings(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
		Pane view = loader.getPage("Proceedings");
		mainBorderPane.setCenter(view);
	}

	@FXML
	void showTechreport(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
		Pane view = loader.getPage("Techreport");
		mainBorderPane.setCenter(view);
	}

	@FXML
	void showUnpublished(ActionEvent event) {
		FxmlLoader loader = new FxmlLoader();
		Pane view = loader.getPage("Unpublished");
		mainBorderPane.setCenter(view);
	}

	public void changeLabelCountBook(String count) {
		bookCount.setText(count);
	}

	public void changeLabelCountArticle(String count) {
		articleCount.setText(count);
	}

	public void changeLabelCountBooklet(String count) {
		bookletCount.setText(count);
	}

	public void changeLabelCountConference(String count) {
		conferenceCount.setText(count);
	}

	public void changeLabelCountInbook(String count) {
		inbookCount.setText(count);
	}

	public void changeLabelCountIncollection(String count) {
		incollectionCount.setText(count);
	}

	public void changeLabelCountInproceedings(String count) {
		inproceedingsCount.setText(count);
	}

	public void changeLabelCountManual(String count) {
		manualCount.setText(count);
	}

	public void changeLabelCountMastersthesis(String count) {
		mastersthesisCount.setText(count);
	}

	public void changeLabelCountMisc(String count) {
		miscCount.setText(count);
	}

	public void changeLabelCountPhdthesis(String count) {
		phdthesisCount.setText(count);
	}

	public void changeLabelCountProceedings(String count) {
		proceedingsCount.setText(count);
	}

	public void changeLabelCountTechreport(String count) {
		techreportCount.setText(count);
	}

	public void changeLabelCountUnpublished(String count) {
		unpublishedCount.setText(count);
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
		downloadDBbt.setDisable(true);
	}

	// metody ze strony

	static private BibTeXDatabase parse(BibTeXParser parser, String path) throws Exception {
		InputStream is = (MainPageController.class).getResourceAsStream(path);

		try {
			Reader reader = new InputStreamReader(is, "US-ASCII");

			try {
				return parser.parse(reader);
			} finally {
				reader.close();
			}
		} finally {
			is.close();
		}

	}

}
