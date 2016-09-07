package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 客服发送的文本消息
 * @author Administrator
 *
 */
public class CustomTextReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"msgtype\":\"text\","
				+ "\"text\":"
				+ "{"
				+ "\"content\":\"Hello World\""
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomTextReply data = mapper.readValue(json, CustomTextReply.class);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
	
	@Test
	public void testDeserialization2() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"msgtype\":\"text\","
				+ "\"text\":"
				+ "{"
				+ "\"content\":\"Hello World\""
				+ "},"
				+ "\"customservice\":"
				+ "{"
				+ "\"kf_account\": \"test1@kftest\""
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomTextReply data = mapper.readValue(json, CustomTextReply.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getCustomService());
		System.out.println(data.toJson());
		System.out.println(data.getCustomService().toJson());
	}
}
