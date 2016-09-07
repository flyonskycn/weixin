package com.flyonsky.weixin.data.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 批量移动用户的请求参数
 * @author Administrator
 *
 */
public class BatchMoveGroupParam extends ServiceReceive{

	// 用户唯一标识符openid的列表（size不能超过50）
	@JsonProperty("openid_list")
	private List<String> openidList;
	
	// 分组id
	@JsonProperty("to_groupid")
	private int toGroupId;

	public List<String> getOpenidList() {
		return openidList;
	}

	public void setOpenidList(List<String> openidList) {
		this.openidList = openidList;
	}

	public int getToGroupId() {
		return toGroupId;
	}

	public void setToGroupId(int toGroupId) {
		this.toGroupId = toGroupId;
	}
}
