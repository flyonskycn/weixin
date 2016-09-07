package com.flyonsky.weixin;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.flyonsky.weixin.data.EnumContentType;
import com.flyonsky.weixin.data.MultiMediaParam;
import com.flyonsky.weixin.data.MultiMediaReceive;

/**
 * 与微信后台交互的http基础类
 * @author Administrator
 *
 */
abstract class AbstractHandle {
	
	protected static final Logger LOG = LoggerFactory.getLogger(AbstractHandle.class);
	
	/**
	 *  http head 中的 contentType名称
	 */
	protected static final String CONTENTTYPE_HEAD = "Content-Type"; 
	
	/**
	 * json 的ContentType
	 */
	protected static final String JSON_CONTENTTYPE = "application/json";
	
	/**
	 * xml 的ContentType
	 */
	protected static final String XML_CONTENTTYPE = "text/xml";
	
	/**
	 * 黙认的编码类型
	 */
	protected static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * 以get方式执行url,并将结果以java对象方式返回
	 * @param url URL地址
	 * @param cls java对象的class
	 * @return
	 */
	protected <T> T doGet(String url, Class<?> cls){
		return this.doGet(url, cls, EnumContentType.json);
	}
	
	/**
	 * 以get方式执行url,并将结果以java对象方式返回
	 * @param url URL地址
	 * @param cls java对象的class
	 * @param resultType 响应字符串表示的类型
	 * @return
	 */
	protected <T> T doGet(String url, Class<?> cls, EnumContentType resultType){
		HttpGet httpGet = new HttpGet(url);
		return this.execute(httpGet, cls, resultType);
	}
	
	/**
	 * 以get方式执行url,并将结果中的多媒体输入流封装在对象中
	 * @param url url地址
	 * @return
	 */
	protected MultiMediaReceive doGet(String url){
		return this.doGet(url,EnumContentType.json);
	}
	
	/**
	 * 以get方式执行url,并将结果中的多媒体输入流封装在对象中
	 * @param url url地址
	 * @param resultType 响应字符串表示的类型
	 * @return
	 */
	protected MultiMediaReceive doGet(String url, EnumContentType resultType){
		HttpGet httpGet = new HttpGet(url);
		return this.execute(httpGet, resultType);
	}
	
	/**
	 * 以post方式执行url,并将结果中的多媒体输入流封装在对象中
	 * @param url url地址
	 * @param param 参数
	 * @return
	 */
	protected MultiMediaReceive doPost(String url, Object param){
		return doPost(url, param,EnumContentType.json, EnumContentType.json);
	}
	
	/**
	 * 以post方式执行url,并将结果中的多媒体输入流封装在对象中
	 * @param url url地址
	 * @param param 参数
	 * @param paramType post参数的java对象转换为成对应类型的字符串表示
	 * @param resultType 响应字符串表示的类型
	 * @return
	 */
	protected MultiMediaReceive doPost(String url,
			Object param,
			EnumContentType paramType,
			EnumContentType resultType){
		HttpPost httpPost = new HttpPost(url);
		String paramData = null;
		switch(paramType){
		case xml:
			httpPost.addHeader(CONTENTTYPE_HEAD, XML_CONTENTTYPE);
			paramData = this.javaToXml(param);
			break;
			default:
				httpPost.addHeader(CONTENTTYPE_HEAD, JSON_CONTENTTYPE);
				paramData = this.javaToJson(param);
				break;
		}
		LOG.debug(paramData);
		HttpEntity entity = new StringEntity(paramData, DEFAULT_CHARSET);
		httpPost.setEntity(entity);
		
		return this.execute(httpPost,resultType);
	}
	
	/**
	 * 通用的多媒体输入流输换为对象
	 * @param request 请求的request对象
	 * @param resultType 结果返回字符串对象类型
	 * @return 
	 */
	private MultiMediaReceive execute(HttpUriRequest request, EnumContentType resultType){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		MultiMediaReceive result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(request);
            HttpEntity entity1 = response1.getEntity();
            boolean flag = response1.containsHeader(CONTENTTYPE_HEAD);
            String contenType = null;
            if(flag){
            	contenType = response1.getFirstHeader(CONTENTTYPE_HEAD).getValue();
            }
            
            LOG.debug(contenType);
            if(flag && "text/plain".equals(contenType)){
                String value = EntityUtils.toString(entity1, Charset.forName("UTF-8"));
                LOG.debug(value);
                
                switch(resultType){
                case xml:
                	result = this.xmlToJava(value, MultiMediaReceive.class);
                	break;
                	default:
                		request = this.jsonToJava(value, MultiMediaReceive.class);
                		break;
                }
            }else{
            	result = new MultiMediaReceive();
            	result.setContentType(ContentType.create(contenType));
            	String disposition = response1.getFirstHeader("Content-disposition").getValue();
            	LOG.debug(disposition);
            	Pattern p = Pattern.compile("filename=\"((\\w|-)+\\.(\\w|-)+)\"");
            	Matcher m = p.matcher(disposition);
            	if(m.find()){
            		String fileName = m.group(1);
            		result.setFileName(fileName);
            	}
            	result.setMedia(IOUtils.toByteArray(entity1.getContent()));
            }
		} catch (IOException e) {
			LOG.error(e.getMessage());
		} finally {
            try {
				response1.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
        }
		return result;
	}
	
