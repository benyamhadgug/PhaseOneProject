package com.lockedme.filesys;

import java.util.Comparator;

public class FileComparerDescending implements Comparator<FileWrap> {

	@Override
	public int compare(FileWrap o1, FileWrap o2) {
		return o2.compareTo(o1);
	}

}
