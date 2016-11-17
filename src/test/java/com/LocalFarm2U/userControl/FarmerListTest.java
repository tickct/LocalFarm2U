package com.LocalFarm2U.userControl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.LocalFarm2U.CustomErrors.IDNotFound;
import com.LocalFarm2U.users.Farmer;

public class FarmerListTest {
	@Test
	public void AddFarmerIncrementsSize(){
		List<String> zips=new ArrayList<String>();
		FarmerList list=new FarmerList();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		list.addFarmer(farmer);
		assertEquals(1,list.size());
	}
	@Test
	public void FindFarmerByID(){
		List<String> zips=new ArrayList<String>();
		FarmerList list=new FarmerList();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		list.addFarmer(farmer);
		assertEquals(farmer,list.getFarmerById(farmer.getFid()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void ErrorThrownIfIDdosntExist(){
		List<String> zips=new ArrayList<String>();
		FarmerList list=new FarmerList();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		list.addFarmer(farmer);
		list.getFarmerById(1);
	}
	@Test
	public void FarmerSummariesReturnOnlyNameAndID(){
		List<String> zips=new ArrayList<String>();
		FarmerList list=new FarmerList();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		list.addFarmer(farmer);
		assertEquals("[{\"fid\":"+farmer.getFid()+",\"Name\":\"A Farm\"}]",list.getFarmerSummarys().toString());
	}
	@Test
	public void FarmerSummariesWithZipReturnsOnlyVaid(){
		FarmerList list=new FarmerList();
		List<String> zips=new ArrayList<String>();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		list.addFarmer(farmer);
		List<String> zips2=new ArrayList<String>();
		zips2.add("111111");
		Farmer farmer2=new Farmer("","123-123-1234","123 abc","email@email.com","Second Farm","321-321-4321",zips2);
		list.addFarmer(farmer2);

		assertEquals("[{\"fid\":"+farmer2.getFid()+",\"Name\":\"Second Farm\"}]",list.getFarmerSummarys("111111").toString());
	}
	@Test
	public void CorrectIndexReturnedFromFind(){
		FarmerList list=new FarmerList();
		List<String> zips=new ArrayList<String>();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		list.addFarmer(farmer);
		assertEquals(0,list.getFarmerIndexByFid(farmer.getFid()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void ErrorThrownIdNotFoundFromFind(){
		FarmerList list=new FarmerList();
		List<String> zips=new ArrayList<String>();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		list.addFarmer(farmer);
		list.getFarmerIndexByFid(10);
	}
}
