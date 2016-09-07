package com.flyonsky.weixin.data.menu;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 测试测试个性化菜单匹配结果
 * @author Administrator
 *
 */
public class MatchReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"menu\":{\"button\":[{\"type\":\"pic_sysphoto\",\"name\":\"拍照\",\"key\":\"rselfmenu_1_0\",\"sub_button\":[]}]}}";
		ObjectMapper mapper = new ObjectMapper();
		MatchReceive data = mapper.readValue(json, MatchReceive.class);
		
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
	}
}
