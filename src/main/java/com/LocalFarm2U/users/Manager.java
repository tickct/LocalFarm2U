package com.LocalFarm2U.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Manager extends User{
	private String mid;
	private String created_by;
	private String create_date;
	@JsonIgnore
	private static int ManagerIdCount=100;
	public Manager(){
		super();
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public void makeID() {
		mid=Integer.toString(ManagerIdCount);
		ManagerIdCount++;
	}
}
