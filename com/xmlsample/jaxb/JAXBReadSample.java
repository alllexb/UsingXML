package com.xmlsample.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.xmlsample.jaxb.classes.Company;
import com.xmlsample.jaxb.classes.Worker;

public class JAXBReadSample {
	public static void main(String[] args) {
		try {
			File file = new File("./src/main/java/lesson8/resource/jaxb_resalt.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class, Worker.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Company company = (Company) jaxbUnmarshaller.unmarshal(file);
			
			System.out.println(company);

			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
