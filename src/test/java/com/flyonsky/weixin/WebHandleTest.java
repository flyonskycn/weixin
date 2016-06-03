package com.flyonsky.weixin;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.EnumScope;

/**
 * 微信网页登陆授权页
 * @author Administrator
 *
 */
public class WebHandleTest extends BaseSpringJUnit{

	@Autowired
	private WebHandle service;
	
	@Test
	public void testWebAuthorize(){
		String url = this.getService().authorizeUrl("wx30ce83aa5b2991f3", EnumScope.snsapi_userinfo, "www.cocopico.com");
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
