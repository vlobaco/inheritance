package en.sunny.inheritance.rest;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import en.sunny.inheritance.entities.Author;

public class AuthorListeners {
	
	private final static Logger log = LoggerFactory.getLogger(AuthorListeners.class);
	
	@PreRemove
	public void deleteDependencies(Author author) {
		author.getPublications().forEach(p -> p.getAuthors().remove(author));
		log.warn("Deleted dependencies of author " + author.toString());
	}
	
	@PrePersist
	public void addingDependencies(Author author) {
		author.getPublications().forEach(p -> p.getAuthors().add(author));
		log.warn("Added dependencies of " + author.toString());
		
	}
	
	@PreUpdate
	public void updatingDependencies(Author author) {
		deleteDependencies(author);
		addingDependencies(author);
	}
	
}
