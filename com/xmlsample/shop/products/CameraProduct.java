package com.xmlsample.shop.products;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CameraProduct extends Product {
	
	boolean digetal;
	int megapixels;
	
	public CameraProduct() {
		super();
	}
	
	public CameraProduct(boolean digetal, int megapixels) {
		super();
		this.digetal = digetal;
		this.megapixels = megapixels;
	}
	
	public boolean isDigetal() {
		return digetal;
	}

	@XmlElement
	public void setDigetal(boolean digetal) {
		this.digetal = digetal;
	}
	
	public int getMegapixels() {
		return megapixels;
	}
	
	@XmlElement
	public void setMegapixels(int megapixels) {
		this.megapixels = megapixels;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
	    }
	    if (obj == null || obj.getClass() != this.getClass()) {
	    	return false;
	    }

	    CameraProduct product = (CameraProduct) obj;
	        
		return super.equals(obj) && (this.digetal == product.isDigetal()) 
					&& this.megapixels == product.getMegapixels();
	}

	@Override
	protected int calcDiscont(int quantity) {
		int def = super.calcDiscont(quantity);
		if (!digetal) {
			def += 20;
		}
		return def;
	}

	@Override
	public String toString() {
		String digetal = "digetal";
		if (!this.digetal) digetal = "analog";
		return "Camera: title - "+ getTitle() +"; type - " + digetal + "; megapixels - " + megapixels   
				+ "; price - " + String.format("%.2f" ,getPrice());
	}
	
	
	
}
