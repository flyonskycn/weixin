package com.flyonsky.weixin.data.material;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VideoMaterialTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"title\":\"TITLE\","
				+ "\"description\":\"DESCRIPTION\","
				+ "\"down_url\":\"DOWN_URL\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		VideoMaterial item = mapper.readValue(json, VideoMaterial.class);
		Assert.assertNotNull(item);
	}
}
