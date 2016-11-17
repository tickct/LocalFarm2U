package com.LocalFarm2U.users;

public abstract class User {
	private String name;
	private String phone;
	private String email;
	
	//needed for json deserializing
	public User(){
	}
	public User(String nm,String pN,String em){
		setName(nm);
		setPhone(pN);
		setEmail(em);
	}

	public String getName() {
		return name;
	}

	public void setName(String na) throws IllegalArgumentException {
		if(na==null){
			throw new IllegalArgumentException();
		}
		this.name = na;
	}
	public void setPhone(String pho) throws IllegalArgumentException{
		if(pho==null){
			throw new IllegalArgumentException();
		}
		this.phone = pho;
	}
	public String getPhoneNumber() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String em) throws IllegalArgumentException {
		if(em==null){
			throw new IllegalArgumentException();
		} 
		this.email = em;
	}
}

