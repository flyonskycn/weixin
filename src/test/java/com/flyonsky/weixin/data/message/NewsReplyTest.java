package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class NewsReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
					+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
					+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
					+ "<CreateTime>12345678</CreateTime>"
					+ "<MsgType><![CDATA[news]]></MsgType>"
					+ "<ArticleCount>2</ArticleCount>"
					+ "<Articles>"
					+ "<item>"
					+ "<Title><![CDATA[title1]]></Title>"
					+ "<Description><![CDATA[description1]]></Description>"
					+ "<PicUrl><![CDATA[picurl]]></PicUrl>"
					+ "<Url><![CDATA[url]]></Url>"
					+ "</item>"
					+ "<item>"
					+ "<Title><![CDATA[title]]></Title>"
					+ "<Description><![CDATA[description]]></Description>"
					+ "<PicUrl><![CDATA[picurl]]></PicUrl>"
					+ "<Url><![CDATA[url]]></Url>"
					+ "</item>"
					+ "</Articles>"
					+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		NewsReply data = mapper.readValue(xml, NewsReply.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getArticles());
		Assert.assertEquals(2, data.getArticles().size());
	}
}
