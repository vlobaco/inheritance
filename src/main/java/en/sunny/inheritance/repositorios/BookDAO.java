package en.sunny.inheritance.repositorios;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import en.sunny.inheritance.entidades.Book;

@RepositoryRestResource(path="books")
public interface BookDAO extends JpaRepository<Book, Long> {
	List<Book> findBookByTitleContainingIgnoreCase(String txt);
	
	public default List<Book> getBooksPublishedAfter(Date date) {
		List<Book> books = this.findAll().stream()
				.filter(b ->b.getPublishingDate().after(date))
				.collect(Collectors.toList());
		return books;
	}
}
