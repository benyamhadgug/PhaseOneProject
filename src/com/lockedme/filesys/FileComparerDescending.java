package com.lockedme.filesys;

import java.util.Comparator;
	/*
	 * Functional interface definition for sorting files ascendingly
	 */
public class FileComparerDescending implements Comparator<FileWrap> {

	@Override
	public int compare(FileWrap o1, FileWrap o2) {
		return o2.compareTo(o1);
	}

}
