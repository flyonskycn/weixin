package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 获取客服聊天记录接口响应
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomRecordReceive extends ServiceReceive{
	
	@JsonProperty("retcode")
	private int retCode;
	
	@JsonProperty("recordlist")
	private List<CustomRecord> recordList;

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public List<CustomRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<CustomRecord> recordList) {
		this.recordList = recordList;
	}
}
