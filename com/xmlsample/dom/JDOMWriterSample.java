package com.xmlsample.dom;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMWriterSample {

	public static void main(String[] args) {
		
		try {
			
			Element company = new Element("company");
			Document document = new Document();
			document.setRootElement(company);
		
			Element staff = new Element("staff");
			staff.setAttribute(new Attribute("id", "1"));
			staff.addContent(new Element("firstname").setText("yong"));
			staff.addContent(new Element("lastname").setText("mook kim"));
			staff.addContent(new Element("nickname").setText("mkyong"));
			staff.addContent(new Element("salary").setText("199999"));
		
			document.getRootElement().addContent(staff);
		
			Element staff2 = new Element("staff");
			staff2.setAttribute(new Attribute("id", "2"));
			staff2.addContent(new Element("firstname").setText("low"));
			staff2.addContent(new Element("lastname").setText("yin fong"));
			staff2.addContent(new Element("nickname").setText("fong fong"));
			staff2.addContent(new Element("salary").setText("188888"));
		
			document.getRootElement().addContent(staff2);
		
			XMLOutputter outputter = new XMLOutputter();
		
			outputter.setFormat(Format.getPrettyFormat());
		
			outputter.output(document, new FileWriter("./src/main/java/lesson8/resource/jdom_xml.xml"));
			
			System.out.println("well done!");
			
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
		
	}

}
