package com.LocalFarm2U;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LocalFarm2U.userControl.ManagerList;
import com.LocalFarm2U.users.Manager;

@SpringBootApplication
public class LocalFarm2UApplication {

	public static void main(String[] args) {
		//creating the intial manager
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String Stringdate=format.format(date);
		Manager manager=new Manager();
		manager.setName("root");
		manager.setCreate_date(Stringdate);
		manager.setCreated_by("System");
		manager.setEmail("It@LocalFarm2U.com");
		manager.setPhone("555-555-5555");
		manager.makeID();
		ManagerList.addManager(manager);
		SpringApplication.run(LocalFarm2UApplication.class, args);
	}
}
