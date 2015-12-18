package com.xmlsample.jaxb.classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Worker {

	String name;
	int age;
	int salary;
	int id;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	
	public int getSalary() {
		return salary;
	}

	@XmlElement
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + ", salary=" + salary + ", id=" + id + "]";
	}

	
}
