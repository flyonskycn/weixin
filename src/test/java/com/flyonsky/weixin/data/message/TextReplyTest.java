package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class TextReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
					+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
					+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
					+ "<CreateTime>12345678</CreateTime>"
					+ "<MsgType><![CDATA[text]]></MsgType>"
					+ "<Content><![CDATA[你好]]></Content>"
					+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		TextReply data = mapper.readValue(xml, TextReply.class);
		Assert.assertNotNull(data);
	}
}
