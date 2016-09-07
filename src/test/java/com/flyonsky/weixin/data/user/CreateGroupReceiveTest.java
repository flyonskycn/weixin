package com.flyonsky.weixin.data.user;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 新建分组的请求响应
 * @author Administrator
 *
 */
public class CreateGroupReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"group\": {"
				+ " \"id\": 107, "
				+ "\"name\": \"test\""
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		
		CreateGroupReceive data = mapper.readValue(json, CreateGroupReceive.class);
		
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getGroup());
		Assert.assertTrue(data.isSuccess());
	}
}
