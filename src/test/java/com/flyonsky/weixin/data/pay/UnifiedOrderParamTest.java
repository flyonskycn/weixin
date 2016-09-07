package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 统一下单请求参数
 * @author Administrator
 *
 */
public class UnifiedOrderParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<appid>wx2421b1c4370ec43b</appid>"
				+ "<attach>支付测试</attach>"
				+ "<body>JSAPI支付测试</body>"
				+ "<mch_id>10000100</mch_id>"
				+ "<detail><![CDATA[{ \"goods_detail\":[ { \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, { \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }]]></detail>"
				+ "<nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>"
				+ "<notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url>"
				+ "<openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>"
				+ "<out_trade_no>1415659990</out_trade_no>"
				+ "<spbill_create_ip>14.23.150.211</spbill_create_ip>"
				+ "<total_fee>1</total_fee>"
				+ "<trade_type>JSAPI</trade_type>"
				+ "<sign>0CB01533B8C1EF103065174F50BCA001</sign>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		UnifiedOrderParam data = mapper.readValue(xml, UnifiedOrderParam.class);
		Assert.assertNotNull(data);
	}
}
