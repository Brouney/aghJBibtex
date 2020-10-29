package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Incollection")
public class Incollection extends EntryTypes {

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

	@Column(name = "publisher")
	private String publisher;

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

	@Column(name = "type")
	private String type;

	@Column(name = "chapter")
	private String chapter;

	@Column(name = "pages")
	private String pages;

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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
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

}
