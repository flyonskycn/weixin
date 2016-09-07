package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 刷卡支付API请求参数
 * @author Administrator
 *
 */
public class MicroPayParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<appid>wx2421b1c4370ec43b</appid>"
				+ "<mch_id>10000100</mch_id>"
				+ "<nonce_str>ec2316275641faa3aacf3cc599e8730f</nonce_str>"
				+ "<attach>订单额外描述</attach>"
				+ "<auth_code>120269300684844649</auth_code>"
				+ "<body>刷卡支付测试</body>"
				+ "<device_info>1000</device_info>"
				+ "<goods_tag></goods_tag>"
				+ "<out_trade_no>1415757673</out_trade_no>"
				+ "<spbill_create_ip>14.17.22.52</spbill_create_ip>"
				+ "<total_fee>1</total_fee>"
				+ "<sign>FDD167FAA73459FD921B144BAF4F4CA2</sign>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		MicroPayParam data = mapper.readValue(xml, MicroPayParam.class);
		Assert.assertNotNull(data);
	}
}
