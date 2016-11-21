package com.LocalFarm2U.products;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	private List<Product> productList;
	public ProductList(){
		productList=new ArrayList<Product>();
	}
	public List<Product> getProductList(){
		return productList;
	}
	public void addProduct(Product product) throws IllegalArgumentException{
		if(Types.idExists(product.getGcpid())){
			productList.add(product);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	public Product findProductById(int id) throws IllegalArgumentException{
		for(Product pro:productList){
			if(pro.getFpsid()==id){
				return pro;
			}
		}
		throw new IllegalArgumentException();
	}
	public int size() {
		// TODO Auto-generated method stub
		return productList.size();
	}

}
