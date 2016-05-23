package com.flyonsky.weixin;

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
}
