package in.tp.led.dto;

public class Book {

	private String bookCode;
	private String title;
	private int price;
	private int edition;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String bookCode, String title, int price, int edition) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.price = price;
		this.edition = edition;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", price="
				+ price + ", edition=" + edition + "]";
	}
}
