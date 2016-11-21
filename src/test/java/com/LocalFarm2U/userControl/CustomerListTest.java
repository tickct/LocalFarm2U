package com.LocalFarm2U.userControl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.LocalFarm2U.users.Customer;

public class CustomerListTest {
	@Before
	public void setUp(){
		CustomerList.clear();
		Customer customer=new Customer();
		customer.makeId();
		CustomerList.addCustomer(customer);
	}
	@Test
	public void AddManagerShouldAddToList() {

		assertEquals(1,CustomerList.size());
	}
	@Test
	public void FindManagerByIDShouldFind(){
		CustomerList.clear();
		Customer customer=new Customer();
		customer.makeId();
		CustomerList.addCustomer(customer);
		assertEquals(customer,CustomerList.getCustomerById(Integer.parseInt(customer.getCid())));
	}
	@Test(expected=IllegalArgumentException.class)
	public void FindManagerShouldThrowErrorIfDosntExist(){
		CustomerList.getCustomerById(0);
	}
	@Test
	public void UpDateCustomerShouldUpdate(){
		CustomerList.clear();
		Customer customer=new Customer();
		customer.makeId();
		customer.setName("Sean");

		CustomerList.addCustomer(customer);
		Customer customer2=new Customer();
		customer2.setCid(customer.getCid());
		customer2.setName("Gray");
		CustomerList.updateCustomer(customer.getCid(), customer2);
		assertEquals(CustomerList.getCustomerById(Integer.parseInt(customer.getCid())).getName(),"Gray");
	}
	@Test(expected=IllegalArgumentException.class)
	public void UpdateShouldthrowErrorIfIDDosntExist(){
		Customer customer=new Customer();
		customer.makeId();
		CustomerList.updateCustomer("0", customer);
	}
	@Test
	public void DeleateClearsOnlyCorrectEntry(){
		CustomerList.clear();
		Customer customer=new Customer();
		customer.makeId();
		customer.setName("Sean");
		CustomerList.addCustomer(customer);
		Customer customer2=new Customer();
		customer2.makeId();
		customer2.setName("Gray");
		CustomerList.addCustomer(customer2);
		assertEquals(2,CustomerList.size());
		CustomerList.deleteCustomer(Integer.parseInt(customer.getCid()));
		assertEquals(1,CustomerList.size());
		assertEquals(CustomerList.getCustomerById(Integer.parseInt(customer2.getCid())).getName(),"Gray");
	}
	@Test(expected=IllegalArgumentException.class)
	public void DeleateThrowsErrorIfIDDosntExist(){
		CustomerList.deleteCustomer(0);
	}

}
