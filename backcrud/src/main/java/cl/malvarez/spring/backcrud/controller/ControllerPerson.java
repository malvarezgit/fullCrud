package cl.malvarez.spring.backcrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.malvarez.spring.backcrud.entity.Person;
import cl.malvarez.spring.backcrud.entity.Phone;
import cl.malvarez.spring.backcrud.service.ServicePerson;

@RestController
@RequestMapping("/api")
@Validated
public class ControllerPerson {

	@Autowired
	private ServicePerson servicePerson;

	@GetMapping("/person/{id}")
	@ResponseBody
	public Person obtenerPersona(@PathVariable(value = "id") Integer id) {
		return servicePerson.getPersona(id);
	}

	@PostMapping("/person")
	public Person agregarPersona(@RequestBody Person per) {
		return servicePerson.addPersona(per);
	}

	@GetMapping("/persons")
	public List<Person> listarPersonas() {
		List<Person> lista = servicePerson.getAllPersonas();
		return lista;
	}

	@PutMapping("/person/{id}")
	public ResponseEntity<Person> actualizarPersona(@PathVariable(value = "id") Integer id, @RequestBody Person personaDet) {

		Person person = servicePerson.getPersona(id);

		person.setName(personaDet.getName());
		person.setEmail(personaDet.getEmail());
		person.setPassword(personaDet.getPassword());
		Phone phone = personaDet.getPhone();
		person.setPhone(phone);

		final Person updatedPerson = servicePerson.updatePersona(person);
		return ResponseEntity.ok(updatedPerson);
	}

	@DeleteMapping("/person/{id}")
	public Map<String, Boolean> deletePersona(@PathVariable(value = "id") Integer id) throws Exception {
		boolean result = false;
		Person person = servicePerson.getPersona(id);
		if (person!=null) {
			result = true;
			servicePerson.deletePersona(id);
		}
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", result);
		return response;
	}

}
