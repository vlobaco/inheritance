package en.sunny.inheritance.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BP")
public class BlogPost extends Publication {
	@Column(name="URL")
	private String url;

	public BlogPost(Long id, String title, Integer version, Date publishingDate, String url) {
		super(id, title, version, publishingDate);
		this.url = url;
	}
	
	public BlogPost() {}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
