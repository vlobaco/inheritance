package en.sunny.inheritance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import en.sunny.inheritance.entities.Publication;

@RepositoryRestResource(path="publications", collectionResourceRel="publications")
public interface PublicationADO extends JpaRepository<Publication, Long>, PublicationADOCustom {
	List<Publication> findByTitle(String name);
}
