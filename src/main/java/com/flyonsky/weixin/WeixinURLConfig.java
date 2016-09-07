package com.flyonsky.weixin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeixinURLConfig {
	
	// 微信服务号token获取地址
	@Value("${weixin.service.token.url}")
	private String serviceTokenUrl;
	
	// 微信服务号用户信息获取地址
	@Value("${weixin.service.user.url}")
	private String serviceUserInfoUrl;
	
	// 微信服务号批量获取用户信息
	@Value("${weixin.service.user.info.batch.url}")
	private String serviceUserBatchUrl;
	
	// 微信服务号第一次获取用户列表
	@Value("${weixin.service.user.list.first.url}")
	private String serviceUserListFirstUrl;
	
	// 微信服务号多次获取用户列表
	@Value("${weixin.service.user.list.multi.url}")
	private String serviceUserListMultiUrl;
	
	// 创建分组
	@Value("${weixin.service.user.group.create.url}")
	private String serviceGroupCreateUrl;
	
	// 查询所有分组
	@Value("${weixin.service.user.group.list.url}")
	private String serviceGroupListUrl;
	
	// 查询用户所在分组
	@Value("${weixin.service.user.group.match.url}")
	private String serviceUserGroupMatchUrl;
	
	// 修改分组
	@Value("${weixin.service.user.group.update.url}")
	private String serviceGroupModifyUrl;
	
	// 移动用户分组
	@Value("${weixin.service.user.group.move.url}")
	private String serviceUserGroupMoveUrl;
	
	// 批量移动用户分组
	@Value("${weixin.service.user.group.batch.move.url}")
	private String serviceUserGroupBatchMoveUrl;
	
	// 删除分组
	@Value("${weixin.service.user.group.delete.url}")
	private String serviceGroupDeleteUrl;
	
	// 设置备注名
	@Value("${weixin.service.user.update.remark.url}")
	private String serviceUserModifyUrl;
	
	// 微信服务号自定义菜单添加地址
	@Value("${weixin.service.menu.create.url}")
	private String serviceMenuCreateUrl;
	
	// 新建个性化菜单
	@Value("${weixin.service.menu.personality.create.url}")
	private String servicePersonCreateUrl;
	
	// 自定义菜单删除接口
	@Value("${weixin.service.menu.delete.url}")
	private String serviceMenuDeleteUrl;
	
	// 删除个性化菜单
	@Value("${weixin.service.menu.personality.delete.url}")
	private String servicePersonDeleteUrl;
	
	// 测试个性化菜单匹配结果
	@Value("${weixin.service.menu.personality.match.url}")
	private String servicePersonMatchUrl;
	
	// 发送模板消息
	@Value("${weixin.service.message.template.send.url}")
	private String serviceMessageTempSendUrl;
	
	// 添加客服帐号
	@Value("${weixin.service.message.customservice.add.url}")
	private String serviceCustomAddUrl;
	
	// 修改客服帐号
	@Value("${weixin.service.message.customservice.update.url}")
	private String serviceCustomUpdateUrl;
	
	// 删除客服帐号
	@Value("${weixin.service.message.customservice.delete.url}")
	private String serviceCustomDeleteUrl;
	
	// 设置客服帐号的头像
	@Value("${weixin.service.message.customservice.head.url}")
	private String serviceCustomHeadUrl;
	
	// 获取所有客服账号
	@Value("${weixin.service.message.customservice.list.url}")
	private String serviceCustomListUrl;
	
	// 客服接口-发消息
	@Value("${weixin.service.message.customservice.send.url}")
	private String serviceCustomSendUrl;
	
	// 客服在线信息
	@Value("${weixin.service.message.customservice.online.url}")
	private String serviceCustomOnlineUrl;
	
	// 创建客服会话
	@Value("${weixin.service.message.customservice.create.session.url}")
	private String serviceCreateSessionUrl;
	
	// 关闭客服会话
	@Value("${weixin.service.message.customservice.close.session.url}")
	private String serviceCloseSessionUrl;
	
	// 获取客户的会话状态
	@Value("${weixin.service.message.customservice.session.status.url}")
	private String serviceSessionStatusUrl;
	
	// 获取客服的会话列表
	@Value("${weixin.service.message.customservice.session.service.list.url}")
	private String serviceSessionListUrl;
	
	// 获取未接入会话列表
	@Value("${weixin.service.message.customservice.session.wait.list.url}")
	private String serviceSessionWaitListUrl;
	
	// 获取客服聊天记录接口
	@Value("${weixin.service.message.customservice.record.url}")
	private String serviceCustomRecordUrl;
	
	// 微信服务号js-sdk获取tocket的地址
	@Value("${weixin.service.js.ticket.url}")
	private String serviceJsTicketUrl;
	
	// 微信服务号创建二维码的地址
	@Value("${weixin.service.qrcode.create.url}")
	private String serviceQrcodeUrl;
	
	// 新增临时素材
	@Value("${weixin.service.material.temporary.url}")
	private String materialTempUrl;
	
	// 获取临时素材，不包括视频临时素材
	@Value("${weixin.service.material.temporary.fetch.url}")
	private String materialTempFetchUrl;
	
	// 获取临时素材，只有视频临时素材
	@Value("${weixin.service.material.temporary.video.fetch.url}")
	private String materialTempVideFetchUrl;
	
	// 微信服务号获取素材信息
	@Value("${weixin.service.material.get.url}")
	private String materialGetUrl;
	
	// 微信服务号素材数量获取接口
	@Value("${weixin.service.material.count.url}")
	private String materialCountUrl;
	
	// 微信服务号素材批量获取接口
	@Value("${weixin.service.material.batchget.url}")
	private String materialBatchGetUrl;
	
	// 删除永久素材
	@Value("${weixin.service.material.delete.url}")
	private String materialDeleteUrl;
	
	// 新增永久图文素材
	@Value("${weixin.service.material.create.news.url}")
	private String materialNewsCreateUrl;
	
	// 在图文消息的具体内容中，将过滤外部的图片链接，开发者可以通过下述接口上传图片得到URL，放到图文内容中使用
	@Value("${weixin.service.material.create.image.url}")
	private String materialImageCreateUrl;
	
	// 新增其他类型永久素材
	@Value("${weixin.service.material.create.other.url}")
	private String materialOtherCreateUrl;
	
	// 修改永久图文素材
	@Value("${weixin.service.material.update.news.url}")
	private String materialNewsModifyUrl;

	// 微信显示二维码的URL地址
	@Value("${weixin.service.qrcode.show.url}")
	private String qrcodeShowUrl;
	
	// 微信网页token获取地址
	@Value("${weixin.web.token.url}")
	private String tokenUrl;
	
	// 微信网页token刷新地址
	@Value("${weixin.web.token.refresh.url}")
	private String refreshTokenUrl;
	
	// 微信网页用户信息获取地址
	@Value("${weixin.web.user.url}")
	private String userInfoUrl;
	
	// 微信网页token有效性验证地址
	@Value("${weixin.web.token.valid.url}")
	private String tokenValidUrl;
	
	// 微信内访问网页登陆授权页,相对于authorizeBaseUrl
	@Value("${weixin.web.authorize.url}")
	private String authorizeUrl;
	
	// 微信授权网站登陆，但并不是在微信内访问的网站,授权地址,相对于authorizeBaseUrl
	@Value("${web.weixin.authorize.url}")
	private String webAuthorizeUrl;
	
	// 统一下单相对URL
	@Value("${weixin.pay.unifiedorder.url}")
	private String unifiedOrderUrl;
	
	// 支付订单查询相对URL
	@Value("${weixin.pay.orderquery.url}")
	private String orderQueryUrl;
	
	// 关闭订单的相对URL
	@Value("${weixin.pay.closeorder.url}")
	private String closeOrderUrl;
	
	// 退款相对URL
	@Value("${weixin.pay.refund.url}")
	private String refundUrl;
	
	// 退款查询URL
	@Value("${weixin.pay.refundquery.url}")
	private String refundQueryUrl;
	
	// 提交刷卡支付API
	@Value("${weixin.pay.micropay.url}")
	private String payMicropayUrl;
	
	// 撤销订单API
	@Value("${weixin.pay.reverse.url}")
	private String payReverseUrl;
	
	// 帐单下载URL
	@Value("${weixin.pay.downloadbill.url}")
	private String downloadBillUrl;
	
	// 测试速上报URL
	@Value("${weixin.pay.report.url}")
	private String reportUrl;
	
	// 微信扫码支付模式一的二维码字符串模板
	@Value("${weixin.pay.scan.template}")
	private String scanPayTemplate;

	public String getServiceTokenUrl() {
		return serviceTokenUrl;
	}

	public void setServiceTokenUrl(String serviceTokenUrl) {
		this.serviceTokenUrl = serviceTokenUrl;
	}

	public String getServiceUserInfoUrl() {
		return serviceUserInfoUrl;
	}

	public void setServiceUserInfoUrl(String serviceUserInfoUrl) {
		this.serviceUserInfoUrl = serviceUserInfoUrl;
	}

	public String getServiceUserBatchUrl() {
		return serviceUserBatchUrl;
	}

	public void setServiceUserBatchUrl(String serviceUserBatchUrl) {
		this.serviceUserBatchUrl = serviceUserBatchUrl;
	}

	public String getServiceUserListFirstUrl() {
		return serviceUserListFirstUrl;
	}

	public void setServiceUserListFirstUrl(String serviceUserListFirstUrl) {
		this.serviceUserListFirstUrl = serviceUserListFirstUrl;
	}

	public String getServiceUserListMultiUrl() {
		return serviceUserListMultiUrl;
	}

	public void setServiceUserListMultiUrl(String serviceUserListMultiUrl) {
		this.serviceUserListMultiUrl = serviceUserListMultiUrl;
	}

	public String getServiceMenuCreateUrl() {
		return serviceMenuCreateUrl;
	}

	public void setServiceMenuCreateUrl(String serviceMenuCreateUrl) {
		this.serviceMenuCreateUrl = serviceMenuCreateUrl;
	}

	public String getServicePersonCreateUrl() {
		return servicePersonCreateUrl;
	}

	public void setServicePersonCreateUrl(String servicePersonCreateUrl) {
		this.servicePersonCreateUrl = servicePersonCreateUrl;
	}

	public String getServiceMenuDeleteUrl() {
		return serviceMenuDeleteUrl;
	}

	public void setServiceMenuDeleteUrl(String serviceMenuDeleteUrl) {
		this.serviceMenuDeleteUrl = serviceMenuDeleteUrl;
	}

	public String getServicePersonDeleteUrl() {
		return servicePersonDeleteUrl;
	}

	public void setServicePersonDeleteUrl(String servicePersonDeleteUrl) {
		this.servicePersonDeleteUrl = servicePersonDeleteUrl;
	}

	public String getServicePersonMatchUrl() {
		return servicePersonMatchUrl;
	}

	public void setServicePersonMatchUrl(String servicePersonMatchUrl) {
		this.servicePersonMatchUrl = servicePersonMatchUrl;
	}

	public String getServiceMessageTempSendUrl() {
		return serviceMessageTempSendUrl;
	}

	public void setServiceMessageTempSendUrl(String serviceMessageTempSendUrl) {
		this.serviceMessageTempSendUrl = serviceMessageTempSendUrl;
	}

	public String getServiceJsTicketUrl() {
		return serviceJsTicketUrl;
	}

	public void setServiceJsTicketUrl(String serviceJsTicketUrl) {
		this.serviceJsTicketUrl = serviceJsTicketUrl;
	}

	public String getServiceQrcodeUrl() {
		return serviceQrcodeUrl;
	}

	public void setServiceQrcodeUrl(String serviceQrcodeUrl) {
		this.serviceQrcodeUrl = serviceQrcodeUrl;
	}

	public String getMaterialGetUrl() {
		return materialGetUrl;
	}

	public void setMaterialGetUrl(String materialGetUrl) {
		this.materialGetUrl = materialGetUrl;
	}

	public String getMaterialCountUrl() {
		return materialCountUrl;
	}

	public void setMaterialCountUrl(String materialCountUrl) {
		this.materialCountUrl = materialCountUrl;
	}

	public String getMaterialBatchGetUrl() {
		return materialBatchGetUrl;
	}

	public void setMaterialBatchGetUrl(String materialBatchGetUrl) {
		this.materialBatchGetUrl = materialBatchGetUrl;
	}

	public String getQrcodeShowUrl() {
		return qrcodeShowUrl;
	}

	public void setQrcodeShowUrl(String qrcodeShowUrl) {
		this.qrcodeShowUrl = qrcodeShowUrl;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getRefreshTokenUrl() {
		return refreshTokenUrl;
	}

	public void setRefreshTokenUrl(String refreshTokenUrl) {
		this.refreshTokenUrl = refreshTokenUrl;
	}

	public String getUserInfoUrl() {
		return userInfoUrl;
	}

	public void setUserInfoUrl(String userInfoUrl) {
		this.userInfoUrl = userInfoUrl;
	}

	public String getTokenValidUrl() {
		return tokenValidUrl;
	}

	public void setTokenValidUrl(String tokenValidUrl) {
		this.tokenValidUrl = tokenValidUrl;
	}

	public String getAuthorizeUrl() {
		return authorizeUrl;
	}

	public void setAuthorizeUrl(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}

	public String getWebAuthorizeUrl() {
		return webAuthorizeUrl;
	}

	public void setWebAuthorizeUrl(String webAuthorizeUrl) {
		this.webAuthorizeUrl = webAuthorizeUrl;
	}

	public String getUnifiedOrderUrl() {
		return unifiedOrderUrl;
	}

	public void setUnifiedOrderUrl(String unifiedOrderUrl) {
		this.unifiedOrderUrl = unifiedOrderUrl;
	}

	public String getOrderQueryUrl() {
		return orderQueryUrl;
	}

	public void setOrderQueryUrl(String orderQueryUrl) {
		this.orderQueryUrl = orderQueryUrl;
	}

	public String getCloseOrderUrl() {
		return closeOrderUrl;
	}

	public void setCloseOrderUrl(String closeOrderUrl) {
		this.closeOrderUrl = closeOrderUrl;
	}

	public String getRefundUrl() {
		return refundUrl;
	}

	public void setRefundUrl(String refundUrl) {
		this.refundUrl = refundUrl;
	}

	public String getRefundQueryUrl() {
		return refundQueryUrl;
	}

	public void setRefundQueryUrl(String refundQueryUrl) {
		this.refundQueryUrl = refundQueryUrl;
	}

	public String getDownloadBillUrl() {
		return downloadBillUrl;
	}

	public void setDownloadBillUrl(String downloadBillUrl) {
		this.downloadBillUrl = downloadBillUrl;
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public String getServiceCustomAddUrl() {
		return serviceCustomAddUrl;
	}

	public void setServiceCustomAddUrl(String serviceCustomAddUrl) {
		this.serviceCustomAddUrl = serviceCustomAddUrl;
	}

	public String getServiceCustomUpdateUrl() {
		return serviceCustomUpdateUrl;
	}

	public void setServiceCustomUpdateUrl(String serviceCustomUpdateUrl) {
		this.serviceCustomUpdateUrl = serviceCustomUpdateUrl;
	}

	public String getServiceCustomDeleteUrl() {
		return serviceCustomDeleteUrl;
	}

	public void setServiceCustomDeleteUrl(String serviceCustomDeleteUrl) {
		this.serviceCustomDeleteUrl = serviceCustomDeleteUrl;
	}

	public String getServiceCustomHeadUrl() {
		return serviceCustomHeadUrl;
	}

	public void setServiceCustomHeadUrl(String serviceCustomHeadUrl) {
		this.serviceCustomHeadUrl = serviceCustomHeadUrl;
	}

	public String getServiceCustomListUrl() {
		return serviceCustomListUrl;
	}

	public void setServiceCustomListUrl(String serviceCustomListUrl) {
		this.serviceCustomListUrl = serviceCustomListUrl;
	}

	public String getServiceCustomSendUrl() {
		return serviceCustomSendUrl;
	}

	public void setServiceCustomSendUrl(String serviceCustomSendUrl) {
		this.serviceCustomSendUrl = serviceCustomSendUrl;
	}

	public String getServiceCustomOnlineUrl() {
		return serviceCustomOnlineUrl;
	}

	public void setServiceCustomOnlineUrl(String serviceCustomOnlineUrl) {
		this.serviceCustomOnlineUrl = serviceCustomOnlineUrl;
	}

	public String getServiceCreateSessionUrl() {
		return serviceCreateSessionUrl;
	}

	public void setServiceCreateSessionUrl(String serviceCreateSessionUrl) {
		this.serviceCreateSessionUrl = serviceCreateSessionUrl;
	}

	public String getServiceCloseSessionUrl() {
		return serviceCloseSessionUrl;
	}

	public void setServiceCloseSessionUrl(String serviceCloseSessionUrl) {
		this.serviceCloseSessionUrl = serviceCloseSessionUrl;
	}

	public String getServiceSessionStatusUrl() {
		return serviceSessionStatusUrl;
	}

	public void setServiceSessionStatusUrl(String serviceSessionStatusUrl) {
		this.serviceSessionStatusUrl = serviceSessionStatusUrl;
	}

	public String getServiceSessionListUrl() {
		return serviceSessionListUrl;
	}

	public void setServiceSessionListUrl(String serviceSessionListUrl) {
		this.serviceSessionListUrl = serviceSessionListUrl;
	}

	public String getServiceSessionWaitListUrl() {
		return serviceSessionWaitListUrl;
	}

	public void setServiceSessionWaitListUrl(String serviceSessionWaitListUrl) {
		this.serviceSessionWaitListUrl = serviceSessionWaitListUrl;
	}

	public String getServiceCustomRecordUrl() {
		return serviceCustomRecordUrl;
	}

	public void setServiceCustomRecordUrl(String serviceCustomRecordUrl) {
		this.serviceCustomRecordUrl = serviceCustomRecordUrl;
	}

	public String getMaterialTempUrl() {
		return materialTempUrl;
	}

	public void setMaterialTempUrl(String materialTempUrl) {
		this.materialTempUrl = materialTempUrl;
	}

	public String getMaterialTempFetchUrl() {
		return materialTempFetchUrl;
	}

	public void setMaterialTempFetchUrl(String materialTempFetchUrl) {
		this.materialTempFetchUrl = materialTempFetchUrl;
	}

	public String getMaterialTempVideFetchUrl() {
		return materialTempVideFetchUrl;
	}

	public void setMaterialTempVideFetchUrl(String materialTempVideFetchUrl) {
		this.materialTempVideFetchUrl = materialTempVideFetchUrl;
	}

	public String getMaterialNewsCreateUrl() {
		return materialNewsCreateUrl;
	}

	public void setMaterialNewsCreateUrl(String materialNewsCreateUrl) {
		this.materialNewsCreateUrl = materialNewsCreateUrl;
	}

	public String getMaterialImageCreateUrl() {
		return materialImageCreateUrl;
	}

	public void setMaterialImageCreateUrl(String materialImageCreateUrl) {
		this.materialImageCreateUrl = materialImageCreateUrl;
	}

	public String getMaterialOtherCreateUrl() {
		return materialOtherCreateUrl;
	}

	public void setMaterialOtherCreateUrl(String materialOtherCreateUrl) {
		this.materialOtherCreateUrl = materialOtherCreateUrl;
	}

	public String getMaterialDeleteUrl() {
		return materialDeleteUrl;
	}

	public void setMaterialDeleteUrl(String materialDeleteUrl) {
		this.materialDeleteUrl = materialDeleteUrl;
	}

	public String getMaterialNewsModifyUrl() {
		return materialNewsModifyUrl;
	}

	public void setMaterialNewsModifyUrl(String materialNewsModifyUrl) {
		this.materialNewsModifyUrl = materialNewsModifyUrl;
	}

	public String getServiceGroupCreateUrl() {
		return serviceGroupCreateUrl;
	}

	public void setServiceGroupCreateUrl(String serviceGroupCreateUrl) {
		this.serviceGroupCreateUrl = serviceGroupCreateUrl;
	}

	public String getServiceGroupListUrl() {
		return serviceGroupListUrl;
	}

	public void setServiceGroupListUrl(String serviceGroupListUrl) {
		this.serviceGroupListUrl = serviceGroupListUrl;
	}

	public String getServiceUserGroupMatchUrl() {
		return serviceUserGroupMatchUrl;
	}

	public void setServiceUserGroupMatchUrl(String serviceUserGroupMatchUrl) {
		this.serviceUserGroupMatchUrl = serviceUserGroupMatchUrl;
	}

	public String getServiceGroupModifyUrl() {
		return serviceGroupModifyUrl;
	}

	public void setServiceGroupModifyUrl(String serviceGroupModifyUrl) {
		this.serviceGroupModifyUrl = serviceGroupModifyUrl;
	}

	public String getServiceUserGroupMoveUrl() {
		return serviceUserGroupMoveUrl;
	}

	public void setServiceUserGroupMoveUrl(String serviceUserGroupMoveUrl) {
		this.serviceUserGroupMoveUrl = serviceUserGroupMoveUrl;
	}

	public String getServiceUserGroupBatchMoveUrl() {
		return serviceUserGroupBatchMoveUrl;
	}

	public void setServiceUserGroupBatchMoveUrl(String serviceUserGroupBatchMoveUrl) {
		this.serviceUserGroupBatchMoveUrl = serviceUserGroupBatchMoveUrl;
	}

	public String getServiceGroupDeleteUrl() {
		return serviceGroupDeleteUrl;
	}

	public void setServiceGroupDeleteUrl(String serviceGroupDeleteUrl) {
		this.serviceGroupDeleteUrl = serviceGroupDeleteUrl;
	}

	public String getServiceUserModifyUrl() {
		return serviceUserModifyUrl;
	}

	public void setServiceUserModifyUrl(String serviceUserModifyUrl) {
		this.serviceUserModifyUrl = serviceUserModifyUrl;
	}

	public String getPayMicropayUrl() {
		return payMicropayUrl;
	}

	public void setPayMicropayUrl(String payMicropayUrl) {
		this.payMicropayUrl = payMicropayUrl;
	}

	public String getPayReverseUrl() {
		return payReverseUrl;
	}

	public void setPayReverseUrl(String payReverseUrl) {
		this.payReverseUrl = payReverseUrl;
	}

	public String getScanPayTemplate() {
		return scanPayTemplate;
	}

	public void setScanPayTemplate(String scanPayTemplate) {
		this.scanPayTemplate = scanPayTemplate;
	}

}
