package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 微信支付订单查询请求参数
 * @author Administrator
 *
 */
public class OrderQueryParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<appid>wx2421b1c4370ec43b</appid>"
				+ "<mch_id>10000100</mch_id>"
				+ "<nonce_str>ec2316275641faa3aacf3cc599e8730f</nonce_str>"
				+ "<transaction_id>1008450740201411110005820873</transaction_id>"
				+ "<sign>FDD167FAA73459FD921B144BAF4F4CA2</sign>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		OrderQueryParam data = mapper.readValue(xml, OrderQueryParam.class);
		Assert.assertNotNull(data);
	}
}
