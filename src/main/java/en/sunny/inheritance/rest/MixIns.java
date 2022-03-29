package en.sunny.inheritance.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class MixIns {
	@JsonIgnoreProperties({"version"})
	@JsonPropertyOrder({"Id, firstName, lastName"})
	public abstract static class MixInAuthor {
		@JsonProperty("id")
		abstract Long getId();
		
	}
	
	@JsonIgnoreProperties({"version"})
	public abstract static class MixInPublication {}
}
