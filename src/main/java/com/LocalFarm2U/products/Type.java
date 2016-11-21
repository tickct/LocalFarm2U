package com.LocalFarm2U.products;

public class Type {
	private static int gcpidCount=100;
	private String gcpid;
	private String name;
	public Type(){
		
	}
	public Type(String nm){
		name=nm;
		makeGcpid();
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getGcpid() {
		// TODO Auto-generated method stub
		return gcpid;
	}
	public void setName(String nm){
		name=nm;
	}
	public void makeGcpid(){
		gcpid=Integer.toString(gcpidCount);
		gcpidCount++;
	}
	public void setGcpid(int catologId) {
		gcpid=Integer.toString(catologId);
		
	}
}
