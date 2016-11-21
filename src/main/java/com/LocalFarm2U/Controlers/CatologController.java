package com.LocalFarm2U.Controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LocalFarm2U.products.Type;
import com.LocalFarm2U.products.Types;

@RestController
@RequestMapping("/managers")
public class CatologController {
	//add new product to catolog
	@RequestMapping(value = "/catalog", method = RequestMethod.POST)
	public String addType(@RequestBody Type type){
		type.makeGcpid();
		Types.addType(type);
		return type.getGcpid();
	}
	//get list off all catalog
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public List<Type> getTypes(){
		return Types.getTypes();
	}
	//get data of single catalog entry
	@RequestMapping(value = "/catalog/{gcpid}", method = RequestMethod.GET)
	public Type getOneType(@PathVariable("gcpid") int catalogId){
			return Types.getTypeById(Integer.toString(catalogId));
	}
	//Update product
	@RequestMapping(value = "/catalog/{gcpid}", method = RequestMethod.POST)
	public HttpStatus updateProduct(@PathVariable("gcpid") int catologId,@RequestBody Type Newtype){
			try{
				Newtype.setGcpid(catologId);
				System.out.println(Newtype.getGcpid());
				Types.updateType(Integer.toString(catologId), Newtype);
				return HttpStatus.OK;

			}
			catch(IllegalArgumentException e){
				return HttpStatus.NOT_FOUND;
			}
			}
}
