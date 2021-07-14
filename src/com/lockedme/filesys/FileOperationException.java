package com.lockedme.filesys;

public class FileOperationException extends Exception {
	public FileOperationException( ) {
		super();
	}
	public FileOperationException(String message) {
		super(message);
	}
}
