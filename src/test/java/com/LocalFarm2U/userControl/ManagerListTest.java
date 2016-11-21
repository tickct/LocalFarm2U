package com.LocalFarm2U.userControl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.LocalFarm2U.users.Manager;

public class ManagerListTest {

	@Test
	public void AddManagerShouldAddToList() {
		ManagerList.clear();
		Manager manager=new Manager();
		ManagerList.addManager(manager);
		assertEquals(1,ManagerList.size());
	}
	@Test
	public void FindManagerByIDShouldFind(){
		ManagerList.clear();
		Manager manager=new Manager();
		manager.makeID();
		ManagerList.addManager(manager);
		assertEquals(manager,ManagerList.findManagerbyID(manager.getMid()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void FindManagerShouldThrowErrorIfDosntExist(){
		ManagerList.clear();
		Manager manager=new Manager();
		manager.makeID();
		ManagerList.addManager(manager);
		ManagerList.findManagerbyID("0");
	}

}
