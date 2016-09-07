package com.flyonsky.weixin.data.material;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 上传图文消息中的图片，但并不作为永久的图片素材响应
 * @author Administrator
 *
 */
public class CreateImageReceiveTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				 + "\"url\":  \"http://mmbiz.qpic.cn/mmbiz/gLO17UPS6FS2xsypf378iaNhWacZ1G1UplZYWEYfwvuU6Ont96b1roYs CNFwaRrSaKTPCUdBK9DgEHicsKwWCBRQ/0\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		CreateImageReceive data = mapper.readValue(json, CreateImageReceive.class);
		Assert.assertNotNull(data);
		Assert.assertNotNull(data.getUrl());
	}
}
