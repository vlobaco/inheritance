package en.sunny.inheritance.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="AUTHORS")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AU_ID")
	private Long id;
	@Column(name="VERSION")
	@JsonIgnore
	private Integer version;
	@Column(name="F_NAME")
	private String firstName;
	@Column(name="L_NAME")
	private String lastName;
	private List<Publication> publications;
	
	public Author() {
		super();
		publications=new List<Publication>;
	}

	public Author(Long id, Integer version, String firstName, String lastName) {
		this();
		this.id = id;
		this.version = version;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
