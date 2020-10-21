package entities;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Conference")
public class Conference extends EntryTypes{

	// required
		private String author;
		private String title;
		private String booktitle;
		private String year;

		// optional
		private String editor;
		private String volume;
		private String number;
		private String series;
		private String pages;
		private String address;
		private String month;
		private String organization;
		private String publisher;
		private String note;
		private String key;
		
		
		@Column(name = "author")
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		
		@Column(name = "title")
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		@Column(name = "booktitle")
		public String getBooktitle() {
			return booktitle;
		}
		public void setBooktitle(String booktitle) {
			this.booktitle = booktitle;
		}
		
		@Column(name = "year")
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		
		@Column(name = "editor")
		public String getEditor() {
			return editor;
		}
		public void setEditor(String editor) {
			this.editor = editor;
		}
		
		@Column(name = "volume")
		public String getVolume() {
			return volume;
		}
		public void setVolume(String volume) {
			this.volume = volume;
		}
		
		@Column(name = "number")
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		
		@Column(name = "series")
		public String getSeries() {
			return series;
		}
		public void setSeries(String series) {
			this.series = series;
		}
		
		@Column(name = "pages")
		public String getPages() {
			return pages;
		}
		public void setPages(String pages) {
			this.pages = pages;
		}
		
		@Column(name = "address")
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		@Column(name = "month")
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		
		@Column(name = "organization")
		public String getOrganization() {
			return organization;
		}
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		
		@Column(name = "publisher")
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		
		@Column(name = "note")
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		
		@Column(name = "key")
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
}
