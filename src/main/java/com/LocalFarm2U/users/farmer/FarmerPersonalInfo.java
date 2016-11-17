package com.LocalFarm2U.users.farmer;

import com.LocalFarm2U.users.User;

public class FarmerPersonalInfo extends User{
	//needed for json deserializing
	public FarmerPersonalInfo(){
	}
	public FarmerPersonalInfo(String name, String email, String phone) {
		super(name,phone,email);
	}
	
}
