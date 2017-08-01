package com.flyonsky.jackson;

import java.io.IOException;

import javax.xml.stream.XMLInputFactory;

import org.junit.Test;

import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class DeserializingTest {

	@Test
	public void test() throws IOException{
		Foo foo = new Foo();
        foo.setBar(new Bar());

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(foo);
        System.out.println(xml);
        System.out.println("XML Desearialzing....");
        XMLInputFactory inputFactory = new WstxInputFactory();
		inputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.FALSE);
		XmlFactory factory = new XmlFactory(inputFactory, new WstxOutputFactory());
		XmlMapper mapper = new XmlMapper(factory);
        Foo foo2= mapper.readValue(xml, Foo.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(foo2));
	}
}

class Bar{
    @JacksonXmlProperty(localName="name:x")
    public String x = "x";
    @JacksonXmlProperty(localName="name:y")
    public String y = "y";
}

@JacksonXmlRootElement(localName="name:Foo")
class Foo{
    private Bar bar;

    @JacksonXmlProperty(localName="name:Bar")
    public Bar getBar() {
        return bar;
    }
    public void setBar(Bar bar) {
        this.bar = bar;
    }
}