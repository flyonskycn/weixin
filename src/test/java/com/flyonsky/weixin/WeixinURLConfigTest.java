package com.flyonsky.weixin;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyonsky.BaseSpringJUnit;

public class WeixinURLConfigTest extends BaseSpringJUnit{
	
	@Autowired
	private WeixinURLConfig config;
	
	/**
	 * 微信服务号token获取地址
	 */
	@Test
	public void testGetServiceTokenUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}", config.getServiceTokenUrl());
	}
	
	/**
	 * 微信服务号用户信息获取地址
	 */
	@Test
	public void testGetServiceUserInfoUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}&lang=zh_CN", config.getServiceUserInfoUrl());
	}
	
	/**
	 * 微信服务号自定义菜单添加地址
	 */
	@Test
	public void testGetServiceMenuCreateUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}", config.getServiceMenuCreateUrl());
	}
	
	/**
	 * 微信服务号js-sdk获取tocket的地址
	 */
	@Test
	public void testGetServiceJsTicketUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={0}&type=jsapi", config.getServiceJsTicketUrl());
	}
	
	/**
	 * 微信服务号创建二维码的地址
	 */
	@Test
	public void testGetServiceQrcodeUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token={0}", config.getServiceQrcodeUrl());
	}
	
	/**
	 * 获取微信显示二维码的URL地址
	 */
	@Test
	public void testGetQrcodeShowUrl(){
		Assert.assertEquals("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket={0}", config.getQrcodeShowUrl());
	}
	
	/**
	 * 微信网页token获取地址
	 */
	@Test
	public void testGetTokenUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code", config.getTokenUrl());
	}
	
	/**
	 * 微信网页token刷新地址
	 */
	@Test
	public void testGetRefreshTokenUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={0}&grant_type=refresh_token&refresh_token={1}", config.getRefreshTokenUrl());
	}
	
	/**
	 * 微信网页用户信息获取地址
	 */
	@Test
	public void testGetUserInfoUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN", config.getUserInfoUrl());
	}
	
	/**
	 * 微信网页token有效性验证地址
	 */
	@Test
	public void testGetTokenValidUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/sns/auth?access_token={0}&openid={1}", config.getTokenValidUrl());
	}
	
	/**
	 * 微信内访问网页登陆授权页
	 */
	@Test
	public void testGetAuthorizeUrl(){
		Assert.assertEquals("https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope={2}&state={3}#wechat_redirect", config.getAuthorizeUrl());
	}
	
	/**
	 * 网站的微信授权登陆地址
	 */
	@Test
	public void testGetWebAuthorizeUrl(){
		Assert.assertEquals("https://open.weixin.qq.com/connect/qrconnect?appid={0}&redirect_uri={1}&response_type=code&scope={2}&state={3}#wechat_redirect", config.getWebAuthorizeUrl());
	}
	
	/**
	 * 微信服务号获取素材信息
	 */
	@Test
	public void testGetMaterialGetUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token={0}", config.getMaterialGetUrl());
	}
	
	/**
	 * 微信服务号素材数量获取接口
	 */
	@Test
	public void testGetMaterialCountUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token={0}", config.getMaterialCountUrl());
	}
	
	/**
	 * 微信服务号素材批量获取接口
	 */
	@Test
	public void testGetMaterialBatchGetUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token={0}", config.getMaterialBatchGetUrl());
	}
	
	/**
	 * 统一下单
	 */
	@Test
	public void testGetUnifiedOrderUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/pay/unifiedorder", config.getUnifiedOrderUrl());
	}
	
	/**
	 * 查询订单
	 */
	@Test
	public void testGetOrderQueryUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/pay/orderquery", config.getOrderQueryUrl());
	}
	
	/**
	 * 关闭订单
	 */
	@Test
	public void testGetCloseOrderUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/pay/closeorder", config.getCloseOrderUrl());
	}
	
	/**
	 * 申请退款
	 */
	@Test
	public void testGetRefundUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/secapi/pay/refund", config.getRefundUrl());
	}
	
	/**
	 * 查询退款
	 */
	@Test
	public void testGetRefundQueryUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/pay/refundquery", config.getRefundQueryUrl());
	}
	
	/**
	 * 下载对账单
	 */
	@Test
	public void testGetDownloadBillUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/pay/downloadbill", config.getDownloadBillUrl());
	}
	
	/**
	 * 测速上报
	 */
	@Test
	public void testGetReportUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/payitil/report", config.getReportUrl());
	}
	
	/**
	 * 自定义菜单删除接口
	 */
	@Test
	public void testGetServiceMenuDeleteUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={0}", config.getServiceMenuDeleteUrl());
	}
	
	/**
	 * 新建个性化菜单
	 */
	@Test
	public void testGetServicePersonCreateUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token={0}", config.getServicePersonCreateUrl());
	}
	
	/**
	 * 删除个性化菜单
	 */
	@Test
	public void testGetServicePersonDeleteUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token={0}", config.getServicePersonDeleteUrl());
	}
	
	/**
	 * 测试个性化菜单匹配结果
	 */
	@Test
	public void testGetServicePersonMatchUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token={0}", config.getServicePersonMatchUrl());
	}
	
	/**
	 * 发送模板消息
	 */
	@Test
	public void testGetServiceMessageTempSendUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={0}", config.getServiceMessageTempSendUrl());
	}
	
	/**
	 * 微信服务号批量获取用户信息
	 */
	@Test
	public void testgetServiceUserBatchUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token={0}", config.getServiceUserBatchUrl());
	}
	
	/**
	 * 微信服务号第一次获取用户列表
	 */
	@Test
	public void testGetServiceUserListFirstUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/user/get?access_token={0}", config.getServiceUserListFirstUrl());
	}
	
	/**
	 * 微信服务号多次获取用户列表
	 */
	@Test
	public void testGetServiceUserListMultiUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/user/get?access_token={0}&next_openid={1}", config.getServiceUserListMultiUrl());
	}
	
	/**
	 * 添加客服帐号
	 */
	@Test
	public void testGetServiceCustomAddUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfaccount/add?access_token={0}", config.getServiceCustomAddUrl());
	}
	
	/**
	 * 修改客服帐号
	 */
	@Test
	public void testGetServiceCustomUpdateUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfaccount/update?access_token={0}", config.getServiceCustomUpdateUrl());
	}
	
	/**
	 * 删除客服帐号
	 */
	@Test
	public void testGetServiceCustomDeleteUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfaccount/del?access_token={0}&kf_account={1}", config.getServiceCustomDeleteUrl());
	}
	
	/**
	 * 设置客服帐号的头像
	 */
	@Test
	public void testGetServiceCustomHeadUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token={0}&kf_account={1}", config.getServiceCustomHeadUrl());
	}
	
	/**
	 * 获取所有客服账号
	 */
	@Test
	public void testGetServiceCustomListUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token={0}", config.getServiceCustomListUrl());
	}
	
	/**
	 * 客服接口-发消息
	 */
	@Test
	public void testGetServiceCustomSendUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token={0}", config.getServiceCustomSendUrl());
	}
	
	/**
	 * 客服在线信息统计
	 */
	@Test
	public void testGetServiceCustomOnlineUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token={0}", config.getServiceCustomOnlineUrl());
	}
	
	/**
	 * 创建会话
	 */
	@Test
	public void testGetServiceCreateSessionUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfsession/create?access_token={0}", config.getServiceCreateSessionUrl());
	}
	
	/**
	 * 关闭会话
	 */
	@Test
	public void testGetServiceCloseSessionUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfsession/close?access_token={0}", config.getServiceCloseSessionUrl());
	}
	
	/**
	 * 获取客户的会话状态
	 */
	@Test
	public void testGetServiceSessionStatusUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfsession/getsession?access_token={0}&openid={1}", config.getServiceSessionStatusUrl());
	}
	
	/**
	 * 获取客服的会话列表
	 */
	@Test
	public void testGetServiceSessionListUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token={0}&kf_account={1}", config.getServiceSessionListUrl());
	}
	
	/**
	 * 获取未接入会话列表
	 */
	@Test
	public void testGetServiceSessionWaitListUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token={0}", config.getServiceSessionWaitListUrl());
	}
	
	/**
	 * 获取客服聊天记录接口
	 */
	@Test
	public void testGetServiceCustomRecordUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/customservice/msgrecord/getrecord?access_token={0}", config.getServiceCustomRecordUrl());
	}
	
	/**
	 * 新增临时素材
	 */
	@Test
	public void testGetMaterialTempUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/media/upload?access_token={0}&type={1}", config.getMaterialTempUrl());
	}
	
	/**
	 * 获取临时素材，不包括视频临时素材
	 */
	@Test
	public void testGetMaterialTempFetchUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/media/get?access_token={0}&media_id={1}", config.getMaterialTempFetchUrl());
	}
	
	/**
	 * 获取临时素材，只有视频临时素材
	 */
	@Test
	public void testGetMaterialTempVideFetchUrl(){
		Assert.assertEquals("http://api.weixin.qq.com/cgi-bin/media/get?access_token={0}&media_id={1}", config.getMaterialTempVideFetchUrl());
	}
	
	/**
	 * 新增永久图文素材
	 */
	@Test
	public void testGetMaterialNewsCreateUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/material/add_news?access_token={0}", config.getMaterialNewsCreateUrl());
	}
	
	/**
	 * 在图文消息的具体内容中，将过滤外部的图片链接，开发者可以通过下述接口上传图片得到URL，放到图文内容中使用
	 */
	@Test
	public void testGetMaterialImageCreateUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token={0}", config.getMaterialImageCreateUrl());
	}
	
	/**
	 * 新增其他类型永久素材
	 */
	@Test
	public void testGetMaterialOtherCreateUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/material/add_material?access_token={0}", config.getMaterialOtherCreateUrl());
	}
	
	/**
	 * 删除永久素材
	 */
	@Test
	public void testGetMaterialDeleteUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/material/del_material?access_token={0}", config.getMaterialDeleteUrl());
	}
	
	/**
	 * 修改永久图文素材
	 */
	public void testGetMaterialNewsModifyUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/material/update_news?access_token={0}", config.getMaterialNewsModifyUrl());
	}
	
	/**
	 * 新建用户分组
	 */
	@Test
	public void testGetServiceGroupCreateUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/groups/create?access_token={0}", config.getServiceGroupCreateUrl());
	}
	
	/**
	 * 查询所有分组
	 */
	@Test
	public void testGetServiceGroupListUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/groups/get?access_token={0}", config.getServiceGroupListUrl());
	}
	
	/**
	 * 查询用户所在分组
	 */
	@Test
	public void testGetServiceUserGroupMatchUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/groups/getid?access_token={0}", config.getServiceUserGroupMatchUrl());
	}
	
	/**
	 * 修改分组名
	 */
	@Test
	public void testGetServiceGroupModifyUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/groups/update?access_token={0}", config.getServiceGroupModifyUrl());
	}
	
	/**
	 * 移动用户分组
	 */
	@Test
	public void testGetServiceUserGroupMoveUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token={0}", config.getServiceUserGroupMoveUrl());
	}
	
	/**
	 * 批量移动用户分组
	 */
	@Test
	public void testGetServiceUserGroupBatchMoveUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token={0}", config.getServiceUserGroupBatchMoveUrl());
	}
	
	/**
	 * 删除分组
	 */
	@Test
	public void testGetServiceGroupDeleteUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/groups/delete?access_token={0}", config.getServiceGroupDeleteUrl());
	}
	
	/**
	 * 设置备注名
	 */
	@Test
	public void testGetServiceUserModifyUrl(){
		Assert.assertEquals("https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token={0}", config.getServiceUserModifyUrl());
	}
	
	/**
	 * 提交刷卡支付API
	 */
	@Test
	public void testGetPayMicropayUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/pay/micropay", config.getPayMicropayUrl());
	}
	
	/**
	 * 撤销订单API
	 */
	@Test
	public void testgetPayReverseUrl(){
		Assert.assertEquals("https://api.mch.weixin.qq.com/secapi/pay/reverse", config.getPayReverseUrl());
	}
	
	/**
	 * 微信扫码支付模式一的二维码字符串模板
	 */
	@Test
	public void testGetScanPayTemplate(){
		Assert.assertEquals("weixin://wxpay/bizpayurl?sign={0}&appid={1}&mch_id={2}&product_id={3}&time_stamp={4}&nonce_str={5}", config.getScanPayTemplate());
	}
}
