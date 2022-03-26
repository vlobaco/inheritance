package en.sunny.inheritance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import en.sunny.inheritance.entities.Author;

@RepositoryRestResource(path="authors")
public interface AuthorADO extends JpaRepository<Author, Long> {
	List<Author> findByFirstName(String name);
}
