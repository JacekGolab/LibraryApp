package pl.coderslab.repository;

import java.util.List;

import pl.coderslab.model.Book;

public interface BookService {
	
	public List<Book> getList();
	
	public void setList(List<Book> list);
	
	public void addBook (Book book);
	
	public Book getById(long id);
	
	public boolean update(Book bookUpdate);
	
	public boolean delete(long id);

}
