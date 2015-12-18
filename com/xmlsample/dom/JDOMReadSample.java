package com.xmlsample.dom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMReadSample {

	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("./src/main/java/lesson8/resource/company.xml");
		
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> companyList = rootNode.getChildren("company");
			
			for (int i = 0; i < companyList.size(); i++) {
				Element company = companyList.get(i);
				System.out.println("Company ID: " + company.getAttribute("id").getValue());
				System.out.println("Company name: " + company.getAttribute("name").getValue());
				
				List<Element> departments = company.getChildren("departments").get(0).getChildren("department");
				
				for(int j = 0; j < departments.size(); j++) {
					Element department = departments.get(j);
					System.out.println("\tDepartment name: " + department.getChildText("name"));
					
					List<Element> workers = department.getChildren("workers").get(0).getChildren("worker");
					
					for(int k = 0; k < workers.size(); k++) {
						Element worker = workers.get(k);
						System.out.println("\t\tWorker ID: " + worker.getAttribute("id").getValue());
						System.out.println("\t\tWorker name: " + worker.getChildText("name"));
						System.out.println("\t\tWorker position: " + worker.getChildText("position"));
						System.out.println("\t\tWorker salary: " + worker.getChildText("salary"));
						System.out.println();
					}
				}
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
