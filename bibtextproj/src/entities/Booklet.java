package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;
import org.jbibtex.ReferenceValue;

import org.jbibtex.Value;

@Entity
@DiscriminatorValue(value = "Booklet")
public class Booklet extends EntryTypes {

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

	@Column(name = "howpublished")
	private String howpublished;

	@Column(name = "address")
	private String address;

	@Column(name = "month")
	private String month;

	@Column(name = "year")
	private String year;

	@Column(name = "note")
	private String note;

	@Column(name = "key")
	private String key;

	public Booklet() {
	}

	public Booklet(BibTeXEntry createFrom) {

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
			val = createFrom.getField(createFrom.KEY_ADDRESS);
			strval = (Value) val;
			if (strval != null) {
				this.address = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.address = refval.toUserString();
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
		try {

			val = createFrom.getField(createFrom.KEY_HOWPUBLISHED);
			strval = (Value) val;
			if (strval != null) {
				this.howpublished = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.howpublished = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}

	}

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

	public String getHowpublished() {
		return howpublished;
	}

	public void setHowpublished(String howpublished) {
		this.howpublished = howpublished;
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

	public boolean myequals(Booklet toCompare) {

		if (toCompare.getAuthor() == null)
			toCompare.setAuthor("");
		if (toCompare.getTitle() == null)
			toCompare.setTitle("");
		if (toCompare.getYear() == null)
			toCompare.setYear("");
		if (toCompare.getMonth() == null)
			toCompare.setMonth("");
		if (toCompare.getKey() == null)
			toCompare.setKey("");
		if (toCompare.getAddress() == null)
			toCompare.setAddress("");
		if (toCompare.getNote() == null)
			toCompare.setNote("");
		if (toCompare.getHowpublished() == null)
			toCompare.setHowpublished("");

		if ((this.author.equals(toCompare.getAuthor())) && (this.title.equals(toCompare.getTitle()))
				&& (this.year.equals(toCompare.getYear())) && (this.month.equals(toCompare.getMonth()))
				&& (this.note.equals(toCompare.getNote())) && (this.key.equals(toCompare.getKey()))
				&& (this.howpublished.equals(toCompare.getHowpublished()))
				&& (this.address.equals(toCompare.getAddress()))) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		String fileString;
		fileString = "@Booklet{";

		if ((this.getBibkey() != (null)) && !this.getBibkey().isEmpty()) {
			fileString += this.getBibkey() + ",\n";
		} else {
			fileString += "\n";
		}
		if ((this.address != (null)) && !this.address.isEmpty()) {
			fileString += "address = \"" + this.address + "\",\n";
		}

		if ((this.author != (null)) && !this.author.isEmpty()) {
			fileString += "author = \"" + this.author + "\",\n";
		}

		if ((this.howpublished != (null)) && !this.howpublished.isEmpty()) {
			fileString += "howpublished = \"" + this.howpublished + "\",\n";
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

	public String generateQuery() {

		String query = "select f from fields f where bibitem = 'Booklet' ";
		if ((this.getBibkey() != (null)) && !this.getBibkey().isEmpty()) {
			query += " AND bibkey LIKE '%" + this.getBibkey() + "%' ";
		}
		if ((this.address != (null)) && !this.address.isEmpty()) {
			query += " AND address LIKE '%" + this.address + "%' ";
		}

		if ((this.author != (null)) && !this.author.isEmpty()) {
			query += " AND author LIKE '%" + this.author + "%' ";
		}

		if ((this.howpublished != (null)) && !this.howpublished.isEmpty()) {
			query += " AND howpublished LIKE '%" + this.howpublished + "%' ";
		}

		if ((this.key != (null)) && !this.key.isEmpty()) {
			query += " AND key LIKE '%" + this.key + "%' ";
		}
		if ((this.month != (null)) && !this.month.isEmpty()) {
			query += " AND month LIKE '%" + this.month + "%' ";
		}
		if ((this.note != (null)) && !this.note.isEmpty()) {
			query += " AND note LIKE '%" + this.note + "%' ";
		}

		if ((this.title != (null)) && !this.title.isEmpty()) {
			query += " AND title LIKE '%" + this.title + "%' ";
		}

		if ((this.year != (null)) && !this.year.isEmpty()) {
			query += " AND year LIKE '%" + this.year + "%' ";
		}

		if ((this.getKeywords() != (null)) && !this.getKeywords().isEmpty()) {
			query += "AND keywords LIKE '%" + this.getKeywords() + "%' ";
		}

		return query;
	}
}
