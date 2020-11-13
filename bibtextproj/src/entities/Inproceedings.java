package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Inproceedings")
public class Inproceedings extends EntryTypes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// required
	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "booktitle")
	private String booktitle;

	@Column(name = "year")
	private String year;

	// optional
	@Column(name = "editor")
	private String editor;

	@Column(name = "volume")
	private String volume;

	@Column(name = "number")
	private String number;

	@Column(name = "series")
	private String series;

	@Column(name = "pages")
	private String pages;

	@Column(name = "address")
	private String address;

	@Column(name = "month")
	private String month;

	@Column(name = "organization")
	private String organization;

	@Column(name = "publisher")
	private String publisher;

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

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
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

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
	
	public boolean myequals(Inproceedings toCompare) {
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
			(this.booktitle.equals(toCompare.getBooktitle())) &&
			(this.month.equals(toCompare.getMonth())) &&
			(this.note.equals(toCompare.getNote())) &&
			(this.key.equals(toCompare.getKey())) &&
			(this.organization.equals(toCompare.getOrganization())) &&
			(this.pages.equals(toCompare.getPages())) 
			) {return true;}
	else {return false;}
	
	}

}
