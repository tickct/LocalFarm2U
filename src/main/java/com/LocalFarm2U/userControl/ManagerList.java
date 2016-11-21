package com.LocalFarm2U.userControl;

import java.util.ArrayList;
import java.util.List;

import com.LocalFarm2U.users.Farmer;
import com.LocalFarm2U.users.Manager;

public class ManagerList {
	private static List<Manager> managerList=new ArrayList<Manager>();
	public static List<Manager> getManagerList(){
		return managerList;
	}
	public static void addManager(Manager manager){
		managerList.add(manager);
	}
	public static Manager findManagerbyID(String id) throws IllegalArgumentException{
		for(Manager target:managerList){
			if(target.getMid().equals(id)){
				return target;
			}
		}
		throw new IllegalArgumentException();
	}
	public static void clear(){
		managerList.clear();
	}
	public static int size(){
		return managerList.size();
	}
}
