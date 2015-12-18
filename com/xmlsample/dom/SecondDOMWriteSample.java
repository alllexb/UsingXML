package com.xmlsample.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SecondDOMWriteSample {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// create root element "company_list" 
			Document document = builder.newDocument();
			Element rootElement = document.createElement("company_list");
			document.appendChild(rootElement);
			
			// create "company"
			Element firstCompany = document.createElement("company");
			rootElement.appendChild(firstCompany);
			Attr firstCompanyIdAttribute= document.createAttribute("id");
			firstCompanyIdAttribute.setValue("1");
			Attr firstCompanyNameAttribute= document.createAttribute("name");
			firstCompanyNameAttribute.setValue("Oracle");
			firstCompany.setAttributeNode(firstCompanyIdAttribute);
			firstCompany.setAttributeNode(firstCompanyNameAttribute);
			
			// create departments
			Element firstCompanyDepartments = document.createElement("departments");
			firstCompany.appendChild(firstCompanyDepartments);
			
			// create departments.department
			Element firstCompanyFirstDepartment = document.createElement("department");
			firstCompanyDepartments.appendChild(firstCompanyFirstDepartment);
			
			// create departments.department.name
			Element firstCompanyFirstDepartmentName = document.createElement("name");
			firstCompanyFirstDepartmentName.appendChild(document.createTextNode("Java Core Department"));
			firstCompanyFirstDepartment.appendChild(firstCompanyFirstDepartmentName);
			
			 // create departments.department.workers
			Element firstCompanyFirstDepartmentWorkers = document.createElement("workers");
			firstCompanyFirstDepartment.appendChild(firstCompanyFirstDepartmentWorkers);
			
			// create departments.department.workers.worker id=1
			Element fcfdFirstWorker = document.createElement("worker");
			Attr fcfdFirstWorkerId = document.createAttribute("id");
			fcfdFirstWorkerId.setValue("1");
			fcfdFirstWorker.setAttributeNode(fcfdFirstWorkerId);
			
			Element fcfdFirstWorkerName = document.createElement("name");
			fcfdFirstWorkerName.appendChild(document.createTextNode("Alexander"));
			fcfdFirstWorker.appendChild(fcfdFirstWorkerName);
			
			Element fcfdFirstWorkerPosition = document.createElement("position");
			fcfdFirstWorkerPosition.appendChild(document.createTextNode("Programmer"));
			fcfdFirstWorker.appendChild(fcfdFirstWorkerPosition);
			
			Element fcfdFirstWorkerSalary = document.createElement("salary");
			fcfdFirstWorkerSalary.appendChild(document.createTextNode("500"));
			fcfdFirstWorker.appendChild(fcfdFirstWorkerSalary);
			
			firstCompanyFirstDepartmentWorkers.appendChild(fcfdFirstWorker);
			
			// create departments.department.workers.worker id=2
			Element fcfdSecondWorker = document.createElement("worker");
			Attr fcfdSecondWorkerId = document.createAttribute("id");
			fcfdSecondWorkerId.setValue("2");
			fcfdSecondWorker.setAttributeNode(fcfdSecondWorkerId);
			
			Element fcfdSecondWorkerName = document.createElement("name");
			fcfdSecondWorkerName.appendChild(document.createTextNode("Yuriy"));
			fcfdSecondWorker.appendChild(fcfdSecondWorkerName);
			
			Element fcfdSecondWorkerPosition = document.createElement("position");
			fcfdSecondWorkerPosition.appendChild(document.createTextNode("Programmer"));
			fcfdSecondWorker.appendChild(fcfdSecondWorkerPosition);
			
			Element fcfdSecondWorkerSalary = document.createElement("salary");
			fcfdSecondWorkerSalary.appendChild(document.createTextNode("1500"));
			fcfdSecondWorker.appendChild(fcfdSecondWorkerSalary);
			
			firstCompanyFirstDepartmentWorkers.appendChild(fcfdSecondWorker);
			
			// create departments.department.workers.worker id=3
			Element fcfdThirdWorker = document.createElement("worker");
			Attr fcfdThirdWorkerId = document.createAttribute("id");
			fcfdThirdWorkerId.setValue("3");
			fcfdThirdWorker.setAttributeNode(fcfdThirdWorkerId);
			
			Element fcfdThirdWorkerName = document.createElement("name");
			fcfdThirdWorkerName.appendChild(document.createTextNode("Jane"));
			fcfdThirdWorker.appendChild(fcfdThirdWorkerName);
			
			Element fcfdThirdWorkerPosition = document.createElement("position");
			fcfdThirdWorkerPosition.appendChild(document.createTextNode("Manager"));
			fcfdThirdWorker.appendChild(fcfdThirdWorkerPosition);
			
			Element fcfdThirdWorkerSalary = document.createElement("salary");
			fcfdThirdWorkerSalary.appendChild(document.createTextNode("2000"));
			fcfdThirdWorker.appendChild(fcfdThirdWorkerSalary);
			
			firstCompanyFirstDepartmentWorkers.appendChild(fcfdThirdWorker);
			
			//
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("./src/main/java/lesson8/resource/new_company.xml"));
		
			transformer.transform(source, result);
			
			System.out.println("File saved!");
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
