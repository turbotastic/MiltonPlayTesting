package com.craig.mcmanus.playtest.milton;

import io.milton.annotations.ContentLength;
import io.milton.annotations.Get;
import io.milton.annotations.Name;

public class DavFile implements DavItem {

	private String name;

	private byte[] bytes;

	// public String getName(DavFile file) {
	// return name;
	// }

	public void setName(String name) {
		System.out.println("MY NAME IS: " + name);
		this.name = name;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	@Name
	public String getName() {
		return name;
	}

	@Get
	public byte[] getFile() {
		return bytes;
	}

	@ContentLength
	public long getContentLength() {
		return (long) bytes.length;
	}
}