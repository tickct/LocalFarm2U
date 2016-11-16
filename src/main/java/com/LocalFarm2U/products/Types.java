package com.LocalFarm2U.products;

import java.util.ArrayList;

public class Types {
	public static ArrayList<String> types = new ArrayList<String>();;
	public static void addType(String in){
		if(!(types.contains(in))){
			types.add(in);
		}
	}
	public static ArrayList<String> getTypes(){
		return types;
	}
	public static int size(){
		return types.size();
	}
}
