package dbcontrollers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
import entities.Proceedings;
import entities.Techreport;
import entities.Techreport;
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

public class TechreportController implements Initializable {

	@FXML
	private TextField tfAuthor;

	@FXML
	private TextField tfTitle;

	@FXML
	private TextField tfYear;

	@FXML
	private TextField tfInstitution;

	@FXML
	private TextField tfType;

	@FXML
	private TextField tfAddress;

	@FXML
	private TextField tfMonth;

	@FXML
	private TextField tfNote;

	@FXML
	private TextField tfKey;

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
	private Button deleteallfromlistid;

	@FXML
	private Button addfromtablebt;

	@FXML
	private TextField tfBibKey;

	@FXML
	private TextField tfkeywords;

	@FXML
	private TableView<Techreport> tvTechreport;

	@FXML
	private TableColumn<Techreport, String> tcAuthor;

	@FXML
	private TableColumn<Techreport, String> tcBibKey;

	@FXML
	private TableColumn<Techreport, String> tcTitle;

	@FXML
	private TableColumn<Techreport, String> tcYear;

	@FXML
	private TableColumn<Techreport, String> tcInstitution;

	@FXML
	private TableColumn<Techreport, String> tcType;

	@FXML
	private TableColumn<Techreport, String> tcAddress;

	@FXML
	private TableColumn<Techreport, String> tcMonth;

	@FXML
	private TableColumn<Techreport, String> tcNote;

	@FXML
	private TableColumn<Techreport, String> tcKey;

	@FXML
	private TableColumn<Techreport, String> tcKeywords;

	@FXML
	void addFromTable(ActionEvent event) {
		Techreport fromtable = tvTechreport.getSelectionModel().getSelectedItem();
		tfAuthor.setText(fromtable.getAuthor());
		tfAddress.setText(fromtable.getAddress());
		tfTitle.setText(fromtable.getTitle());
		tfYear.setText(fromtable.getYear());
		tfMonth.setText(fromtable.getMonth());
		tfNote.setText(fromtable.getNote());
		tfKey.setText(fromtable.getKey());
		tfType.setText(fromtable.getType());
		tfInstitution.setText(fromtable.getInstitution());
		tfBibKey.setText(fromtable.getBibkey());
		tfkeywords.setText(fromtable.getKeywords());
	}

	@FXML
	void searchdbfunc(ActionEvent event) {

		Techreport tofind = new Techreport();
		editelement(tofind);

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			List<Techreport> Techreportitems = em.createQuery(tofind.generateQuery()).getResultList();
			dbcontrollers.ClassOfLists.listOfTechreport = new ArrayList<Techreport>(Techreportitems);
			Main.mainController
					.changeLabelCountTechreport(Integer.toString(dbcontrollers.ClassOfLists.listOfTechreport.size()));
			refresh();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	void addElementToFile(ActionEvent event) {
		Techreport tofile = new Techreport();
		editelement(tofile);
		System.out.println(tofile);

		try {
			FileWriter fw = new FileWriter(guicontrollers.MainPageController.fileToExport.getAbsolutePath(), true);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(tofile.toString());
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void deleteAllFromDB(ActionEvent event) {

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		em.getTransaction().begin();

		for (Techreport fromdbobj : ClassOfLists.listOfTechreport) {

			Techreport infunc = em.find(Techreport.class, fromdbobj.getID());

			em.remove(infunc);
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfTechreport.clear();
		refresh();
		Main.mainController.changeLabelCountTechreport(Integer.toString((ClassOfLists.listOfTechreport.size())));

	}

	@FXML
	void deleteElementFromDB(ActionEvent event) {
		Techreport fromtable = tvTechreport.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Techreport fromdbobj = em.find(Techreport.class, id);

		em.getTransaction().begin();
		em.remove(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

		ClassOfLists.listOfTechreport.remove(tvTechreport.getSelectionModel().getSelectedItem());
		refresh();
		Main.mainController.changeLabelCountTechreport(Integer.toString((ClassOfLists.listOfTechreport.size())));

	}

	private void editelement(Techreport tech) {

		tech.setAuthor(tfAuthor.getText());
		tech.setAddress(tfAddress.getText());
		tech.setTitle(tfTitle.getText());
		tech.setYear(tfYear.getText());
		tech.setMonth(tfMonth.getText());
		tech.setNote(tfNote.getText());
		tech.setKey(tfKey.getText());
		tech.setInstitution(tfInstitution.getText());
		tech.setType(tfType.getText());
		tech.setBibkey(tfBibKey.getText());
		tech.setKeywords(tfkeywords.getText());

	}

	@FXML
	void editElementInDB(ActionEvent event) {
		Techreport fromtable = tvTechreport.getSelectionModel().getSelectedItem();

		Long id = fromtable.getID();

		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("bibtextproj");
		EntityManager em = null;
		em = emf.createEntityManager();

		Techreport fromdbobj = em.find(Techreport.class, id);
		editelement(fromdbobj);
		em.getTransaction().begin();
		em.merge(fromdbobj);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	void refresh() {

		ObservableList<Techreport> tableViewList = FXCollections.observableArrayList(ClassOfLists.listOfTechreport);

		tvTechreport.setItems(tableViewList);
	}

	@FXML
	void cleanText(ActionEvent event) {
		tfAuthor.setText("");
		tfAddress.setText("");
		tfTitle.setText("");
		tfYear.setText("");
		tfMonth.setText("");
		tfNote.setText("");
		tfKey.setText("");
		tfType.setText("");
		tfInstitution.setText("");
		tfBibKey.setText("");
		tfkeywords.setText("");

	}

	@FXML
	void deleteAllFromList(ActionEvent event) {
		ClassOfLists.listOfTechreport.clear();
		refresh();
		Main.mainController.changeLabelCountTechreport(Integer.toString((ClassOfLists.listOfTechreport.size())));

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Author"));
		tcType.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Type"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Title"));
		tcYear.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Year"));
		tcMonth.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Month"));
		tcNote.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Note"));
		tcKey.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Key"));
		tcAddress.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Address"));
		tcInstitution.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Institution"));
		tcBibKey.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Bibkey"));
		tcKeywords.setCellValueFactory(new PropertyValueFactory<Techreport, String>("Keywords"));
		refresh();

	}

}
