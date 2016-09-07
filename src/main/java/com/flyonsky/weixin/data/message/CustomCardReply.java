package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 发送卡券
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomCardReply extends AbstractCustomReply{

	@JsonProperty("wxcard")
	private CustomCardItem wxCard;

	public CustomCardItem getWxCard() {
		return wxCard;
	}

	public void setWxCard(CustomCardItem wxCard) {
		this.wxCard = wxCard;
	}
}
