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
public class CustomClientWaitListReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"count\" : 150,"
				+ "\"waitcaselist\" : ["
				+ "{"
				+ "\"createtime\" : 123456789,"
				+ "\"kf_account\" : \"test1@test\","
				+ "\"openid\" : \"OPENID\""
				+ "},"
				+ "{"
				+ "\"createtime\" : 123456789,"
				+ "\"kf_account\" : \"\","
				+ "\"openid\" : \"OPENID\""
				+ "}"
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomClientWaitListReceive data = mapper.readValue(json, CustomClientWaitListReceive.class);
		
		Assert.assertNotNull(data);
		Assert.assertEquals(2, data.getWaitCaseList().size());
	}
}
