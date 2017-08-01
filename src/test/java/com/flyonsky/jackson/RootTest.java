package com.flyonsky.jackson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class RootTest {

	@Test
	public void testRoot() throws JsonGenerationException, JsonMappingException, IOException{
		XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        String value = xmlMapper.writeValueAsString(new SampleRequest());
        Assert.assertNotNull(value);
        System.out.println(value);
	}


//	@JacksonXmlRootElement(localName="xml")
	private static class SampleRequest{
	    public int x = 1;
	    public int y = 2;
	}

}