package com.flyonsky.weixin.data;

import java.io.InputStream;

/**
 * 多媒体对象
 * @author Administrator
 *
 */
public class MultiMedia {

	private String fileName;
	
	private InputStream inputStream; 
	
	private EnumMaterialContentType type;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public EnumMaterialContentType getType() {
		return type;
	}

	public void setType(EnumMaterialContentType type) {
		this.type = type;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
