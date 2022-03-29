package en.sunny.inheritance.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import en.sunny.inheritance.rest.AuthorListeners;

@Entity(name="author")
@EntityListeners(AuthorListeners.class)
@Table(name="AUTHORS")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AU_ID")
	private Long id;
	private int version;
	
	@Column(name="F_NAME")
	private String firstName;
	
	@Column(name="L_NAME")
	private String lastName;
	
	@ManyToMany(mappedBy="authors")
	private Set<Publication> publications;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getVersion() {
		return version;
	}
	
	public String toString() {
		return "Author: " + getLastName() + ", " + getFirstName();
	}
	
	public Set<Publication> getPublications() {
		return publications;
	}
	
	public void addPublication(Publication publication) {
		this.getPublications().add(publication);
		publication.getAuthors().add(this);
	}
	
	public void removePublication(Publication publication) {
		this.getPublications().remove(publication);
		publication.getAuthors().remove(this);
	}
	public Author(Long id, int version, String firstName, String lastName) {
		this();
		this.id = id;
		this.version = version;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Author() {
		this.publications = new HashSet<Publication>();
	}
	
	
}
