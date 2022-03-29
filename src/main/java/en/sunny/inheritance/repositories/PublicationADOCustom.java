package en.sunny.inheritance.repositories;

import java.util.Date;
import java.util.List;

import en.sunny.inheritance.entities.Publication;

public interface PublicationADOCustom {
	List<Publication> betweenDates(Date from, Date to);
}
