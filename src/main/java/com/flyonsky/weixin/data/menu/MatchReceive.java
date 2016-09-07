package com.flyonsky.weixin.data.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 测试个性化菜单匹配结果
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchReceive extends ServiceReceive{

	@JsonProperty("menu")
	private DefaultMenu menu;

	public DefaultMenu getMenu() {
		return menu;
	}

	public void setMenu(DefaultMenu menu) {
		this.menu = menu;
	}
}
