package com.flyonsky.weixin;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.NotifyReceive;
import com.flyonsky.weixin.data.UnifiedOrderData;

/**
 * 微信签名工具类单元测试用例
 * @author Administrator
 *
 */
public class WeixinUtilTest extends BaseSpringJUnit{

	// 支付商户配置的Api安全key
	@Value("${weixin.coco.service.pay.key}")
	private String key;
	
	/**
	 * 测试对异步通知参签名的验证
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testNotifySign() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"return_code\":\"SUCCESS\",\"appid\":\"wxf1848c8d085e6e48\",\"mch_id\":\"1346026101\",\"nonce_str\":\"myWjqfCEIlhMQLfplSKvoSJm\",\"sign\":\"E92191FDF02F2680B44421CA9C8FC631\",\"result_code\":\"SUCCESS\",\"openid\":\"oIf-3wEXPbEKJP1GFrRH9k8fbMGk\",\"is_subscribe\":\"Y\",\"trade_type\":\"JSAPI\",\"bank_type\":\"CFT\",\"total_fee\":1,\"fee_type\":\"CNY\",\"cash_fee\":1,\"transaction_id\":\"4001532001201605316557086630\",\"out_trade_no\":\"1029\",\"time_end\":\"20160531141458\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		NotifyReceive data = mapper.readValue(json, NotifyReceive.class);
		Assert.assertNotNull(data);
		String sign = WeixinUtil.sign(data, key);
		
		Assert.assertEquals(data.getSign(), sign);
	}
	
	/**
	 * 测试统一下单的签名
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testUnifiedOrderSign() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml><appid><![CDATA[wxf1848c8d085e6e48]]></appid><mch_id><![CDATA[1346026101]]></mch_id><sign>710290E6CF979095AC4AD7C1CA45AFED</sign><nonce_str>myWjqfCEIlhMQLfplSKvoSJm</nonce_str><body><![CDATA[1029]]></body><out_trade_no><![CDATA[1029]]></out_trade_no><fee_type>CNY</fee_type><total_fee>1</total_fee><spbill_create_ip>127.0.0.1</spbill_create_ip><time_start><![CDATA[20160531141451]]></time_start><time_expire><![CDATA[20160531142451]]></time_expire><notify_url><![CDATA[HTTP://www.cocopico.com/pubv2/notify.co]]></notify_url><trade_type>JSAPI</trade_type><product_id>1029</product_id><openid>oIf-3wEXPbEKJP1GFrRH9k8fbMGk</openid></xml>";
		
		ObjectMapper mapper = new XmlMapper();
		
		UnifiedOrderData data = mapper.readValue(xml, UnifiedOrderData.class);
		Assert.assertNotNull(data);
		String sign = WeixinUtil.sign(data, key);
		
		Assert.assertEquals("710290E6CF979095AC4AD7C1CA45AFED", sign);
	}
}
