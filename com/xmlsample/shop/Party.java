package com.xmlsample.shop;

import java.util.Map;
import java.util.HashMap;

public class Party {
	private String name;
	private String address;
	private Map<String,String> properties = new HashMap<String, String>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public String setProperty(String key, String property) {
		return this.properties.put(key, property);
	}

}
