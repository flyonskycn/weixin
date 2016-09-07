package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 所有客服账号响应
 * @author Administrator
 *
 */
public class CustomListReceive extends ServiceReceive{

	// 客户信息列表
	@JsonProperty("kf_list")
	private List<Custom> kfList;

	public List<Custom> getKfList() {
		return kfList;
	}

	public void setKfList(List<Custom> kfList) {
		this.kfList = kfList;
	} 
}
