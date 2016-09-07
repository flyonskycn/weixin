package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomOnlineTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"kf_account\": \"test1@test\","
				+ "\"status\": 1, "
				+ "\"kf_id\": \"1001\", "
				+ "\"auto_accept\": 0, "
				+ "\"accepted_case\": 1"
				+ "}";			
		ObjectMapper mapper = new ObjectMapper();
		CustomOnline data = mapper.readValue(json, CustomOnline.class);
		Assert.assertNotNull(data);
		Assert.assertEquals(1, data.getStatus());
		System.out.println(data.toJson());
	}
}
