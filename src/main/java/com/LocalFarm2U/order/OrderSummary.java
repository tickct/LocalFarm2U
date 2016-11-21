package com.LocalFarm2U.order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderSummary {
	private String oid;
	private String order_date;
	private String planned_delivery_date;
	private String actural_delivery_date;
	private String status;
	private String fid;
	public OrderSummary(String oid, String planned_delivery_date, String actural_delivery_date,
			String status, String fid) {
		super();
		this.oid = oid;
		setOrder_date();
		this.planned_delivery_date = planned_delivery_date;
		this.actural_delivery_date = actural_delivery_date;
		this.status = status;
		this.fid = fid;
	}
	public OrderSummary() {
		
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date() {
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		order_date=format.format(date);
	}
	public String getPlanned_delivery_date() {
		return planned_delivery_date;
	}
	public void setPlanned_delivery_date(String planned_delivery_date) {
		this.planned_delivery_date = planned_delivery_date;
	}
	public String getActural_delivery_date() {
		return actural_delivery_date;
	}
	public void setActural_delivery_date(String actural_delivery_date) {
		this.actural_delivery_date = actural_delivery_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String stat) {
		this.status = stat;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
}
