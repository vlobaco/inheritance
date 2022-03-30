package en.sunny.inheritance.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BO")
public class Book extends Publication {
	@Column(name="PAGES")
	private Integer pages;

	public Book(Long id, String title, Integer version, Date publishingDate, Integer pages) {
		super(id, title, version, publishingDate);
		this.pages = pages;
	}
	
	public Book() {}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	
}
