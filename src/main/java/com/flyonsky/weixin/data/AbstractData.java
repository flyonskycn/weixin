package com.flyonsky.weixin.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.stax.OutputFactoryImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 微信数据交换基类,提供了java对象转换为XML或json字符串的通用方法
 * @author Administrator
 *
 */
public abstract class AbstractData {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractData.class);

	/**
	 * 将对应的java对象转换为XML类型的字符串
	 * @return
	 */
	public String toXml(){
		XmlFactory factory = new XmlFactory(new InputFactoryImpl(), new OutputFactoryImpl());
		ObjectMapper mapper = new XmlMapper(factory);
		String value = "";
		try {
			value = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
		}
		return value;
	}
	
	/**
	 * 将对应的java对象转换JSON的字符串
	 * @return
	 */
	public String toJson(){
		ObjectMapper mapper = new ObjectMapper();
		String value = "";
		try {
			value = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
		}
		return value;
	}
}
