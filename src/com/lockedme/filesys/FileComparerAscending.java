package com.lockedme.filesys;

import java.util.Comparator;

public class FileComparerAscending implements Comparator<FileWrap> {

	@Override
	public int compare(FileWrap o1, FileWrap o2) {
		return o1.compareTo(o2);
	}

}
