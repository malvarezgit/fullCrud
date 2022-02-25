package cl.malvarez.spring.backcrud.service;

import java.util.List;

import cl.malvarez.spring.backcrud.entity.Person;

public interface ServicePerson {
	/**
	 * Obtiene la persona a partir del id.
	 * @param id
	 * @return
	 */
	Person getPersona(Integer id);
	
	/**
	 * Agrega la persona.
	 * @param per
	 * @return
	 */
	Person addPersona(Person per);
	
	/**
	 * Retorna todas las personas existentes.
	 * @return
	 */
	List<Person> getAllPersonas();
	
	/**
	 * Actualiza la persona.
	 * @param per
	 * @return
	 */
	Person updatePersona(Person per);
	
	/**
	 * Elimina la persona.
	 * @param id
	 */
	void deletePersona(Integer id);
}
