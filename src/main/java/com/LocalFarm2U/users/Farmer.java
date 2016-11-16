package com.LocalFarm2U.users;

import java.util.List;

public class Farmer extends User{
	private String FarmName;
	private String FarmPone;
	private String FarmWeb;
	private List<String> DzipCode;
	static private int farmID;
	
	}
	public Farmer(String Personalname, String PersonalNumber, String Farmadress,String Personalemail,String FarmN, String FarmNumber,List<String> dzip) {
		super(Personalname, PersonalNumber, Farmadress,Personalemail);
		FarmName=FarmN;
		DzipCode=dzip;
	}
	public boolean willDeliver(String zip){
		if(DzipCode.contains(zip)){
			return true;
		}
		return false;
	}
public String getFarmName() {
		return FarmName;
	}
	public void setFarmName(String farmName) {
		FarmName = farmName;
	}
	public String getFarmPone() {
		return FarmPone;
	}
	public void setFarmPone(String farmPone) {
		FarmPone = farmPone;
	}
	public String getFarmWeb() {
		return FarmWeb;
	}
	public void setFarmWeb(String farmWeb) {
		FarmWeb = farmWeb;
	}
	public List<String> getDzipCode() {
		return DzipCode;
	}
	public void setDzipCode(List<String> dzipCode) {
		DzipCode = dzipCode;
	}
	public static int getFarmID() {
		return farmID;
	}
	public static void setFarmID(int farmID) {
		Farmer.farmID = farmID;
}
