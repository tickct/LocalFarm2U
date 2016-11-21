package com.LocalFarm2U.products;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	@Before
	public void setUp(){
		Types.addType(new Type("Apple"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setCostShouldFailIfNegative() {
		Product product=new Product(Types.getIDFromName("Apple"),-2,"lb");
	}
	@Test
	public void setCostShouldSetIfPositive(){
		Product product=new Product(Types.getIDFromName("Apple"),2,"lb");
		//extra zero is for error range
		assertEquals(2.0,product.getPrice(),0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void setTypeCanOnlySetTypesInList(){
	 Product product=new Product("123",2,"lb");
	}
	@Test
	public void YouCanSetAll(){
		Product product=new Product();
		product.setName(Types.getIDFromName("Apple"));
		product.setNote("no note");
		product.setStart_date("september");
		product.setEnd_date("never");
		product.setPrice(3);
		product.setProduct_unit("lb");
	    product.setImage("");
	    product.setGcpid("123");
	}

}
