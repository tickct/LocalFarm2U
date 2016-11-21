package com.LocalFarm2U.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.LocalFarm2U.userControl.FarmerList;
import com.LocalFarm2U.users.farmer.FarmerFarmInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Order {
	private String fid;
	private String oid;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date;
	private String status;
	private FarmerFarmInfo farm_info;
	private List<LineItem> order_detail=new ArrayList<LineItem>();
	private String delivery_note;
	private double products_total;
	private double delivery_charge;
	private double order_total;
	@JsonIgnore
	private int OrderIdCount=100;
	@JsonIgnore
	private OrderSummary summary=new OrderSummary();
	public Order(){
		
	}
	
	public void GernerateData(){
		setFarm_info(Integer.parseInt(fid));
		setProducts_total();
		setDelivery_charge(Integer.parseInt(fid));
		setOrder_total();
		setOid();
		// need to create summary before status to initialize in time
		summary=new OrderSummary(oid,planned_delivery_date,actual_delivery_date,"open",fid);
		setStatus("open");
	}


	public String getOid() {
		return oid;
	}
	public String getOrder_date() {
		return order_date;
	}
	public String getPlanned_delivery_date() {
		return planned_delivery_date;
	}
	public String getActual_delivery_date() {
		return actual_delivery_date;
	}
	public String getStatus() {
		return status;
	}
	public FarmerFarmInfo getFarm_info() {
		return farm_info;
	}
	public List<LineItem> getOrder_detail() {
		return order_detail;
	}
	public String getDelivery_note() {
		return delivery_note;
	}
	public double getProducts_total() {
		return products_total;
	}
	public double getDelivery_charge() {
		return delivery_charge;
	}
	public double getOrder_total() {
		return order_total;
	}
	public void setOid() {
		oid=Integer.toString(OrderIdCount);
		OrderIdCount++;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public void setPlanned_delivery_date(String planned_delivery_date) throws IllegalArgumentException, ParseException{
		
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		Date date = format.parse(planned_delivery_date);
		Date currentDate=new Date();
		//if date before current date
		if(date.compareTo(currentDate)<0){
			throw new IllegalArgumentException("date is in the past");
		}
		this.planned_delivery_date = planned_delivery_date;
		summary.setPlanned_delivery_date(planned_delivery_date);
	}
	public void setAcutal_delivery_date(String actual_delivery_date) throws IllegalArgumentException, ParseException{
		
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		Date date = format.parse(actual_delivery_date);
		Date currentDate=new Date();
		//if date before current date
		if(date.compareTo(currentDate)<0){
			throw new IllegalArgumentException("date is in the past");
		}
		this.planned_delivery_date = actual_delivery_date;
		summary.setActural_delivery_date(actual_delivery_date);
	}
	public void setStatus(String stat) {

		this.status = stat;
		summary.setStatus(stat);
	}
	public void setFarm_info(int farmid) {
		farm_info=FarmerList.getFarmerById(farmid).getFarm_info();
		
	}
	public void setOrder_detail(List<LineItem> order_detail) {
		this.order_detail = order_detail;
	}
	public void setDelivery_note(String delivery_note) {
		this.delivery_note = delivery_note;
	}
	public void setProducts_total() {
		double total=0;
		for(LineItem line:order_detail){
			total += line.getLine_item_total();
		}
		products_total=total;
	}
	public void setDelivery_charge(int farmid) {
		delivery_charge=FarmerList.getFarmerById(farmid).getDeliveryCharge();
	}
	public void setOrder_total() {
		this.order_total = products_total+delivery_charge;
	}

	public void setFid(int fid2) {
		fid=Integer.toString(fid2);
	}

	public void Additem(LineItem item) {
		order_detail.add(item);
		
	}
	public String getFid() {
		return fid;
	}
	@JsonIgnore
	public OrderSummary getOrderSummary() {
		// TODO Auto-generated method stub
		return summary;
	}
	
}
