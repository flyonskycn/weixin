package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 地理位置选择器娄据
 * @author Administrator
 *
 */
public class SendLocationInfo {

	// X坐标信息
	@JsonProperty("Location_X")
	private double locationX;
	
	@JsonProperty("Location_Y")
	private double locationY;
	
	@JsonProperty("Scale")
	private double scale;
	
	@JsonProperty("Label")
	private String label;
	
	@JsonProperty("Poiname")
	private String poiname;

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return locationY;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPoiname() {
		return poiname;
	}

	public void setPoiname(String poiname) {
		this.poiname = poiname;
	}
}
