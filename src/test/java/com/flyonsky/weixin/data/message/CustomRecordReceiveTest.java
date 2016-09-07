package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 获取客服聊天记录接口响应
 * @author Administrator
 *
 */
public class CustomRecordReceiveTest {
	
	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"errcode\": 0,"
				+ "\"errmsg\": \"\","
				+ "\"retcode\": 0,"
				+ "\"recordlist\" : ["
				+ "{"
				+ "\"openid\" : \"oDF3iY9WMaswOPWjCIp_f3Bnpljk\","
				+ "\"opercode\" : 2002,"
				+ "\"text\" : \" 您好，客服test1为您服务。\","
				+ "\"time\" : 1400563710,"
				+ "\"worker\" : \"test1\""
				+ "}"
				+ "]"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		CustomRecordReceive data = mapper.readValue(json, CustomRecordReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getRecordList());
	}
}
