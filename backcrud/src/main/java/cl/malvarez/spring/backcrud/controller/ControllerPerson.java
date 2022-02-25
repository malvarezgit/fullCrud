package cl.malvarez.spring.backcrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import cl.malvarez.spring.backcrud.exception.BadRequestException;
import cl.malvarez.spring.backcrud.service.ServicePerson;


/**
 * Clase responsable de procesar las solicitudes de API REST entrantes, preparar un modelo 
 * y devolver la vista para que se muestre como respuesta.
 * 
 * @author malvarez
 */

/*
 Nota: Como buena practica se puede retornar un value object (asi no se llega al cliente con una entidad persistente), 
 el VO es la representacion de la entidad, ademas existen las clases Mappers que copian los datos de la 
 entidad base datos a su equivalente value object.  Por temas de tiempo no se implementa VO y Mappers.
*/

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@Validated
public class ControllerPerson {

	@Autowired
	private ServicePerson servicePerson;

	/**
	 * Metodo que retorna la persona segun el id.
	 * Notar que se implementa un ejemplo de mensajes y/o control de errores.
	 * @param id
	 * @return
	 * @author malvarez
	 */
	@GetMapping("/person/{id}")
	@ResponseBody
	public Person obtenerPersona(@PathVariable(value = "id") Integer id) {
		Person person = servicePerson.getPersona(id);
		
		if (person==null) { //TODO: Ejemplo: Control de errores o mensajes (los demas metodos no se implementa por tiempo)
			throw new BadRequestException("Persona no encontrada.");
		}
		
		return person;
	}

	/**
	 * Metodo que permite agregar una persona nueva.
	 * @param per
	 * @return
	 */
	@PostMapping("/person")
	public Person agregarPersona(@RequestBody Person per) {
		return servicePerson.addPersona(per);
	}

	/**
	 * Metodo que retorna todas las personas existentes.
	 * @return
	 */
	@GetMapping("/persons")
	public List<Person> listarPersonas() {
		List<Person> lista = servicePerson.getAllPersonas();
		return lista;
	}

	/**
	 * Metodo que actualiza los datos de la persona.
	 * @param id
	 * @param personaDet
	 * @return
	 */
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

	/**
	 * Metodo que elimina a una persona.
	 * @param id
	 * @return
	 * @throws Exception
	 */
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
