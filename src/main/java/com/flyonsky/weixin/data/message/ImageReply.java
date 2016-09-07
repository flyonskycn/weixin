package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 回复图片消息
 * @author Administrator
 *
 */
@JacksonXmlRootElement(localName="xml")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageReply extends AbstractReply{

	@JsonProperty("Image")
	private ImageItem image;

	public ImageItem getImage() {
		return image;
	}

	public void setImage(ImageItem image) {
		this.image = image;
	}
}
