package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.StringValue;
import org.jbibtex.Value;

@Entity
@DiscriminatorValue(value = "Book")
public class Book extends EntryTypes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// required
	@Column(name = "author")
	private String author;
	
	@Column(name = "editor")
	private String editor;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "publisher")
	private String publisher;

	// optional
	@Column(name = "volume")
	private String volume;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "series")
	private String series;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "key")
	private String key;
	
	@Column(name = "url")
	private String url;

	
	public Book() {}
	public Book(BibTeXEntry createFrom) {
		Value val = createFrom.getField(createFrom.KEY_AUTHOR);
		StringValue strval = (StringValue) val;
		if(strval!= null) {
			this.author = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_ADDRESS);
		strval = (StringValue) val;
		if(strval!= null) {
			this.address = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_EDITOR);
		strval = (StringValue) val;
		if(strval!= null) {
			this.editor = strval.toUserString();
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
		val = createFrom.getField(createFrom.KEY_PUBLISHER);
		strval = (StringValue) val;
		if(strval!= null) {
			this.publisher = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_VOLUME);
		strval = (StringValue) val;
		if(strval!= null) {
			this.volume = strval.toUserString();
		}
		
		val = createFrom.getField(createFrom.KEY_NUMBER);
		strval = (StringValue) val;
		if(strval!= null) {
			this.number = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_SERIES);
		strval = (StringValue) val;
		if(strval!= null) {
			this.series = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_EDITION);
		strval = (StringValue) val;
		if(strval!= null) {
			this.edition = strval.toUserString();
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
		val = createFrom.getField(createFrom.KEY_URL);
		strval = (StringValue) val;
		if(strval!= null) {
			this.url = strval.toUserString();
		}
		
		
		
		
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
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

	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean equals(Book toCompare) {
	if(
			(this.address.equals(toCompare.getAddress())) &&
			(this.editor.equals(toCompare.getEditor())) && 
			(this.title.equals(toCompare.getTitle()))&&
			(this.year.equals(toCompare.getYear()))&&
			(this.publisher.equals(toCompare.getPublisher()))&&
			(this.author.equals(toCompare.getAuthor()))&&
			(this.volume.equals(toCompare.getVolume()))&&
			(this.number.equals(toCompare.getNumber()))&&
			(this.series.equals(toCompare.getSeries()))&&
			(this.edition.equals(toCompare.getEdition()))&&
			(this.month.equals(toCompare.getMonth())) &&
			(this.note.equals(toCompare.getNote())) &&
			(this.key.equals(toCompare.getKey())) &&
			(this.url.equals(toCompare.getUrl())) 
			) {return true;}
	else {return false;}
	
	}
	

}
