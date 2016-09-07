package com.flyonsky.weixin.data.material;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaterialCountReceive extends ServiceReceive{

	@JsonProperty("voice_count")
	private int voiceCount;
	
	@JsonProperty("video_count")
	private int videoCount;
	
	@JsonProperty("image_count")
	private int imageCount;
	
	@JsonProperty("news_count")
	private int newsCount;

	public int getVoiceCount() {
		return voiceCount;
	}

	public void setVoiceCount(int voiceCount) {
		this.voiceCount = voiceCount;
	}

	public int getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}

	public int getImageCount() {
		return imageCount;
	}

	public void setImageCount(int imageCount) {
		this.imageCount = imageCount;
	}

	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}
	
}
