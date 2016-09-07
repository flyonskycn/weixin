package com.flyonsky.weixin;

import java.text.MessageFormat;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.EnumQrcodeType;
import com.flyonsky.weixin.data.QrcodeParam;
import com.flyonsky.weixin.data.QrcodeReceive;
import com.flyonsky.weixin.data.QrcodeScene;
import com.flyonsky.weixin.data.Scene;
import com.flyonsky.weixin.data.TicketReceive;

@Service
public class ServiceHandleImp extends AbstractHandle implements ServiceHandle{
	
	@Autowired
	private WeixinURLConfig config;
	
	@Autowired(required=false)
	private WeixinCache cache;

	@Override
	public boolean checkSignature(String token, String signature, String timestamp, String nonce, String echostr) {
		Assert.notNull(token);
		Assert.notNull(signature);
		Assert.notNull(timestamp);
		Assert.notNull(nonce);
		Assert.notNull(echostr);
		
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
	public AccessToken accessToken(String appid, String secret) {
		Assert.notNull(appid);
		Assert.notNull(secret);
		
		return this.accessToken(appid, secret, false);
	}
	
	@Override
	public AccessToken accessToken(String appid, String secret, boolean isObtain) {
		Assert.notNull(appid);
		Assert.notNull(secret);
		
		AccessToken tokenBean = null;
    	String key = WeixinUtil.md5(appid);
		if(isObtain || this.getCache() == null || !this.getCache().contains(key)){
			String url = MessageFormat.format(this.getConfig().getServiceTokenUrl(), appid, secret);
			tokenBean = this.doGet(url, AccessToken.class);
            if(this.getCache() != null){
            	long expires = tokenBean.getExpiresIn();
            	this.getCache().put(key, tokenBean, expires);
            }
		}else{
			tokenBean = (AccessToken) this.getCache().get(key);
		}
		return tokenBean;
	}

	@Override
	public String ticket(String appid, String accessToken) {
		Assert.notNull(appid);
		Assert.notNull(accessToken);
		
		String token = "";
    	String key = WeixinUtil.md5(appid + "_ticket");
		if(this.getCache() == null || !this.getCache().contains(key)){
			String url = MessageFormat.format(this.getConfig().getServiceJsTicketUrl(), accessToken);
			TicketReceive tokenBean = this.doGet(url, TicketReceive.class);
            token = tokenBean.getTicket();
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
	public QrcodeReceive createQrcode(String accessToken, EnumQrcodeType qrcodeType, int sceneId, long expireSeconds) {
		Assert.notNull(accessToken);
		Assert.notNull(qrcodeType);
		
		QrcodeParam param = new QrcodeParam();
		param.setExpireSeconds(expireSeconds);
		param.setActionName(qrcodeType.toString());
		QrcodeScene scene = new QrcodeScene();
		scene.setSceneId(sceneId);
		Scene s = new Scene();
		s.setScene(scene);
		param.setActionInfo(s);
		
		String url = MessageFormat.format(this.getConfig().getServiceQrcodeUrl(), accessToken);
		QrcodeReceive receive = this.doPost(url, param, QrcodeReceive.class);
		return receive;
	}

	@Override
	public String showQrcode(String ticket) {
		Assert.notNull(ticket);
		
		String url = MessageFormat.format(this.getConfig().getQrcodeShowUrl(), ticket);
		return url;
	}

	public WeixinCache getCache() {
		return cache;
	}

	public void setCache(WeixinCache cache) {
		this.cache = cache;
	}

	public WeixinURLConfig getConfig() {
		return config;
	}

	public void setConfig(WeixinURLConfig config) {
		this.config = config;
	}

}
