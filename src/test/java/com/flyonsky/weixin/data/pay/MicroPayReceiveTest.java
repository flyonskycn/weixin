package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 刷卡支付API返回的响应
 * @author Administrator
 *
 */
public class MicroPayReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<return_code><![CDATA[SUCCESS]]></return_code>"
				+ "<return_msg><![CDATA[OK]]></return_msg>"
				+ "<appid>wx2421b1c4370ec43b</appid>"
				+ "<mch_id>10000100</mch_id>"
				+ "<nonce_str>ec2316275641faa3aacf3cc599e8730f</nonce_str>"
				+ "<sign>FDD167FAA73459FD921B144BAF4F4CA2</sign>"
				+ "<device_info><![CDATA[1000]]></device_info>"
				+ "<result_code><![CDATA[SUCCESS]]></result_code>"
				+ "<openid><![CDATA[oUpF8uN95-Ptaags6E_roPHg7AG0]]></openid>"
				+ "<is_subscribe><![CDATA[Y]]></is_subscribe>"
				+ "<trade_type><![CDATA[MICROPAY]]></trade_type>"
				+ "<bank_type><![CDATA[CCB_DEBIT]]></bank_type>"
				+ "<total_fee>1</total_fee>"
				+ "<fee_type><![CDATA[CNY]]></fee_type>"
				+ "<transaction_id><![CDATA[1008450740201411110005820873]]></transaction_id>"
				+ "<out_trade_no><![CDATA[1415757673]]></out_trade_no>"
				+ "<attach><![CDATA[订单额外描述]]></attach>"
				+ "<time_end><![CDATA[20141111170043]]></time_end>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		MicroPayReceive data = mapper.readValue(xml, MicroPayReceive.class);
		Assert.assertNotNull(data);
	}
}
