package com.LocalFarm2U.Controlers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LocalFarm2U.userControl.ManagerList;
import com.LocalFarm2U.users.Manager;

@RestController
@RequestMapping("/managers/accounts")
public class ManagerController {
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String makeManager(@RequestBody Manager manager){
		manager.makeID();
		ManagerList.addManager(manager);
		return manager.getMid();
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Manager> getAllManager(){
		return ManagerList.getManagerList();
	}
	@RequestMapping(value = "/{mid}", method = RequestMethod.GET)
	public Manager getAllManager(@PathVariable("mid") int managerID){
		return ManagerList.findManagerbyID(Integer.toString(managerID));
	}
}

