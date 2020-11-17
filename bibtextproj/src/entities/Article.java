package entities;



import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.StringValue;
import org.jbibtex.Value;

@Entity
@DiscriminatorValue(value = "Article")
public class Article extends EntryTypes{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	
	
	// required
	@Column(name = "author")
	private String author;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "volume")
	private String volume;

	@Column(name = "journal")
	private String journal;

	// optional
	@Column(name = "number")
	private String number;
	
	@Column(name = "pages")
	private String pages;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "doi")
	private String doi;
	
	@Column(name = "note")
	private String note;

	@Column(name = "key")
	private String key;

	
	public Article(){}
	public Article(BibTeXEntry createFrom){
		Value val = createFrom.getField(createFrom.KEY_AUTHOR);
		StringValue strval = (StringValue) val;
		if(strval!= null) {
			this.author = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_JOURNAL);
		strval = (StringValue) val;
		if(strval!= null) {
			this.journal = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_TITLE);
		strval = (StringValue) val;
		if(strval!= null) {
			this.title = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_YEAR);
		strval = (StringValue) val;
		if(strval!= null) {
			this.year = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_VOLUME);
		strval = (StringValue) val;
		if(strval!= null) {
			this.volume = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_PAGES);
		strval = (StringValue) val;
		if(strval!= null) {
			this.pages = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_NUMBER);
		strval = (StringValue) val;
		if(strval!= null) {
			this.number = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_MONTH);
		strval = (StringValue) val;
		if(strval!= null) {
			this.month = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_NOTE);
		strval = (StringValue) val;
		if(strval!= null) {
			this.note = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_KEY);
		strval = (StringValue) val;
		if(strval!= null) {
			this.key = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_DOI);
		strval = (StringValue) val;
		if(strval!= null) {
			this.doi = strval.toUserString();
		}
		
		
		
	}
	
	
	
	
	
	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean equals(Article toCompare) {
		if(
				(this.author.equals(toCompare.getAuthor())) &&
				(this.journal.equals(toCompare.getJournal())) && 
				(this.title.equals(toCompare.getTitle()))&&
				(this.year.equals(toCompare.getYear()))&&
				(this.volume.equals(toCompare.getVolume()))&&	
				(this.pages.equals(toCompare.getPages()))&&
				(this.number.equals(toCompare.getNumber()))&&
				(this.month.equals(toCompare.getMonth())) &&
				(this.note.equals(toCompare.getNote())) &&
				(this.key.equals(toCompare.getKey())) &&
				(this.doi.equals(toCompare.getDoi())) 
				) {return true;}
		else {return false;}
		
		}
	
	
	@Override
	public String toString() {
		return "autor: " + author + " title: " + title;
	}

}
