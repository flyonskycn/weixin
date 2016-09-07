package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 退款查询响应数据
 * @author Administrator
 *
 */
public class RefundQueryReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<appid><![CDATA[wx2421b1c4370ec43b]]></appid>"
				+ "<mch_id><![CDATA[10000100]]></mch_id>"
				+ "<nonce_str><![CDATA[TN55wO9Pba5yENl8]]></nonce_str>"
				+ "<out_trade_no><![CDATA[1415757673]]></out_trade_no>"
				+ "<refund_count>1</refund_count>"
				+ "<refund_fee_0>1</refund_fee_0>"
				+ "<refund_id_0><![CDATA[2008450740201411110000174436]]></refund_id_0>"
				+ "<refund_status_0><![CDATA[PROCESSING]]></refund_status_0>"
				+ "<result_code><![CDATA[SUCCESS]]></result_code>"
				+ "<return_code><![CDATA[SUCCESS]]></return_code>"
				+ "<return_msg><![CDATA[OK]]></return_msg>"
				+ "<sign><![CDATA[BDF0099C15FF7BC6B1585FBB110AB635]]></sign>"
				+ "<transaction_id><![CDATA[1008450740201411110005820873]]></transaction_id>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		RefundQueryReceive data = mapper.readValue(xml, RefundQueryReceive.class);
		Assert.assertNotNull(data);
	}
}
