package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.LiteralValue;
import org.jbibtex.ReferenceValue;
import org.jbibtex.StringValue;
import org.jbibtex.Value;

@Entity
@DiscriminatorValue(value = "Article")
public class Article extends EntryTypes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// required
	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private String year;

	@Column(name = "journal")
	private String journal;

	// optional

	@Column(name = "volume")
	private String volume;

	@Column(name = "number")
	private String number;

	@Column(name = "pages")
	private String pages;

	@Column(name = "month")
	private String month;

	@Column(name = "doi")
	private String doi;

	@Column(name = "note")
	private String note;

	@Column(name = "key")
	private String key;

	public Article() {
	}

	public Article(BibTeXEntry createFrom) {
		Value val = null;
		ReferenceValue refval = null;
		Value strval = null;
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
			val = createFrom.getField(createFrom.KEY_JOURNAL);
			strval = (Value) val;
			if (strval != null) {
				this.journal = strval.toUserString();
			}

		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.journal = refval.toUserString();
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
			val = createFrom.getField(createFrom.KEY_VOLUME);
			strval = (Value) val;
			if (strval != null) {
				this.volume = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.volume = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {
			val = createFrom.getField(createFrom.KEY_PAGES);
			strval = (Value) val;
			if (strval != null) {
				this.pages = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.pages = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {
			val = createFrom.getField(createFrom.KEY_NUMBER);
			strval = (Value) val;
			if (strval != null) {
				this.number = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.number = refval.toUserString();
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
			val = createFrom.getField(createFrom.KEY_DOI);
			strval = (Value) val;
			if (strval != null) {
				this.doi = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.doi = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}

	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
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

	public boolean equals(Article toCompare) {
		if ((this.author.equals(toCompare.getAuthor())) && (this.journal.equals(toCompare.getJournal()))
				&& (this.title.equals(toCompare.getTitle())) && (this.year.equals(toCompare.getYear()))
				&& (this.volume.equals(toCompare.getVolume())) && (this.pages.equals(toCompare.getPages()))
				&& (this.number.equals(toCompare.getNumber())) && (this.month.equals(toCompare.getMonth()))
				&& (this.note.equals(toCompare.getNote())) && (this.key.equals(toCompare.getKey()))
				&& (this.doi.equals(toCompare.getDoi()))) {
			return true;
		} else {
			return false;
		}

	}

	public String generateQuery() {

		String query = "select f from fields f where bibitem = 'Article' ";

		if ((this.getBibkey() != (null)) && !this.getBibkey().isEmpty()) {
			query += " AND bibkey LIKE '%" + this.getBibkey() + "%' ";
		}
		if ((this.author != (null)) && !this.author.isEmpty()) {
			query += " AND author LIKE '%" + this.author + "%' ";
		}
		if ((this.journal != (null)) && !this.journal.isEmpty()) {
			query += "AND journal LIKE '%" + this.journal + "%' ";
		}
		if ((this.title != (null)) && !this.title.isEmpty()) {
			query += "AND title LIKE '%" + this.title + "%' ";
		}
		if ((this.year != (null)) && !this.year.isEmpty()) {
			query += "AND year LIKE '%" + this.year + "%' ";
		}
		if ((this.volume != (null)) && !this.volume.isEmpty()) {
		}
		if ((this.pages != (null)) && !this.pages.isEmpty()) {
			query += "AND pages LIKE '%" + this.pages + "%' ";
		}
		if ((this.number != (null)) && !this.number.isEmpty()) {
			query += "AND number LIKE '%" + this.number + "%' ";
		}
		if ((this.month != (null)) && !this.month.isEmpty()) {
			query += "AND month LIKE '%" + this.month + "%' ";
		}
		if ((this.note != (null)) && !this.note.isEmpty()) {
			query += "AND note LIKE '%" + this.note + "%' ";
		}
		if ((this.key != (null)) && !this.key.isEmpty()) {
			query += "AND key LIKE '%" + this.key + "%' ";
		}
		if ((this.doi != (null)) && !this.doi.isEmpty()) {
			query += "AND doi LIKE '%" + this.doi + "%' ";
		}

		if ((this.getKeywords() != (null)) && !this.getKeywords().isEmpty()) {
			query += "AND keywords LIKE '%" + this.getKeywords() + "%' ";
		}

		return query;
	}

	@Override
	public String toString() {
		String fileString;
		fileString = "@Article{";

		if ((this.getBibkey() != (null)) && !this.getBibkey().isEmpty()) {
			fileString += this.getBibkey() + ",\n";
		} else {
			fileString += "\n";
		}
		if ((this.author != (null)) && !this.author.isEmpty()) {
			fileString += "author = \"" + this.author + "\",\n";
		}
		if ((this.journal != (null)) && !this.journal.isEmpty()) {
			fileString += "journal = \"" + this.journal + "\",\n";
		}
		if ((this.title != (null)) && !this.title.isEmpty()) {
			fileString += "title = \"" + this.title + "\",\n";
		}
		if ((this.year != (null)) && !this.year.isEmpty()) {
			fileString += "year = \"" + this.year + "\",\n";
		}
		if ((this.volume != (null)) && !this.volume.isEmpty()) {
			fileString += "volume = \"" + this.volume + "\",\n";
		}
		if ((this.pages != (null)) && !this.pages.isEmpty()) {
			fileString += "pages = \"" + this.pages + "\",\n";
		}
		if ((this.number != (null)) && !this.number.isEmpty()) {
			fileString += "number = \"" + this.number + "\",\n";
		}
		if ((this.month != (null)) && !this.month.isEmpty()) {
			fileString += "month = \"" + this.month + "\",\n";
		}
		if ((this.note != (null)) && !this.note.isEmpty()) {
			fileString += "note = \"" + this.note + "\",\n";
		}
		if ((this.key != (null)) && !this.key.isEmpty()) {
			fileString += "key = \"" + this.key + "\",\n";
		}
		if ((this.doi != (null)) && !this.doi.isEmpty()) {
			fileString += "doi = \"" + this.doi + "\",\n";
		}
		fileString += "}\n";

		return fileString;
	}

}
