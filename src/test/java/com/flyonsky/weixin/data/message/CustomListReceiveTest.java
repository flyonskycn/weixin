package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 所有客服账号响应
 * @author Administrator
 *
 */
public class CustomListReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"kf_list\": ["
				+ "{"
				+ "\"kf_account\": \"test1@test\", "
				+ "\"kf_nick\": \"ntest1\","
				+ "\"kf_id\": \"1001\","
				+ "\"kf_headimgurl\": \" http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjfUS8Ym0GSaLic0FD3vN0V8PILcibEGb2fPfEOmw/0\""
				+ " } "
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomListReceive data = mapper.readValue(json, CustomListReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getKfList());
		Assert.assertTrue(data.getKfList().size() > 0);
	}
}
