package com.xmlsample.shop.products;

import javax.xml.bind.annotation.XmlElement;

public abstract class Product {
	public static final int DEF_DISCOUNT = 10;
	
	private String title;
	private double price;
	private String description;
	
	public Product() {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Product product = (Product) obj;
        
		return (this.title != null && this.title == product.getTitle()) 
				&& this.price == product.getPrice();
	}
	
	
	public double getCost(int quantity) {
		double realCost = price*quantity; 
		return realCost - realCost*calcDiscont(quantity)/100;
	}
	
	protected int calcDiscont(int quantity) {
		if (quantity > 10) { 
			return DEF_DISCOUNT;
		} else {
			return 0;
		}
	}
}
