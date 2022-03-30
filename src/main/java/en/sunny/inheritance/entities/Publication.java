package en.sunny.inheritance.entities;

import java.time.Instant;

public class Publication {

	private Long id;
	private String title;
	private Integer version;
	private Instant publishingDate;
	
	public Publication() {
		super();
	}

	public Publication(Long id, String title, Integer version, Instant publishingDate) {
		super();
		this.id = id;
		this.title = title;
		this.version = version;
		this.publishingDate = publishingDate;
	}
	
	
}
