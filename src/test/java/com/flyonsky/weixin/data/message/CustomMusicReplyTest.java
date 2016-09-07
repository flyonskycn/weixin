package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 客服发送的音乐消息
 * @author Administrator
 *
 */
public class CustomMusicReplyTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"touser\":\"OPENID\","
				+ "\"msgtype\":\"music\","
				+ "\"music\":"
				+ " {"
				+ "\"title\":\"MUSIC_TITLE\","
				+ "\"description\":\"MUSIC_DESCRIPTION\","
				+ "\"musicurl\":\"musicurl\","
				+ "\"hqmusicurl\":\"hqmusicurl\","
				+ "\"thumb_media_id\":\"THUMB_MEDIA_ID\""
				+ "}"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CustomMusicReply data = mapper.readValue(json, CustomMusicReply.class);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
}
