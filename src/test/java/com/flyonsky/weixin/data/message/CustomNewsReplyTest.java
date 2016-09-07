package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 客服发送的图文消息
 * @author Administrator
 *
 */
public class CustomNewsReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"msgtype\":\"news\","
				+ "\"news\":{"
				+ "\"articles\": ["
				+ "{"
				+ "\"title\":\"Happy Day\","
				+ "\"description\":\"Is Really A Happy Day\","
				+ "\"url\":\"URL\","
				+ "\"picurl\":\"PIC_URL\""
				+ "},"
				+ "{"
				+ " \"title\":\"Happy Day\","
				+ "\"description\":\"Is Really A Happy Day\","
				+ "\"url\":\"URL\","
				+ "\"picurl\":\"PIC_URL\""
				+ "}"
				+ "]"
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomNewsReply data = mapper.readValue(json, CustomNewsReply.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getNews());
		Assert.assertTrue(data.getNews().getArticles().size() > 0);
		System.out.println(data.toJson());
	}
}
