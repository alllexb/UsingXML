package com.xmlsample.shop.products;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BootsProduct extends Product {
	
	private String color; 
	private int size;
	
	public BootsProduct() {
		super();
	}
	
	public BootsProduct(String color, int size) {
		super();
		this.color = color;
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	@XmlElement
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getSize() {
		return size;
	}
	
	@XmlElement
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
	    }
	    if (obj == null || obj.getClass() != this.getClass()) {
	    	return false;
	    }

	    BootsProduct product = (BootsProduct) obj;
	        
		return super.equals(obj) && (this.color != null && this.color.equals(product.getColor())) 
					&& this.size == product.getSize();
	}
		
	@Override
	public String toString() {
		return "Boots: title - "+ getTitle() +"; size - " + size + "; color - " + color 
				+ "; price - " + String.format("%.2f" ,getPrice());
	}
}
