package com.lockedme.filesys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeDirectory implements IFileOperation {
	private String homeDirectory; 
	private List<FileWrap>  files;
	private boolean isSorted=false; 
	
	public HomeDirectory() {
		this.homeDirectory= FileSystemUtil.HOME_DIR;
		files= new ArrayList<>();
		this.populate();
	}
	public HomeDirectory(String homeDirectory) {
		this.homeDirectory= homeDirectory;
	}
	public void populate() {
		this.files.clear();
		File folder= new File(this.homeDirectory);
	    for (final File fileEntry : folder.listFiles()) {
	        if (! fileEntry.isDirectory()) {
	        	FileWrap fw= new FileWrap(fileEntry.getParent(), fileEntry.getName());
	        	this.files.add(fw);
	        }
	    }
	}
	public String getHomeDirectory() {
		return homeDirectory;
	}
	public void setHomeDirectory(String homeDirectory) {
		this.homeDirectory = homeDirectory;
	}
	@Override
	public boolean create(String filename)  throws FileOperationException {

		if(this.search(filename) != null)
			throw new FileOperationException("File already exists.");
		FileWrap fileWrap= new FileWrap(this.homeDirectory, filename);
	    File newFile = new File(new FileWrap(this.homeDirectory, filename).toFullString());
	    try {
			boolean flag= newFile.createNewFile();
			if(flag == false)
				return false; 
			int size=this.files.size();
			this.files.add(new FileWrap(this.homeDirectory, filename));
			return (this.files.size() == (size+1));
		} catch (IOException e) {
			throw new FileOperationException("File can not be deleted !");
		}
	}
	@Override
	public FileWrap search(String filename) {
		FileWrap key= new FileWrap(this.homeDirectory, filename);
		if(this.isSorted())
			return this.binarySearch(0, this.files.size()-1, key);
		return this.linearSearch(key);

	}
	@Override
	public boolean delete(String filename) throws FileOperationException {
		if(this.search(filename) == null)
			throw new FileOperationException("File does not exist to be deleted.");
		try {
		    File targetFile = new File(new FileWrap(this.homeDirectory, filename).toFullString()); 
		    targetFile.delete();
			int size=this.files.size();
			this.files.remove(new FileWrap(this.homeDirectory, filename));
			return (this.files.size() == (size-1)); 
		} catch (Exception e) {
			return false; 
		}
	}
	@Override
	public void display() {
		if(this.files.size() <= 0 ) {
			System.out.println("********************************************");
			System.out.println(" NOT FILE IN DIRECTORY - " + this.homeDirectory);
			System.out.println("********************************************");
			return;
		}
		System.out.println("********************************************");
		System.out.println(" FILES IN DIRECTORY - " + this.homeDirectory + ", Order -> ASCENDDING : ");
		System.out.println("********************************************");
		this.files.stream().sorted(new FileComparerAscending()).forEach(a->a.display());
		System.out.println("*************** FILE LIST END **************");
		System.out.println("********************************************");

	}
	@Override
	public void displaySorted() {
//		System.out.println("FILE LIST IN DESCENDING ORDER ----");
//		System.out.println("_________________________________________");
//		this.sortDescending();
//		this.files.stream().sorted(new FileComparerDescending()).forEach(a->a.display());
		if(this.files.size() <= 0 ) {
			System.out.println("********************************************");
			System.out.println(" NOT FILE IN DIRECTORY - " + this.homeDirectory);
			System.out.println("********************************************");
			return;
		}
		System.out.println("********************************************");
		System.out.println(" FILES IN DIRECTORY - " + this.homeDirectory + ", Order -> DESCENDDING : ");
		System.out.println("********************************************");
		this.files.stream().sorted(new FileComparerDescending()).forEach(a->a.display());
		System.out.println("*************** FILE LIST END **************");
		System.out.println("********************************************");
	}
	@Override
	public boolean sortAscending() {
		try {

			this.files.sort(new FileComparerAscending());
			return true;
		} catch(Exception e) {
			return false; 
		}
	}
	@Override
	public boolean sortDescending() {
		try {
			this.files.sort(new FileComparerDescending());
			return true;
		} catch(Exception e) {
			return false; 
		}
	}
	@Override
	public FileWrap[] getAll() {
		return (FileWrap[]) this.files.toArray();
	}
	public boolean isSorted() {
		if(this.files == null || this.files.size() <= 1)
			return true; 
		for(int i=1; i < this.files.size(); i++)
			if(this.files.get(i-1).compareTo(this.files.get(i)) > 0)
				return false; 
		return true; 
	}
	
	private FileWrap binarySearch(int l, int r, FileWrap fw) {
	    if (r >= l) {
	        int mid = l + (r - l) / 2;
	  
	        if (this.files.get(mid).equals(fw))
	            return this.files.get(mid);

	        if (this.files.get(mid).compareTo(fw) > 0)
	            return binarySearch(l, mid - 1, fw);

	        return binarySearch(mid + 1, r, fw);
	    }
	    return null;
	}
	private FileWrap linearSearch(FileWrap key) {
		for(int i=0; i < this.files.size(); i++)
			if(this.files.get(i).equals(key))
				return this.files.get(i);
		return null; 
	}
}
