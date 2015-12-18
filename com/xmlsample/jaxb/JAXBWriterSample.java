package com.xmlsample.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.xmlsample.jaxb.classes.Company;
import com.xmlsample.jaxb.classes.Worker;

public class JAXBWriterSample {

	public static void main(String[] args) {
		Worker worker1 = new Worker();
		worker1.setId(1);
		worker1.setName("Alexander");
		worker1.setAge(30);
		worker1.setSalary(500);
		
		Worker worker2 = new Worker();
		worker2.setId(2);
		worker2.setName("Kiril");
		worker2.setAge(30);
		worker2.setSalary(2100);
		
		List<Worker> workers = new ArrayList<Worker>();
		workers.add(worker1);
		workers.add(worker2);
		
		Company company = new Company();
		company.setId(1);
		company.setName("Epam");
		company.setWorkers(workers);
		
		try {
			File file = new File("./src/main/java/lesson8/resource/jaxb_resalt.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class, Worker.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(company, file);
			jaxbMarshaller.marshal(company, System.out);
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
		
	}

}
