package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 客服会话接口请求参数
 * @author Administrator
 *
 */
public class CustomSessionParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"kf_account\" : \"test1@test\","
				+ "\"openid\" : \"OPENID\","
				+ "\"text\" : \"这是一段附加信息\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomSessionParam data = mapper.readValue(json, CustomSessionParam.class);
		
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getKfAccount());
		Assert.assertNotNull(data.getOpenid());
		Assert.assertNotNull(data.getText());
	}
}
