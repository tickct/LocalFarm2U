package com.LocalFarm2U.users;

import com.LocalFarm2U.users.User;

public class Customer extends User{
	private String zip;
	public Customer(String nm, String pN, String ad,String email, String zipCode) {
		super(nm, pN, ad, email);
		this.setZip(zipCode);
	}
	public void setZip(String zipCode) throws IllegalArgumentException{
		if(zipCode.length()!=6){
			throw new IllegalArgumentException("Zip Code is not 6 long");
		}
		zip=zipCode;
	}
	public String getZip() {
		return zip;
	}
	
}
