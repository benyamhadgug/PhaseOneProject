package com.lockedme.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.lockedme.appinfo.ApplicationInfo;
import com.lockedme.filesys.FileOperationException;
import com.lockedme.filesys.FileWrap;
import com.lockedme.filesys.HomeDirectory;

public class MenuDriver implements IMenu {
	private HomeDirectory homeDirectory;
	private ApplicationInfo applicationInfo;
	
	public MenuDriver(ApplicationInfo applicationInfo, HomeDirectory homeDirectory) {
		this.applicationInfo= applicationInfo;
		this.homeDirectory= homeDirectory;
	}
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

	@Override
	public int acceptMenuOptions() {
		Scanner scanner= new Scanner(System.in);
		int num=1; 
		try {
			num= scanner.nextInt();
		} catch(Exception e) {
			num= 0;
		}
		
		while(num < 1 || num > 7) {
			System.out.println("Value shouls be 1-6, according to the menu displayed.");
			num= scanner.nextInt();
		}
		//scanner.close();
		return num;
	}

	@Override
	public void driveMenu() {
		int num=1;
		String filename=null;
		boolean flag= false;
		do {
			this.displayMenuOptions();
			num= this.acceptMenuOptions();
			switch(num) {
			case 1:
				this.homeDirectory.display();
				break;
			
			case 2:
				this.homeDirectory.displaySorted();
				break;
			
			case 3:
				filename= this.getFileName("Create"); 
				try {
					flag= this.homeDirectory.create(filename);
				} catch (FileOperationException e) {
					System.out.println(e.getMessage());
					flag=false;
				}
				if(! flag )
					System.out.println("File was not created.");
				else
					System.out.println("File was created");
				break;
			
			case 4:
				filename= this.getFileName("Search"); 
				FileWrap file= this.homeDirectory.search(filename);
				if(file == null )
					System.out.println("File does not exist.");
				else {
					System.out.println("File exists. Here is the detail " );
					file.displayFull();
				}
					
				break;
			
			case 5:
				filename= this.getFileName("Delete"); 
				try {
					flag= this.homeDirectory.delete(filename);
				} catch (FileOperationException e) {
					System.out.println(e.getMessage());
					flag=false;
				}
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
