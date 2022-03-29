package en.sunny.inheritance.rest;

import java.util.Date;
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
				@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
				@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")Date to,
				PersistentEntityResourceAssembler assembler) { 
		List<Publication> partidos = publicationADO.betweenDates(from, to); 
		return assembler.toCollectionModel(partidos); 
	}
}
