package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客服发送的图片消息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomImageReply extends AbstractCustomReply{

	@JsonProperty("image")
	private CustomMediaItem image;

	public CustomMediaItem getImage() {
		return image;
	}

	public void setImage(CustomMediaItem image) {
		this.image = image;
	}
}
