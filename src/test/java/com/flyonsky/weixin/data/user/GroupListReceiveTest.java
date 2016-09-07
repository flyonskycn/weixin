package com.flyonsky.weixin.data.user;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 查询所有分组响应
 * @author Administrator
 *
 */
public class GroupListReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"groups\": ["
				+ " {"
				+ "\"id\": 0,"
				+ "\"name\": \"未分组\", "
				+ "\"count\": 72596"
				+ "}"
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		GroupListReceive data = mapper.readValue(json, GroupListReceive.class);
		
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
	}
}
