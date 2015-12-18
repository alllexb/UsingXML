package com.xmlsample.shop;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.xmlsample.shop.products.Product;

public class Deal {
	private Date date = new Date();;
	private Party seller;
	private Party buyer;
	private Map<Product, Integer> products = new HashMap<Product,Integer>();
	
	public Deal(Party seller, Party buyer, Map<Product, Integer> products) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.products = products;
	}

	public Date getDate() {
		return date;
	}

	public Party getSeller() {
		return seller;
	}

	public Party getBuyer() {
		return buyer;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}
	
	public double getSum() {
		double result = 0;
		for (Map.Entry<Product, Integer> element: products.entrySet()) {
			result += element.getKey().getCost(element.getValue());
		}
		return result;
	}
	
	
	
}
