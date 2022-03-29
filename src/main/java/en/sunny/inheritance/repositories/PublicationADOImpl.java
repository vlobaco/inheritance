package en.sunny.inheritance.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import en.sunny.inheritance.entities.Publication;

public class PublicationADOImpl {
	
	@PersistenceContext
	EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	List<Publication> betweenDates(Date from, Date to) {
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
