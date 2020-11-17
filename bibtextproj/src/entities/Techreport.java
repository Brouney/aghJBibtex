package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.StringValue;
import org.jbibtex.Value;

@Entity
@DiscriminatorValue(value = "Techreport")
public class Techreport extends EntryTypes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// required
	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "institution")
	private String institution;

	@Column(name = "year")
	private String year;

	// optional
	@Column(name = "type")
	private String type;

	@Column(name = "number")
	private String number;

	@Column(name = "address")
	private String address;

	@Column(name = "month")
	private String month;

	@Column(name = "note")
	private String note;

	@Column(name = "key")
	private String key;

	public Techreport() {
	}

	public Techreport(BibTeXEntry createFrom) {
		Value val = createFrom.getField(createFrom.KEY_AUTHOR);
		StringValue strval = (StringValue) val;
		if (strval != null) {
			this.author = strval.toUserString();
		}
		val = createFrom.getField(createFrom.KEY_ADDRESS);
		strval = (StringValue) val;
		if (strval != null) {
			this.address = strval.toUserString();
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

		val = createFrom.getField(createFrom.KEY_NUMBER);
		strval = (StringValue) val;
		if (strval != null) {
			this.number = strval.toUserString();
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

		val = createFrom.getField(createFrom.KEY_INSTITUTION);
		strval = (StringValue) val;
		if (strval != null) {
			this.institution = strval.toUserString();
		}

		val = createFrom.getField(createFrom.KEY_TYPE);
		strval = (StringValue) val;
		if (strval != null) {
			this.type = strval.toUserString();
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public boolean myequals(Techreport toCompare) {
		if ((this.address.equals(toCompare.getAddress())) && (this.title.equals(toCompare.getTitle()))
				&& (this.year.equals(toCompare.getYear())) && (this.author.equals(toCompare.getAuthor()))
				&& (this.month.equals(toCompare.getMonth())) && (this.note.equals(toCompare.getNote()))
				&& (this.key.equals(toCompare.getKey())) && (this.type.equals(toCompare.getType()))
				&& (this.institution.equals(toCompare.getInstitution()))) {
			return true;
		} else {
			return false;
		}

	}
}
