package com.LocalFarm2U.products;

public class Product {
	private String name;
	private String type;
	private double cost;
	public Product(String nm,String tp,double cst){
		name=nm;
		setType(tp);
		setCost(cst);
	}

	public void setCost(double cst) {
		//if neative set to zero
		if(cst<0){
			throw new IllegalArgumentException("Cost can not be zero");
		}
		cost=cst;
		
	}

	public void setType(String tp) {
		if(Types.types.contains(tp)){
			type=tp;
		}
		else{
			throw new IllegalArgumentException("Non Legal Type");
		}
		
	}

	public double getCost() {
		// TODO Auto-generated method stub
		return cost;
	}
}
