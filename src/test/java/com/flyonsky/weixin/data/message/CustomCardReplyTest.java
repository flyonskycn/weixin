package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 发送卡券
 * @author Administrator
 *
 */
public class CustomCardReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\", "
				+ "\"msgtype\":\"wxcard\","
				+ "\"wxcard\":{"
				+ "\"card_id\":\"123dsdajkasd231jhksad\","
				+ "\"card_ext\": \"{\\\"code\\\":\\\"\\\",\\\"openid\\\":\\\"\\\",\\\"timestamp\\\":\\\"1402057159\\\",\\\"signature\\\":\\\"017bb17407c8e0058a66d72dcc61632b70f511ad\\\"}\""
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		
		CustomCardReply data = mapper.readValue(json, CustomCardReply.class);
		
		Assert.assertNotNull(data);
		System.out.println(data.getWxCard().getCardExt());
		System.out.println(data.toJson());
	}
}
