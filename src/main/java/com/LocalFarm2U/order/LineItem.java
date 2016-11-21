package com.LocalFarm2U.order;

import java.util.StringTokenizer;

import com.LocalFarm2U.products.Product;
import com.LocalFarm2U.userControl.FarmerList;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LineItem {
	private String fspid;
	private String name;
	private double amount;
	private String price;
	private double line_item_total;
	@JsonIgnore
	private Product product;
	public LineItem(){
		
	}
	public void GenerateData(int fid){
		setProduct(FarmerList.getFarmerById(fid).getProdutList().findProductById(Integer.parseInt(fspid)));
		setName(product.getName());
		setPrice();
		setLine_item_total();
		
	}// TODO Auto-generated method stub
	public String getFspid() {
		return fspid;
	}
	public String getName() {
		return name;
	}
	@JsonIgnore
	public double getNumamount() {
		return amount;
	}
	public String getAmount(){
		return amount+" "+product.getProduct_unit();
	}
	@JsonIgnore
	public double getNumprice(){
		StringTokenizer token=new StringTokenizer(price);
		double numPrice=Double.parseDouble(token.nextToken());
		return numPrice;
	}
	public String getPrice() {
		return price;
	}
	public double getLine_item_total() {
		return line_item_total;
	}
	
	public void setFspid(String fpsid) {
		this.fspid = fpsid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAmount(double am) {
		this.amount = am;
	}
	public void setPrice() {
		this.price = product.getPrice()+" per "+product.getProduct_unit();
	}
	public void setLine_item_total() {
		this.line_item_total = getNumamount()*product.getPrice();
	}

	public void setProduct(Product pro){
		product=pro;
	}
	
}
