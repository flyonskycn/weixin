package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class SendPicsInfo {
	
	@JsonProperty("Count")
	private int count;
	
	@JacksonXmlElementWrapper(localName="PicList")
	@JsonProperty("item")
	private List<PicMd5Sum> picList;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<PicMd5Sum> getPicList() {
		return picList;
	}

	public void setPicList(List<PicMd5Sum> picList) {
		this.picList = picList;
	}
	
}
