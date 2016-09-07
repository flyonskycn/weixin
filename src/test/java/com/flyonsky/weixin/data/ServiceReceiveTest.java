package com.flyonsky.weixin.data;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 公从号服务号接受数据的基类单元测试
 * @author Administrator
 *
 */
public class ServiceReceiveTest {
	
	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"errcode\":40013,\"errmsg\":\"invalid appid\"}";
		ObjectMapper mapper = new ObjectMapper();
		ServiceReceive data = mapper.readValue(json, ServiceReceive.class);
		Assert.assertNotNull(data);
		Assert.assertFalse(data.isSuccess());
		Assert.assertTrue(data.getErrCode().intValue() > 0);
	}
}
