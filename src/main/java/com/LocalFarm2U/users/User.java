package com.LocalFarm2U.users;

public abstract class User {
	private String name;
	private String phoneNumber;
	private String street;
	private String email;

	public User(String nm,String pN,String ad,String email){
		name=nm;
		phoneNumber=pN;
		street=ad;
		email=email;
	}
}

