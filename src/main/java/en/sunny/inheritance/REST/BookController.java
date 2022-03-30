package en.sunny.inheritance.REST;

import java.util.Date;
import java.util.List;

import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import en.sunny.inheritance.entidades.Book;
import en.sunny.inheritance.repositorios.BookDAO;

@RepositoryRestController
public class BookController {
	private BookDAO bookDAO;
	
	public BookController(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@GetMapping("/books/search/published-after")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> findBooksPublishedAfter (
			@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			PersistentEntityResourceAssembler assembler) {
		List<Book> books = bookDAO.getBooksPublishedAfter(date);
		return assembler.toCollectionModel(books);
	}
	
}
