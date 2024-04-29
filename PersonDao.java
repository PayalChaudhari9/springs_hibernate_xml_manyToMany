package spring_hibernate_xml_mtm.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import antlr.debug.TraceAdapter;
import spring_hibernate_xml_mtm.dto.Language;
import spring_hibernate_xml_mtm.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("shivani").createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		List<Language> lang = person.getLang();

		transaction.begin();
		for (Language language : lang) {
			manager.persist(language);
		}
		manager.persist(person);
		transaction.commit();

	}

	public void findPerson(int id) {
		EntityManager manager = getEntityManager();
		Person person = manager.find(Person.class, id);

		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("No person found!");
		}
	}

	public void deletePerson(int id) {
		EntityManager manager = getEntityManager();
		Person person = manager.find(Person.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if (person != null) {
			List<Language> lang = person.getLang();
			transaction.begin();
			for (Language language : lang) {
				manager.remove(lang);
			}
			manager.remove(person);
			transaction.commit();
		} else {
			System.out.println("No person found!");
		}
	}

	public void updatePerson(int id, Person erson) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person person1 = manager.find(Person.class, id);
		if (person1 != null) {
			person1.setId(id);
			person1.setLang(person1.getLang());
			transaction.begin();
			manager.merge(person1);
			transaction.commit();
		} else {
			System.out.println("no person found with id" + id);
		}
	}

	public void updateBoth(int id, Person person) {

		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person person2 = manager.find(Person.class, id);
		if (person2 != null) {
			person.setId(id);
			for (int i = 0; i < person2.getLang().size(); i++) {
				person.getLang().get(i).setId(person2.getLang().get(i).getId());
			}
			transaction.begin();
			for (Language language : person.getLang()) {
				manager.merge(language);
			}
			manager.merge(person);
			transaction.commit();
		} else {
			System.out.println("no person found with id" + id);
		}
	}
}
