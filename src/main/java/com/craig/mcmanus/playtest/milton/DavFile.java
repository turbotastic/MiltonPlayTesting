package com.craig.mcmanus.playtest.milton;
public class DavFile {
        private String name;
        private byte[] bytes;

        public DavFile(String name, byte[] bytes) {
            this.name = name;
            this.bytes = bytes;
        }

        public String getName() {
            return name;
        }                
    }