package com.flyonsky.weixin;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.message.TemplateNote;
import com.flyonsky.weixin.data.message.TemplateParam;
import com.flyonsky.weixin.data.message.TemplateReceive;

/**
 * 服务号消息管理测试类
 * @author Administrator
 *
 */
public class MessageHandleTest extends BaseSpringJUnit{

	// 测试服务号 appid
	@Value("${weixin.coco.service.test.appid}")
	private String appid;
	
	// 测试服务号 secret
	@Value("${weixin.coco.service.test.secret}")
	private String secret;
	
	// 测试服务号下用户的opendid
	@Value("${weixin.coco.service.test.openid}")
	private String openid;
	
	// 测试服务号的模板消息模板ID
	@Value("${weixin.coco.service.test.templateid}")
	private String templateid;
	
	// 测试服务号的微信号
	@Value("${weixin.coco.service.test.account}")
	private String weixinAccount;
	
	private String accessToken;
	
	@Autowired
	private ServiceHandle serviceHandle;
	
	@Autowired
	private MessageHandle messageHandle;
	
	@Before
	public void init(){
		AccessToken token = this.serviceHandle.accessToken(appid, secret);
		Assert.assertNotNull(token);
		Assert.assertTrue(token.isSuccess());
		accessToken = token.getAccessToken();
	}
	
	/**
	 * 测试模板消息发送
	 */
	@Test
	public void testSendTemplateMsg(){
		TemplateParam param = new TemplateParam();
		param.setTemplateId(templateid);
		param.setTouser(openid);
		Map<String,TemplateNote> data = new HashMap<String,TemplateNote>();
		TemplateNote note = new TemplateNote();
		note.setValue("你好,你有新的工单");
		note.setColor("#173177");
		data.put("first", note);
		note = new TemplateNote();
		note.setValue("业务工单");
		note.setColor("#173177");
		data.put("keyword1", note);
		note = new TemplateNote();
		note.setValue("商务询价 [CNNGB - TINCAN] 2X40HC");
		note.setColor("#173177");
		data.put("keyword2", note);
		note = new TemplateNote();
		note.setValue("点击回复");
		note.setColor("#173177");
		data.put("remark", note);
		param.setData(data);
		
		TemplateReceive receive = this.messageHandle.sendTemplateMsg(accessToken, param);
		
		Assert.assertNotNull(receive);
		Assert.assertTrue(receive.isSuccess());
	}
}
