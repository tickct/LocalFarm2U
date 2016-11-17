package com.LocalFarm2U.users.farmers;

import org.junit.Test;

import com.LocalFarm2U.users.farmer.FarmerFarmInfo;

public class FarmerFarmInfoTest {

	@Test(expected=IllegalArgumentException.class)
	public void InitializeWithoutnameFails() {
		FarmerFarmInfo farmer=new FarmerFarmInfo(null,"a","b","c");
	}
	@Test(expected=IllegalArgumentException.class)
	public void InitializeWithoutadressFails() {
		FarmerFarmInfo farmer=new FarmerFarmInfo("a",null,"b","c");
	}
	@Test(expected=IllegalArgumentException.class)
	public void InitializeWithoutphoneFails() {
		FarmerFarmInfo farmer=new FarmerFarmInfo("b","a",null,"c");
	}
	@Test
	public void EmailCanBeVoid(){
		FarmerFarmInfo famrer=new FarmerFarmInfo("a","b","c",null);
	}

}
