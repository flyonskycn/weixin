package com.flyonsky.weixin;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.UserInfo;

public class ServiceHandleTest extends BaseSpringJUnit{
	
	@Autowired
	private ServiceHandle serviceHandle;
	
	// 测试公众号 appid
	@Value("${weixin.coco.service.test.appid}")
	private String appId;
	
	// 测试公众号 secret
	@Value("${weixin.coco.service.test.secret}")
	private String appSecret;
	
	// 测试公众号token
	@Value("${weixin.coco.service.test.token}")
	private String token;
	
	// 关注测试公众号下用户的openid
	@Value("${weixin.coco.service.test.openid}")
	private String openId;
	
	@Test
	public void testCheckSignature(){
		boolean flag = this.getServiceHandle().checkSignature(this.getToken(),
				"62ff4e83d8d3843de9b94a52c66817eadedfd6d3",
				"1462875334",
				"213579889",
				"7805496793625132286");
		Assert.assertTrue(flag);
	}
	
	@Test
	public void testAccessToken(){
		String token = this.getServiceHandle().accessToken(this.getAppId(), this.getAppSecret());
		Assert.assertNotNull(token);
		Assert.assertTrue(token.length() > 1);
	}
	
	@Test
	public void testUserInfo() throws WeixinException{
		UserInfo info = this.getServiceHandle().userInfo(this.getAppId(), this.getAppSecret(), this.getOpenId());
		Assert.assertNotNull(info);
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public ServiceHandle getServiceHandle() {
		return serviceHandle;
	}

	public void setServiceHandle(ServiceHandle serviceHandle) {
		this.serviceHandle = serviceHandle;
	}
}
