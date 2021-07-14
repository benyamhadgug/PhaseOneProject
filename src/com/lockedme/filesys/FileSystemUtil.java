package com.lockedme.filesys;

import java.io.File;

public class FileSystemUtil {
	public static final String HOME_DIR;
	public static final String FOLDER_SEPARATOR;
	static {
		HOME_DIR= System.getProperty("user.home");
		FOLDER_SEPARATOR= System.getProperty("file.separator");
	}

	public static File getUserHomeFolder() {
		return new File(HOME_DIR);
	}
}
