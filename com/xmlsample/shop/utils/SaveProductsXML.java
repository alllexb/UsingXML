package com.xmlsample.shop.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.xmlsample.shop.DealProcess;

public class SaveProductsXML {
	
	public static void save(DealProcess process) {
	
		try {
			File file = new File("./src/main/java/lesson8/shop/resource/products.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(DealProcess.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(process, file);
//			jaxbMarshaller.marshal(company, System.out);
			
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
		
	}
}
