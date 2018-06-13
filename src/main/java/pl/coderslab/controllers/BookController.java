package pl.coderslab.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private MemoryBookService memoryBookService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "{\"hello\":\"world\"}";
	}
	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L, "9788365676078", "A Game of Thrones", "George R.R. Martin",
						"Zysk i S-ka", "Fantasy");
	}
	
	@RequestMapping("/list")
	public List<Book> lists () {

		List<Book>lists = new ArrayList<Book>();

		lists.add(new Book (1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
		lists.add(new Book (2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
		lists.add(new Book (3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
		lists.remove(0);
		return lists;
	}
	
	@RequestMapping("/array")
	public Book[] array() {

		Book[] books = {
				new Book(1L, "9788324132614", "The Lord of the Rings: The Fellowship of the Ring",
						 "John R.R. Tolkien", "Amber Warszawa", "Fantasy"),
				new Book(2L, "9788324132614", "The Lord of the Rings: The Two Towers",
						 "John R.R. Tolkien", "Amber Warszawa", "Fantasy"),
				new Book(3L, "9788324132614", "The Lord of the Rings: The Return of the King",
						 "John R.R. Tolkien", "Amber Warszawa", "Fantasy")};

		return books;

	}
	
	@GetMapping("/getBook/{id}")
	public Book book(@PathVariable long id) {
		return memoryBookService.getById(id);
	}

	@PostMapping("/addBook")
	public boolean addBook(HttpServletRequest request, @RequestBody Book book) {
		memoryBookService.addBook(book);
		return true;
	}

	@RequestMapping("/getList")
	public List<Book> list() {
		return memoryBookService.getList();
	}

	@PutMapping("/updateBook")
	public boolean update(HttpServletRequest request, @RequestBody Book book) {
		memoryBookService.update(book);
		return true;
	}

	@DeleteMapping("/deleteBook/{id}")
	public boolean delete(@PathVariable long id) {
		return memoryBookService.delete(id);
	}
	
}
