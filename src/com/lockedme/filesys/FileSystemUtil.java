package com.lockedme.filesys;

import java.io.File;

/*
 * Contains fields and method for handling environment-specific user home and file separator markers
 */
public class FileSystemUtil {
	public static final String HOME_DIR;
	public static final String FOLDER_SEPARATOR;
	static {
		//retrieves the system property for user home directory
		HOME_DIR= System.getProperty("user.home");
		//retrieves the system property for file separator
		FOLDER_SEPARATOR= System.getProperty("file.separator");
	}
	// returns the home directory in Java File object format
	public static File getUserHomeFolder() {
		return new File(HOME_DIR);
	}
}
