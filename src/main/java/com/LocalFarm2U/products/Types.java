package com.LocalFarm2U.products;

import java.util.ArrayList;
import java.util.List;

public class Types {
	public static List<Type> types = new ArrayList<Type>();;
	public static void addType(String in){
		if(!(nameExists(in))){
			types.add(new Type(in));
		}
	}
	public static List<Type> getTypes(){
		return types;
	}
	public static String getNameFromID(String gcpid) throws IllegalArgumentException{
		for(Type type:types){
			if(type.getGcpid().equals(gcpid)){
				return type.getName();
			}
		}
		throw new IllegalArgumentException();
		
	}
	public static String getIDFromName(String name) throws IllegalArgumentException{
		for(Type type:types){
			if(type.getName().equals(name)){
				return type.getGcpid();
			}
		}
		throw new IllegalArgumentException();
		
	}
	public static int size(){
		return types.size();
	}
	public static boolean nameExists(String in){
		for(Type type:types){
			if(type.getName().equals(in)){
				return true;
			}
		}
		return false;
	}
	public static boolean idExists(String id){
		for(Type type:types){
			if(type.getGcpid().equals(id)){
				return true;
			}
		}
		return false;
	}
}
