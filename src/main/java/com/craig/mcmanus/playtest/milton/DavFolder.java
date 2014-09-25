package com.craig.mcmanus.playtest.milton;

import io.milton.annotations.Name;

import java.util.ArrayList;
import java.util.List;

public class DavFolder implements DavItem {
	private String name;
	private List<DavItem> childFiles = new ArrayList<DavItem>();

	public DavFolder() {

	}

	public DavFolder(String folderName) {
		name = folderName;
	}

	@Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DavItem> getChildren() {
		return childFiles;
	}

	public void setChildFiles(List<DavItem> childFiles) {
		this.childFiles = childFiles;
	}
}