package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 获取客户的会话状态响应
 * @author Administrator
 *
 */
public class ClientSessionReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"createtime\" : 123456789,"
				+ "\"errcode\" : 0,"
				+ "\"errmsg\" : \"ok\","
				+ "\"kf_account\" : \"test1@test\""
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		ClientSessionReceive data = mapper.readValue(json, ClientSessionReceive.class);
		
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
	}
}
