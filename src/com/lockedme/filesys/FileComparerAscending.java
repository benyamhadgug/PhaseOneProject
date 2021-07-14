package com.lockedme.filesys;

import java.util.Comparator;

/*
 * Functional interface definition for sorting files descendingsly
 */
public class FileComparerAscending implements Comparator<FileWrap> {
	@Override
	public int compare(FileWrap o1, FileWrap o2) {
		return o1.compareTo(o2);
	}
}
