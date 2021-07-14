package com.lockedme.appinfo;

import java.util.Objects;

/*
 * Denotes a developer of the application; an entity class
 */
public class Developer {
	// fields definition
	private String name; 
	private String address;
	private String contact;
	
	//default constructor
	public Developer() {
		this("", "", "");
	}
	//argumented constructor
	public Developer(String name, String address, String contact) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	// name field getter
	public String getName() {
		return name;
	}
	//name field setter
	public void setName(String name) {
		this.name = name;
	}
	// address field getter
	public String getAddress() {
		return address;
	}
	// address field setter
	public void setAddress(String address) {
		this.address = address;
	}
	// contact field getter
	public String getContact() {
		return contact;
	}
	//contact field setter
	public void setContact(String contact) {
		this.contact = contact;
	}
	// console-prints developer information
	public void display() {
		System.out.print("Developer: " + this.name);
		if(! Objects.isNull(this.address))
			System.out.print(", " + this.address);
		if(! Objects.isNull(this.contact))
			System.out.println(", Tel: " + this.contact);
	}
}
