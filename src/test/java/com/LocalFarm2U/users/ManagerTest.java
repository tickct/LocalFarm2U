package com.LocalFarm2U.users;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ManagerTest {

	@Test
	public void IDIsUnique() {
		Manager manager=new Manager();
		Manager manager2=new Manager();
		manager.makeID();
		manager2.makeID();
		assertFalse(manager.getMid().equals(manager2.getMid()));
	}

}
