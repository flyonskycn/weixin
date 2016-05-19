package com.flyonsky.weixin;

public class WeixinException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3590712148042809382L;

	private int errcode;
	
	private String errmsg;
	
	public WeixinException(){
		super();
	}
	
	public WeixinException(int code,String message){
		super();
		errcode = code;
		errmsg = message;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
