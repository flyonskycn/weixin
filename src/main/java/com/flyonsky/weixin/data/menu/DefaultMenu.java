package com.flyonsky.weixin.data.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 微信自定义菜单
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultMenu extends AbstractData{

	@JsonProperty("button")
	private List<MenuItem> button;

	public List<MenuItem> getButton() {
		return button;
	}

	public void setButton(List<MenuItem> button) {
		this.button = button;
	}
	
}
