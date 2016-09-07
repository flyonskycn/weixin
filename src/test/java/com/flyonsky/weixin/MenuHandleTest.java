package com.flyonsky.weixin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.EnumMenuType;
import com.flyonsky.weixin.data.menu.DefaultMenu;
import com.flyonsky.weixin.data.menu.MatchReceive;
import com.flyonsky.weixin.data.menu.MatchRule;
import com.flyonsky.weixin.data.menu.MenuItem;
import com.flyonsky.weixin.data.menu.PersonalityMenu;
import com.flyonsky.weixin.data.menu.PersonalityReceive;

/**
 * 测试自定义菜单
 * @author Administrator
 *
 */
public class MenuHandleTest extends BaseSpringJUnit{
	
	@Autowired
	private MenuHandle menuHandle;
	
	@Autowired
	private ServiceHandle serviceHandle;
	
	// 测试公众号 appid
	@Value("${weixin.coco.service.test.appid}")
	private String appid;
	
	// 测试公众号 secret
	@Value("${weixin.coco.service.test.secret}")
	private String secret;
	
	// 测试服务号下用户的opendid 
	@Value("${weixin.coco.service.test.openid}")
	private String openid;
	
	private String accessToken;
	
	@Before
	public void init(){
		AccessToken token = this.getServiceHandle().accessToken(appid, secret);
		Assert.assertTrue(token.isSuccess());
		accessToken = token.getAccessToken();
	}
	
	@Ignore
	@Test
	public void testCreateMenu(){
		DefaultMenu menu = new DefaultMenu();
		List<MenuItem> list = new ArrayList<MenuItem>();
		
		MenuItem item = new MenuItem();
		item.setType(EnumMenuType.scancode_push.toString());
		item.setName("扫码推事件");
		item.setKey("rselfmenu_0_1");
		list.add(item);
		
		item = new MenuItem();
		item.setType(EnumMenuType.view.toString());
		item.setName("商城首页");
		item.setUrl("http://test.cocopico.com/mobile/index.co");
		list.add(item);
		
		item = new MenuItem();
		item.setType(EnumMenuType.pic_sysphoto.toString());
		item.setName("拍照");
		item.setKey("rselfmenu_1_0");
		list.add(item);
		menu.setButton(list);
		boolean flag = this.getMenuHandle().createMenu(accessToken, menu);
		Assert.assertTrue(flag);
		
		flag = this.getMenuHandle().deleteMenu(accessToken);
		
		Assert.assertTrue(flag);
	}
	
	@Test
	public void testCreatePersonalityMenu(){
		boolean flag = this.getMenuHandle().deleteMenu(accessToken);
		Assert.assertTrue(flag);
		
		// 添加黙认菜单
		DefaultMenu menu = new DefaultMenu();
		List<MenuItem> list = new ArrayList<MenuItem>();
		
		MenuItem item = new MenuItem();
		item.setType(EnumMenuType.scancode_push.toString());
		item.setName("扫码推事件");
		item.setKey("rselfmenu_0_1");
		list.add(item);
		
		item = new MenuItem();
		item.setType(EnumMenuType.view.toString());
		item.setName("商城首页");
		item.setUrl("http://test.cocopico.com/mobile/index.co");
		list.add(item);
		
		item = new MenuItem();
		item.setType(EnumMenuType.pic_sysphoto.toString());
		item.setName("拍照");
		item.setKey("rselfmenu_1_0");
		list.add(item);
		menu.setButton(list);
		
		flag = this.getMenuHandle().createMenu(accessToken, menu);
		Assert.assertTrue(flag);
		
		// 添加个性化菜单
		PersonalityMenu personMenu = new PersonalityMenu();
		list = new ArrayList<MenuItem>();
		list.add(item);
		personMenu.setButton(list);
		MatchRule rule = new MatchRule();
		rule.setSex(1);
		personMenu.setMatchRule(rule);
		PersonalityReceive receive = this.getMenuHandle().createPersonalityMenu(accessToken, personMenu);
		
		Assert.assertNotNull(receive);
		
		Assert.assertTrue(StringUtils.isNotBlank(receive.getMenuid()));
		
		// 测试个性化菜单匹配结果
		MatchReceive matchMenu = this.menuHandle.matchMenu(accessToken, openid);
		Assert.assertNotNull(matchMenu);
		Assert.assertNotNull(matchMenu.getMenu());
		Assert.assertNotNull(matchMenu.getMenu().getButton());
		Assert.assertEquals(1,matchMenu.getMenu().getButton().size());
		
		// 删除个性化菜单
		flag = this.menuHandle.deleteMenu(accessToken, receive.getMenuid());
		
		Assert.assertTrue(flag);
	}

	public MenuHandle getMenuHandle() {
		return menuHandle;
	}

	public void setMenuHandle(MenuHandle menuHandle) {
		this.menuHandle = menuHandle;
	}

	public ServiceHandle getServiceHandle() {
		return serviceHandle;
	}

	public void setServiceHandle(ServiceHandle serviceHandle) {
		this.serviceHandle = serviceHandle;
	}
}
