package com.flyonsky.weixin.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 关闭订单请求参数
 * @author Administrator
 *
 */
public class CloseOrderParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<appid><![CDATA[wx2421b1c4370ec43b]]></appid>"
				+ "<mch_id><![CDATA[10000100]]></mch_id>"
				+ "<nonce_str><![CDATA[TN55wO9Pba5yENl8]]></nonce_str>"
				+ "<out_trade_no>1415983244</out_trade_no>"
				+ "<sign><![CDATA[BDF0099C15FF7BC6B1585FBB110AB635]]></sign>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		CloseOrderParam data = mapper.readValue(xml, CloseOrderParam.class);
		Assert.assertNotNull(data);
	}
}
