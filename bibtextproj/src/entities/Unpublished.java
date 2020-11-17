package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.StringValue;
import org.jbibtex.Value;

@Entity
@DiscriminatorValue(value = "Unpublished")
public class Unpublished extends EntryTypes {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// required
	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "note")
	private String note;

	// optional
	@Column(name = "month")
	private String month;

	@Column(name = "year")
	private String year;

	@Column(name = "key")
	private String key;

	public Unpublished() {
	}

	public Unpublished(BibTeXEntry createFrom) {
		Value val = createFrom.getField(createFrom.KEY_AUTHOR);
		StringValue strval = (StringValue) val;
		if (strval != null) {
			this.author = strval.toUserString();
		}

		val = createFrom.getField(createFrom.KEY_TITLE);
		strval = (StringValue) val;
		if (strval != null) {
			this.title = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_YEAR);
		strval = (StringValue) val;
		if (strval != null) {
			this.year = strval.toUserString();
		}

		val = createFrom.getField(createFrom.KEY_MONTH);
		strval = (StringValue) val;
		if (strval != null) {
			this.month = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_NOTE);
		strval = (StringValue) val;
		if (strval != null) {
			this.note = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_KEY);
		strval = (StringValue) val;
		if (strval != null) {
			this.key = strval.toUserString();
		}

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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean myequals(Unpublished toCompare) {
		if ((this.title.equals(toCompare.getTitle())) && (this.year.equals(toCompare.getYear()))
				&& (this.author.equals(toCompare.getAuthor())) && (this.month.equals(toCompare.getMonth()))
				&& (this.note.equals(toCompare.getNote())) && (this.key.equals(toCompare.getKey()))) {
			return true;
		} else {
			return false;
		}

	}

}
