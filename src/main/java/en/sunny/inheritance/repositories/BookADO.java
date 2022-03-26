package en.sunny.inheritance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import en.sunny.inheritance.entities.Book;

@RepositoryRestResource(path="books")
public interface BookADO extends JpaRepository<Book, Long> {
	List<Book> findByTitle(String name);
}
