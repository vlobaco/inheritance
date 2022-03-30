package en.sunny.inheritance.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import en.sunny.inheritance.entidades.Author;

@RepositoryRestResource(path="authors")
public interface AuthorDAO extends JpaRepository<Author, Long> {

}
