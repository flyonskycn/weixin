package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 获取客服的会话列表响应
 * @author Administrator
 *
 */
public class CustomClientListReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"sessionlist\" : ["
				+ "{"
				+ "\"createtime\" : 123456789,"
				+ "\"openid\" : \"OPENID\""
				+ "},"
				+ "{"
				+ "\"createtime\" : 123456789,"
				+ "\"openid\" : \"OPENID\""
				+ "}"
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomClientListReceive data = mapper.readValue(json, CustomClientListReceive.class);
		
		Assert.assertNotNull(data);
		Assert.assertEquals(2, data.getSessionList().size());
	}
}
