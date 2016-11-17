package com.LocalFarm2U.products;

public class Type {
	private static int gcpidCount=100;
	private String gcpid;
	private String name;
	public Type(){
	}
	public Type(String nm){
		name=nm;
		gcpid=Integer.toString(gcpidCount);
		gcpidCount++;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getGcpid() {
		// TODO Auto-generated method stub
		return gcpid;
	}
}
