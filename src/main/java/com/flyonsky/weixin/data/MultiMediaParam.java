package com.flyonsky.weixin.data;

/**
 * 多媒体参数
 * @author Administrator
 *
 */
public class MultiMediaParam {

	// 多媒体参数名称,黙认为media
	private String paramName = "media";
	
	// 多媒体对象
	private MultiMedia multiMedia;

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public MultiMedia getMultiMedia() {
		return multiMedia;
	}

	public void setMultiMedia(MultiMedia multiMedia) {
		this.multiMedia = multiMedia;
	}
	
}
