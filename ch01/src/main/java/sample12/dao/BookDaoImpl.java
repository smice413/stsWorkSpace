package sample12.dao;

import sample12.model.Book;

public class BookDaoImpl implements BookDao {
	public Book getBook(String title) { //  title="λλ°μΈμ"
		return new Book(title, 20000);
	}
}