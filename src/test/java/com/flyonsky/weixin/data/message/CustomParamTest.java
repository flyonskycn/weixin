package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 微信客服消息参数测试
 * @author Administrator
 *
 */
public class CustomParamTest {
	
	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"kf_account\" : \"test1@test\","
				+ "\"nickname\" : \"客服1\","
				+ "\"password\" : \"pswmd5\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomParam data = mapper.readValue(json, CustomParam.class);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
}
