package com.flyonsky.weixin;

import java.text.MessageFormat;
import java.util.SortedSet;
import java.util.TreeSet;

import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.MessageData;
import com.flyonsky.weixin.data.UserInfo;

@Service
public class ServiceHandleImp extends AbstractHandle implements ServiceHandle{
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceHandle.class);
	
	// 微信服务号基本地址
	@Value("${weixin.service.base.url}")
	private String serviceBaseUrl;
	
	// 微信服务号token获取地址
	@Value("${weixin.service.token.url}")
	private String serviceTokenUrl;
	
	// 微信服务号用户信息获取地址
	@Value("${weixin.service.user.url}")
	private String serviceUserInfoUrl;
	
	@Autowired(required=false)
	private WeixinCache cache;

	@Override
	public boolean checkSignature(String token, String signature, String timestamp, String nonce, String echostr) {
		boolean flag = false;
		SortedSet<String> sortSet = new TreeSet<String>();
		sortSet.add(token);
		sortSet.add(timestamp);
		sortSet.add(nonce);
		StringBuilder sb = new StringBuilder();
		for(String s : sortSet){
			sb.append(s);
		}
		String digest = WeixinUtil.sha1(sb.toString());
		if(digest.equals(signature)){
			flag = true;
		}
		return flag;
	}

	@Override
	public String accessToken(String appid, String secret) {
		return this.accessToken(appid, secret, false);
	}
	
	@Override
	public String accessToken(String appid, String secret, boolean isObtain) {
		String token = "";
    	String key = WeixinUtil.md5(appid);
		if(isObtain || this.getCache() == null || !this.getCache().contains(key)){
			String url = this.getServiceBaseUrl() + MessageFormat.format(this.getServiceTokenUrl(), appid, secret);
			AccessToken tokenBean = this.doGet(url, AccessToken.class);
            token = tokenBean.getAccessToken();
            if(this.getCache() != null){
            	long expires = tokenBean.getExpiresIn();
            	this.getCache().put(key, token, expires);
            }
		}else{
			token = this.getCache().get(key).toString();
		}
		return token;
	}
	
	@Override
	public UserInfo userInfo(String appid, String secret, String openid) throws WeixinException {
		String token = this.accessToken(appid, secret);
		String url = this.getServiceBaseUrl() + MessageFormat.format(this.getServiceUserInfoUrl(), token, openid);
		UserInfo userInfo = this.doGet(url, UserInfo.class);
        if(userInfo.getErrCode() > 0){
        	int code = userInfo.getErrCode();
        	WeixinException e = new WeixinException(code,userInfo.getErrMsg());
        	throw e;
        }
		return userInfo;
	}

	public WeixinCache getCache() {
		return cache;
	}

	public void setCache(WeixinCache cache) {
		this.cache = cache;
	}

	public String getServiceBaseUrl() {
		return serviceBaseUrl;
	}

	public void setServiceBaseUrl(String serviceBaseUrl) {
		this.serviceBaseUrl = serviceBaseUrl;
	}

	public String getServiceTokenUrl() {
		return serviceTokenUrl;
	}

	public void setServiceTokenUrl(String serviceTokenUrl) {
		this.serviceTokenUrl = serviceTokenUrl;
	}

	public String getServiceUserInfoUrl() {
		return serviceUserInfoUrl;
	}

	public void setServiceUserInfoUrl(String serviceUserInfoUrl) {
		this.serviceUserInfoUrl = serviceUserInfoUrl;
	}

}
