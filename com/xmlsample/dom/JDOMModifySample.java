package com.xmlsample.dom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMModifySample {
	public static void main(String[] args) {
		try {
			
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("./src/main/java/lesson8/resource/jdom_mod_file.xml");
				
			Document document = builder.build(xmlFile);
			
			Element rootNode = document.getRootElement();
			
			Element staff = rootNode.getChild("staff");
			staff.getAttribute("id").setValue("2");
			
			Element age = new Element("age").setText("28");
			staff.addContent(age);
			
			staff.getChild("salary").setText("7000");
			
			staff.removeChild("firstname");
			
			XMLOutputter outputter = new XMLOutputter();
			
			outputter.setFormat(Format.getPrettyFormat());
			outputter.output(document, new FileWriter(xmlFile.getPath()));
			
			System.out.println("Well done!");
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
