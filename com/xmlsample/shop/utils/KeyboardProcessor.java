package com.xmlsample.shop.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardProcessor {
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
	
	public String readString(String message) throws IOException {
		System.out.print(message + ": ");
		return input.readLine();
	}
	
	public int readInteger(String message) throws IOException {
		int num = 0;
		while (true) {
			try {
				System.out.print(message + ": ");
				String readLine = input.readLine();
				num = Integer.parseInt(readLine);
				break;
			} catch (NumberFormatException e) {
				System.out.println(" This is not number! Try again.");
				continue;
			} 
		}
		return num;
	}
	
	public double readDouble(String message) throws IOException {
		double num = 0;
		while (true) {
			try {
				System.out.print(message + ": ");
				String readLine = input.readLine();
				num = Double.parseDouble(readLine);
				break;
			} catch (NumberFormatException e) {
				System.out.println(" This is not number! Try again.");
				continue;
			} 
		}
		return num;
	}
	
	public void closeKeybord() {
		try {
			input.close();
		} catch (Throwable e) {
			System.out.println("Input stream closing ERROR!");
			e.printStackTrace();
		}
	}
}
