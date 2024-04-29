package spring_hibernate_xml_mtm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_hibernate_xml_mtm.dao.PersonDao;
import spring_hibernate_xml_mtm.dto.Language;
import spring_hibernate_xml_mtm.dto.Person;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ApplicationContext context = new ClassPathXmlApplicationContext("mtm.xml");
		Person person1 = context.getBean("p1", Person.class);
		Person person2 = context.getBean("p2", Person.class);
		PersonDao pdao = context.getBean("pdao", PersonDao.class);

		System.out.println(
				"Enter your choice : \n1.savePerson\n2.find Person\n3.delete Person\n4.update Person\n5.update Both");
		switch (scanner.nextInt()) {
		case 1: {
			pdao.savePerson(person1);
			pdao.savePerson(person2);
		}
			break;

		case 2: {
			pdao.findPerson(1);
		}
			break;

		case 3: {
			pdao.deletePerson(20);
		}
			break;

		case 4: {
			pdao.updatePerson(1, person1);
		}
			break;

		case 5: {
			pdao.updateBoth(2, person2);
		}
			break;
		default:
			break;
		}

	}
}
