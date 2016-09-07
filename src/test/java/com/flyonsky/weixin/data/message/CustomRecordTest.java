package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 客服记录
 * @author Administrator
 *
 */
public class CustomRecordTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"openid\" : \"oDF3iY9WMaswOPWjCIp_f3Bnpljk\","
				+ "\"opercode\" : 2002,"
				+ "\"text\" : \" 您好，客服test1为您服务。\","
				+ "\"time\" : 1400563710,"
				+ "\"worker\" : \"test1\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomRecord data = mapper.readValue(json, CustomRecord.class);
		Assert.assertNotNull(data);
	}
}
