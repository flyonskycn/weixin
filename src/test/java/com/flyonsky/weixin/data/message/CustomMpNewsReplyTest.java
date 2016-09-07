package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomMpNewsReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"msgtype\":\"mpnews\","
				+ "\"mpnews\":"
				+ " {"
				+ "\"media_id\":\"MEDIA_ID\""
				+ " }"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomMpNewsReply data = mapper.readValue(json, CustomMpNewsReply.class);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
}
