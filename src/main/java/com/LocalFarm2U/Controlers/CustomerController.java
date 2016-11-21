package com.LocalFarm2U.Controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LocalFarm2U.StubObjects.Status;
import com.LocalFarm2U.order.LineItem;
import com.LocalFarm2U.order.Order;
import com.LocalFarm2U.userControl.CustomerList;
import com.LocalFarm2U.users.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	//create user
	@RequestMapping(value = "", method=RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		try{
			customer.makeId();
			CustomerList.addCustomer(customer);
			return new ResponseEntity<>(customer.getCid(),HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	//update customer
	@RequestMapping(value = "/{cid}", method=RequestMethod.PUT)
	public HttpStatus addCustomer(@RequestBody Customer customer,@PathVariable("cid") int CustomerId){
		try{
			customer.setCid(CustomerList.getCustomerById(CustomerId).getCid());
			CustomerList.updateCustomer(Integer.toString(CustomerId),customer);
			return HttpStatus.OK;
		}
		catch(IllegalArgumentException e){
			return HttpStatus.NOT_FOUND;
		}
		
	}
	//view Customer
	@RequestMapping(value="/{cid}", method=RequestMethod.GET)
	public ResponseEntity<Customer> showCustomer(@PathVariable("cid") int CustomerId){
		try{
			return new ResponseEntity<Customer>(CustomerList.getCustomerById(CustomerId),HttpStatus.OK);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//delete Customer
	@RequestMapping(value="/{cid}/delete", method=RequestMethod.PUT)
	public HttpStatus deleateCustomer(@PathVariable("cid") int CustomerId){
		try{
			CustomerList.deleteCustomer(CustomerId);
			return HttpStatus.OK;
		}
		catch( IllegalArgumentException e){
			return HttpStatus.NOT_FOUND;
		}
	}
	//create order
	@RequestMapping(value="/{cid}/orders", method=RequestMethod.POST)
	public ResponseEntity<?> addOrder(@PathVariable("cid") int customerId,@RequestBody Order order){
		try{
			order.GernerateData();
			for(LineItem L:order.getOrder_detail()){
				System.out.println(L.getFspid());
				L.GenerateData(Integer.parseInt(order.getFid()));
			}
			//need to do it twice due to be coupling totals are cant be calculated before line item data and line item data needs order data
			order.GernerateData();
			CustomerList.getCustomerById(customerId).addOrder(order);
			return new ResponseEntity<>(order.getOid(),HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//view order list
	@RequestMapping(value="/{cid}/orders", method=RequestMethod.GET)
	public ResponseEntity<?> viewOrderSummary(@PathVariable("cid") int customerId){
		try{
			return new ResponseEntity<>(CustomerList.getCustomerById(customerId).getOrderSummaries(),HttpStatus.OK);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//view one order
	@RequestMapping(value="/{cid}/orders/{oid}", method=RequestMethod.GET)
	public ResponseEntity<?> viewOrder(@PathVariable("cid") int customerId,@PathVariable("oid") int orderID){
		try{
			return new ResponseEntity<Order>(CustomerList.getCustomerById(customerId).getOrderFromId(orderID),HttpStatus.OK);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//update status
	@RequestMapping(value="/{cid}/orders/{oid}", method=RequestMethod.POST)
	public ResponseEntity<?> statusChange(@PathVariable("cid") int customerId,@PathVariable("oid") int orderID,@RequestBody Status status){
		try{
			CustomerList.getCustomerById(customerId).getOrderFromId(orderID).setStatus(status.getStatus());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}

