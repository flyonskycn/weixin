package com.flyonsky.weixin.data.menu;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 公众号的不同用户群体看到不一样的自定义菜单
 * @author Administrator
 *
 */
public class PersonalityMenuTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = " {"
				+ "\"button\":["
				+ " {"
				+ "\"type\":\"click\","
				+ "\"name\":\"今日歌曲\","
				+ "\"key\":\"V1001_TODAY_MUSIC\""
				+ " },"
				+ "{"
				+ "\"name\":\"菜单\","
				+ "\"sub_button\":["
				+ "{"
				+ "\"type\":\"view\","
				+ "\"name\":\"搜索\","
				+ "\"url\":\"http://www.soso.com/\""
				+ "},"
				+ " {"
				+ ""
				+ "\"type\":\"view\","
				+ "\"name\":\"视频\","
				+ "\"url\":\"http://v.qq.com/\""
				+ "}]"
				+ "}],"
				+ "\"matchrule\":{"
				+ "\"group_id\":\"2\","
				+ "\"sex\":\"1\","
				+ "\"country\":\"中国\","
				+ "\"province\":\"广东\","
				+ "\"city\":\"广州\","
				+ "\"client_platform_type\":\"2\","
				+ "\"language\":\"zh_CN\""
				+ " }"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		PersonalityMenu data  = mapper.readValue(json, PersonalityMenu.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getButton());
		Assert.assertEquals(2, data.getButton().size());
		Assert.assertNotNull(data.getMatchRule());
	}
}
