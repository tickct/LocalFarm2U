package com.LocalFarm2U.users;

import org.junit.Test;

import com.LocalFarm2U.users.farmer.FarmerPersonalInfo;

public class UserTest {
	@Test(expected=IllegalArgumentException.class)
	public void InitializeWithoutnameFails() {
		User farmer=new FarmerPersonalInfo(null,"a","b");
	}
	@Test(expected=IllegalArgumentException.class)
	public void InitializeWithoutadressFails() {
		User farmer=new FarmerPersonalInfo("a",null,"b");
	}
	@Test(expected=IllegalArgumentException.class)
	public void InitializeWithoutemailFails() {
		User farmer=new FarmerPersonalInfo("b","a",null);
	}
	@Test
	public void CanCreate(){
		FarmerPersonalInfo farmer= new FarmerPersonalInfo("b","a","c");
	}
}
