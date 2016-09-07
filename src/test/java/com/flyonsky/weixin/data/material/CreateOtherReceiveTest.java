package com.flyonsky.weixin.data.material;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 新增其他类型永久素材响应
 * @author Administrator
 *
 */
public class CreateOtherReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"media_id\":\"MEDIA_ID\","
				+ "\"url\":\"URL\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CreateOtherReceive data = mapper.readValue(json, CreateOtherReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getMediaId());
		Assert.assertNotNull(data.getUrl());
	}
}
