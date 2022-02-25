package cl.malvarez.spring.backcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.malvarez.spring.backcrud.dao.DaoPerson;
import cl.malvarez.spring.backcrud.entity.Person;

@Service
public class ServicePersonImpl implements ServicePerson {
	
	//private DaoPerson daoPerson;
	
	@Override
	public Person getPersona(Integer id) {
		return DaoPerson.getPerson(id);
	}
	
	@Override
	public Person addPersona(Person per) {
		return DaoPerson.addPerson(per);
	}
	
	@Override
	public List<Person> getAllPersonas() {
		return DaoPerson.getAllPersons();
	}
	
	@Override
    public Person updatePersona(Person per) {
        return DaoPerson.updatePerson(per);
    }
	
	@Override
    public void deletePersona(Integer id) {
        DaoPerson.deletePerson(id);
    }
	
}
