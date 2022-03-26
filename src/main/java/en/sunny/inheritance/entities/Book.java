package en.sunny.inheritance.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="book")
@DiscriminatorValue("BO")
public class Book extends Publication{
	@Column(name="N_PAGES")
	private int pages;

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public boolean equals(Object obj) {
		Book b = (Book) obj;
		return (this.title == b.title) & (this.getPages() == b.getPages());
	}
}
