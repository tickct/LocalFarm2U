package com.LocalFarm2U.userControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.LocalFarm2U.users.Farmer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FarmerList {
	private static List<Farmer> farmerList=new ArrayList<Farmer>();
	public static List<Farmer> getFarmerList(){
		return farmerList;
	}
	public static Farmer getFarmerById(int id) throws IllegalArgumentException{
		for(Farmer target:farmerList){
			if(target.getFid()==id){
				return target;
			}
		}
		throw new IllegalArgumentException();
	}
	public static void addFarmer(Farmer farmer){
		farmerList.add(farmer);
	}
	public static int size(){
		return farmerList.size();
	}
	public static void set(int index,Farmer farmer){
		farmerList.set(index, farmer);
	}
	public static ArrayNode getFarmerSummarys(){
		ObjectMapper mapper=new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		for(Farmer target:farmerList){
			ObjectNode node=mapper.createObjectNode();
			node.put("fid", target.getFid());
			node.put("Name", target.getFarm_info().getName());
			arrayNode.add(node);
		}
		return arrayNode;
	}
	public static ArrayNode getFarmerSummarys(String zip){
		ObjectMapper mapper=new ObjectMapper();
		ArrayNode arrayNode = mapper.createArrayNode();
		for(Farmer target:farmerList){
			if(target.willDeliver(zip)){
			ObjectNode node=mapper.createObjectNode();
			node.put("fid", target.getFid());
			node.put("Name", target.getFarm_info().getName());
			arrayNode.add(node);
			}
		}
		return arrayNode;
	}
	public static int getFarmerIndexByFid(int id) throws IllegalArgumentException{
		for(Farmer target:farmerList){
			if(target.getFid()==id){
				return farmerList.indexOf(target);
			}
		}
		throw new IllegalArgumentException();
	}
	public static void deleteFarmer(int farmerId) throws IllegalArgumentException{
		for (Iterator<Farmer> iter = farmerList.listIterator(); iter.hasNext(); ) {
			Farmer current = iter.next();
			if (current.getFid()==farmerId){
				iter.remove();
				return;
			}
		}
		throw new IllegalArgumentException();
			
	}
	public static void clear(){
		farmerList.clear();
	}
		
}


