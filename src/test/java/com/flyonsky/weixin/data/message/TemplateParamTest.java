package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 测试发送模板消息的请求参数
 * @author Administrator
 *
 */
public class TemplateParamTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"template_id\":\"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY\","
				+ "\"url\":\"http://weixin.qq.com/download\","
				+ "\"data\":{"
				+ "\"first\": {"
				+ "\"value\":\"恭喜你购买成功！\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keynote1\":{"
				+ "\"value\":\"巧克力\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keynote2\": {"
				+ "\"value\":\"39.8元\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keynote3\": {"
				+ "\"value\":\"2014年9月22日\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"remark\":{"
				+ "\"value\":\"欢迎再次购买！\","
				+ "\"color\":\"#173177\""
				+ "}"
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		TemplateParam data = mapper.readValue(json, TemplateParam.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isNotBlank(data.getTemplateId()));
		Assert.assertEquals(5, data.getData().size());
		System.out.println(mapper.writeValueAsString(data));
	}
}
