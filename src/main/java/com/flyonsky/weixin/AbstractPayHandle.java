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
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.weixin.data.pay.AbstractPayData;

/**
 * 与微信后台交互的支付相关http基础类
 * @author Administrator
 *
 */
public abstract class AbstractPayHandle extends AbstractHandle{

	// 微信支付提供给商家的证书文件名称
	@Value("${weixin.coco.service.mch.cert.filename}")
	protected String certFileName;
	
	// 微信支付提供给商家的证书访问密码
	@Value("${weixin.coco.service.mch.cert.pwd}")
	protected String mchCertPwd;

	/**
	 * 以post和https双向验证的方式执行url
	 * @param url URL请求地址
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
	protected <T> T doHttpsPost(String url, Object param, Class<?> cls) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException{
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
		httpPost.addHeader(CONTENTTYPE_HEAD, XML_CONTENTTYPE);
		String xml = this.javaToXml(param);
		LOG.debug(xml);
		HttpEntity entity = new StringEntity(xml, DEFAULT_CHARSET);
		httpPost.setEntity(entity);
		T result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpPost);
            HttpEntity entity1 = response1.getEntity();
            String value = EntityUtils.toString(entity1, Charset.forName(DEFAULT_CHARSET));
            LOG.debug(value);
			result = this.xmlToJava(value, cls);
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
	 * 签名请求参数
	 * @param data 支付请求参数
	 * @param key API密钥
	 */
	protected void sign(AbstractPayData data, String key){
		data.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		String sign = WeixinUtil.sign(data, key);
		data.setSign(sign);
	}
	
	/**
	 * 验证对象的签名是否正确
	 * @param data 待验证的对象
	 * @param key API密钥
	 * @return
	 */
	protected boolean verify(AbstractPayData data, String key){
		boolean flag = false;
		String sign = WeixinUtil.sign(data, key);
		if(sign.equals(data.getSign())){
			flag = true;
		}
		return flag;
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
	};
}
