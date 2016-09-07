package com.flyonsky.weixin.data;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.flyonsky.weixin.data.message.Notice;

public class MessageDataTest {

	@Test
	public void testPicSysphoto() throws JsonParseException, JsonMappingException, IOException{
		String value = "<xml><ToUserName><![CDATA[gh_17d2db65dc57]]></ToUserName>"
					+ "<FromUserName><![CDATA[o4_jrw3yB-8WV_DH0z-kQ0hidscU]]></FromUserName>"
					+ "<CreateTime>1467356642</CreateTime>"
					+ "<MsgType><![CDATA[event]]></MsgType>"
					+ "<Event><![CDATA[pic_sysphoto]]></Event>"
					+ "<EventKey><![CDATA[rselfmenu_1_0]]></EventKey>"
					+ "<SendPicsInfo><Count>1</Count>"
					+ "<PicList><item><PicMd5Sum><![CDATA[3271ec392d09a61473a949f0bc38e580]]></PicMd5Sum>"
					+ "</item>"
					+ "</PicList>"
					+ "</SendPicsInfo>"
					+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(value, Notice.class);
		Assert.assertNotNull(data);
	}
}
