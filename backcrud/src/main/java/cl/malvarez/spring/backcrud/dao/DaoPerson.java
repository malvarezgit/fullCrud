package cl.malvarez.spring.backcrud.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.malvarez.spring.backcrud.entity.Person;
import cl.malvarez.spring.backcrud.entity.Phone;

public class DaoPerson {
	private static final Map<Integer, Person> persMap = new HashMap<Integer, Person>();

	static {
		init();
	}
	
	private static void init() {
		Phone pho1 = new Phone("1234567", "1", "57");
		Person per1 = new Person(1, "Juan Rodriguez", "juan@rodriguez.org", "hunter2", pho1);

		persMap.put(per1.getId(), per1);
	}
	
    public static Person getPerson(Integer id) {
        return persMap.get(id);
    }

    public static Person addPerson(Person per) {
        persMap.put(per.getId(), per);
        return per;
    }

    public static Person updatePerson(Person per) {
        persMap.put(per.getId(), per);
        return per;
    }

    public static void deletePerson(Integer id) {
        persMap.remove(id);
    }

    public static List<Person> getAllPersons() {
        Collection<Person> c = persMap.values();
        List<Person> list = new ArrayList<Person>();
        list.addAll(c);
        return list;
    }
    
}
