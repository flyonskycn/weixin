package com.flyonsky.weixin;

import java.text.MessageFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.EnumScope;
import com.flyonsky.weixin.data.ServiceReceive;

@Service
public class WebHandleImp extends AbstractHandle implements WebHandle{
	
	@Autowired
	private WeixinURLConfig config;

	@Override
	public String authorizeUrl(String appid, EnumScope scope, String redirectUri) {
		Assert.notNull(appid);
		Assert.notNull(scope);
		
		Random random = new Random();
		int r = random.nextInt();
		String url = "";
		switch(scope){
		case snsapi_base:
		case snsapi_userinfo:
			url = MessageFormat.format(this.getConfig().getAuthorizeUrl(), appid, redirectUri, scope.toString(), String.valueOf(r));
			break;
			default:
				url = MessageFormat.format(this.getConfig().getWebAuthorizeUrl(), appid, redirectUri, scope.toString(), String.valueOf(r));
				break;
		}
		return url;
	}

	@Override
	public AccessToken accessToken(String appid, String secret, String code) {
		Assert.notNull(appid);
		Assert.notNull(secret);
		Assert.notNull(code);
		
		String url = MessageFormat.format(this.getConfig().getTokenUrl(), appid, secret, code);
		AccessToken tokenBean = this.doGet(url, AccessToken.class);
		return tokenBean;
	}

	@Override
	public AccessToken refreshToken(String appid, String refreshToken) {
		Assert.notNull(appid);
		Assert.notNull(refreshToken);
		
		String url = MessageFormat.format(this.getConfig().getRefreshTokenUrl(), appid, refreshToken);
		AccessToken tokenBean = this.doGet(url, AccessToken.class);
		return tokenBean;
	}

	@Override
	public boolean accessTokenValid(String accessToken, String openid) {
		Assert.notNull(accessToken);
		Assert.notNull(openid);
		
		String url = MessageFormat.format(this.getConfig().getTokenValidUrl(), accessToken, openid);
		ServiceReceive base = this.doGet(url,  ServiceReceive.class);
		boolean flag = false;
		if(base.isSuccess()){
			flag = true;
		}
		return flag;
	}

	public WeixinURLConfig getConfig() {
		return config;
	}

	public void setConfig(WeixinURLConfig config) {
		this.config = config;
	}

}
