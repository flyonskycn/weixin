package com.flyonsky.weixin.data.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 批量获取用户信息查询参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchFetchParam extends AbstractData{

	@JsonProperty("user_list")
	private List<SimpleParam> userList;

	public List<SimpleParam> getUserList() {
		return userList;
	}

	public void setUserList(List<SimpleParam> userList) {
		this.userList = userList;
	}
}
