package com.LocalFarm2U.order;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.LocalFarm2U.products.Product;
import com.LocalFarm2U.products.Type;
import com.LocalFarm2U.products.Types;
import com.LocalFarm2U.userControl.FarmerList;
import com.LocalFarm2U.users.Farmer;

public class OrderTest {
	List<String> zips=new ArrayList<String>();
	Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
	LineItem line=new LineItem();
	Order order=new Order();
	LineItem item=new LineItem();
	@Before
	public void Setup(){
		farmer.makeId();
		FarmerList.addFarmer(farmer);
		Types.addType(new Type("Apple"));
		Product product=new Product(Types.getIDFromName("Apple"),2,"lb");
		farmer.addProduct(product);
		farmer.setDeliveryCharge(2);
		line.setFspid(Integer.toString(product.getFpsid()));
		line.setProduct(product);
		line.setAmount(2);
		order.setFid(farmer.getFid());
		order.Additem(line);
	}
	@Test
	public void CanGenerateData() {
		order.GernerateData();
		assertNotNull(order.getProducts_total());
		assertNotNull(order.getDelivery_charge());
		assertNotNull(order.getOrder_total());
		assertNotNull(order.getStatus());
	}
	@Test(expected=IllegalArgumentException.class)
	public void SetPlannedDeliveryShouldNotLetYouPutOldDates() throws ParseException{
		order.setPlanned_delivery_date("20001111");
	}
	@Test(expected=IllegalArgumentException.class)
	public void SetActualDeliveryShouldNotLetYouPutOldDates() throws ParseException{
		order.setAcutal_delivery_date("20001111");
	}
	@Test
	//will need to be changed in 2200
	public void SetPlannedDeliveryShouldWorkIfFutureDate() throws ParseException{
		order.setPlanned_delivery_date("22001111");
	}
	@Test
	//will need to be changed in 2200
	public void SetActualDeliveryShouldWorkIfFutureDate() throws ParseException{
		order.setAcutal_delivery_date("22001111");
	}
	@Test
	public void setProducts_totalCorrect(){
		line.GenerateData(farmer.getFid());
		order.GernerateData();
		assertEquals(4.0,order.getProducts_total(),0);
	}
	@Test
	public void setOrderTotalCorrect(){
		line.GenerateData(farmer.getFid());
		order.GernerateData();
		assertEquals(6.0,order.getOrder_total(),0);
	}


}
