package com.lockedme.appinfo;

import java.util.Objects;

public class Developer {
	private String name; 
	private String address;
	private String contact;
	
	public Developer() {
		this("", "", "");
	}
	public Developer(String name, String address, String contact) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void display() {
		System.out.print("Developer: " + this.name);
		if(! Objects.isNull(this.address))
			System.out.print(", " + this.address);
		if(! Objects.isNull(this.contact))
			System.out.println(", Tel: " + this.contact);
	}
}
