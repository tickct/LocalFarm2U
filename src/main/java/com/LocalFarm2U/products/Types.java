package com.LocalFarm2U.products;

import java.util.ArrayList;
import java.util.List;

public class Types {
	public static List<Type> types = new ArrayList<Type>();;
	public static void addType(Type type){
		if(!(nameExists(type.getName()))){
			types.add(type);
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
	public static Type getTypeById(String id) throws IllegalArgumentException{
		for(Type type:types){
			if(type.getGcpid().equals(id)){
				return type;
			}
		}
		throw new IllegalArgumentException();
	}
	public static void updateType(String id,Type type) throws IllegalArgumentException{
		if(idExists(id)){
		types.set(types.indexOf(getTypeById(id)), type);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	public static void clear(){
		types.clear();
	}
}
