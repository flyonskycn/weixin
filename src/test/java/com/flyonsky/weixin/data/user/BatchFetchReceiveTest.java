package com.flyonsky.weixin.data.user;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 批量获取用户信息接口返回数据对象单元测试
 * @author Administrator
 *
 */
public class BatchFetchReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"user_info_list\": ["
				+ " {"
				+ "\"subscribe\": 1,"
				+ "\"openid\": \"otvxTs4dckWG7imySrJd6jSi0CWE\", "
				+ "\"nickname\": \"iWithery\","
				+ "\"sex\": 1, "
				+ "\"language\": \"zh_CN\", "
				+ "\"city\": \"Jieyang\", "
				+ "\"province\": \"Guangdong\","
				+ "\"country\": \"China\", "
				+ "\"headimgurl\": \"http://wx.qlogo.cn/mmopen/xbIQx1GRqdvyqkMMhEaGOX802l1CyqMJNgUzKP8MeAeHFicRDSnZH7FY4XB7p8XHXIf6uJA2SCunTPicGKezDC4saKISzRj3nz/0\", "
				+ "\"subscribe_time\": 1434093047, "
				+ "\"unionid\": \"oR5GjjgEhCMJFyzaVZdrxZ2zRRF4\", "
				+ "\"remark\": \"\", "
				+ "\"groupid\": 0"
				+ "},"
				+ "{"
				+ "\"subscribe\": 0, "
				+ "\"openid\": \"otvxTs_JZ6SEiP0imdhpi50fuSZg\", "
				+ "\"unionid\": \"oR5GjjjrbqBZbrnPwwmSxFukE41U\""
				+ "}"
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		BatchFetchReceive data = mapper.readValue(json, BatchFetchReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getUserInfoList());
		Assert.assertTrue(data.getUserInfoList().size() > 0);
	}
}
