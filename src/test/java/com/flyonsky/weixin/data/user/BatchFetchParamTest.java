package com.flyonsky.weixin.data.user;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 批量获取用户信息查询参数单元测试
 * @author Administrator
 *
 */
public class BatchFetchParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"user_list\": ["
				+ "{"
				+ "\"openid\": \"otvxTs4dckWG7imySrJd6jSi0CWE\", "
				+ "\"lang\": \"zh-CN\""
				+ " },"
				+ "{"
				+ "\"openid\": \"otvxTs_JZ6SEiP0imdhpi50fuSZg\", "
				+ "\"lang\": \"zh-CN\""
				+ " }"
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		BatchFetchParam data = mapper.readValue(json, BatchFetchParam.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getUserList());
		Assert.assertTrue(data.getUserList().size() > 0);
	}
}
