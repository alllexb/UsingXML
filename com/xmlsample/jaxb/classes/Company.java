package com.xmlsample.jaxb.classes;

import java.util.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {

	String name;
	List<Worker> workers = new ArrayList<Worker>();
	int id;
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public List<Worker> getWorkers() {
		return workers;
	}
	
	@XmlElementWrapper(name = "workers")
	@XmlElement(name = "worker")
	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
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
		String company = "Company [name=" + name + ", \nworkers:";
		for (Worker worker: workers) 
			company += "\n\t" + worker.toString();
		return company + ",\nid=" + id + "]";
	}
	
	
}
