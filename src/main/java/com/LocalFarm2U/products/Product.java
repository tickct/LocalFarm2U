package com.LocalFarm2U.products;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product {
	private String name;
	private String note;
	private String start_date;
	private String end_date;
	private double price;
	private String product_unit;
	private String image;
	

	private static int ProductIdCount;
	private int fpsid;
	private String gcpid;
	
	public Product(){
	}
	
	public Product(String idFromName, int i, String string) {
		setName(idFromName);
		setPrice(i);
		setProduct_unit(string);
		makefpsid();
	}

	public void setName(String gcpid) {
		name=Types.getNameFromID(gcpid);
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public void setPrice(double cst) {
		//if neative set to zero
		if(cst<0){
			throw new IllegalArgumentException("Cost can not be zero");
		}
		price=cst;
		
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setGcpid(String gcpid) {
		this.gcpid = gcpid;
	}
	public void setFpsid(int fpsid) {
		this.fpsid = fpsid;
	}
	
	public String getName() {
		return name;
	}
	public String getNote() {
		return note;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public double getPrice() {
		return price;
	}
	public String getProduct_unit() {
		return product_unit;
	}
	public String getImage() {
		return image;
	}
	public int getFpsid() {
		return fpsid;
	}
	@JsonIgnore
	public String getGcpid() {
		return gcpid;
	}
	
	public void makefpsid(){
		setFpsid(ProductIdCount);
		ProductIdCount++;
	}

	
	

}
