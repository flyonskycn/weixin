package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 获取客服聊天记录接口请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomRecordParam extends AbstractData{

	// 查询结束时间，UNIX时间戳
	@JsonProperty("endtime")
	private long endTime;
	
	// 查询第几页
	@JsonProperty("pageindex")
	private int pageIndex;
	
	// 每页大小，每页最多拉取50条
	@JsonProperty("pagesize")
	private int pageSize;
	
	// 查询开始时间，UNIX时间戳
	@JsonProperty("starttime")
	private long startTime;

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
}
