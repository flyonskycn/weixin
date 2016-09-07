package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 自定义菜单的扫码信息
 * @author Administrator
 *
 */
public class ScanCodeInfo {

	@JsonProperty("ScanType")
	private String scanType;
	
	@JsonProperty("ScanResult")
	private String scanResult;

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getScanResult() {
		return scanResult;
	}

	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}
	
}
