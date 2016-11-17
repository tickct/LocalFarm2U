package com.LocalFarm2U.users;

import java.util.List;

import com.LocalFarm2U.products.Product;
import com.LocalFarm2U.products.Types;
import com.LocalFarm2U.users.farmer.FarmerFarmInfo;
import com.LocalFarm2U.users.farmer.FarmerPersonalInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Farmer {
	private int fid;
	private FarmerFarmInfo farm_info;
	private FarmerPersonalInfo personal_info;
	private List<String> delivers_to;
	private List<Product> products;
	//start count at 100 for id for astetic reasons
	@JsonIgnore
	static private int farmIDCount=100;
	public Farmer(){
		
	}
	public Farmer(FarmerFarmInfo farm_info, FarmerPersonalInfo personal_info, List<String> delivers_to) {
		this.setFarm_info(farm_info);
		this.setPersonal_info(personal_info);
		this.setDelivers_to(delivers_to);
		fid=farmIDCount;
		farmIDCount++;
	}
	//for internal testing
	public Farmer(String Personalname, String PersonalNumber, String FarmAdress,String Personalemail,String FarmN, String FarmNumber,List<String> dzip) {
		farm_info=new FarmerFarmInfo(FarmN,FarmAdress,FarmNumber,"");
		personal_info=new FarmerPersonalInfo(Personalname,Personalemail,PersonalNumber);
		delivers_to = dzip;
		fid=farmIDCount;
		farmIDCount++;
	}
	
	
	public void setFarm_info(FarmerFarmInfo farm) throws IllegalArgumentException{
		if(farm==null){
			throw new IllegalArgumentException();
		}
		this.farm_info = farm;
	}
	public void setPersonal_info(FarmerPersonalInfo personal) throws IllegalArgumentException {
		if(personal==null){
			throw new IllegalArgumentException();
		}
		this.personal_info = personal;
	}
	public void setDelivers_to(List<String> delivers) throws IllegalArgumentException{
		if(delivers==null){
			throw new IllegalArgumentException();
		}
		this.delivers_to = delivers;
	}
	public FarmerFarmInfo getFarm_info() {
		return farm_info;
	}

	public FarmerPersonalInfo getPersoanl_info() {
		return personal_info;
	}
	
	public List<String> getDelivers_to() {
		return delivers_to;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public boolean willDeliver(String zip){
		if(delivers_to.contains(zip)){
			return true;
		}
		return false;
	}
	//needed since post data uses setters vs constructor
	public void makeId() {
		fid=farmIDCount;
		farmIDCount++;
		
	}
	public void addProduct(Product product) throws IllegalArgumentException{
		if(Types.idExists(product.getGcpid())){
			products.add(product);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	public List<Product> getProduts() {
		// TODO Auto-generated method stub
		return products;
	}

	
}
