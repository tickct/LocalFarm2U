package com.LocalFarm2U.Controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LocalFarm2U.users.Farmer;

@RestController
public class FarmerController {

	@RequestMapping(value = "/farmers", method = RequestMethod.GET)
	public List<Farmer> getAllFarmers(){
		List<Farmer> farmers=new ArrayList<Farmer>();
		List<String> zips=new ArrayList<String>();
		Farmer farmer=new Farmer("Sean","123-123-1234","123 abc","email@email.com","A Farm","321-321-4321",zips);
		farmers.add(farmer);
		return farmers;
	}
	
}
