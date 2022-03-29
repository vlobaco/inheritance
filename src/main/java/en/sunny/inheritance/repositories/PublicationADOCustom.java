package en.sunny.inheritance.repositories;

import java.time.Instant;
import java.util.List;

import en.sunny.inheritance.entities.Publication;

public interface PublicationADOCustom {
	List<Publication> betweenDates(Instant from, Instant to);
}