	/**
	 * 以post方式执行url
	 * @param url url地址
	 * @param param 参数对象
	 * @param cls java对的class
	 * @return
	 */
	protected <T> T doPost(String url, Object param, Class<?> cls){
		return this.doPost(url,
				param,
				cls,
				EnumContentType.json,
				EnumContentType.json);
	}
	
	/**
	 * 以post方式执行url
	 * @param url url地址
	 * @param param 参数对象
	 * @param cls 响应结果java对的class
	 * @param paramType post参数的java对象转换为成对应类型的字符串表示
	 * @param resultType 响应字符串表示的类型
	 * @return
	 */
	protected <T> T doPost(String url,
			Object param, Class<?> cls,
			EnumContentType paramType,
			EnumContentType resultType){
		HttpPost httpPost = new HttpPost(url);
		String paramData = null;
		switch(paramType){
		case xml:
			httpPost.addHeader(CONTENTTYPE_HEAD, XML_CONTENTTYPE);
			paramData = this.javaToXml(param);
			break;
			default:
				httpPost.addHeader(CONTENTTYPE_HEAD, JSON_CONTENTTYPE);
				paramData = this.javaToJson(param);
				break;
		}
		LOG.debug(paramData);
		HttpEntity entity = new StringEntity(paramData, DEFAULT_CHARSET);
		httpPost.setEntity(entity);
		
		return this.execute(httpPost, cls, resultType);
	}
	
	/**
	 * 以post方式执行url
	 * @param url url地址
	 * @param param 参数对象
	 * @param mediaParam 多媒体参数对象
	 * @param cls 响应结果java对的class
	 * @return
	 */
	protected <T> T doPost(String url, 
			Map<String,Object> param, 
			MultiMediaParam mediaParam,
			Class<?> cls){
		return this.doPost(url,
				param,
				mediaParam,
				cls,
				EnumContentType.json,
				EnumContentType.json);
	}
	
	/**
	 * 以post方式执行url
	 * @param url url地址
	 * @param param 参数对象
	 * @param mediaParam 多媒体参数对象
	 * @param cls 响应结果java对的class
	 * @param paramType post参数的java对象转换为成对应类型的字符串表示
	 * @param resultType 响应字符串表示的类型
	 * @return
	 */
	protected <T> T doPost(String url,
			Map<String,Object> param,
			MultiMediaParam mediaParam,
			Class<?> cls,
			EnumContentType paramType,
			EnumContentType resultType){
		HttpPost httpPost = new HttpPost(url);
		MultipartEntityBuilder httpBuilder = MultipartEntityBuilder.create();
		httpBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		if(param != null){
			for(Entry<String,Object> entry : param.entrySet()){
				switch(paramType){
				case xml:
					httpBuilder.addTextBody(entry.getKey(), this.javaToXml(entry.getKey()));
					break;
					default:
						httpBuilder.addTextBody(entry.getKey(), this.javaToJson(entry.getKey()));
						break;
				}
			}
		}
		if(mediaParam != null){
			byte[] bytes = null;
			try {
				bytes = IOUtils.toByteArray(mediaParam.getMultiMedia().getInputStream());
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
			httpBuilder.addBinaryBody(mediaParam.getParamName(),
					bytes,
					WeixinUtil.createContentType(mediaParam.getMultiMedia().getType()),
					mediaParam.getMultiMedia().getFileName());
		}
		HttpEntity entity = httpBuilder.build();
		httpPost.setEntity(entity);
		return this.execute(httpPost, cls, resultType);
	}
	
	/**
	 * 通用的简单对象结果返回
	 * @param request 请求对象
	 * @param cls 响应结果的java对象的class
	 * @param resultType 结果返回字符串对象类型
	 * @return
	 */
	private <T> T execute(HttpUriRequest request, Class<?> cls, EnumContentType resultType){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		T result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(request);
            HttpEntity entity1 = response1.getEntity();
            String value = EntityUtils.toString(entity1, Charset.forName(DEFAULT_CHARSET));
            LOG.debug(value);
            LOG.debug(response1.getFirstHeader(CONTENTTYPE_HEAD).getValue());
            switch(resultType){
            case xml:
            	result = this.xmlToJava(value, cls);
            	break;
            	default:
            		result = this.jsonToJava(value, cls);
            		break;
            }
		} catch (IOException e) {
			LOG.error(e.getMessage());
		} finally {
            try {
				response1.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
        }
		return result;
	}
	
	/**
	 * 将xml字符串转换为java对象
	 * @param xml xml字符串
	 * @param cls java对象class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T xmlToJava(String xml, Class<?> cls){
		XmlMapper mapper = new XmlMapper();
		T value = null;
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			value = (T) mapper.readValue(xml, cls);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return value;
	}
	
	/**
	 * 将java对象转换为xml字符串
	 * @param obj java对象
 	 * @return xml字符串
	 */
	protected String javaToXml(Object obj) {
		XmlMapper xmlMapper = new XmlMapper();
		String xml = null;
		try {
			xml = xmlMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
		}
		return xml;
	}
	
	/**
	 * 将java对象转换为json字符串表示
	 * @param obj 待转换为json字符串的java对象
	 * @return json字符串
	 */
	protected String javaToJson(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 将json字符串表示成java对象
	 * @param json java对象的json字符串表示
	 * @param cls 转换为对应java对象的class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T jsonToJava(String json, Class<?> cls){
		ObjectMapper mapper = new ObjectMapper();
		T value = null;
		try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			value = (T) mapper.readValue(json, cls);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return value;
	}
}
