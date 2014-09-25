package com.craig.mcmanus.playtest.milton;

import io.milton.annotations.ChildrenOf;
import io.milton.annotations.Delete;
import io.milton.annotations.PutChild;
import io.milton.annotations.ResourceController;
import io.milton.annotations.Root;

import java.util.ArrayList;
import java.util.List;

@ResourceController
public class MiltonPlayController {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MiltonPlayController.class);

	private List<DavFolder> folders = new ArrayList<DavFolder>();

	public MiltonPlayController() {
		folders.add(new DavFolder("Folder1"));
		folders.add(new DavFolder("Folder2"));
	}

	@Root
	public MiltonPlayController getRoot() {
		return this;
	}

	@ChildrenOf
	public List<DavFolder> getRootFolders(MiltonPlayController root) {
		return folders;
	}

	@ChildrenOf
	public List<DavItem> getChildrenOfFolder(DavFolder folder) {
		return folder.getChildren();
	}

	@PutChild
	public DavFile upload(DavFolder folder, String newName, byte[] bytes) {
		DavFile uploadedFile = new DavFile();
		uploadedFile.setName(newName);
		uploadedFile.setBytes(bytes);
		folder.getChildren().add(uploadedFile);
		return uploadedFile;
	}

	@Delete
	public void deleteFile(DavFile fileToDelete) {
		DavFolder davFolder = folders.get(0);
		davFolder.getChildren().remove(0);
	}

}
