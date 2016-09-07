package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 微信支付订单查询接收到的响应数据
 * @author Administrator
 *
 */
public class OrderQueryReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<return_code><![CDATA[SUCCESS]]></return_code>"
				+ "<return_msg><![CDATA[OK]]></return_msg>"
				+ "<appid><![CDATA[wx2421b1c4370ec43b]]></appid>"
				+ "<mch_id><![CDATA[10000100]]></mch_id>"
				+ "<device_info><![CDATA[1000]]></device_info>"
				+ "<nonce_str><![CDATA[TN55wO9Pba5yENl8]]></nonce_str>"
				+ "<sign><![CDATA[BDF0099C15FF7BC6B1585FBB110AB635]]></sign>"
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
				+ "<trade_state><![CDATA[SUCCESS]]></trade_state>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		OrderQueryReceive data = mapper.readValue(xml, OrderQueryReceive.class);
		Assert.assertNotNull(data);
	}
}