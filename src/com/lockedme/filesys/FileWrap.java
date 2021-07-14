package com.lockedme.filesys;

import java.util.Objects;

/*
 * Wraps a File with parent path and file name
 */
public class FileWrap implements Comparable<FileWrap> {
	//field definition
	private String path; 
	private String name;
	
	//argument constructor 
	public FileWrap(String path, String name) {
		this.path= path;
		this.name= name;
	}
	//returns the File objects as absolute path file
	public String getFileAsString() {
		try {
			return this.path + FileSystemUtil.FOLDER_SEPARATOR + this.name;
		} catch(Exception e ) {
			return null;
		}
	}
	// Returns the file name as the object string representation
	@Override
	public String toString() {
		return this.name;
	}
	// returns the file file path as string representtion of the object
	public String toFullString() {
		return this.path + FileSystemUtil.FOLDER_SEPARATOR +this.name;
	}
	//Displays the string representation of the File object to standard console app
	public void display() {
		System.out.println(this.toString());
	}
	//Displays the path representation of the File object to standard console stream
	public void displayFull() {
		System.out.println(this.toFullString());
	}
	// getter for path field
	public String getPath() {
		return path;
	}
	//setter for path field
	public void setPath(String path) {
		this.path = path;
	}
	//getter for file name
	public String getName() {
		return name;
	}
	//setter for file name
	public void setName(String name) {
		this.name = name;
	}
	// compares two FileWrap object
	@Override
	public int compareTo(FileWrap o) {
		if(Objects.isNull(o))
			return 1;
		int pathCompare= this.path.compareTo(o.path);
		if(pathCompare != 0 )	return pathCompare;
		return this.name.compareTo(o.name);
	}
	//compares current object with another for equality
	@Override
	public boolean equals(Object o) {
		if(Objects.isNull(o))
			return false; 
		if(! (o instanceof FileWrap))
			return false; 
		FileWrap of= (FileWrap)o;
		try {
			return ((this.path.equals(of.path)) & (this.name.equals(of.name)));
		} catch(Exception e) {
			return false;
		}
	}
	
}
