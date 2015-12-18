package com.xmlsample.shop;

import com.xmlsample.shop.utils.SaveProductsXML;

public class Main {
	public static void main (String[] args) {
		DealProcess makedeals = new DealProcess();
		makedeals.input();
		makedeals.input();
		makedeals.output();
		
		SaveProductsXML.save(makedeals);
	}
}
