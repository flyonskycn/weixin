package com.flyonsky.weixin;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.message.CustomClientWaitListReceive;
import com.flyonsky.weixin.data.message.CustomListReceive;
import com.flyonsky.weixin.data.message.CustomOnlineReceive;
import com.flyonsky.weixin.data.message.CustomParam;
import com.flyonsky.weixin.data.message.CustomRecordParam;
import com.flyonsky.weixin.data.message.CustomRecordReceive;

/**
 * 测试公众号客户功能
 * @author Administrator
 *
 */
public class CustomMessageHandleTest extends BaseSpringJUnit{

	@Autowired
	private MessageHandle messageHandle;
	
	@Autowired
	private ServiceHandle serviceHandle;
	
	// 可可智能HUD服务号appid
	@Value("${weixin.customservice.appid}")
	private String appid;
	
	// 可可智能HUD服务号secret
	@Value("${weixin.customservice.secret}")
	private String secret;
	
	// 可可智能HUD服务号微信号
	@Value("${weixin.customservice.account}")
	private String weixinAccount;
	
	private String accessToken;
	
	@Before
	public void init(){
		AccessToken token = this.serviceHandle.accessToken(appid, secret);
		Assert.assertNotNull(token);
		Assert.assertTrue(token.isSuccess());
		accessToken = token.getAccessToken();
	}
	
	/**
	 * 添加客户帐号
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testKfAdd() throws FileNotFoundException{
		CustomParam param = new CustomParam();
		String account = "flyonskycn@" + this.weixinAccount;
		param.setKfAccount(account);
		param.setNickName("Custom1");
		String pwd = WeixinUtil.md5("cocopico");
		System.out.println(pwd);
		param.setPassword(pwd);
		ServiceReceive data = this.messageHandle.kfAdd(accessToken, param);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
		Assert.assertTrue(data.isSuccess());
		
		InputStream input = this.getClass().getClassLoader().getResourceAsStream("icon.jpg");
		// 修改客户头象
		data = this.messageHandle.kfModifyHead(accessToken,account,input);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
		
		// 修改客服名称
		param.setNickName("Custom100");
		data = this.messageHandle.kfModify(accessToken, param);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
		
		// 删除客户帐号
		data = this.messageHandle.kfDelete(accessToken, account);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
		Assert.assertTrue(data.isSuccess());
	}
	
	/**
	 * 获取客服列表
	 */
	@Test
	public void testKfList(){
		CustomListReceive data = this.messageHandle.kfList(accessToken);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
	}
	
	/**
	 * 获取客服在线信息
	 */
	@Test
	public void testKfOnline(){
		CustomOnlineReceive data = this.messageHandle.kfOnline(accessToken);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
		System.out.println(data.toJson());
	}
	
	/**
	 * 获取未接入会话列表 
	 */
	@Test
	public void testClientWaitSessionList(){
		CustomClientWaitListReceive data = this.messageHandle.clientWaitSessionList(accessToken);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
		Assert.assertNotNull(data.getWaitCaseList());
	}
	
	/**
	 * 获取客服聊天记录接口
	 * @throws ParseException 
	 */
	@Test
	public void testKfRecordList() throws ParseException{
		CustomRecordParam param = new CustomRecordParam();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date curTime = Calendar.getInstance().getTime();
		Date btime = f.parse(f.format(curTime));
		param.setPageIndex(1);
		param.setPageSize(50);
		param.setEndTime(curTime.getTime()/1000);
		param.setStartTime(btime.getTime()/1000);
		CustomRecordReceive data = this.messageHandle.kfRecordList(accessToken,param);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
	}
}
