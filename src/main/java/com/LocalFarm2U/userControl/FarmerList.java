package com.LocalFarm2U.userControl;

import java.util.ArrayList;
import java.util.List;

import com.LocalFarm2U.CustomErrors.IDNotFound;
import com.LocalFarm2U.users.Farmer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FarmerList {
	List<Farmer> farmerList;
	public FarmerList(){
		farmerList=new ArrayList<Farmer>();
	}
	public List<Farmer> getFarmerList(){
		return farmerList;
	}
	public Farmer getFarmerById(int id) throws IDNotFound{
		for(Farmer target:farmerList){
			if(target.getFid()==id){
				return target;
			}
		}
		throw new IllegalArgumentException();
	}
	public void addFarmer(Farmer farmer){
		farmerList.add(farmer);
	}
	public int size(){
		return farmerList.size();
	}
	public void set(int index,Farmer farmer){
		farmerList.set(index, farmer);
	}
	public ArrayNode getFarmerSummarys(){
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
	public ArrayNode getFarmerSummarys(String zip){
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
	public int getFarmerIndexByFid(int id) throws IllegalArgumentException{
		for(Farmer target:farmerList){
			if(target.getFid()==id){
				return farmerList.indexOf(target);
			}
		}
		throw new IllegalArgumentException();
	}
}

