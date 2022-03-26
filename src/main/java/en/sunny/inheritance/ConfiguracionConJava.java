package en.sunny.inheritance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import en.sunny.inheritance.entities.Author;
import en.sunny.inheritance.entities.Publication;
import en.sunny.inheritance.json.MixIns;

@Configuration
public class ConfiguracionConJava {
	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper o = new ObjectMapper();
		o.addMixIn(Author.class, MixIns.MixInAuthor.class);
		o.addMixIn(Publication.class, MixIns.MixInPublication.class);
		return o;
	}
}
