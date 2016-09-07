package com.flyonsky.weixin.data.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 创建个性化菜单接口的近回结果
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalityReceive extends ServiceReceive{

	// 创建成功后的个性化菜单Id
	@JsonProperty("menuid")
	private String menuid;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
}
