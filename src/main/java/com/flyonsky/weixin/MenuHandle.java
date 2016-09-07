package com.flyonsky.weixin;

import com.flyonsky.weixin.data.menu.DefaultMenu;
import com.flyonsky.weixin.data.menu.MatchReceive;
import com.flyonsky.weixin.data.menu.PersonalityMenu;
import com.flyonsky.weixin.data.menu.PersonalityReceive;

/**
 * 微信自定义菜单
 * @author Administrator
 *
 */
public interface MenuHandle {
	
	/**
	 * 为指定服务号创建自定义菜单
	 * @param accessToken 对应公从号的 accessToken
	 * @param menu 自定义菜单数据
	 * @return
	 */
	boolean createMenu(String accessToken, DefaultMenu menu);
	
	/**
	 * 创建个性化菜单
	 * @param accessToken accessToken 对应公从号的 accessToken
	 * @param menu 个性化菜单数据
	 * @return
	 */
	PersonalityReceive createPersonalityMenu(String accessToken, PersonalityMenu menu);
	
	/**
	 * 删除自定义菜单
	 * @param accessToken 对应公从号的 accessToken
	 * @return
	 */
	boolean deleteMenu(String accessToken);
	
	/**
	 * 删除个性化菜单
	 * @param accessToken 对应公从号的 accessToken
	 * @param menuid 菜单id
	 * @return
	 */
	boolean deleteMenu(String accessToken, String menuid);
	
	/**
	 * 测试个性化菜单匹配结果
	 * @param accessToken 对应公从号的 accessToken
	 * @param userId 可以是粉丝的OpenID，也可以是粉丝的微信号。
	 * @return 匹配的菜单信息
	 */
	MatchReceive matchMenu(String accessToken, String userId);
}
