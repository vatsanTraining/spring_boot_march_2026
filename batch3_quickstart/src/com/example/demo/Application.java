package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Product tv;
		try {
			tv = new Product(2030,"Sony Tv", "television", 45000);
			System.out.println(tv.getRatePerUnit());
			
			System.out.println(tv);

					
					List<String> products = new ArrayList<>();
			
					products.add("tv");
					products.add("printer");
					products.add("ups");
					products.add("clock");
					products.add("fridge");
					
//					for(String eachProduct: products) {
//						System.out.println(eachProduct);
//					}
//			
					//products.forEach(e -> System.out.println(e));
					
					
					products.forEach(System.out::println);
					
					
					Product printer = new Product(3030,"Epson", "printer", 15000);
							
					Product epson = new Product(3030,"Epson", "printer", 15000);

					//Product epson = printer;
					
					System.out.println("Is Equal =>"+printer.equals(epson));
					
					

					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
