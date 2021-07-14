package com.lockedme.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.lockedme.appinfo.ApplicationInfo;
import com.lockedme.filesys.FileOperationException;
import com.lockedme.filesys.FileWrap;
import com.lockedme.filesys.HomeDirectory;

/*
 * Driver application based on menu
 */
public class MenuDriver implements IMenu {
	//field definfition
	private HomeDirectory homeDirectory;
	private ApplicationInfo applicationInfo;
	
	// Argumented constructor
	public MenuDriver(ApplicationInfo applicationInfo, HomeDirectory homeDirectory) {
		this.applicationInfo= applicationInfo;
		this.homeDirectory= homeDirectory;
	}
	// Displays menu content for user to choose from
	@Override
	public void displayMenuOptions() {
		this.applicationInfo.display();
		System.out.println("xxxxxxxxxxxxx MENU xxxxxxxxxxxxxxx");
		System.out.println("1 ................ TO List file in Ascending Order");
		System.out.println("2 ................ TO List file in Descending Order");
		System.out.println("3 ................ TO Create a new file.");
		System.out.println("4 ................ TO Search a file.");
		System.out.println("5 ................ TO Delete a file.");
		System.out.println("6 ................ TO Quit!");
	}
	
	// Accepts user input as required by the menu range
	@Override
	public int acceptMenuOptions() {
		Scanner scanner= new Scanner(System.in);
		int num=1; 
		try {
			//gets the next input integer in stream
			num= scanner.nextInt();
		} catch(Exception e) {
			num= 0;
		}
		//checks and loops while input is out of range
		while(num < 1 || num > 6) {
			System.out.println("Value shouls be 1-6, according to the menu displayed.");
			num= scanner.nextInt();
		}
		//scanner.close();
		return num;
	}

	// Iteratively displays menu, accepts input and execute operation until user signals exit
	@Override
	public void driveMenu() {
		int num=1;
		String filename=null;
		boolean flag= false;
		do {
			//shows the menu
			this.displayMenuOptions();
			
			//accepts user choice of operation
			num= this.acceptMenuOptions();
			switch(num) {
			case 1:
				//displays user home directory in ascending order
				this.homeDirectory.display();
				break;
			
			case 2:
				//displays user home directory in descending order
				this.homeDirectory.displaySorted();
				break;
			
			case 3:
				//accept user input for the new file name
				filename= this.getFileName("Create"); 
				try {
					//create a file in the home directory for the user
					flag= this.homeDirectory.create(filename);
				} catch (FileOperationException e) {
					System.out.println(e.getMessage());
					flag=false;
				}
				// ouput result of creating the file
				if(! flag )
					System.out.println("File was not created.");
				else
					System.out.println("File was created");
				break;
			
			case 4:
				//accepts the file name to search
				filename= this.getFileName("Search"); 
				//retrieves matching file
				FileWrap file= this.homeDirectory.search(filename);
				//output result of the search
				if(file == null )
					System.out.println("File does not exist.");
				else {
					System.out.println("File exists. Here is the detail " );
					file.displayFull();
				}
					
				break;
			
			case 5:
				//accepts file name to delete
				filename= this.getFileName("Delete"); 
				try {
					//perform a deletion of the file 
					flag= this.homeDirectory.delete(filename);
				} catch (FileOperationException e) {
					System.out.println(e.getMessage());
					flag=false;
				}
				//displays result of the deletion operatino
				if(! flag )
					System.out.println("File was not deleted.");
				else
					System.out.println("File was deleted");
				break;
			case 6:
				System.out.println(".... EXISTING APP.");
				System.exit(1);
			}
		} while( num != 6 );
	}
	//accepts user input for file name
	@Override
	public String getFileName(String op) {
		System.out.println("Enter a file name to " + op + " : ");
		Scanner scanner= new Scanner(System.in);
		
		String name=null;
		try {
			name= scanner.nextLine();
		} catch(NoSuchElementException e) {
			scanner.reset();
		}catch(Exception e) {
			name=null;
		}
				
		while(name == null || name.trim().equals("") || name.contains(" ")) {
			System.out.println("File name is invalid. It should not be empty or contain space in between characters.");
			name= scanner.nextLine();
		}
		//scanner.close();
		return name;	
	}
}
