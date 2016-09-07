package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 消息转发到多客服
 * @author Administrator
 *
 */
public class CustomTransferReplyTest {
	
	@Test
	public void testDeserialization1() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[touser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromuser]]></FromUserName>"
				+ "<CreateTime>1399197672</CreateTime>"
				+ "<MsgType><![CDATA[transfer_customer_service]]></MsgType>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		CustomTransferReply data = mapper.readValue(xml, CustomTransferReply.class);
		Assert.assertNotNull(data);
		Assert.assertNull(data.getTransInfo());
	}
	
	
	@Test
	public void testDeserialization2() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[touser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromuser]]></FromUserName>"
				+ "<CreateTime>1399197672</CreateTime>"
				+ "<MsgType><![CDATA[transfer_customer_service]]></MsgType>"
				+ "<TransInfo>"
				+ "<KfAccount><![CDATA[test1@test]]></KfAccount>"
				+ "</TransInfo>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		CustomTransferReply data = mapper.readValue(xml, CustomTransferReply.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getTransInfo());
	}
}
