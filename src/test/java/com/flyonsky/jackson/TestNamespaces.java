package com.flyonsky.jackson;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class TestNamespaces {
	 @JacksonXmlRootElement( localName = "person", namespace =
			 "http://example.org/person" )
			    static class Person
			    {
			        private String name;

			        @JacksonXmlProperty( namespace = "http://example.org/person" )
			        public String getName()
			        {
			            return name;
			        }

			        public void setName( String name )
			        {
			            this.name = name;
			        }
			    }

			    public static void main( String... args ) throws IOException
			    {
			        Person person = new Person();
			        person.setName( "hello" );

			        XmlMapper xmlMapper = new XmlMapper();
			        xmlMapper.writeValue( System.err, person );
			    }
}
