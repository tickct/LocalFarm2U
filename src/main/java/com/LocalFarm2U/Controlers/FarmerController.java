package com.LocalFarm2U.Controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LocalFarm2U.products.Product;
import com.LocalFarm2U.products.ProductList;
import com.LocalFarm2U.userControl.FarmerList;
import com.LocalFarm2U.users.Farmer;
import com.fasterxml.jackson.databind.node.ArrayNode;

@RestController
@RequestMapping("/farmers")
public class FarmerController {
	
	
	//Get Summaries of Farms in area
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayNode> getAllFarmers(@RequestParam(value="zip", defaultValue="") String zip){
		if(zip.equals("")){
			return new ResponseEntity<ArrayNode>(FarmerList.getFarmerSummarys(),HttpStatus.OK);
		}
		return new ResponseEntity<ArrayNode>(FarmerList.getFarmerSummarys(zip),HttpStatus.OK);
	}
	// Get Detailed Report of One Farmer
	@RequestMapping(value = "/{fid}", method = RequestMethod.GET)
	public ResponseEntity<Farmer> getFarmer( @PathVariable("fid") int FarmerId){
		Farmer foundFarmer;
		try{
			foundFarmer=FarmerList.getFarmerById(FarmerId);
			return new ResponseEntity<Farmer>(foundFarmer,HttpStatus.OK);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<Farmer>(HttpStatus.NOT_FOUND);
		}
		
	}
	//Create New Farmer
	//TODO: check bad data
	@RequestMapping(value = "", method=RequestMethod.POST)
	public ResponseEntity<?> addFarmer(@RequestBody Farmer farmer){
		try{
		farmer.makeId();
		FarmerList.addFarmer(farmer);
		return new ResponseEntity<>(farmer.getFid(),HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//Update Farmer
	@RequestMapping(value = "/{fid}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateFarmer(@RequestBody Farmer farmer,  @PathVariable("fid") int FarmerId){
		try{
			farmer.setFid(FarmerList.getFarmerById(FarmerId).getFid());
			FarmerList.set(FarmerList.getFarmerIndexByFid(FarmerId),farmer);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/{fid}/deleate", method=RequestMethod.PUT)
	public HttpStatus deleateCustomer(@PathVariable("fid") int FarmerId){
		try{
			FarmerList.deleteFarmer(FarmerId);
			return HttpStatus.OK;
		}
		catch( IllegalArgumentException e){
			return HttpStatus.NOT_FOUND;
		}
	}
	//Post new Product
	@RequestMapping(value = "/{fid}/products", method=RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody Product product,@PathVariable("fid") int farmerId){
		try{
			
			Farmer foundFarmer=FarmerList.getFarmerById(farmerId);
			product.makefpsid();
			product.setName(product.getGcpid());
			System.out.println(product.getGcpid());
			foundFarmer.addProduct(product);
			return new ResponseEntity<>(product.getFpsid(),HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//Get all of a farmers products
	@RequestMapping(value = "/{fid}/products", method=RequestMethod.GET)
	public ResponseEntity<ProductList> getAllProducts(@PathVariable("fid") int farmerId){
		try{
			Farmer foundFarmer=FarmerList.getFarmerById(farmerId);
			return new ResponseEntity<ProductList>(foundFarmer.getProdutList(),HttpStatus.OK);
					
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//get one Product
	@RequestMapping(value = "/{fid}/products/{fpid}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("fid") int farmerId,@PathVariable("fpid") int productId){
		try{
			Farmer foundFarmer=FarmerList.getFarmerById(farmerId);
			return new ResponseEntity<Product>(foundFarmer.getProdutList().findProductById(productId),HttpStatus.OK);
					
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}