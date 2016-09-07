package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 退款申请响应数据
 * @author Administrator
 *
 */
public class RefundReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<return_code><![CDATA[SUCCESS]]></return_code>"
				+ "<return_msg><![CDATA[OK]]></return_msg>"
				+ "<appid><![CDATA[wx2421b1c4370ec43b]]></appid>"
				+ "<mch_id><![CDATA[10000100]]></mch_id>"
				+ "<nonce_str><![CDATA[TN55wO9Pba5yENl8]]></nonce_str>"
				+ "<sign><![CDATA[BDF0099C15FF7BC6B1585FBB110AB635]]></sign>"
				+ "<result_code><![CDATA[SUCCESS]]></result_code>"
				+ "<transaction_id><![CDATA[1008450740201411110005820873]]></transaction_id>"
				+ "<out_trade_no><![CDATA[1415757673]]></out_trade_no>"
				+ "<out_refund_no><![CDATA[1415701182]]></out_refund_no>"
				+ "<refund_id><![CDATA[2008450740201411110000174436]]></refund_id>"
				+ "<refund_channel><![CDATA[]]></refund_channel>"
				+ "<refund_fee>1</refund_fee> "
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		RefundReceive data = mapper.readValue(xml, RefundReceive.class);
		Assert.assertNotNull(data);
	}
}
