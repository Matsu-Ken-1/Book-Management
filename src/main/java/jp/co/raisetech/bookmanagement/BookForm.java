package jp.co.raisetech.bookmanagement;

public class BookForm {

	// ID
	private Integer id;
	
	// ジャンル
	private String  genre;
	
	// 本の名前
	private String  bookname;
	
	// 作者
	private String  author;
	
	// 出版社
	private String  publisher;
	
	// コメント
	private String  comment;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}