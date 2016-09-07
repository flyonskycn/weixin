package com.flyonsky.weixin.data.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 个性化菜单的匹配规则
 * @author Administrator
 *
 */
public class MatchRule extends AbstractData{

	// 用户分组id
	@JsonProperty("group_id")
	private int groupId;
	
	// 性别：男（1）女（2）
	@JsonProperty("sex")
	private int sex;
	
	// 国家信息
	@JsonProperty("country")
	private String country;
	
	// 省份信息
	@JsonProperty("province")
	private String province;
	
	// 城市信息
	@JsonProperty("city")
	private String city;
	
	// 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)
	@JsonProperty("client_platform_type")
	private int clientPlatformType;
	
	// 语言信息
	@JsonProperty("language")
	private String language;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getClientPlatformType() {
		return clientPlatformType;
	}

	public void setClientPlatformType(int clientPlatformType) {
		this.clientPlatformType = clientPlatformType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
