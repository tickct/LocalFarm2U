package com.LocalFarm2U.users.farmer;

public class FarmerFarmInfo {
	private String name;
	private String adress;
	private String phone;
	private String web;
	//to make the json happy
	public FarmerFarmInfo(){	
	}
	public FarmerFarmInfo(String name, String adress, String phone,String email) {
		this.setName(name);
		this.setAdress(adress);
		this.setPhone(phone);
		this.setWeb(email);
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
	public void setAdress(String adr) throws IllegalArgumentException{
		if(adr==null){
			throw new IllegalArgumentException();
		}
		this.adress = adr;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getName() {
		return name;
	}
	public String getAdress() {
		return adress;
	}
	public String getPhone() {
		return phone;
	}
	public String getWeb() {
		return web;
	}
	
	
}
