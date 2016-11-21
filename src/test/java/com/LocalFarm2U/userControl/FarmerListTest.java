package com.LocalFarm2U.userControl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.LocalFarm2U.users.Farmer;

public class FarmerListTest {
	List<String> zips=new ArrayList<String>();

	@Test
	public void AddFarmerIncrementsSize(){
		FarmerList.clear();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		FarmerList.addFarmer(farmer);
		assertEquals(1,FarmerList.size());
	}
	@Test
	public void FindFarmerByID(){
		FarmerList.clear();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		FarmerList.addFarmer(farmer);
		assertEquals(farmer,FarmerList.getFarmerById(farmer.getFid()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void ErrorThrownIfIDdosntExist(){
		FarmerList.clear();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		FarmerList.addFarmer(farmer);
		FarmerList.getFarmerById(1);
	}
	@Test
	public void FarmerSummariesReturnOnlyNameAndID(){
		FarmerList.clear();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		FarmerList.addFarmer(farmer);
		assertEquals("[{\"fid\":"+farmer.getFid()+",\"Name\":\"A Farm\"}]",FarmerList.getFarmerSummarys().toString());
	}
	@Test
	public void FarmerSummariesWithZipReturnsOnlyVaid(){
		FarmerList.clear();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		FarmerList.addFarmer(farmer);
		List<String> zips2=new ArrayList<String>();
		zips2.add("111111");
		Farmer farmer2=new Farmer("","123-123-1234","123 abc","email@email.com","Second Farm","321-321-4321",zips2);
		FarmerList.addFarmer(farmer2);

		assertEquals("[{\"fid\":"+farmer2.getFid()+",\"Name\":\"Second Farm\"}]",FarmerList.getFarmerSummarys("111111").toString());
	}
	@Test
	public void CorrectIndexReturnedFromFind(){
		FarmerList.clear();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		FarmerList.addFarmer(farmer);
		assertEquals(0,FarmerList.getFarmerIndexByFid(farmer.getFid()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void ErrorThrownIdNotFoundFromFind(){
		FarmerList.getFarmerIndexByFid(10);
	}
	@Test
	public void DeleteDeleatesCorrectOne(){
		FarmerList.clear();
		Farmer farmer=new Farmer();
		farmer.makeId();
		Farmer farmer2=new Farmer();
		farmer2.makeId();
		FarmerList.addFarmer(farmer);
		FarmerList.addFarmer(farmer2);
		assertEquals(2,FarmerList.size());
		FarmerList.deleteFarmer(farmer.getFid());
		assertEquals(1,FarmerList.size());
		assertEquals(farmer2,FarmerList.getFarmerById(farmer2.getFid()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void DeleatethrowsErrorifIddosntExist(){
		FarmerList.deleteFarmer(0);
	}
}
