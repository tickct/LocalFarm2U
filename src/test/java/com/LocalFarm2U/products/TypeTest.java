package com.LocalFarm2U.products;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TypeTest {
	Types typeTest=new Types();
	@Test
	public void addAdds() {
		typeTest.addType("test");
		assertEquals(1,typeTest.size());
	}
	@Test
	public void addDosntAddDuplcates() {
		typeTest.addType("test");
		typeTest.addType("test");
		assertEquals(1,typeTest.size());
	}
	@Test
	public void sizeCallsArrayListSize(){
		assertEquals(typeTest.size(),typeTest.getTypes().size());
		
	}

}
