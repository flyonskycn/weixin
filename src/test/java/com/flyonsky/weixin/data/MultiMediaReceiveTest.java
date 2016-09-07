package com.flyonsky.weixin.data;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 获取具体媒体的响应对象
 * @author Administrator
 *
 */
public class MultiMediaReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"errcode\":40007,\"errmsg\":\"invalid media_id\"}";
		ObjectMapper mapper = new ObjectMapper();
		MultiMediaReceive data = mapper.readValue(json, MultiMediaReceive.class);
		
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getErrCode().intValue() > 0);
	}
}
