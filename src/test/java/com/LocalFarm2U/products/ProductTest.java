package com.LocalFarm2U.products;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	@Before
	public void setUp(){
		Types.addType("Apple");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setCostShouldFailIfNegative() {
		Product product=new Product("Granny","Apple",-2);
	}
	@Test
	public void setCostShouldSetIfPositive(){
		Product product=new Product("Granny","Apple",2);
		//extra zero is for error range
		assertEquals(2.0,product.getCost(),0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void setTypeCanOnlySetTypesInList(){
	 Product product=new Product("Granny","Oragne",.2);
	}

}
