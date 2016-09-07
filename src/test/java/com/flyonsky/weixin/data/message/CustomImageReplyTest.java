package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 客服发送的图片消息
 * @author Administrator
 *
 */
public class CustomImageReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"msgtype\":\"image\","
				+ "\"image\":"
				+ " {"
				+ "\"media_id\":\"MEDIA_ID\""
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomImageReply data = mapper.readValue(json, CustomImageReply.class);
		
		Assert.assertNotNull(data);
		
		System.out.println(data.toJson());
	}
}
