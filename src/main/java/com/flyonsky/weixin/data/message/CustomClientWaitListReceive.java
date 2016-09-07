package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 获取未接入会话列表响应
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomClientWaitListReceive extends ServiceReceive{

	@JsonProperty("count")
	private int count;
	
	@JsonProperty("waitcaselist")
	private List<CustomClientStatus> waitCaseList;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<CustomClientStatus> getWaitCaseList() {
		return waitCaseList;
	}

	public void setWaitCaseList(List<CustomClientStatus> waitCaseList) {
		this.waitCaseList = waitCaseList;
	}
	
}
