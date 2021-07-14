package com.lockedme.menu;

/*
 * Interface for Console GUI
 */
public interface IMenu {
	//prints the menu options
	void displayMenuOptions();
	// receives valid input value from console
	int acceptMenuOptions();
	//drives the application
	void driveMenu();
	// acceptes valid file name input from user
	String getFileName(String op);
}
