package com.lockedme.filesys;

public interface IFileOperation {
	
	boolean create(String filename) throws FileOperationException;
	FileWrap search(String filename);
	boolean delete(String filename) throws FileOperationException;
	void display();
	void displaySorted();
	boolean sortAscending();
	boolean sortDescending();
	FileWrap[] getAll();
}
