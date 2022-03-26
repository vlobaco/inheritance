package en.sunny.inheritance.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PUBLICATIONS")
@Inheritance
@DiscriminatorColumn(name="PUB_TYPE")
public class Publication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PU_ID")
	protected Long id;
	@Column(name="title")
	protected String title;
	private int version;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="PUB_AUT",
			joinColumns=@JoinColumn(name="PU_ID", referencedColumnName="PU_ID"),
			inverseJoinColumns=@JoinColumn(name="AU_ID", referencedColumnName="AU_ID")
	)
	private Set<Author> authors;
	@Column(name="PUB_DATE")
	private Date publishingDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Date getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	
	public String toString() {
		return "Publicacion: " + getTitle() + 
				", " + getAuthors() + "," + getPublishingDate();
	}
}
