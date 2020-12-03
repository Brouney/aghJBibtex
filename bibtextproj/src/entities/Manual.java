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
@DiscriminatorValue(value = "Manual")
public class Manual extends EntryTypes {

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

	public Manual() {
	}

	public Manual(BibTeXEntry createFrom) {
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

			System.out.print(e.getMessage());
			System.out.println("manualau");
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

			System.out.print(e.getMessage());
			System.out.println("manualad");
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

			System.out.print(e.getMessage());
			System.out.println("manualtit");
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

			System.out.print(e.getMessage());
			System.out.println("manualyea");
		}
		try {

			val = createFrom.getField(createFrom.KEY_EDITION);
			strval = (Value) val;
			if (strval != null) {
				this.edition = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.edition = refval.toUserString();
			}

			System.out.print(e.getMessage());
			System.out.println("manualed");
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

			System.out.print(e.getMessage());
			System.out.println("manualmon");
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

			System.out.print(e.getMessage());
			System.out.println("manualnote");
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

			System.out.print(e.getMessage());
			System.out.println("manualkey");
		}
		try {

			val = createFrom.getField(createFrom.KEY_ORGANIZATION);
			strval = (Value) val;
			if (strval != null) {
				this.organization = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.organization = refval.toUserString();
			}

			System.out.print(e.getMessage());
			System.out.println("manualorg");
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
		if ((this.author.equals(toCompare.getAuthor())) && (this.title.equals(toCompare.getTitle()))
				&& (this.year.equals(toCompare.getYear())) && (this.edition.equals(toCompare.getEdition()))
				&& (this.month.equals(toCompare.getMonth())) && (this.note.equals(toCompare.getNote()))
				&& (this.key.equals(toCompare.getKey())) && (this.organization.equals(toCompare.getOrganization()))
				&& (this.address.equals(toCompare.getAddress()))) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		String fileString;
		fileString = "@Manual{";

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

		if ((this.edition != (null)) && !this.edition.isEmpty()) {
			fileString += "edition = \"" + this.edition + "\",\n";
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

		if ((this.organization != (null)) && !this.organization.isEmpty()) {
			fileString += "organization = \"" + this.organization + "\",\n";
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

		String query = "select f from fields f where bibitem = 'Manual' ";
		if ((this.getBibkey() != (null)) && !this.getBibkey().isEmpty()) {
			query += " AND bibkey LIKE '%" + this.getBibkey() + "%' ";
		}
		if ((this.address != (null)) && !this.address.isEmpty()) {
			query += " AND address LIKE '%" + this.address + "%' ";
		}

		if ((this.author != (null)) && !this.author.isEmpty()) {
			query += " AND author LIKE '%" + this.author + "%' ";
		}

		if ((this.edition != (null)) && !this.edition.isEmpty()) {
			query += " AND edition LIKE '%" + this.edition + "%' ";
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

		if ((this.organization != (null)) && !this.organization.isEmpty()) {
			query += " AND organization LIKE '%" + this.organization + "%' ";
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
