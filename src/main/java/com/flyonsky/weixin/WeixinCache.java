package com.flyonsky.weixin;

/**
 * 微信模块缓存扩展接口
 * @author Administrator
 *
 */
public interface WeixinCache {
	
	/**
	 * 将数据保存到缓存中
	 * @param key 缓存键值 
	 * @param value 值
	 * @param expires 有效时间，以秒为单位
	 * @return
	 */
	boolean put(String key, Object value, long expires);
	
	/**
	 * 是否包含对应键值 
	 * @param key 缓存键值 
	 * @return
	 */
	boolean contains(String key);
	
	/**
	 * 移除缓存
	 * @param key 缓存键值 
	 * @return
	 */
	boolean remove(String key);
	
	/**
	 * 获取缓存中的值
	 * @param key 缓存键值 
	 * @return
	 */
	Object get(String key);
}
