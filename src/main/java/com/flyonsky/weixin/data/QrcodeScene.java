package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 公众号二维码生成时的action_info数据
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QrcodeScene {

	@JsonProperty("scene_id")
	private int sceneId;
	
	@JsonProperty("scene_str")
	private String sceneStr;

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public String getSceneStr() {
		return sceneStr;
	}

	public void setSceneStr(String sceneStr) {
		this.sceneStr = sceneStr;
	}
	
}
