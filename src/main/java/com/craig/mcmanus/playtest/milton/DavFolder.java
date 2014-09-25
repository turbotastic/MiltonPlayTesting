package com.craig.mcmanus.playtest.milton;
import java.util.ArrayList;
import java.util.List;


public class DavFolder {
        private String name;
        private List<DavFile> childFiles = new ArrayList<DavFile>();

        public DavFolder(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }             

        public List<DavFile> getChildFiles() {
            return childFiles;
        }                
    }