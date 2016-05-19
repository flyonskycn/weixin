package com.flyonsky.weixin;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 与微信后台交互的http基础类
 * @author Administrator
 *
 */
abstract class AbstractHandle {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractHandle.class);

	@SuppressWarnings("unchecked")
	public <T> T doGet(String url, Class<?> cls){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		T result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpGet);
            HttpEntity entity1 = response1.getEntity();
            String value = EntityUtils.toString(entity1, Charset.forName("UTF-8"));
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    		try {
    			result = (T) mapper.readValue(value, cls);
    		} catch (IOException e) {
    			LOG.error(e.getMessage());
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
	
	@SuppressWarnings("unchecked")
	public <T> T xmlToJava(String xml, Class<?> cls){
		XmlMapper xmlMapper = new XmlMapper();
		T value = null;
		try {
			value = (T) xmlMapper.readValue(xml, cls);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return value;
	}
}
