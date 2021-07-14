package com.lockedme.appinfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ApplicationInfo {
	private Developer author;
	private String applicationName; 
	private String description;
	
	public ApplicationInfo() {
        try (InputStream input = new FileInputStream("application.properties")) {

            Properties prop = new Properties();
            // load a properties file
            prop.load(input);            
            this.author= new Developer(prop.getProperty("author.name"), prop.getProperty("author.address"), prop.getProperty("author.contact"));
            this.applicationName= prop.getProperty("app.name");
            this.description= prop.getProperty("app.description");
//            this.display();
             
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//		this(null, null, null);
	}
	public ApplicationInfo(Developer author, String applicationName, String description) {
		this.author= author;
		this.applicationName= applicationName;
		this.description= description;
	}
	public void display() {
		System.out.println("------------------------------------------------------------");
		System.out.println("        " + this.applicationName + " Application ");
		System.out.println(this.description);
		System.out.println("------------------------------------------------------------");
		if( ! Objects.isNull(this.author) )
			this.author.display();
		System.out.println("************************************************************");

	}
}
