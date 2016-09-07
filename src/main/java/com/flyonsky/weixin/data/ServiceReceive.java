package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 公从号服务号接受数据的基类
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceReceive extends AbstractData {

	@JsonProperty("errcode")
	private Integer errCode;
	
	@JsonProperty("errmsg")
	private String errMsg;

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * 增加基本的成功失败判断，由于有些成功响应并未返回errCode，因此增加些方法
	 * @return
	 */
	@JsonIgnore
	public boolean isSuccess(){
		boolean flag = false;
		if(errCode == null || errCode.intValue() == 0){
			flag = true;
		}
		return flag;
	}
}
