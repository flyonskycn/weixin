package com.flyonsky.weixin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.CloseOrderParam;
import com.flyonsky.weixin.data.EnumCurrencyType;
import com.flyonsky.weixin.data.EnumTradeState;
import com.flyonsky.weixin.data.EnumTradeType;
import com.flyonsky.weixin.data.JSPayData;
import com.flyonsky.weixin.data.OrderQueryParam;
import com.flyonsky.weixin.data.OrderQueryReceive;
import com.flyonsky.weixin.data.PayReceiveBase;
import com.flyonsky.weixin.data.UnifiedOrderData;
import com.flyonsky.weixin.data.UnifiedOrderReceive;

public class PayHandleTest extends BaseSpringJUnit{
	
	private static final Logger LOG = LoggerFactory.getLogger(PayHandleTest.class);

	@Autowired
	private PayHandle payHandle;
	
	// 微信公众号appId
	@Value("${weixin.coco.service.appid}")
	private String appId;
	
	// 微信支付商户号
	@Value("${weixin.coco.service.mchid}")
	private String mchId;
	
	// 支付商户配置的Api安全key
	@Value("${weixin.coco.service.pay.key}")
	private String key;
	
	// 微信用户在公从号下对应的openid
	@Value("${weixin.coco.service.openid}")
	private String openId;
	
	/**
	 * 微信支付统一下单支付
	 * 公众号支付
	 */
	@Test
	public void testUnifiedOrderByJsapi(){
		UnifiedOrderData data = this.createOrderData(EnumTradeType.JSAPI, openId);
		
		UnifiedOrderReceive receive = this.getPayHandle().unifiedOrder(data, key);
		Assert.assertNotNull(receive);
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getReturnCode());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getResultCode());
	}
	
	/**
	 * 微信支付统一下单支付
	 * 原生扫码支付
	 */
	@Test
	public void testUnifiedOrderByNative(){
		UnifiedOrderData data = this.createOrderData(EnumTradeType.NATIVE, null);
		
		UnifiedOrderReceive receive = this.getPayHandle().unifiedOrder(data, key);
		Assert.assertNotNull(receive);
		Assert.assertNotNull(receive.getCodeUrl());
		LOG.debug(receive.getCodeUrl());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getReturnCode());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getResultCode());
	}
	
	/**
	 * 测试公众号内支付JS需要的数据
	 */
	@Test
	public void testJsPayOrder(){
		UnifiedOrderData data = this.createOrderData(EnumTradeType.JSAPI, openId);
		
		UnifiedOrderReceive receive = this.getPayHandle().unifiedOrder(data, key);
		Assert.assertNotNull(receive);
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getReturnCode());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getResultCode());
		
		JSPayData jsData = this.getPayHandle().jsPayOrder(appId, receive.getPrepayId(), key);
		
		Assert.assertNotNull(jsData);
		Assert.assertNotNull(jsData.getPaySign());
	}
	
	/**
	 * 测试支付订单查询
	 */
	@Test
	public void testQueryOrder(){
		UnifiedOrderData data = this.createOrderData(EnumTradeType.NATIVE, null);
		UnifiedOrderReceive receive = this.getPayHandle().unifiedOrder(data, key);
		
		Assert.assertNotNull(receive);
		Assert.assertNotNull(receive.getCodeUrl());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getReturnCode());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getResultCode());
		
		OrderQueryParam param = new OrderQueryParam();
		param.setAppId(appId);
		param.setMchId(mchId);
		param.setOutTradeNo(data.getOutTradeNo());
		OrderQueryReceive queryData = this.getPayHandle().queryOrder(param, key);
		
		Assert.assertNotNull(queryData);
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, queryData.getReturnCode());
		Assert.assertEquals(EnumTradeState.NOTPAY.toString(), queryData.getTradeState());
	}
	
	/**
	 * 关闭支付订单
	 */
	@Test
	public void testCloseOrder(){
		UnifiedOrderData data = this.createOrderData(EnumTradeType.NATIVE, null);
		UnifiedOrderReceive receive = this.getPayHandle().unifiedOrder(data, key);
		
		Assert.assertNotNull(receive);
		Assert.assertNotNull(receive.getCodeUrl());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getReturnCode());
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receive.getResultCode());
		
		CloseOrderParam param = new CloseOrderParam();
		param.setAppId(appId);
		param.setMchId(mchId);
		param.setOutTradeNo(data.getOutTradeNo());
		
		PayReceiveBase receiveData = this.getPayHandle().closeOrder(param, key);
		
		Assert.assertNotNull(receiveData);
		Assert.assertEquals(WeixinConst.CODE_SUCCESS, receiveData.getReturnCode());
	}
	
	/**
	 * 新建统一支付订单数据
	 * @param type 支付类型
	 * @param openid 公众号下的openid
	 * @return
	 */
	private UnifiedOrderData createOrderData(EnumTradeType type,String openid){
		UnifiedOrderData data = new UnifiedOrderData();
		data.setAppId(appId);
		data.setMchId(mchId);
		data.setBody("good");
		data.setDetail("goods detail");
		data.setNonceStr(WeixinUtil.randomString(WeixinConst.RANDOM_STRING_LENGTH));
		Random random = new Random();
		long orderId = random.nextLong();
		
		data.setOutTradeNo(String.valueOf(orderId));
		data.setFeeType(EnumCurrencyType.CNY.toString());
		data.setTotalFee(1);
		data.setSpbillCreateIp("127.0.0.1");
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		Date time = Calendar.getInstance().getTime();
		data.setTimeStart(f.format(time));
		time.setTime(time.getTime() + 100*60*1000);
		data.setTimeExpire(f.format(time));
		data.setNotifyUrl("http://www.cocopico.com/pubv2/pubPay.co");
		data.setTradeType(type.toString());
		data.setOpenid(openid);
		return data;
	}

	public PayHandle getPayHandle() {
		return payHandle;
	}

	public void setPayHandle(PayHandle payHandle) {
		this.payHandle = payHandle;
	}
}
