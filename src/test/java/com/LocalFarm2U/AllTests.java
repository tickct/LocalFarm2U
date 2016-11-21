package com.LocalFarm2U;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.LocalFarm2U.order.LineItemtest;
import com.LocalFarm2U.order.OrderTest;
import com.LocalFarm2U.products.ProductTest;
import com.LocalFarm2U.products.TypeTest;
import com.LocalFarm2U.userControl.CustomerListTest;
import com.LocalFarm2U.userControl.FarmerListTest;
import com.LocalFarm2U.userControl.ManagerListTest;
import com.LocalFarm2U.users.CustomersTest;
import com.LocalFarm2U.users.FarmerTest;
import com.LocalFarm2U.users.ManagerTest;
import com.LocalFarm2U.users.UserTest;
import com.LocalFarm2U.users.farmers.FarmerFarmInfoTest;

@RunWith(Suite.class)
@SuiteClasses({LineItemtest.class,
				OrderTest.class,ProductTest.class, TypeTest.class,
				ManagerListTest.class,FarmerListTest.class,CustomerListTest.class,
				CustomersTest.class,ManagerTest.class,
				FarmerTest.class,UserTest.class,FarmerFarmInfoTest.class})
public class AllTests {

}
