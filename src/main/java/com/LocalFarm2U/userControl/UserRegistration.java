package com.LocalFarm2U.userControl;

import java.util.ArrayList;

import com.LocalFarm2U.users.User;

public class UserRegistration {
	ArrayList<User> userList;
	public UserRegistration(){
		userList = new ArrayList<User>();
	}
	public int getSize(){
		return userList.size();
	}
	public void removeUser(User user){
		if(userList.contains(user)){
			userList.remove(user);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
}