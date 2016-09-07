package com.flyonsky.weixin.data.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 删除个性化菜单的请求参数
 * @author Administrator
 *
 */
public class DeleteParam extends AbstractData{

	@JsonProperty("menuid")
	private String menuid;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
}
