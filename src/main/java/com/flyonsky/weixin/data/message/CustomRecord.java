package com.flyonsky.weixin.data.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 客服记录
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomRecord extends AbstractData{

	// 用户的标识，对当前公众号唯一
	@JsonProperty("openid")
	private String openid;
	
	// 操作ID（会话状态）
	@JsonProperty("opercode")
	private int operCode;
	
	// 聊天记录
	@JsonProperty("text")
	private String text;
	
	// 操作时间，UNIX时间戳
	@JsonProperty("time")
	private long time;
	
	// 客服账号
	@JsonProperty("worker")
	private String worker;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getOperCode() {
		return operCode;
	}

	public void setOperCode(int operCode) {
		this.operCode = operCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}
}
