package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MusicReplyTest {
	
	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>12345678</CreateTime>"
				+ "<MsgType><![CDATA[music]]></MsgType>"
				+ "<Music>"
				+ "<Title><![CDATA[TITLE]]></Title>"
				+ "<Description><![CDATA[DESCRIPTION]]></Description>"
				+ "<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>"
				+ "<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>"
				+ "<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>"
				+ "</Music>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		MusicReply data = mapper.readValue(xml, MusicReply.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getMusic());
	}
}
