package com.flyonsky.weixin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.flyonsky.weixin.data.CloseOrderParam;
import com.flyonsky.weixin.data.JSPayData;
import com.flyonsky.weixin.data.OrderQueryParam;
import com.flyonsky.weixin.data.OrderQueryReceive;
import com.flyonsky.weixin.data.PayReceiveBase;
import com.flyonsky.weixin.data.RefundParam;
import com.flyonsky.weixin.data.RefundQueryParam;
import com.flyonsky.weixin.data.RefundQueryReceive;
import com.flyonsky.weixin.data.RefundReceive;
import com.flyonsky.weixin.data.UnifiedOrderData;
import com.flyonsky.weixin.data.UnifiedOrderReceive;

@Service
public class PayHandleImp extends AbstractHandle implements PayHandle{
	
	private static final Logger LOG = LoggerFactory.getLogger(PayHandleImp.class);
	
	// 微信支付提供给商家的证书文件名称
	@Value("${weixin.coco.service.mch.cert.filename}")
	private String certFileName;
	
	// 微信支付提供给商家的证书访问密码
	@Value("${weixin.coco.service.mch.cert.pwd}")
	private String mchCertPwd;
	
	// 微信支付URL公共部分
	@Value("${weixin.pay.base.url}")
	private String baseUrl;
	
	// 统一下单相对URL
	@Value("${weixin.pay.unifiedorder.url}")
	private String unifiedOrderUrl;
	
	// 支付订单查询相对URL
	@Value("${weixin.pay.orderquery.url}")
	private String orderQueryUrl;
	
	// 关闭订单的相对URL
	@Value("${weixin.pay.closeorder.url}")
	private String closeOrderUrl;
	
	// 退款相对URL
	@Value("${weixin.pay.refund.url}")
	private String refundUrl;
	
	// 退款查询URL
	@Value("${weixin.pay.refundquery.url}")
	private String refundQueryUrl;
	
	// 帐单下载URL
	@Value("${weixin.pay.downloadbill.url}")
	private String downloadBillUrl;
	
	// 测试速上报URL
	@Value("${weixin.pay.report.url}")
	private String reportUrl;
	
	/**
	 * 以post方式执行url
	 * @param url 
	 * @param param 参数对象
	 * @param cls java对的class
	 * @return
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws CertificateException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnrecoverableKeyException 
	 * @throws KeyManagementException 
	 */
	@SuppressWarnings("unchecked")
	protected <T> T doPost(String url, Object param, Class<?> cls) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException{
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
        InputStream instream = this.getClass().getClassLoader().getResourceAsStream(this.getCertFileName());//加载本地的证书进行https加密传输
        keyStore.load(instream, this.getMchCertPwd().toCharArray());//设置证书密码

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, this.getMchCertPwd().toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		CloseableHttpClient httpclient = HttpClientBuilder.create().setSSLSocketFactory(sslsf).build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "text/xml");
		String xml = this.javaToXml(param);
		LOG.debug(xml);
		HttpEntity entity = new StringEntity(xml, "UTF-8");
		httpPost.setEntity(entity);
		T result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpPost);
            HttpEntity entity1 = response1.getEntity();
            String value = EntityUtils.toString(entity1, Charset.forName("UTF-8"));
            ObjectMapper mapper = new XmlMapper();
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
		orderData.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		String sign = WeixinUtil.sign(orderData, key);
		orderData.setSign(sign);
		UnifiedOrderReceive receive = null;
		try{
			receive = this.doPost(url, orderData, UnifiedOrderReceive.class);
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
		return receive;
	}

	@Override
	public JSPayData jsPayOrder(String appId, String prepayId, String key) {
		JSPayData payData = new JSPayData();
		payData.setAppId(appId);
		payData.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		payData.setPackageInfo("prepay_id=" + prepayId);
		long ms = System.currentTimeMillis()/1000;
		payData.setTimeStamp(String.valueOf(ms));
		payData.setSignType("MD5");
		
		String sign = WeixinUtil.sign(payData, key);
		payData.setPaySign(sign);
		
		return payData;
	}
	
	@Override
	public OrderQueryReceive queryOrder(OrderQueryParam param, String key) {
		String url = this.getBaseUrl() + this.getOrderQueryUrl();
		param.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		String sign = WeixinUtil.sign(param, key);
		param.setSign(sign);
		OrderQueryReceive receive = null;
		try{
			receive = this.doPost(url, param, OrderQueryReceive.class);
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
		return receive;
	}

	@Override
	public PayReceiveBase closeOrder(CloseOrderParam param, String key) {
		String url = this.getBaseUrl() + this.getCloseOrderUrl();
		param.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		String sign = WeixinUtil.sign(param, key);
		param.setSign(sign);
		PayReceiveBase receive = null;
		try{
			receive = this.doPost(url, param, PayReceiveBase.class);
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
		return receive;
	}

	@Override
	public RefundReceive refund(RefundParam param, String key) {
		String url = this.getBaseUrl() + this.getRefundUrl();
		param.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		String sign = WeixinUtil.sign(param, key);
		param.setSign(sign);
		RefundReceive receive = null;
		try{
			receive = this.doPost(url, param, RefundReceive.class);
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
		return receive;
	}

	@Override
	public RefundQueryReceive queryRefund(RefundQueryParam param, String key) {
		String url = this.getBaseUrl() + this.getRefundQueryUrl();
		param.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		String sign = WeixinUtil.sign(param, key);
		param.setSign(sign);
		RefundQueryReceive receive = null;
		try{
			receive = this.doPost(url, param, RefundQueryReceive.class);
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
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

	public String getCertFileName() {
		return certFileName;
	}

	public void setCertFileName(String certFileName) {
		this.certFileName = certFileName;
	}

	public String getMchCertPwd() {
		return mchCertPwd;
	}

	public void setMchCertPwd(String mchCertPwd) {
		this.mchCertPwd = mchCertPwd;
	}
}
