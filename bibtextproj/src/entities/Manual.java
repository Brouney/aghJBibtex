package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Manual")
public class Manual extends EntryTypes{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// required
	@Column(name = "title")
	private String title;

	// optional
	@Column(name = "author")
	private String author;
	
	@Column(name = "organization")
	private String organization;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "key")
	private String key;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
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
	
	public boolean myequals(Manual toCompare) {
		if(
				(this.author.equals(toCompare.getAuthor())) &&
				(this.title.equals(toCompare.getTitle()))&&
				(this.year.equals(toCompare.getYear()))&&
				(this.edition.equals(toCompare.getEdition())) &&
				(this.month.equals(toCompare.getMonth())) &&
				(this.note.equals(toCompare.getNote())) &&
				(this.key.equals(toCompare.getKey())) &&
				(this.organization.equals(toCompare.getOrganization())) &&
				(this.address.equals(toCompare.getAddress())) 
				) {return true;}
		else {return false;}
		
		}


}
