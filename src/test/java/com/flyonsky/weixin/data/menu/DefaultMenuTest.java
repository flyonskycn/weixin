package com.flyonsky.weixin.data.menu;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 测试微信自定义菜单
 * @author Administrator
 *
 */
public class DefaultMenuTest {
	
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
				+ "}]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		DefaultMenu data  = mapper.readValue(json, DefaultMenu.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getButton());
		Assert.assertEquals(2, data.getButton().size());
	}
}
