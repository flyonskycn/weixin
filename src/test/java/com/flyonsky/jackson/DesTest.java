package com.flyonsky.jackson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class DesTest {

	@Test
	public void test1() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<Courses semester=\"1\"><Course code=\"A231\" credits=\"3\">Intermediate A</Course><Course code=\"A105\" credits=\"2\">Intro to A</Course><Course code=\"B358\" credits=\"4\">Advanced B</Course></Courses>";
		
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper(module);
		Schedule s = xmlMapper.readValue(xml, Schedule.class);
		Assert.assertNotNull(s);
		System.out.println(s);
	}
}

@JacksonXmlRootElement(localName = "Courses")
class Schedule {

    @JacksonXmlProperty(isAttribute = true)
    private int semester;

    @JacksonXmlProperty(localName = "Course")
    private Course[] courses;

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Course[] getCourses() {
		return courses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
}

class Course {

    @JacksonXmlProperty(isAttribute = true)
    private String code;

    @JacksonXmlProperty(isAttribute = true)
    private int credits;

    @JacksonXmlText(value = true)
    private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
