package en.sunny.inheritance.repositories;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import en.sunny.inheritance.entities.Publication;

@Transactional(readOnly = true)
public class PublicationADOImpl implements PublicationADOCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Publication> betweenDates(Instant from, Instant to) {
		List<Publication> publications = new ArrayList<Publication>();
		String SQL = "SELECT * FROM PUBLICATIONS WHERE PUB_DATE BETWEEN ?1 AND ?2";
		Query query = entityManager.createQuery(SQL);
		query.setParameter(1, from);
		query.setParameter(2, to);
		query.getResultStream().forEach(o -> 
				publications.add((Publication)o));
		return publications;
	}
	
}
