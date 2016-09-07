package com.flyonsky.weixin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.EnumAuthorizeSource;
import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.user.BatchFetchReceive;
import com.flyonsky.weixin.data.user.CreateGroupReceive;
import com.flyonsky.weixin.data.user.FetchListReceive;
import com.flyonsky.weixin.data.user.UserInfo;

/**
 * 微信用户接口单元测试
 * @author Administrator
 *
 */
public class UserHandleTest extends BaseSpringJUnit{

	@Autowired
	private UserHandle userHandle;
	
	@Autowired
	private ServiceHandle serviceHandle;
	
	private String accessToken;
	
	// 测试公众号 appid
	@Value("${weixin.coco.service.test.appid}")
	private String appid;
	
	// 测试公众号 secret
	@Value("${weixin.coco.service.test.secret}")
	private String secret;
	
	// 关注测试公众号下用户的openid
	@Value("${weixin.coco.service.test.openid}")
	private String openId;
	
	@Before
	public void init(){
		AccessToken token = this.serviceHandle.accessToken(appid, secret);
		Assert.assertNotNull(token);
		Assert.assertTrue(token.isSuccess());
		accessToken = token.getAccessToken();
	}
	
	/**
	 * 测试用户信息获取
	 */
	@Test
	public void testInfo(){
		UserInfo user = this.userHandle.info(accessToken, openId, EnumAuthorizeSource.SERVICE);
		Assert.assertNotNull(user);
		System.out.println(user.toJson());
	}
	
	/**
	 * 批量获取用户息
	 */
	@Test
	public void testBatchFetch(){
		List<String> list = new ArrayList<String>();
		list.add(openId);
		BatchFetchReceive data = this.userHandle.batchFetch(accessToken, list);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getUserInfoList().size() > 0);
	}
	
	/**
	 * 批量获取关注者列表
	 */
	@Test
	public void testBatchFetchOpen(){
		FetchListReceive data = this.userHandle.batchFetchOpen(accessToken, null);
		Assert.assertNotNull(data);
	}
	
	/**
	 * 测试添加分组
	 */
	@Test
	public void testCreateGroup(){
		CreateGroupReceive data = this.userHandle.createGroup(accessToken, "管理员分组");
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
		Assert.assertNotNull(data.getGroup());
		
		ServiceReceive receive = this.userHandle.removeGroup(accessToken, data.getGroup().getId());
		
		Assert.assertNotNull(receive);
		Assert.assertTrue(receive.isSuccess());
	}
}
