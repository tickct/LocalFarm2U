package com.LocalFarm2U.users;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.LocalFarm2U.products.Product;
import com.LocalFarm2U.products.Type;
import com.LocalFarm2U.products.Types;
import com.LocalFarm2U.users.farmer.FarmerFarmInfo;
import com.LocalFarm2U.users.farmer.FarmerPersonalInfo;

public class FarmerTest {
	List<String> zips=new ArrayList<String>();
	
	@Test
	public void willDeliverTrue() {
		zips.add("123456");
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		assertTrue(farmer.willDeliver("123456"));
	}
	@Test
	public void willDeliverFalse() {
		zips.add("123456");
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		assertFalse(farmer.willDeliver("123434"));
	}
	@Test
	public void canConstructOtherType(){
		zips.add("123456");
		FarmerFarmInfo farm=new FarmerFarmInfo("a","b","c","d");
		FarmerPersonalInfo person=new FarmerPersonalInfo("a","b","c");
		Farmer farmer=new Farmer(farm,person,zips);
	}
	@Test
	public void canAddProducts(){
		Types.addType(new Type("Apple"));
		Product product=new Product(Types.getIDFromName("Apple"),2,"lb");
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		farmer.addProduct(product);
		assertEquals(1,farmer.getProdutList().size());
	}
	@Test(expected=IllegalArgumentException.class)
	public void FarmInfoCantBeSettoNull(){
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		farmer.setFarm_info(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void PersonalInfoCantBeSettoNull(){
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		farmer.setPersonal_info(null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void DeliversToCantBeSetToNull(){
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		farmer.setDelivers_to(null);
	}
	@Test
	public void IdShouldBeUnique(){
		Farmer farmer=new Farmer();
		Farmer farmer2=new Farmer();
		farmer.makeId();
		farmer2.makeId();
		assertFalse(farmer.getFid()==farmer2.getFid());
	}

}
