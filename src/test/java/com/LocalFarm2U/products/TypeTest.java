package com.LocalFarm2U.products;

import static org.junit.Assert.*;

import org.junit.Test;

public class TypeTest {
	Types typeTest=new Types();
	@Test
	public void addDosntAddDuplcates() {
		typeTest.clear();
		typeTest.addType(new Type("test"));
		typeTest.addType(new Type("test"));
		assertEquals(1,typeTest.size());
	}
	@Test
	public void sizeCallsArrayListSize(){
		assertEquals(typeTest.size(),typeTest.getTypes().size());
	}
	@Test
	public void getIdFromNameReturnsCorrect(){
		typeTest.clear();
		Type type=new Type("test");
		typeTest.addType(type);
		assertEquals(type.getGcpid(),typeTest.getIDFromName("test"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void getIdFromNameReturnsErrorIfNameDosntExist(){
		typeTest.getIDFromName("wrongname");
	}
	@Test
	public void IdExists(){
		typeTest.clear();
		Type type=new Type("test");
		typeTest.addType(type);
		assertTrue(typeTest.idExists(type.getGcpid()));
	}
	@Test
	public void IddosntExist(){
		assertFalse(typeTest.idExists("WorngID"));
	}
	@Test
	public void NameExists(){
		typeTest.clear();
		Type type=new Type("test");
		typeTest.addType(type);
		assertTrue(typeTest.nameExists(type.getName()));
	}
	@Test
	public void NamedosntExist(){
		assertFalse(typeTest.nameExists("WorngName"));
	}
	@Test
	public void getTypeFromIdWorks(){
		typeTest.clear();
		Type type=new Type("test");
		typeTest.addType(type);
		assertEquals(type,typeTest.getTypeById(type.getGcpid()));
	}
	@Test(expected=IllegalArgumentException.class)
	public void getTypefromIdthrowsErrorifIddosntExist(){
		typeTest.getTypeById("WrongId");
	}
	@Test
	public void updateTypeupdates(){
		typeTest.clear();
		Type type=new Type("test");
		typeTest.addType(type);
		Type type2=new Type("Second Test");
		type2.setGcpid(Integer.parseInt(type.getGcpid()));
		typeTest.updateType(type.getGcpid(), type2);
		assertEquals(typeTest.getNameFromID(type.getGcpid()),type2.getName());
	}
	@Test(expected=IllegalArgumentException.class)
	public void UpdatethrowsErrorifIddosntExist(){
		typeTest.updateType("WrongId", new Type("WorngType"));
	}
	@Test
	public void TypeIdIsUnique(){
		typeTest.clear();
		Type type=new Type("test");
		Type type2=new Type("Second Test");
		assertFalse(type.getGcpid().equals(type2.getGcpid()));
	}

}
