package en.sunny.inheritance.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PU_TYPE")
public abstract class Publication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PU_ID")
	private Long id;
	@Column(name="TITLE")
	private String title;
	@Column(name="VERSION")
	@JsonIgnore
	private Integer version;
	@Column(name="PUB_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishingDate;
	@ManyToMany(mappedBy="publications")
	private List<Author> authors;
	
	public Publication() {
		super();
		authors = new ArrayList<Author>();
	}

	public Publication(Long id, String title, Integer version, Date publishingDate) {
		this();
		this.id = id;
		this.title = title;
		this.version = version;
		this.publishingDate = publishingDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public Long getId() {
		return id;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	
	public void addAuthor(Author author) {
		getAuthors().add(author);
		author.getPublications().add(this);
	}

	@Override
	public String toString() {
		return "Publication [title=" + title + ", publishingDate=" + publishingDate + "]";
	}
	
}
