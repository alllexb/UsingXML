package com.xmlsample.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SecondDOMModifySample {

	public static void main(String[] args) {
		try {
			String modFilePath = "./src/main/java/lesson8/resource/new_file_for_mod.xml";
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(modFilePath);

			Node company = document.getElementsByTagName("company").item(0);
			System.out.println("Root element: " + company.getNodeName());
			
			Node staff = document.getElementsByTagName("staff").item(0);
			
			Node staffId= staff.getAttributes().getNamedItem("id");
			staffId.setNodeValue("2");
			
			Element staffAge = document.createElement("age");
			staffAge.appendChild(document.createTextNode("28"));
			staff.appendChild(staffAge);
			
			NodeList staffElements = staff.getChildNodes();
			
			for (int i = 0; i < staffElements.getLength(); i++) {
				
				Node node = staffElements.item(i);
				
				if ("firstname".equals(node.getNodeName())) {
					staff.removeChild(node);
				}
				
				if("salary".equals(node.getNodeName())) {
					node.setTextContent("200000");
				}
				
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult result = new StreamResult(new File(modFilePath));
			DOMSource source = new DOMSource(document);
			
			transformer.transform(source, result);
			
			System.out.println("Well done!");
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
