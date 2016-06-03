package com.flyonsky.weixin;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.EnumScope;

/**
 * 微信网页登陆授权页
 * @author Administrator
 *
 */
public class WebHandleTest extends BaseSpringJUnit{
	
	// web应用appid
	@Value("${weixin.coco.web.appid}")
	private String appId;

	@Autowired
	private WebHandle service;
	
	/**
	 * 获取微信网页授权地址
	 */
	@Test
	public void testAuthorizeUrl(){
		String url = this.getService().authorizeUrl(appId, EnumScope.snsapi_login, "www.cocopico.com");
		System.out.println(url);
		Assert.assertNotNull(url);
	}

	public WebHandle getService() {
		return service;
	}

	public void setService(WebHandle service) {
		this.service = service;
	}
}
