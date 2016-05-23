package com.flyonsky.weixin;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyonsky.weixin.data.UnifiedOrderData;
import com.flyonsky.weixin.data.UnifiedOrderReceive;

@Service
public class PayHandleImp extends AbstractHandle implements PayHandle{
	
	private static final Logger LOG = LoggerFactory.getLogger(PayHandleImp.class);
	
	@Value("${weixin.pay.base.url}")
	private String baseUrl;
	
	@Value("${weixin.pay.unifiedorder.url}")
	private String unifiedOrderUrl;
	
	@Value("${weixin.pay.orderquery.url}")
	private String orderQueryUrl;
	
	@Value("${weixin.pay.closeorder.url}")
	private String closeOrderUrl;
	
	@Value("${weixin.pay.refund.url}")
	private String refundUrl;
	
	@Value("${weixin.pay.refundquery.url}")
	private String refundQueryUrl;
	
	@Value("${weixin.pay.downloadbill.url}")
	private String downloadBillUrl;
	
	@Value("${weixin.pay.report.url}")
	private String reportUrl;
	
	/**
	 * 以post方式执行url
	 * @param url 
	 * @param param 参数对象
	 * @param cls java对的class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T doPost(String url, Object param, Class<?> cls){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		HttpEntity entity = new StringEntity(this.javaToXml(param), "UTF-8");
		httpPost.setEntity(entity);
		T result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpPost);
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

	@Override
	public UnifiedOrderReceive unifiedOrder(UnifiedOrderData orderData, String key) {
		String url = this.getBaseUrl() + this.getUnifiedOrderUrl();
		WeixinUtil.sign(orderData, key);
		UnifiedOrderReceive receive = this.doPost(url, orderData, UnifiedOrderReceive.class);
		return receive;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getUnifiedOrderUrl() {
		return unifiedOrderUrl;
	}

	public void setUnifiedOrderUrl(String unifiedOrderUrl) {
		this.unifiedOrderUrl = unifiedOrderUrl;
	}

	public String getOrderQueryUrl() {
		return orderQueryUrl;
	}

	public void setOrderQueryUrl(String orderQueryUrl) {
		this.orderQueryUrl = orderQueryUrl;
	}

	public String getCloseOrderUrl() {
		return closeOrderUrl;
	}

	public void setCloseOrderUrl(String closeOrderUrl) {
		this.closeOrderUrl = closeOrderUrl;
	}

	public String getRefundUrl() {
		return refundUrl;
	}

	public void setRefundUrl(String refundUrl) {
		this.refundUrl = refundUrl;
	}

	public String getRefundQueryUrl() {
		return refundQueryUrl;
	}

	public void setRefundQueryUrl(String refundQueryUrl) {
		this.refundQueryUrl = refundQueryUrl;
	}

	public String getDownloadBillUrl() {
		return downloadBillUrl;
	}

	public void setDownloadBillUrl(String downloadBillUrl) {
		this.downloadBillUrl = downloadBillUrl;
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

}
