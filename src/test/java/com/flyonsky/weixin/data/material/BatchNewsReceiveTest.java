package com.flyonsky.weixin.data.material;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BatchNewsReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"total_count\":10,"
				+ "\"item_count\":1,"
				+ "\"item\": [{"
				+ "\"media_id\": \"MEDIA_ID\","
				+ "\"content\": {"
				+ "\"news_item\": [{"
				+ "\"title\": \"TITLE\","
				+ "\"thumb_media_id\":\"THUMB_MEDIA_ID\","
				+ "\"thumb_url\": \"THUMB_URL\","
				+ "\"show_cover_pic\": 1,"
				+ "\"author\": \"AUTHOR\","
				+ "\"digest\": \"DIGEST\","
				+ "\"content\": \"CONTENT\","
				+ "\"url\": \"URL\","
				+ "\"content_source_url\": \"CONTETN_SOURCE_URL\""
				+ "}"
				+ "]"
				+ "},"
				+ "\"update_time\": 1468574659"
				+ "}"
				+ "]"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		BatchNewsReceive receive = mapper.readValue(json, BatchNewsReceive.class);
		Assert.assertNotNull(receive);
		Assert.assertNotNull(receive.getItem());
		Assert.assertNotNull(receive.getItem().get(0));
	}
}
