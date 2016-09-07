package com.flyonsky.weixin.data.material;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 图文素材对象
 * @author Administrator
 *
 */
public class NewsMaterialTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"news_item\":"
				+ "["
				+ "{"
				+ "\"title\":\"TITLE\","
				+ "\"thumb_media_id\":\"THUMB_MEDIA_ID\","
				+ "\"thumb_url\":\"THUMB_URL\","
				+ "\"show_cover_pic\":1,"
				+ "\"author\":\"AUTHOR\","
				+ "\"digest\":\"DIGEST\","
				+ "\"content\":\"CONTENT\","
				+ "\"url\":\"URL\","
				+ "\"content_source_url\":\"CONTENT_SOURCE_URL\""
				+ "}"
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		NewsMaterial item = mapper.readValue(json, NewsMaterial.class);
		Assert.assertNotNull(item);
	}
}
