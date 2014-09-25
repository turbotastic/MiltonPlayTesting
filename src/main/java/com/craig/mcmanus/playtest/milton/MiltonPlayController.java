package com.craig.mcmanus.playtest.milton;

import io.milton.annotations.ChildrenOf;
import io.milton.annotations.PutChild;
import io.milton.annotations.ResourceController;
import io.milton.annotations.Root;
import java.util.ArrayList;
import java.util.List;

@ResourceController
public class MiltonPlayController  {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MiltonPlayController.class);

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
    public List<DavFolder> getProducts(MiltonPlayController root) {
        return folders;
    }
    
    @ChildrenOf
    public List<DavFile> getChildrenOfFolder(DavFolder folder) {
        return folder.getChildFiles();
    }

    @PutChild
    public DavFile upload(DavFolder folder, String newName, byte[] bytes) {
        DavFile uploadedFile = new DavFile(newName, bytes);
        folder.getChildFiles().add(uploadedFile);
        return uploadedFile;
    }
}
