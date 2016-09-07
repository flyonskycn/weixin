package com.flyonsky.weixin.data.user;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 单元测试
 * @author Administrator
 *
 */
public class FetchListReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"total\":23000,"
				+ "\"count\":10000,"
				+ "\"data\":{"
				+ "\"openid\":["
				+ "\"OPENID1\","
				+ "\"OPENID2\","
				+ "\"OPENID10000\""
				+ " ]"
				+ "},"
				+ "\"next_openid\":\"OPENID10000\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		FetchListReceive data = mapper.readValue(json, FetchListReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getData());
		Assert.assertTrue(data.getData().getOpenid().size() > 0);
	}
}
