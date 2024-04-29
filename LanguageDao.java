package spring_hibernate_xml_mtm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import spring_hibernate_xml_mtm.dto.Language;

public class LanguageDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("shivani").createEntityManager();
	}
	
	public void saveLanguage(Language language) {
		
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(language);
		transaction.commit();
	}
	
	public void findLanguage(int id) {
		EntityManager manager = getEntityManager();
		Language language = manager.find(Language.class, id);
		
		if (language!=null) {
			System.out.println(language);
		}else {
			System.out.println("language not found!");
		}
	}
	
	public void deleteLanguage(int id) {
		EntityManager manager = getEntityManager();
		Language language = manager.find(Language.class, id);
		
		if (language!=null) {
			EntityTransaction transaction = manager.getTransaction();
			
			transaction.begin();
			manager.remove(language);
			transaction.commit();
		}else {
			System.out.println("No language found!");
		}
	}
	
	public void updateLanguage(int id, Language language) {
		
		EntityManager manager = getEntityManager();
		Language language1 = manager.find(Language.class, id);
		
		if (language1!=null) {
			EntityTransaction transaction = manager.getTransaction();
			language.setId(id);
			
			language.setId(language1.getId());
			transaction.begin();
			manager.merge(language1);
			transaction.commit();
		}else {
			System.out.println("No language found!");
		}
	}
	
	public void updateBoth(int id,Language language) {
		EntityManager manager = getEntityManager();
		Language language2 = manager.find(Language.class, id);
		
		if (language2!=null) {
			
			language.setId(id);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(language.getId());
			manager.merge(language);
			transaction.commit();	
		}else {
			System.out.println("no language found!");
		}
	}
}
