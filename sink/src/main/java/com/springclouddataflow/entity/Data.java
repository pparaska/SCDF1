package com.springclouddataflow.entity;

import org.springframework.data.annotation.Id;

public class Data {

	@Id
	private Integer id;	
	private String data;
	
	public Data() {
		// TODO Auto-generated constructor stub
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
