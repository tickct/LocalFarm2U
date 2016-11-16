package com.LocalFarm2U.users;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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

}
