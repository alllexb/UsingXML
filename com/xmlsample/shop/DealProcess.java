package com.xmlsample.shop;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.xmlsample.shop.utils.KeyboardProcessor;
import com.xmlsample.shop.products.*;

@XmlRootElement(name = "products")
public class DealProcess {
	private Collection<Deal> deals = new LinkedList<Deal>();
	private List<Product> camerasDataBase = new ArrayList<Product>();
	private List<Product> bootsDataBase = new ArrayList<Product>();
	private KeyboardProcessor keyboard; 
	
	public void input() {
			Deal deal = inputDeal();
			deals.add(deal);
	}
	
	private Deal inputDeal() {
		Party buyer = null;
		Party seller = null;
		Map<Product, Integer> products = new HashMap<Product,Integer>();
		keyboard = new KeyboardProcessor();
		try {
			buyer = inputParty("buyer");
			seller = inputParty("seller");
			for (int i = 0; true; i++) {
				System.out.println("Adding products: ");
				System.out.println("What kind of product do you want to add? \n 1 -> Camera \n 2 -> Boots");
				int productType = 0;
				while (true) {
					productType = keyboard.readInteger("Please, input product type");
					if (productType == 1 || productType == 2) break;
				}
				Product product;
				switch (productType) {
					case 1: 
						product = selectProduct(camerasDataBase);
						if (product == null) {
							product = inputCameraProduct(String.valueOf(i+1));
							if (camerasDataBase.contains(product)) {
								System.out.println("This product is already in memory!");
								product = camerasDataBase.get(camerasDataBase.indexOf(product));
								System.out.println(product);
							} else {
								camerasDataBase.add(product);
							}
						} else {
							camerasDataBase.add(product);
						}
						break;
					case 2:
					default:
						product = selectProduct(bootsDataBase);
						if (product == null) {
							product = inputBootsProduct(String.valueOf(i+1));
							if (bootsDataBase.contains(product)) {
								System.out.println("This product is already in memory!");
								product = bootsDataBase.get(bootsDataBase.indexOf(product));
								System.out.println(product);
							} else {
								bootsDataBase.add(product);
							}
						} else {
							bootsDataBase.add(product);
						}
				}
				int quantity = keyboard.readInteger("Please, input " + String.valueOf(i+1) + " product quantity");
				products.put(product, quantity);
				if (!keyboard.readString("Add one more product? 'yes' for agree" ).toLowerCase().equals("yes")) break; 
			}
			
		} catch (IOException e) {
			System.out.println("Keyboard input fatal error!");
		} finally {
//			keyboard.closeKeybord();
		}
		return new Deal(buyer, seller, products);
	}
		
	private Party inputParty(String reason) throws IOException {
		String name = keyboard.readString("Please, input " + reason + " name");
		Party party = new Party();
		party.setName(name);
		return party;
	}
	
	private BootsProduct inputBootsProduct(String reason) throws IOException {
		String color = keyboard.readString("Please, input boots color");
		int size = keyboard.readInteger("Please, input boots size");
		BootsProduct boots = new BootsProduct(color, size);
		inputProduct(reason, boots);
		return boots;
	}
	
	private CameraProduct inputCameraProduct(String reason) throws IOException {
		System.out.println("Type of camera 1 -> digetal, 2 -> analog.");
		int cameraType = 0;
		while (true) {
			cameraType = keyboard.readInteger("Please, input camera type");
			if (cameraType == 1 || cameraType == 2) break;
		}	
		int megapixels = keyboard.readInteger("Please, input camera matrix resolution");
		CameraProduct camera;
		switch (cameraType) {
			case 1: 
				camera = new CameraProduct(true, megapixels);
				break;
			case 2: 
			default:
				camera = new CameraProduct(false, megapixels);
		}
		inputProduct(reason, camera);
		return camera; 
	}
	
	private void inputProduct(String reason, Product product) throws IOException {
		String title = keyboard.readString("Please, input " + reason + " product title");
		double price = keyboard.readDouble("Please, input " + reason + " product price");
		product.setTitle(title);
		product.setPrice(price);
	}
	
	private Product selectProduct(List<Product> products) throws IOException {
		if (products.isEmpty()) return null; 
		if (!keyboard.readString("Do you want to add product from list? 'yes' for agree" ).toLowerCase().equals("yes")) return null; 
		for (int i = 0; i < products.size(); i++) {
			System.out.println(i + ". " + products.get(i).toString());
		}
		int productPosition = 0;
		while (true) {
			productPosition = keyboard.readInteger("Please, input product type");
			if (productPosition >= 0 && productPosition < products.size()) break;
		}
		return products.get(productPosition);
	}
	
	
	public void output() {
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
		for (Deal deal: deals) {
			System.out.println("Deal: " + dataFormat.format((deal.getDate())));
			System.out.println("   " + deal.getBuyer().getName() + " buys in " + deal.getSeller().getName() + ": ");
			for (Map.Entry<Product, Integer> product: deal.getProducts().entrySet()) {
				System.out.println(product.getKey().toString() + "; quantity - " + product.getValue()   
								   + ";  its costs: " + String.format("%.2f", product.getKey().getCost(product.getValue())));
			}
			System.out.println("   " + "Total sum: " + String.format("%.2f",deal.getSum()));
		}
	}

	protected List<Product> getCamerasDataBase() {
		return camerasDataBase;
	}
	
	@XmlElementWrapper(name = "cameres")
	@XmlElement(name = "camera", type = CameraProduct.class)
	protected void setCamerasDataBase(List<Product> camerasDataBase) {
		this.camerasDataBase = camerasDataBase;
	}

	protected List<Product> getBootsDataBase() {
		return bootsDataBase;
	}

	@XmlElementWrapper(name = "shoes")
	@XmlElement(name = "boots", type = BootsProduct.class)
	protected void setBootsDataBase(List<Product> bootsDataBase) {
		this.bootsDataBase = bootsDataBase;
	}

}

