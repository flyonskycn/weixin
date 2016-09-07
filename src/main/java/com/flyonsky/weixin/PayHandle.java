package com.flyonsky.weixin;

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

/**
 * 微信支付相关接口
 * @author Administrator
 *
 */
public interface PayHandle {
	
	/**
	 * 统一下单
	 * @param orderData 下单请求参数
	 * @param key API密钥
	 * @return 下单结果
	 */
	UnifiedOrderReceive unifiedOrder(UnifiedOrderParam orderData, String key);
	
	/**
	 * 网页端调起支付API时所用的数据
	 * @param appId 应用Appid
	 * @param prepayId 统一下单返回的prepay_id
	 * @param key API密钥
	 * @return 页端调起支付API时所用的数据
	 */
	JSPayData jsPayOrder(String appId, String prepayId, String key);
	
	/**
	 * 查询支付订单
	 * @param param 查询参数
	 * @param key API密钥
	 * @return
	 */
	OrderQueryReceive queryOrder(OrderQueryParam param, String key);
	
	/**
	 * 关闭订单
	 * @param param 关闭订单请求参数
	 * @param key API密钥
	 * @return
	 */
	PayReceive closeOrder(CloseOrderParam param, String key);
	
	/**
	 * 申请退款
	 * @param param 申请退款请求参数
	 * @param key API密钥
	 * @return
	 */
	RefundReceive refund(RefundParam param, String key);
	
	/**
	 * 退款单查询
	 * @param param 退款单查询参数
	 * @param key API密钥
	 * @return
	 */
	RefundQueryReceive queryRefund(RefundQueryParam param, String key);
	
	/**
	 * 提交刷卡支付API
	 * @param param 刷卡支付请求参数
	 * @param key API密钥
	 * @return
	 */
	MicroPayReceive microPay(MicroPayParam param, String key);
	
	/**
	 * 撤销订单API,请求需要双向证书
	 * @param param 撤销订单请求参数
	 * @param key API密钥
	 * @return
	 */
	ReverseReceive reverse(ReverseParam param, String key);
	
	/**
	 * 扫码支付模式一生成二维码字符串
	 * @param param 扫码支付模式一生成二维码的请求参数
	 * @param key API密钥
	 * @return
	 */
	String scanPay(ScanPayParam param, String key);
	
	/**
	 * 扫码支付模式一回调地址处理
	 * @param param 统一下单响应结果
	 * @param key API密钥
	 * @return
	 */
	ScanCallBackReceive scanCallBack(UnifiedOrderReceive param, String key);
}
