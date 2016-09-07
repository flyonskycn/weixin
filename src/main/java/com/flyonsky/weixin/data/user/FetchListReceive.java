package com.flyonsky.weixin.data.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 获取用户列表响应
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchListReceive extends ServiceReceive{

	@JsonProperty("total")
	private int total;
	
	@JsonProperty("count")
	private int count;
	
	@JsonProperty("data")
	private UserArray data;
	
	@JsonProperty("next_openid")
	private String nextOpenid;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UserArray getData() {
		return data;
	}

	public void setData(UserArray data) {
		this.data = data;
	}

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}
}
