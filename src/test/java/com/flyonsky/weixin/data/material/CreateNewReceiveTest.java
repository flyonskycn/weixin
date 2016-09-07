package com.flyonsky.weixin.data.material;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 上传永久素材的响应
 * @author Administrator
 *
 */
public class CreateNewReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"media_id\":\"MEDIA_ID\"}";
		ObjectMapper mapper = new ObjectMapper();
		CreateNewReceive data = mapper.readValue(json, CreateNewReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getMediaId());
	}
}
