package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 客服发送的视频消息
 * @author Administrator
 *
 */
public class CustomVideoReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"msgtype\":\"video\","
				+ "\"video\":"
				+ " {"
				+ "\"media_id\":\"MEDIA_ID\","
				+ "\"thumb_media_id\":\"MEDIA_ID\","
				+ "\"title\":\"TITLE\","
				+ "\"description\":\"DESCRIPTION\""
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomVideoReply data = mapper.readValue(json, CustomVideoReply.class);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
}
