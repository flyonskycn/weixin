package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 撤销订单API响应
 * @author Administrator
 *
 */
public class ReverseReceiveTest {

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
				+ "<recall><![CDATA[N]]></recall>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		ReverseReceive data = mapper.readValue(xml, ReverseReceive.class);
		Assert.assertNotNull(data);
	}
}
