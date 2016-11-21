package com.LocalFarm2U.users;

import java.util.ArrayList;
import java.util.List;

import com.LocalFarm2U.order.Order;
import com.LocalFarm2U.order.OrderSummary;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer extends User{
	private String cid;
	private String zip;
	private String street;
	@JsonIgnore
	private static int CustomerIdCount=100;
	@JsonIgnore
	private List<Order> orders=new ArrayList<Order>();
	public Customer(){
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Customer(String nm, String pN, String ad,String email, String zipCode) {
		super(nm, pN, email);
		this.setZip(zipCode);
		street=ad;
	}
	public void setZip(String zipCode) throws IllegalArgumentException{
		if(zipCode.length()!=5){
			throw new IllegalArgumentException("Zip Code is not 5 long");
		}
		zip=zipCode;
	}
	public String getZip() {
		return zip;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public void makeId(){
		cid=Integer.toString(CustomerIdCount);
		CustomerIdCount++;
	}
	public void addOrder(Order order) {
		orders.add(order);
		
	}
	public List<OrderSummary> getOrderSummaries() {
		// TODO Auto-generated method stub
		List<OrderSummary> summary=new ArrayList<OrderSummary>();
		for(Order o:orders){
			summary.add(o.getOrderSummary());
		}
		return summary;
	}
	public Order getOrderFromId(int id){
		for(Order o:orders){
			if(o.getOid().equals(Integer.toString(id))){
				return o;
			}
		}
		throw new IllegalArgumentException("Order Id not Found");
	}
	@JsonIgnore
	public List<Order> getOrders(){
		return orders;
	}
	
}
