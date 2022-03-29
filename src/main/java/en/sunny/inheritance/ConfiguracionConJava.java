package en.sunny.inheritance;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import en.sunny.inheritance.entities.Author;
import en.sunny.inheritance.entities.Publication;
import en.sunny.inheritance.rest.MixIns;
import en.sunny.inheritance.rest.PublicationController;

@Configuration
public class ConfiguracionConJava {
	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper o = new ObjectMapper();
		o.addMixIn(Author.class, MixIns.MixInAuthor.class);
		o.addMixIn(Publication.class, MixIns.MixInPublication.class);
		return o;
	}
	
	@Bean
	RepresentationModelProcessor<RepositorySearchesResource> addSearchLinks(RepositoryRestConfiguration config) {
		Map<Class<?>, Class<?>> controllersRegistrados = new HashMap<>();

		controllersRegistrados.put(Publication.class, PublicationController.class);
		
		return new RepresentationModelProcessor<RepositorySearchesResource>() {
			@Override
			public RepositorySearchesResource process(RepositorySearchesResource searchResource) {
				if (controllersRegistrados.containsKey(searchResource.getDomainType())) {
					Method[] metodos = 
						controllersRegistrados.get(searchResource.getDomainType()).getDeclaredMethods();
					for (Method m : metodos) {
						if (!m.isAnnotationPresent(ResponseBody.class)) continue;
						try {
							Object[] pathVars = Stream.of(m.getParameters())
								.filter(p -> p.isAnnotationPresent(PathVariable.class))
								.map(p -> "(" + p.getName() + ")")
								.collect(Collectors.toList()).toArray();
							URI uri = linkTo(m, pathVars).toUri();
							String path = new URI(
								uri.getScheme(), 
								uri.getUserInfo(), 
								uri.getHost(), 
								uri.getPort(),
								config.getBasePath() + uri.getPath(), 
								uri.getQuery(), 
								uri.getFragment()
								).toString().replace("(", "{").replace(")", "}");
							String requestParams = Stream.of(m.getParameters())
								.filter(p -> p.isAnnotationPresent(RequestParam.class))
								.map(Parameter::getName)
								.collect(Collectors.joining(","));
							searchResource.add(Link.of(path + "{?" + requestParams + "}", m.getName()));
						} catch (URISyntaxException e) { e.printStackTrace(); }
					}
				}
				return searchResource;
			}};
		}
}
