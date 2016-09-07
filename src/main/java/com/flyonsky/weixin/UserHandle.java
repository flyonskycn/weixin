package com.flyonsky.weixin;

import java.util.List;

import com.flyonsky.weixin.data.EnumAuthorizeSource;
import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.user.BatchFetchReceive;
import com.flyonsky.weixin.data.user.CreateGroupReceive;
import com.flyonsky.weixin.data.user.FetchListReceive;
import com.flyonsky.weixin.data.user.GroupListReceive;
import com.flyonsky.weixin.data.user.UserInfo;
import com.flyonsky.weixin.data.user.UserMatchGroupReceive;

/**
 * 微信用户接口
 * @author Administrator
 *
 */
public interface UserHandle {

	/**
	 * 获取用户信息
	 * @param accessToken 应用的accessToken,根据source不同,accessToken代表的意义不相同，具体情况看各种应用的接入说明
	 * @param openid 用户openid
	 * @param source accessToken的来源
	 * @return 用户信息
	 */
	UserInfo info(String accessToken, String openid, EnumAuthorizeSource source);
	
	/**
	 * 批量获取用户信息
	 * @param accessToken 应用的accessToken
	 * @param openList 用户列表
	 * @return
	 */
	BatchFetchReceive batchFetch(String accessToken, List<String> openList);
	
	/**
	 * 批量获取关注者列表
	 * @param accessToken 应用的accessToken
	 * @param nextOpenid 起始的openid
	 * @return
	 */
	FetchListReceive batchFetchOpen(String accessToken,String nextOpenid);
	
	/**
	 * 新建用户分组
	 * @param accessToken 应用的accessToken
	 * @param groupName 分组名称
	 * @return
	 */
	CreateGroupReceive createGroup(String accessToken,String groupName);
	
	/**
	 * 获取所有用户分组
	 * @param accessToken 应用的accessToken
	 * @return
	 */
	GroupListReceive fetchAllGroup(String accessToken);
	
	/**
	 * 查询用户所在分组
	 * @param accessToken 应用的accessToken
	 * @param openid 用户的OpenID
	 * @return
	 */
	UserMatchGroupReceive matchUserGroup(String accessToken, String openid);
	
	/**
	 * 修改用户分组
	 * @param accessToken 应用的accessToken
	 * @param groupId 分组id
	 * @param groupName 分组名称
	 * @return
	 */
	ServiceReceive modifyGroup(String accessToken, int groupId,String groupName);
	
	/**
	 * 移动用户分组
	 * @param accessToken 应用的accessToken
	 * @param openid 用户的OpenID
	 * @param groupId 分组ID
	 * @return
	 */
	ServiceReceive moveUserGroup(String accessToken, String openid,int groupId);
	
	/**
	 * 批量移动用户分组
	 * @param accessToken 应用的accessToken
	 * @param openList 用户的OpenID列表
	 * @param groupId 分组ID
	 * @return
	 */
	ServiceReceive batchMoveUserGroup(String accessToken, List<String> openList, int groupId);
	
	/**
	 * 删除分组
	 * @param accessToken 应用的accessToken
	 * @param groupId 分组ID
	 * @return
	 */
	ServiceReceive removeGroup(String accessToken, int groupId);
	
	/**
	 * 设置备注名
	 * @param accessToken 应用的accessToken
	 * @param openid 用户的OpenID
	 * @param remark 备注
	 * @return
	 */
	ServiceReceive modifyUserRemark(String accessToken, String openid, String remark);
}
