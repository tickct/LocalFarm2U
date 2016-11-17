package com.LocalFarm2U.Controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LocalFarm2U.products.Type;
import com.LocalFarm2U.products.Types;

@RestController
@RequestMapping("/managers")
public class ManagerController {
	@RequestMapping(value = "/catalog", method = RequestMethod.POST)
	public String addType(@RequestBody String name){
		String[] fixedName=name.split("\\w");
		Types.addType(fixedName[4]);
		String id=Types.getIDFromName(name);
		return id;
	}
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public List<Type> getTypes(){
		return Types.getTypes();
	}
}
