package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 获取客服聊天记录接口请求参数
 * @author Administrator
 *
 */
public class CustomRecordParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"endtime\" : 987654321,"
				+ "\"pageindex\" : 1,"
				+ "\"pagesize\" : 10,"
				+ "\"starttime\" : 123456789"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomRecordParam data = mapper.readValue(json, CustomRecordParam.class);
		Assert.assertNotNull(data);
		Assert.assertEquals(1, data.getPageIndex());
		Assert.assertEquals(10, data.getPageSize());
	}
}
