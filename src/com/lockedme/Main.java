package com.lockedme;

import java.io.File;
import java.nio.file.Path;

import com.lockedme.appinfo.ApplicationInfo;
import com.lockedme.filesys.FileOperationException;
import com.lockedme.filesys.FileSystemUtil;
import com.lockedme.filesys.HomeDirectory;
import com.lockedme.menu.MenuDriver;

public class Main {

	public static void main(String[] args) {
		// Main menu
		ApplicationInfo app= new ApplicationInfo();
		
		HomeDirectory homeDirectory= new HomeDirectory();
		
		MenuDriver menu= new MenuDriver(app, homeDirectory);
		
		//calls the UI of the app
		menu.driveMenu();
	}
	
}
