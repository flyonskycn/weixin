package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scene {

	@JsonProperty("scene")
	private QrcodeScene scene;

	public QrcodeScene getScene() {
		return scene;
	}

	public void setScene(QrcodeScene scene) {
		this.scene = scene;
	}
}
