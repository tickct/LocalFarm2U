package com.LocalFarm2U.Controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LocalFarm2U.StubObjects.DeliveryCharge;
import com.LocalFarm2U.userControl.FarmerList;

@RestController
@RequestMapping("/farmers/{fid}/delivery_charge")
public class DeliveryController {
	@RequestMapping(value = (""), method=RequestMethod.POST)
	public ResponseEntity<?> updateDeliveryCharge(@PathVariable("fid") int farmerId,@RequestBody DeliveryCharge deliveryCharge){
		//try{
			FarmerList.getFarmerById(farmerId).setDeliveryCharge((deliveryCharge.getDelivery_charge()));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		//}
		//catch(IllegalArgumentException e){
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//}
	}
	@RequestMapping(value = (""), method=RequestMethod.GET)
	public ResponseEntity<?> viewDeliveryCharge(@PathVariable("fid") int farmerId){
		try{
			return new ResponseEntity<>(FarmerList.getFarmerById(farmerId).getDeliveryCharge(),HttpStatus.OK);
		}
		catch(IllegalArgumentException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
