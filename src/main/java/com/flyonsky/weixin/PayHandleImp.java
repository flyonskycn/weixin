package com.flyonsky.weixin;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.MessageFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.flyonsky.weixin.data.EnumContentType;
import com.flyonsky.weixin.data.pay.CloseOrderParam;
import com.flyonsky.weixin.data.pay.JSPayData;
import com.flyonsky.weixin.data.pay.MicroPayParam;
import com.flyonsky.weixin.data.pay.MicroPayReceive;
import com.flyonsky.weixin.data.pay.OrderQueryParam;
import com.flyonsky.weixin.data.pay.OrderQueryReceive;
import com.flyonsky.weixin.data.pay.PayReceive;
import com.flyonsky.weixin.data.pay.RefundParam;
import com.flyonsky.weixin.data.pay.RefundQueryParam;
import com.flyonsky.weixin.data.pay.RefundQueryReceive;
import com.flyonsky.weixin.data.pay.RefundReceive;
import com.flyonsky.weixin.data.pay.ReverseParam;
import com.flyonsky.weixin.data.pay.ReverseReceive;
import com.flyonsky.weixin.data.pay.ScanCallBackReceive;
import com.flyonsky.weixin.data.pay.ScanPayParam;
import com.flyonsky.weixin.data.pay.UnifiedOrderParam;
import com.flyonsky.weixin.data.pay.UnifiedOrderReceive;

@Service
public class PayHandleImp extends AbstractPayHandle implements PayHandle{
	
	// 微信url
	@Autowired
	private WeixinURLConfig config;

	@Override
	public UnifiedOrderReceive unifiedOrder(UnifiedOrderParam orderData, String key) {
		Assert.notNull(orderData);
		Assert.notNull(key);
		
		String url = this.getConfig().getUnifiedOrderUrl();

		this.sign(orderData, key);
		
		UnifiedOrderReceive receive = this.doPost(url,
				orderData,
				UnifiedOrderReceive.class,
				EnumContentType.xml,
				EnumContentType.xml);
		
		if(!this.verify(receive, key)){
			LOG.error("unifiedOrder method sign signature failed");
			receive = null;
		}
		return receive;
	}

	@Override
	public JSPayData jsPayOrder(String appId, String prepayId, String key) {
		Assert.notNull(appId);
		Assert.notNull(prepayId);
		Assert.notNull(key);
		
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
		Assert.notNull(param);
		Assert.notNull(key);
		
		String url = this.getConfig().getOrderQueryUrl();

		this.sign(param, key);
		
		OrderQueryReceive receive = this.doPost(url,
				param,
				OrderQueryReceive.class,
				EnumContentType.xml,
				EnumContentType.xml);
		
		if(!this.verify(receive, key)){
			LOG.error("queryOrder method sign signature failed");
			receive = null;
		}
		
		return receive;
	}

	@Override
	public PayReceive closeOrder(CloseOrderParam param, String key) {
		Assert.notNull(param);
		Assert.notNull(key);
		
		String url = this.getConfig().getCloseOrderUrl();

		this.sign(param, key);
		
		PayReceive receive = this.doPost(url,
					param, 
					PayReceive.class,
					EnumContentType.xml,
					EnumContentType.xml);
		
		if(!this.verify(receive, key)){
			LOG.error("closeOrder method sign signature failed");
			receive = null;
		}
		
		return receive;
	}

	@Override
	public RefundReceive refund(RefundParam param, String key) {
		Assert.notNull(param);
		Assert.notNull(key);
		
		String url = this.getConfig().getRefundUrl();
		
		this.sign(param, key);
		
		RefundReceive receive = null;
		try{
			receive = this.doHttpsPost(url, param, RefundReceive.class);
		}catch(Exception e){
			LOG.error(e.getMessage());
		}
		
		if(!this.verify(receive, key)){
			LOG.error("refund method sign signature failed");
			receive = null;
		}
		
		return receive;
	}

	@Override
	public RefundQueryReceive queryRefund(RefundQueryParam param, String key) {
		Assert.notNull(param);
		Assert.notNull(key);
		
		String url = this.getConfig().getRefundQueryUrl();
		
		this.sign(param, key);
		
		RefundQueryReceive receive = this.doPost(url,
					param,
					RefundQueryReceive.class,
					EnumContentType.xml,
					EnumContentType.xml);
		
		if(!this.verify(receive, key)){
			LOG.error("queryRefund method sign signature failed");
			receive = null;
		}
		
		return receive;
	}

	@Override
	public MicroPayReceive microPay(MicroPayParam param, String key) {
		Assert.notNull(param);
		Assert.notNull(key);
		
		String url = this.getConfig().getPayMicropayUrl();
		
		this.sign(param, key);
		
		MicroPayReceive receive = this.doPost(url,
						param,
						MicroPayReceive.class,
						EnumContentType.xml,
						EnumContentType.xml);
		
		if(!this.verify(receive, key)){
			LOG.error("microPay method sign signature failed");
			receive = null;
		}
		
		return receive;
	}

	@Override
	public ReverseReceive reverse(ReverseParam param, String key) {
		Assert.notNull(param);
		Assert.notNull(key);
		
		String url = this.getConfig().getPayReverseUrl();
		
		this.sign(param, key);
		
		ReverseReceive receive = null;
		try {
			receive = this.doHttpsPost(url,
							param,
							ReverseReceive.class);
		} catch (KeyManagementException | UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException
				| CertificateException | IOException e) {
			LOG.error(e.getMessage());
		}
		
		if(!this.verify(receive, key)){
			LOG.error("reverse method sign signature failed");
			receive = null;
		}
		
		return receive;
	}

	@Override
	public String scanPay(ScanPayParam param, String key) {
		Assert.notNull(param);
		Assert.notNull(key);
		
		// 系统当前时间(秒)
		long mis = Calendar.getInstance().getTimeInMillis()/1000;
		param.setTimeStamp(String.valueOf(mis));
		
		this.sign(param, key);
		String codeStr = MessageFormat.format(this.getConfig().getScanPayTemplate(),
				param.getSign(),
				param.getAppId(),
				param.getMchId(),
				param.getProductId(),
				param.getTimeStamp(),
				param.getNonceStr());
		return codeStr;
	}

	@Override
	public ScanCallBackReceive scanCallBack(UnifiedOrderReceive param, String key) {
		Assert.notNull(param);
		Assert.notNull(key);
		
		ScanCallBackReceive data = new ScanCallBackReceive();
		data.setAppId(param.getAppId());
		data.setMchId(param.getMchId());
		data.setNonceStr(param.getNonceStr());
		data.setReturnCode(param.getReturnCode());
		data.setReturnMsg(param.getReturnMsg());
		data.setPrepayId(param.getPrepayId());
		data.setResultCode(param.getResultCode());
		data.setErrCodeDes(param.getErrCodeDes());
		
		this.sign(data, key);
		
		return data;
	}

	public WeixinURLConfig getConfig() {
		return config;
	}

	public void setConfig(WeixinURLConfig config) {
		this.config = config;
	}
}
