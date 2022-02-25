package cl.malvarez.spring.backcrud.service;

import java.util.List;

import cl.malvarez.spring.backcrud.entity.Person;

public interface ServicePerson {
	Person getPersona(Integer id);
	
	Person addPersona(Person per);
	
	List<Person> getAllPersonas();
	
	Person updatePersona(Person per);
	
	void deletePersona(Integer id);
}
