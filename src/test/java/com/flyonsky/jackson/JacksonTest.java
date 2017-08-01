package com.flyonsky.jackson;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;

import org.codehaus.stax2.XMLOutputFactory2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.ctc.wstx.api.WstxInputProperties;
import com.ctc.wstx.stax.WstxOutputFactory;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.stax.OutputFactoryImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.jaxb.XmlJaxbAnnotationIntrospector;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

public class JacksonTest {

	@Ignore
	@Test
	public void testSimple() throws JsonParseException, JsonMappingException, IOException{
		
		String json = "{\"name\":\"Bob\", \"age\":13}";
		ObjectMapper mapper = new ObjectMapper();
		MyValue value = mapper.readValue(json, MyValue.class);
		Assert.assertNotNull(value);
		Assert.assertEquals(13, value.getAge());
		
		String jsonString = mapper.writeValueAsString(value);
		System.out.println(jsonString);
	}
	
	@Ignore
	@Test
	public void testListSimple() throws JsonParseException, JsonMappingException, IOException{
		String json = "[{\"name\":\"Bob\", \"age\":13},{\"name\":\"wengang\", \"age\":13}]";
		ObjectMapper mapper = new ObjectMapper();
		List<MyValue> list = mapper.readValue(json, new TypeReference<List<MyValue>>() {
		});
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
	}
	
	@Ignore
	@Test
	public void testMapList() throws JsonParseException, JsonMappingException, IOException{
		String json = "[\"name\",\"Bob\"]";
		ObjectMapper mapper = new ObjectMapper();
		List<String> list = mapper.readValue(json, List.class);
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
		
		String mapString = "{\"age\":10,\"sex\":1}";
		Map<String,Integer> map = mapper.readValue(mapString, Map.class);
		Assert.assertNotNull(map);
		Assert.assertEquals(10, map.get("age").intValue());
	}
	
	@Ignore
	@Test
	public void testComplex() throws IOException{
		String jsonString = "{\"name\" : \"wengang\", \"age\" : 20,\"other\":{\"type\" : \"luo\"}}";
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = (ObjectNode) mapper.readTree(jsonString);
		Complex com = mapper.treeToValue(root, Complex.class);
		
		Assert.assertNotNull(com);
		
		String name = root.get("name").asText();
		int age = root.get("age").asInt();
		System.out.println(name);
		System.out.println(age);
		
		// can modify as well: this adds child Object as property 'other', set property 'type'
		root.with("other").put("type", "student");
		String json = mapper.writeValueAsString(root);
		System.out.println(json);
		// with above, we end up with something like as 'json' String:
		// {
		//   "name" : "Bob", "age" : 13,
		//   "other" : {
//		      "type" : "student"
		//   }
		// }
	}
	
	@Test
	public void testList() throws JsonProcessingException{
		List<Complex> list = new ArrayList<Complex>();
		
		Complex  c = null;
		for(int i=0;i<2;i++){
			c = new Complex();
			c.setName(String.valueOf(i));
			c.setAge(i);
			list.add(c);
		}
		
		ArrayComplex comlist = new ArrayComplex();
		comlist.setList(list);
		XMLOutputFactory outputFactory = new WstxOutputFactory(){

			@Override
			public XMLStreamWriter createXMLStreamWriter(OutputStream out) throws XMLStreamException {
				XMLStreamWriter writer = super.createXMLStreamWriter(out);
				mConfig.setProperty(WstxInputProperties.P_RETURN_NULL_FOR_DEFAULT_NAMESPACE,  true);
				writer.setPrefix("launcher", "http://schemas.android.com/apk/res/com.coco.launcher");
				return writer;
			}

			@Override
			public XMLStreamWriter createXMLStreamWriter(OutputStream out, String enc) throws XMLStreamException {
				XMLStreamWriter writer = super.createXMLStreamWriter(out,enc);
				mConfig.setProperty(WstxInputProperties.P_RETURN_NULL_FOR_DEFAULT_NAMESPACE,  true);
				writer.setPrefix("launcher", "http://schemas.android.com/apk/res/com.coco.launcher");
				return writer;
			}

			@Override
			public XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException {
				XMLStreamWriter writer = super.createXMLStreamWriter(result);
				mConfig.setProperty(WstxInputProperties.P_RETURN_NULL_FOR_DEFAULT_NAMESPACE,  true);
				writer.setPrefix("launcher", "http://schemas.android.com/apk/res/com.coco.launcher");
				return writer;
			}

			@Override
			public XMLStreamWriter createXMLStreamWriter(Writer w) throws XMLStreamException {
				XMLStreamWriter writer = super.createXMLStreamWriter(w);
				mConfig.setProperty(WstxInputProperties.P_RETURN_NULL_FOR_DEFAULT_NAMESPACE,  true);
				writer.setPrefix("launcher", "http://schemas.android.com/apk/res/com.coco.launcher");
				return writer;
			}

			@Override
			public XMLStreamWriter2 createXMLStreamWriter(Writer w, String enc) throws XMLStreamException {
				XMLStreamWriter2 writer = super.createXMLStreamWriter(w,enc);
				mConfig.setProperty(WstxInputProperties.P_RETURN_NULL_FOR_DEFAULT_NAMESPACE,  true);
				writer.setPrefix("launcher", "http://schemas.android.com/apk/res/com.coco.launcher");
				return writer;
			}
			
		};
//		outputFactory.setProperty(XMLOutputFactory2.P_AUTOMATIC_NS_PREFIX, "launcher");
		XmlFactory factory = new XmlFactory(new InputFactoryImpl(), outputFactory);
		XmlMapper mapper = new XmlMapper(factory);
		mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );
		String xml = mapper.writeValueAsString(comlist);
		System.out.println(xml);
	}
	
	private static class Complex{
		@JacksonXmlProperty(localName="launcher:name",isAttribute=true)
		private String name;
		@JacksonXmlProperty(localName="launcher:age",isAttribute=true)
		private int age;
		@JacksonXmlProperty(localName="launcher:other",isAttribute=true)
		private Student other;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Student getOther() {
			return other;
		}
		public void setOther(Student other) {
			this.other = other;
		}
	}
	
	@JacksonXmlRootElement(localName="favorites",namespace="http://schemas.android.com/apk/res/com.coco.launcher")
	private static class ArrayComplex{
		@JacksonXmlProperty(localName="favorite",namespace="http://schemas.android.com/apk/res/com.coco.launcher")
		@JacksonXmlElementWrapper(useWrapping=false)
		private List<Complex> list = new ArrayList<Complex>();

		public List<Complex> getList() {
			return list;
		}

		public void setList(List<Complex> list) {
			this.list = list;
		} 
	}
	
	private static class Student{
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}
}
