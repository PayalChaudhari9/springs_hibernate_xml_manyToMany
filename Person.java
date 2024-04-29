package spring_hibernate_xml_mtm.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	@Id
	private int id;
	private String name;
	private long phone;
	private String address;
	@ManyToMany
	private List<Language>lang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Language> getLang() {
		return lang;
	}

	public void setLang(List<Language> lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
}
