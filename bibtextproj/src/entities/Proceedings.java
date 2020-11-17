package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.StringValue;
import org.jbibtex.Value;

@Entity
@DiscriminatorValue(value = "Proceedings")
public class Proceedings extends EntryTypes {

	// required

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "title")
	private String title;

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

	public Proceedings() {}
	public Proceedings(BibTeXEntry createFrom) {
		Value val = createFrom.getField(createFrom.KEY_ADDRESS);
		StringValue strval = (StringValue) val;
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
		
		
		
		val = createFrom.getField(createFrom.KEY_ORGANIZATION);
		strval = (StringValue) val;
		if(strval!= null) {
			this.organization = strval.toUserString();
		}
	
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
	
	public boolean myequals(Proceedings toCompare) {
		if(
				(this.address.equals(toCompare.getAddress())) &&
				(this.editor.equals(toCompare.getEditor())) && 
				(this.title.equals(toCompare.getTitle()))&&
				(this.year.equals(toCompare.getYear()))&&
				(this.publisher.equals(toCompare.getPublisher()))&&
				(this.volume.equals(toCompare.getVolume()))&&
				(this.number.equals(toCompare.getNumber()))&&
				(this.series.equals(toCompare.getSeries()))&&
				(this.month.equals(toCompare.getMonth())) &&
				(this.note.equals(toCompare.getNote())) &&
				(this.key.equals(toCompare.getKey())) &&
				(this.organization.equals(toCompare.getOrganization())) 
				) {return true;}
		else {return false;}
		
		}
}
