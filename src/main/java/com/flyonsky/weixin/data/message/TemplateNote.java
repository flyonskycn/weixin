package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateNote {

	@JsonProperty("value")
	private String value;
	
	@JsonProperty("color")
	private String color;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
