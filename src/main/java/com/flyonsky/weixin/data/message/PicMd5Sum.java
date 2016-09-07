package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PicMd5Sum {

	@JsonProperty("PicMd5Sum")
	private String md5;

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}
}
