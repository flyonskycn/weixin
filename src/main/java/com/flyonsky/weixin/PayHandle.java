package com.flyonsky.weixin;

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
	UnifiedOrderReceive unifiedOrder(UnifiedOrderData orderData, String key);
	
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
	PayReceiveBase closeOrder(CloseOrderParam param, String key);
	
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
}
