package com.LocalFarm2U.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.LocalFarm2U.products.Product;
import com.LocalFarm2U.products.Type;
import com.LocalFarm2U.products.Types;
import com.LocalFarm2U.userControl.FarmerList;
import com.LocalFarm2U.users.Farmer;

public class LineItemtest {
	List<String> zips=new ArrayList<String>();
	Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
	LineItem line=new LineItem();
	@Before
	public void Setup(){
		farmer.makeId();
		FarmerList.addFarmer(farmer);
		Types.addType(new Type("Apple"));
		Product product=new Product(Types.getIDFromName("Apple"),2,"lb");
		farmer.addProduct(product);
		line.setAmount(2);
		line.setFspid(Integer.toString(product.getFpsid()));
		line.setProduct(product);
		
		
	}
	@Test
	public void canGenerate(){
		line.GenerateData(farmer.getFid());
		assertNotNull(line.getName());
		assertNotNull(line.getPrice());
		assertNotNull(line.getLine_item_total());
	}
	@Test
	public void getAmmountShouldAddUnit(){
		line.GenerateData(farmer.getFid());
		line.setAmount(2);
		assertEquals("2.0 lb",line.getAmount());
	}
	@Test
	public void getPriceShouldAddUnit(){
		line.GenerateData(farmer.getFid());
		assertEquals("2.0 per lb",line.getPrice());
	}
	@Test
	public void getNumPriceShouldReturnOnlyNumber(){
		line.GenerateData(farmer.getFid());
		assertEquals(2.0,line.getNumprice(),0);
	}
	@Test
	public void SetLineItemTotalCorrect(){
		line.GenerateData(farmer.getFid());
		assertEquals(4.0,line.getLine_item_total(),0);
	}

}
