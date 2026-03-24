/**
 * Application to convert USD to INR
 * @author srivatsan
 * @version 1.0
 */
package com.example.demo;

import com.example.demo.ifaces.CurrencyConverter;

public class UsdToInr implements CurrencyConverter{

	// static variable or class variable
	  private static String message1;
	  
	  //instance variable
	  private  String message2;

	
	  
	  //usd is a parameter variable
	public double convertUsdToInr(double usd ) {
		
		// local variable
		int val=90 ;
		
		System.out.println(message1);
		System.out.println(val);
		return  usd*95.00;
	}



	@Override
	public double convert(double arg) {
		return convertUsdToInr(arg);
	}
	
}
