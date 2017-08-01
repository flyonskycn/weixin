package com.flyonsky.jackson;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.stax.OutputFactoryImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class XmlnsTest {

	@Test
	public void test() throws JsonProcessingException{
		XmlFactory factory = new XmlFactory(new InputFactoryImpl(), new OutputFactoryImpl());
		ObjectMapper xmlMapper = new XmlMapper(factory);
		String xml = xmlMapper.writeValueAsString(new Simple());
		Assert.assertNotNull(xml);
		System.out.println(xml);
	}
	
	@JacksonXmlRootElement(localName="xml",namespace="abc")
	private static class Simple {
		@JacksonXmlProperty(namespace="abc")
		public int x = 1;
		public int y = 2;
	}
}
