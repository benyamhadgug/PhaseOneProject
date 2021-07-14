package com.lockedme.appinfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
/*
 * Encapsulates information of the application; such as description and developer information
 */
public class ApplicationInfo {
	private Developer author;
	private String applicationName; 
	private String description;
	
	//Default constructor
	public ApplicationInfo() {
		// retrieves application configs from properties file in the root of the project
        try (InputStream input = new FileInputStream("application.properties")) {

            Properties prop = new Properties();
            // loads the properties with file content
            prop.load(input);       
            //load developer configs from properties file
            this.author= new Developer(prop.getProperty("author.name"), prop.getProperty("author.address"), prop.getProperty("author.contact"));
          //load applciation configs from properties file
            this.applicationName= prop.getProperty("app.name");
            this.description= prop.getProperty("app.description");
             
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	// Argumented constructor
	public ApplicationInfo(Developer author, String applicationName, String description) {
		this.author= author;
		this.applicationName= applicationName;
		this.description= description;
	}
	// Console-prints the app infor
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
