package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息转发到多客服的消息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomTransferReply extends AbstractReply{

	@JsonProperty("TransInfo")
	private CustomTransInfo transInfo;

	public CustomTransInfo getTransInfo() {
		return transInfo;
	}

	public void setTransInfo(CustomTransInfo transInfo) {
		this.transInfo = transInfo;
	}
}
