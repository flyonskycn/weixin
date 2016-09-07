package com.flyonsky.weixin.data.user;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 新建分组的请求参数
 * @author Administrator
 *
 */
public class GroupParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"group\":{\"name\":\"test\"}}";
		ObjectMapper mapper = new ObjectMapper();
		
		GroupParam data = mapper.readValue(json, GroupParam.class);
		
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getGroup());
	}
}
