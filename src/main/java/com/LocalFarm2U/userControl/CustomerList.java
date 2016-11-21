package com.LocalFarm2U.userControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.LocalFarm2U.users.Customer;

public class CustomerList {
	private static List<Customer> customerList= new ArrayList<Customer>();

	public static void addCustomer(Customer customer) {
		customerList.add(customer);
		
	}
	public static  Customer getCustomerById(int id) throws IllegalArgumentException{
		for(Customer target:customerList){
			if(target.getCid().equals(Integer.toString(id))){
				return target;
			}
		}
		throw new IllegalArgumentException();
	}
	public static void updateCustomer(String customerId,Customer customer) throws IllegalArgumentException{
		for(Customer cust:customerList){
			if(cust.getCid().equals(customerId)){
				customerList.set(customerList.indexOf(cust), customer);
				return;
			}
		}
		throw new IllegalArgumentException("Id not found");
		
	}
	public static void deleteCustomer(int customerId) throws IllegalArgumentException{
		for (Iterator<Customer> iter = customerList.listIterator(); iter.hasNext(); ) {
		    Customer current = iter.next();
		    if (current.getCid().equals(Integer.toString(customerId))) {
		        iter.remove();
		        return;
		    }
		}
		throw new IllegalArgumentException();
		
	}
	public static List<Customer> getCustomerList(){
		return customerList;
	}
	public static void clear() {
		customerList.clear();
	}
	public static int size(){
		return customerList.size();
	}
}
