package com.lockedme.filesys;

/*
 * Defines exception for file operations of create and delete in existing home directory for the user
 */
public class FileOperationException extends Exception {
	// default constructor
	public FileOperationException( ) {
		super();
	}
	//argumented constructor
	public FileOperationException(String message) {
		super(message);
	}
}
