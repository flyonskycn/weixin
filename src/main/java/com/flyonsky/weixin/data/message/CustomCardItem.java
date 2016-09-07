package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服消息的卡券项
 * @author Administrator
 *
 */
public class CustomCardItem {

	@JsonProperty("card_id")
	private String cardId;
	
	@JsonProperty("card_ext")
	private String cardExt;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardExt() {
		return cardExt;
	}

	public void setCardExt(String cardExt) {
		this.cardExt = cardExt;
	}
}
