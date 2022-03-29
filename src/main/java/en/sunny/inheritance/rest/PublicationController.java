package en.sunny.inheritance.rest;

import java.time.Instant;
import java.util.List;

import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import en.sunny.inheritance.entities.Publication;
import en.sunny.inheritance.repositories.PublicationADO;

@RepositoryRestController
public class PublicationController {
	private PublicationADO publicationADO;
	
	public PublicationController(PublicationADO publicationADO) {
		this.publicationADO=publicationADO;
	}
	
	@GetMapping("/publications/search/betweenDates")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> betweenDates (
				@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Instant from,
				@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") Instant to,
				PersistentEntityResourceAssembler assembler) { 
		List<Publication> publications = publicationADO.betweenDates(from, to); 
		return assembler.toCollectionModel(publications); 
	}
}
