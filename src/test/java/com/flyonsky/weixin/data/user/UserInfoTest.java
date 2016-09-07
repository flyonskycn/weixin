package com.flyonsky.weixin.data.user;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 微信用户信息单元测试
 * @author Administrator
 *
 */
public class UserInfoTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"subscribe\": 1, "
				+ "\"openid\": \"o6_bmjrPTlm6_2sgVt7hMZOPfL2M\", "
				+ "\"nickname\": \"Band\", "
				+ "\"sex\": 1, "
				+ "\"language\": \"zh_CN\", "
				+ "\"city\": \"广州\", "
				+ "\"province\": \"广东\", "
				+ "\"country\": \"中国\", "
				+ "\"headimgurl\":\"http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0\","
				+ "\"subscribe_time\": 1382694957,"
				+ "\"unionid\": \" o6_bmasdasdsad6_2sgVt7hMZOPfL\","
				+ "\"remark\": \"\","
				+ "\"groupid\": 0"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		UserInfo user = mapper.readValue(json, UserInfo.class);
		Assert.assertNotNull(user);
		Assert.assertTrue(user.isSuccess());
	}
}
