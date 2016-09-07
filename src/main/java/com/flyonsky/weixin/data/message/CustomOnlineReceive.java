package com.flyonsky.weixin.data.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 客服在线信息响应
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomOnlineReceive extends ServiceReceive{

	@JsonProperty("kf_online_list")
	private List<CustomOnline> kfOnlineList;

	public List<CustomOnline> getKfOnlineList() {
		return kfOnlineList;
	}

	public void setKfOnlineList(List<CustomOnline> kfOnlineList) {
		this.kfOnlineList = kfOnlineList;
	}
}
