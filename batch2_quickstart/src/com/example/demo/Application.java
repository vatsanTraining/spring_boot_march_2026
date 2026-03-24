/**
 * 
 */
package com.example.demo;

/**
 * 
 */
public class Application {

	public static void main(String[] args) {
		
		UsdToInr obj = new UsdToInr();
		

		System.out.println( "USD =>"+obj.convertUsdToInr(200.00));

		System.out.println( "USD =>"+obj.convertUsdToInr(Double.parseDouble(args[0])));
		
		
		
		Book headFirstJava = new Book(1010, "Head First Java", "Kathy", -450);
		
		System.out.println(headFirstJava.toString());
		
		
		
	}
}
