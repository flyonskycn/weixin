package com.flyonsky.weixin;

import java.io.InputStream;

import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.message.AbstractCustomReply;
import com.flyonsky.weixin.data.message.ClientSessionReceive;
import com.flyonsky.weixin.data.message.CustomClientListReceive;
import com.flyonsky.weixin.data.message.CustomClientWaitListReceive;
import com.flyonsky.weixin.data.message.CustomListReceive;
import com.flyonsky.weixin.data.message.CustomOnlineReceive;
import com.flyonsky.weixin.data.message.CustomParam;
import com.flyonsky.weixin.data.message.CustomRecordParam;
import com.flyonsky.weixin.data.message.CustomRecordReceive;
import com.flyonsky.weixin.data.message.CustomSessionParam;
import com.flyonsky.weixin.data.message.TemplateParam;
import com.flyonsky.weixin.data.message.TemplateReceive;

/**
 * 服务号消息管理
 * @author Administrator
 *
 */
public interface MessageHandle {

	/**
	 * 发送模板消息 
	 * @param accessToken 对应公从号的 accessToken
	 * @param param 模板消息参数
	 * @return
	 */
	TemplateReceive sendTemplateMsg(String accessToken, TemplateParam param);
	
	/**
	 * 添加客户帐号
	 * @param accessToken 对应公众号的 accessToken
	 * @param param 请求参数
	 * @return
	 */
	ServiceReceive kfAdd(String accessToken,CustomParam param);
	
	/**
	 * 修改客户帐号
	 * @param accessToken 对应公众号的 accessToken
	 * @param param 请求参数
	 * @return
	 */
	ServiceReceive kfModify(String accessToken,CustomParam param);
	
	/**
	 * 删除客户帐号
	 * @param accessToken 对应公众号的 accessToken
	 * @param account 完整客服账号，格式为：账号前缀@公众号微信号
	 * @return
	 */
	ServiceReceive kfDelete(String accessToken,String account);
	
	/**
	 * 获取客户帐号列表
	 * @param accessToken 对应公众号的 accessToken
	 * @return
	 */
	CustomListReceive kfList(String accessToken);
	
	/**
	 * 发送客户消息
	 * @param accessToken 对应公众号的 accessToken
	 * @param reply 请求参数
	 * @return
	 */
	ServiceReceive sendKfMsg(String accessToken, AbstractCustomReply reply);
	
	/**
	 * 客服的在线信息
	 * @param accessToken 对应公众号的 accessToken
	 * @return
	 */
	CustomOnlineReceive kfOnline(String accessToken);
	
	/**
	 * 修改客户头象
	 * @param accessToken 对应公众号的 accessToken
	 * @param account 完整客服账号，格式为：账号前缀@公众号微信号
	 * @param image 头象图片输入流,头像图片文件必须是jpg格式，推荐使用640*640大小
	 * @return
	 */
	ServiceReceive kfModifyHead(String accessToken,String account, InputStream image);
	
	/**
	 * 创建客服会话
	 * @param accessToken 对应公众号的 accessToken
	 * @param param 创建客服会话的参数
	 * @return
	 */
	ServiceReceive createKfSession(String accessToken,CustomSessionParam param);
	
	/**
	 * 创建客服会话
	 * @param accessToken 对应公众号的 accessToken
	 * @param param 关闭客服会话的参数
	 * @return
	 */
	ServiceReceive closeKfSession(String accessToken,CustomSessionParam param);
	
	/**
	 * 获取客户的会话状态
	 * @param accessToken 对应公众号的 accessToken
	 * @param openid 客户在微信公众号下openid
	 * @return
	 */
	ClientSessionReceive clientSession(String accessToken,String openid);
	
	/**
	 * 获取客服的会话列表
	 * @param accessToken 对应公众号的 accessToken
	 * @param kfAccount 客服帐号
	 * @return
	 */
	CustomClientListReceive kfSessionList(String accessToken,String kfAccount);
	
	/**
	 * 获取未接入会话列表 
	 * @param accessToken 对应公众号的 accessToken
	 * @return
	 */
	CustomClientWaitListReceive clientWaitSessionList(String accessToken);
	
	/**
	 * 获取客服聊天记录接口
	 * @param accessToken 对应公众号的 accessToken
	 * @param param 获取客服聊天记录接的参数
	 * @return
	 */
	CustomRecordReceive kfRecordList(String accessToken,CustomRecordParam param);
}
