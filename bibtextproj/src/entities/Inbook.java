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
@DiscriminatorValue(value = "Inbook")
public class Inbook extends EntryTypes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// required
	@Column(name = "author")
	private String author;

	@Column(name = "editor")
	private String editor;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private String year;

	@Column(name = "publisher")
	private String publisher;

	@Column(name = "chapter")
	private String chapter;

	@Column(name = "pages")
	private String pages;

	// optional
	@Column(name = "volume")
	private String volume;

	@Column(name = "number")
	private String number;

	@Column(name = "series")
	private String series;

	@Column(name = "type")
	private String type;

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

	@Column(name = "url")
	private String url;

	public Inbook() {
	}

	public boolean myequals(Inbook toCompare) {

		if (toCompare.getAddress() == null)
			toCompare.setAddress("");

		if (toCompare.getEditor() == null)
			toCompare.setEditor("");
		if (toCompare.getTitle() == null)
			toCompare.setTitle("");
		if (toCompare.getYear() == null)
			toCompare.setYear("");
		if (toCompare.getPublisher() == null)
			toCompare.setPublisher("");
		if (toCompare.getAuthor() == null)
			toCompare.setAuthor("");
		if (toCompare.getVolume() == null)
			toCompare.setVolume("");
		if (toCompare.getSeries() == null)
			toCompare.setSeries("");
		if (toCompare.getMonth() == null)
			toCompare.setMonth("");

		if (toCompare.getKey() == null)
			toCompare.setKey("");
		if (toCompare.getPages() == null)
			toCompare.setPages("");
		if (toCompare.getUrl() == null)
			toCompare.setUrl("");
		if (toCompare.getNumber() == null)
			toCompare.setNumber("");
		if (toCompare.getEdition() == null)
			toCompare.setEdition("");
		if (toCompare.getNote() == null)
			toCompare.setNote("");
		if (toCompare.getChapter() == null)
			toCompare.setChapter("");
		if (toCompare.getType() == null)
			toCompare.setType("");

		
		
		
		if ((this.address.equals(toCompare.getAddress())) && (this.editor.equals(toCompare.getEditor()))
				&& (this.title.equals(toCompare.getTitle())) && (this.year.equals(toCompare.getYear()))
				&& (this.publisher.equals(toCompare.getPublisher())) && (this.author.equals(toCompare.getAuthor()))
				&& (this.volume.equals(toCompare.getVolume())) && (this.number.equals(toCompare.getNumber()))
				&& (this.series.equals(toCompare.getSeries())) && (this.edition.equals(toCompare.getEdition()))
				&& (this.month.equals(toCompare.getMonth())) && (this.note.equals(toCompare.getNote()))
				&& (this.key.equals(toCompare.getKey())) && (this.chapter.equals(toCompare.getChapter()))
				&& (this.pages.equals(toCompare.getPages())) && (this.type.equals(toCompare.getType()))
				&& (this.url.equals(toCompare.getUrl()))) {
			return true;
		} else {
			return false;
		}

	}

	public Inbook(BibTeXEntry createFrom) {

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
			val = createFrom.getField(createFrom.KEY_EDITOR);
			strval = (Value) val;
			if (strval != null) {
				this.editor = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.editor = refval.toUserString();
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
			val = createFrom.getField(createFrom.KEY_PUBLISHER);
			strval = (Value) val;
			if (strval != null) {
				this.publisher = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.publisher = refval.toUserString();
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
			val = createFrom.getField(createFrom.KEY_SERIES);
			strval = (Value) val;
			if (strval != null) {
				this.series = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.series = refval.toUserString();
			}

			System.out.println(e.getMessage());
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
			val = createFrom.getField(createFrom.KEY_URL);
			strval = (Value) val;
			if (strval != null) {
				this.url = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.url = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {

			val = createFrom.getField(createFrom.KEY_TYPE);
			strval = (StringValue) val;
			if (strval != null) {
				this.type = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.type = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}
		try {

			val = createFrom.getField(createFrom.KEY_CHAPTER);
			strval = (StringValue) val;
			if (strval != null) {
				this.chapter = strval.toUserString();
			}
		} catch (Exception e) {
			refval = (ReferenceValue) val;
			if (refval != null) {
				this.chapter = refval.toUserString();
			}

			System.out.println(e.getMessage());
		}

		try {

			val = createFrom.getField(createFrom.KEY_PAGES);
			strval = (StringValue) val;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		String fileString;
		fileString = "@Inbook{";

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
		if ((this.editor != (null)) && !this.editor.isEmpty()) {
			fileString += "editor = \"" + this.editor + "\",\n";
		}
		if ((this.chapter != (null)) && !this.chapter.isEmpty()) {
			fileString += "chapter = \"" + this.chapter + "\",\n";
		}
		if ((this.pages != (null)) && !this.pages.isEmpty()) {
			fileString += "pages = \"" + this.pages + "\",\n";
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
		if ((this.number != (null)) && !this.number.isEmpty()) {
			fileString += "number = \"" + this.number + "\",\n";
		}

		if ((this.publisher != (null)) && !this.publisher.isEmpty()) {
			fileString += "publisher = \"" + this.publisher + "\",\n";
		}

		if ((this.series != (null)) && !this.series.isEmpty()) {
			fileString += "series = \"" + this.series + "\",\n";
		}
		if ((this.title != (null)) && !this.title.isEmpty()) {
			fileString += "title = \"" + this.title + "\",\n";
		}
		if ((this.type != (null)) && !this.type.isEmpty()) {
			fileString += "type = \"" + this.type + "\",\n";
		}
		if ((this.volume != (null)) && !this.volume.isEmpty()) {
			fileString += "volume = \"" + this.volume + "\",\n";
		}
		if ((this.year != (null)) && !this.year.isEmpty()) {
			fileString += "year = \"" + this.year + "\",\n";
		}

		fileString += "}\n";

		return fileString;
	}

	public String generateQuery() {

		String query = "select f from fields f where bibitem = 'Inbook' ";
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
		if ((this.editor != (null)) && !this.editor.isEmpty()) {
			query += " AND editor LIKE '%" + this.editor + "%' ";
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
		if ((this.number != (null)) && !this.number.isEmpty()) {
			query += " AND number LIKE '%" + this.number + "%' ";
		}

		if ((this.publisher != (null)) && !this.publisher.isEmpty()) {
			query += " AND publisher LIKE '%" + this.publisher + "%' ";
		}

		if ((this.series != (null)) && !this.series.isEmpty()) {
			query += " AND series LIKE '%" + this.series + "%' ";
		}
		if ((this.title != (null)) && !this.title.isEmpty()) {
			query += " AND title LIKE '%" + this.title + "%' ";
		}
		if ((this.type != (null)) && !this.type.isEmpty()) {
			query += " AND type LIKE '%" + this.type + "%' ";
		}
		if ((this.volume != (null)) && !this.volume.isEmpty()) {
			query += " AND volume LIKE '%" + this.volume + "%' ";
		}
		if ((this.year != (null)) && !this.year.isEmpty()) {
			query += " AND year LIKE '%" + this.year + "%' ";
		}

		if ((this.getKeywords() != (null)) && !this.getKeywords().isEmpty()) {
			query += "AND keywords LIKE '%" + this.getKeywords() + "%' ";
		}
		if ((this.chapter != (null)) && !this.chapter.isEmpty()) {
			query += " AND chapter LIKE '%" + this.chapter + "%' ";
		}
		if ((this.pages != (null)) && !this.pages.isEmpty()) {
			query += " AND pages LIKE '%" + this.pages + "%' ";
		}

		return query;
	}
}
