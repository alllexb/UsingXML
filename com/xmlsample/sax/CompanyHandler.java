package com.xmlsample.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CompanyHandler extends DefaultHandler {
	private int workerId = 0; 
	
	private boolean cWorker = false;
	private boolean cWorkerName = false;
	private boolean cWorkerPosition = false;
	private boolean cWorkerSalary = false;
	
	CompanyHandler(){
		super();
	}
	
	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (cWorker) {
			if (cWorkerName) System.out.println("Name : " + new String(ch, start, length));
			if (cWorkerPosition) System.out.println("Position : " + new String(ch, start, length));
			if (cWorkerSalary) System.out.println("Salary : " + new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("WORKER")) { 
			cWorker = false;
			cWorkerName = false;
			cWorkerPosition = false;
			cWorkerSalary = false;
		}
		if (cWorkerName && qName.equalsIgnoreCase("NAME")) cWorkerName = false;
		if (cWorkerPosition && qName.equalsIgnoreCase("POSITION")) cWorkerPosition = false;
		if (cWorkerSalary && qName.equalsIgnoreCase("SALARY")) cWorkerSalary = false;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("WORKER") && attributes.getValue("id").equals(String.valueOf(workerId))) { 
			cWorker = true;
		}
		if (cWorker) {
			if (qName.equalsIgnoreCase("NAME")) cWorkerName = true;
			if (qName.equalsIgnoreCase("POSITION")) cWorkerPosition = true;
			if (qName.equalsIgnoreCase("SALARY")) cWorkerSalary = true;
		}
		
	}

	
}
