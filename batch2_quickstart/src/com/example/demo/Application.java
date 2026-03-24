/**
 * 
 */
package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.exceptions.RangeCheckException;
import com.example.demo.ifaces.CurrencyConverter;

/**
 * 
 */
public class Application {

	public static void main(String[] args) {
		
		UsdToInr obj = new UsdToInr();
		
		

		CurrencyConverter conv = new UsdToInr();
		
//		                                convert(double arg)  => (arg)
//		                                		{
//		                                arg *32 =>	      return arg*32
//		                                		}
		
		CurrencyConverter farenToCel = (arg) ->  (arg- 32)*5/9; 
		
		System.out.println("Faren Heit" +farenToCel.convert(100));
		
		System.out.println(conv.convert(100));
		
		System.out.println( "USD =>"+obj.convertUsdToInr(200.00));

		System.out.println( "USD =>"+obj.convertUsdToInr(Double.parseDouble(args[0])));
		
		
		
		//int marks[] =new int[] {90,96,97,99,100};
		
		List<Integer> marks = new ArrayList<>();
		
		marks.add(90);
		marks.add(99);
		marks.add(97);
		marks.add(96);
		
		
		//marks.forEach(e -> System.out.println(e));
		
		// refactored in to this
		
		marks.forEach(System.out::println);
		
		
		
		
	    

		
		Book headFirstJava;
		try {
			headFirstJava = new Book(1010, "Head First Java", "Kathy", 450);
			System.out.println(headFirstJava.toString());

		} catch (RangeCheckException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
