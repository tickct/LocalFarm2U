package com.LocalFarm2U.users;

import static org.junit.Assert.*;

import org.junit.Test;

import com.LocalFarm2U.order.Order;

public class CustomersTest {
	Customer user=new Customer("Sean Gray","1231231234","123ABC","email.email.com","12345");
	
	@Test
	public void ZipCodeShouldBe5Long(){
		user.setZip("12345");
		assertEquals("12345",user.getZip());
	}
	@Test(expected=IllegalArgumentException.class)
	public void ZipCodeShouldBeNullIfNot5(){
		user.setZip("1234");
	}
	@Test
	public void IdUnique(){
		Customer customer=new Customer();
		Customer customer2=new Customer();
		customer.makeId();
		customer2.makeId();
		assertFalse(customer.getCid().equals(customer2.getCid()));
	}
	@Test
	public void AddingOrderShouldIncement(){
		Order order=new Order();
		Customer customer=new Customer();
		customer.addOrder(order);
		assertEquals(1,customer.getOrders().size());
	}
	@Test
	public void getOrderFromIdReturnsCorrect(){
		Order order=new Order();
		order.setOid();
		Customer customer=new Customer();
		customer.addOrder(order);
		assertEquals(order,customer.getOrderFromId(Integer.parseInt(order.getOid())));
	}
	@Test(expected=IllegalArgumentException.class)
	public void getOrderFromIdThrowsErrorIfnotFound(){
		Customer customer=new Customer();
		customer.getOrderFromId(1);
	}
	@Test
	public void getOrdersummariesReturnsAll(){
		Order order=new Order();
		order.setOid();
		Customer customer=new Customer();
		customer.addOrder(order);
		assertEquals(1,customer.getOrderSummaries().size());
	}

}
