package com.xmlsample.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SecondSAXSample {

	public static void main(String[] args) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			CompanyHandler handler = new CompanyHandler();
			handler.setWorkerId(7);
			parser.parse("./src/main/java/lesson8/resource/company.xml", handler);
			
			handler.setWorkerId(1);
			parser.parse("./src/main/java/lesson8/resource/company.xml", handler);
			
			handler.setWorkerId(12);
			parser.parse("./src/main/java/lesson8/resource/company.xml", handler);
			
			System.out.println("\nParse all workers by ID: \n");
			for (int i = 1; i <= 12; i++) {
				handler.setWorkerId(i);
				parser.parse("./src/main/java/lesson8/resource/company.xml", handler);
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
