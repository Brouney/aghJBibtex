package dbcontrollers;

import java.util.ArrayList;
import java.util.List;

import entities.Article;
import entities.Book;
import entities.Booklet;
import entities.Conference;
import entities.Inbook;
import entities.Incollection;
import entities.*;
public class ClassOfLists {

	public static List<Article> listOfArticles;
	public static List<Book> listOfBooks;
	public static List<Booklet> listOfBooklet;
	public static List<Conference> listOfConference;
	public static List<Inbook> listOfInbook;
	public static List<Incollection> listOfIncollection;
	
	public static List<Inproceedings> listOfInproceedings;
	public static List<Manual> listOfManual = new ArrayList<Manual>();
	public static List<Mastersthesis> listOfMastersthesis;
	public static List<Misc> listOfMisc = new ArrayList<Misc>();
	public static List<Phdthesis> listOfPhdthesis;
	public static List<Proceedings> listOfProceedings;
	public static List<Techreport> listOfTechreport;
	public static List<Unpublished> listOfUnpublished ;
}
