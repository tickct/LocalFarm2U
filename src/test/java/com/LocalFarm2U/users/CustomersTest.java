package com.LocalFarm2U.users;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomersTest {
	Customer user=new Customer("Sean Gray","1231231234","123ABC","email.email.com","123456");
	
	@Test
	public void ZipCodeShouldBe6Long(){
		user.setZip("123456");
		assertEquals("123456",user.getZip());
	}
	@Test(expected=IllegalArgumentException.class)
	public void ZipCodeShouldBeNullIfNot6(){
		user.setZip("1234");
	}

}
