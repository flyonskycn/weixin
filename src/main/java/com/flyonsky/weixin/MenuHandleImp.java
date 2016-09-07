package com.flyonsky.weixin;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.menu.DefaultMenu;
import com.flyonsky.weixin.data.menu.DeleteParam;
import com.flyonsky.weixin.data.menu.MatchParam;
import com.flyonsky.weixin.data.menu.MatchReceive;
import com.flyonsky.weixin.data.menu.PersonalityMenu;
import com.flyonsky.weixin.data.menu.PersonalityReceive;

@Service
public class MenuHandleImp extends AbstractHandle implements MenuHandle{
	
	@Autowired
	private WeixinURLConfig config;

	@Override
	public boolean createMenu(String accessToken, DefaultMenu menu) {
		Assert.notNull(accessToken);
		Assert.notNull(menu);
		
		String url = MessageFormat.format(this.getConfig().getServiceMenuCreateUrl(), accessToken);
		boolean flag = false;
		ServiceReceive receive = this.doPost(url, menu, ServiceReceive.class);
		if(receive.isSuccess()){
			flag = true;
		}
		return flag;
	}

	@Override
	public PersonalityReceive createPersonalityMenu(String accessToken, PersonalityMenu menu) {
		Assert.notNull(accessToken);
		Assert.notNull(menu);
		
		String url = MessageFormat.format(this.getConfig().getServicePersonCreateUrl(), accessToken);
		PersonalityReceive receive = this.doPost(url, menu, PersonalityReceive.class);
		return receive;
	}

	@Override
	public boolean deleteMenu(String accessToken) {
		Assert.notNull(accessToken);
		
		boolean flag = false;
		String url = MessageFormat.format(this.getConfig().getServiceMenuDeleteUrl(), accessToken);
		ServiceReceive receive = this.doGet(url, ServiceReceive.class);
		if(receive.isSuccess()){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteMenu(String accessToken, String menuid) {
		Assert.notNull(accessToken);
		Assert.notNull(menuid);
		
		DeleteParam param = new DeleteParam();
		param.setMenuid(menuid);
		
		boolean flag = false;
		String url = MessageFormat.format(this.getConfig().getServicePersonDeleteUrl(), accessToken);
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
			if(receive.isSuccess()){
				flag = true;
			}
		return flag;
	}

	@Override
	public MatchReceive matchMenu(String accessToken, String userId) {
		Assert.notNull(accessToken);
		Assert.notNull(userId);
		
		MatchParam param = new MatchParam();
		param.setUserId(userId);
		
		String url = MessageFormat.format(this.getConfig().getServicePersonMatchUrl(), accessToken);
		MatchReceive receive = this.doPost(url, param, MatchReceive.class);
		return receive;
	}

	public WeixinURLConfig getConfig() {
		return config;
	}

	public void setConfig(WeixinURLConfig config) {
		this.config = config;
	}

}
