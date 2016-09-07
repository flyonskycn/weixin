package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomOnlineReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"kf_online_list\": ["
				+ "{"
				+ "\"kf_account\": \"test1@test\","
				+ "\"status\": 1, "
				+ "\"kf_id\": \"1001\", "
				+ "\"auto_accept\": 0, "
				+ "\"accepted_case\": 1"
				+ "},"
				+ "{"
				+ "\"kf_account\": \"test2@test\", "
				+ "\"status\": 1,"
				+ "\"kf_id\": \"1002\", "
				+ "\"auto_accept\": 0, "
				+ "\"accepted_case\": 2"
				+ "}"
				+ "]"
				+ "}";			
		ObjectMapper mapper = new ObjectMapper();
		CustomOnlineReceive data = mapper.readValue(json, CustomOnlineReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getKfOnlineList());
		Assert.assertEquals(2, data.getKfOnlineList().size());
		System.out.println(data.toJson());
	}
}
