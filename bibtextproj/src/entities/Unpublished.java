package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;
import org.jbibtex.ReferenceValue;
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

		Value val = null;
		Value strval = null;
		ReferenceValue refval = null;
		try {
			Key str2 = createFrom.getKey();

			if (str2 != null) {
				this.setBibkey(str2.getValue());
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		try {
			val = createFrom.getField(createFrom.KEY_AUTHOR);
			strval = (Value) val;
			if (strval != null) {
				this.author = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.author = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {

			val = createFrom.getField(createFrom.KEY_TITLE);
			strval = (Value) val;
			if (strval != null) {
				this.title = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.title = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {
			val = createFrom.getField(createFrom.KEY_YEAR);
			strval = (Value) val;
			if (strval != null) {
				this.year = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.year = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {

			val = createFrom.getField(createFrom.KEY_MONTH);
			strval = (Value) val;
			if (strval != null) {
				this.month = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.month = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {
			val = createFrom.getField(createFrom.KEY_NOTE);
			strval = (Value) val;
			if (strval != null) {
				this.note = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.note = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {
			val = createFrom.getField(createFrom.KEY_KEY);
			strval = (Value) val;
			if (strval != null) {
				this.key = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.key = refval.toUserString();
			}

			System.out.println(e.getMessage());
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

	@Override
	public String toString() {
		String fileString;
		fileString = "@Author{";

		if ((this.getBibkey() != (null)) && !this.getBibkey().isEmpty()) {
			fileString += this.getBibkey() + ",\n";
		} else {
			fileString += "\n";
		}

		if ((this.author != (null)) && !this.author.isEmpty()) {
			fileString += "author = \"" + this.author + "\",\n";
		}

		if ((this.key != (null)) && !this.key.isEmpty()) {
			fileString += "key = \"" + this.key + "\",\n";
		}
		if ((this.month != (null)) && !this.month.isEmpty()) {
			fileString += "month = \"" + this.month + "\",\n";
		}
		if ((this.note != (null)) && !this.note.isEmpty()) {
			fileString += "note = \"" + this.note + "\",\n";
		}

		if ((this.title != (null)) && !this.title.isEmpty()) {
			fileString += "title = \"" + this.title + "\",\n";
		}

		if ((this.year != (null)) && !this.year.isEmpty()) {
			fileString += "year = \"" + this.year + "\",\n";
		}

		fileString += "}\n";

		return fileString;
	}
}
