package com.xmlsample.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SecondDOMReadSample {

	public static void main(String[] args) {
		try {
			File xmlFile = new File("./src/main/java/lesson8/resource/company.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
			
			//normalize
			doc.getDocumentElement().normalize();
			
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

			NodeList nCompanyList = doc.getElementsByTagName("company");
			System.out.println("----------------------------");
			
			for (int companyCounter = 0; companyCounter < nCompanyList.getLength(); companyCounter++) {
				Node nCompany = nCompanyList.item(companyCounter);
				System.out.print("\nCurrent Element : " + nCompany.getNodeName());
				System.out.print(" with id = " + nCompany.getAttributes().getNamedItem("id").getNodeValue());
				System.out.println(" named : " + nCompany.getAttributes().getNamedItem("name").getNodeValue());
				
				Node departments = nCompany.getChildNodes().item(1);
				System.out.println("Current Element : " + departments.getNodeName());
				
				NodeList nDepartmentsList = departments.getChildNodes();
								
				for (int departmentsCounter = 0; departmentsCounter < nDepartmentsList.getLength(); departmentsCounter++) {
					Node nDepatrmentNode = nDepartmentsList.item(departmentsCounter);
					if (nDepatrmentNode.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("Current Element : " + nDepatrmentNode.getNodeName() + " named: " + nDepatrmentNode.getChildNodes().item(1).getTextContent());
						
						Node workers = nDepatrmentNode.getChildNodes().item(3);
						System.out.println("Current Element : " + workers.getNodeName());
						
						NodeList nWorkerList = workers.getChildNodes();
						for (int workersCounter = 0; workersCounter < nWorkerList.getLength(); workersCounter++ ) {
							Node nWorkerNode = nWorkerList.item(workersCounter);
							if (nWorkerNode.getNodeType() == Node.ELEMENT_NODE) {
								Element worker = (Element) nWorkerNode;
								
								System.out.println("Worker id : " + worker.getAttribute("id"));
								System.out.println("Name : " + worker.getElementsByTagName("name").item(0).getTextContent());
								System.out.println("Position : " + worker.getElementsByTagName("position").item(0).getTextContent());
								System.out.println("Salary : " + worker.getElementsByTagName("salary").item(0).getTextContent());
								
							}
						}
					}
				}
				
			}
			
			
			
		} catch (SAXException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

}
