package com.lockedme.filesys;

import java.util.Objects;

public class FileWrap implements Comparable<FileWrap> {
	private String path; 
	private String name;
	
	public FileWrap(String path, String name) {
		this.path= path;
		this.name= name;
	}
	public String getFileAsString() {
		try {
			return this.path + FileSystemUtil.FOLDER_SEPARATOR + this.name;
		} catch(Exception e ) {
			return null;
		}
	}
	@Override
	public String toString() {
		return this.name;
	}
	public String toFullString() {
		return this.path + FileSystemUtil.FOLDER_SEPARATOR +this.name;
	}
	public void display() {
		System.out.println(this.toString());
	}
	public void displayFull() {
		System.out.println(this.toFullString());
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(FileWrap o) {
		if(Objects.isNull(o))
			return 1;
		int pathCompare= this.path.compareTo(o.path);
		if(pathCompare != 0 )	return pathCompare;
		return this.name.compareTo(o.name);
	}
	
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
