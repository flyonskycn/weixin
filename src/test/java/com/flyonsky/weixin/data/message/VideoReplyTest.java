package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class VideoReplyTest {
	
	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
					+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
					+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
					+ "<CreateTime>12345678</CreateTime>"
					+ "<MsgType><![CDATA[video]]></MsgType>"
					+ "<Video>"
					+ "<MediaId><![CDATA[media_id]]></MediaId>"
					+ "<Title><![CDATA[title]]></Title>"
					+ "<Description><![CDATA[description]]></Description>"
					+ "</Video>"
					+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		VideoReply data = mapper.readValue(xml, VideoReply.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getVideo());
	}
}
