package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Misc")
public class Misc extends EntryTypes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// optional
	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "howpublished")
	private String howpublished;

	@Column(name = "month")
	private String month;

	@Column(name = "year")
	private String year;

	@Column(name = "note")
	private String note;

	@Column(name = "key")
	private String key;

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

	public String getHowpublished() {
		return howpublished;
	}

	public void setHowpublished(String howpublished) {
		this.howpublished = howpublished;
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

}
