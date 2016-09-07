package com.flyonsky.weixin;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.flyonsky.weixin.data.EnumMaterialContentType;
import com.flyonsky.weixin.data.MultiMedia;
import com.flyonsky.weixin.data.MultiMediaParam;
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

@Service
public class MessageHandleImp extends AbstractHandle implements MessageHandle{

	@Autowired
	private WeixinURLConfig config;
	
	@Override
	public TemplateReceive sendTemplateMsg(String accessToken, TemplateParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getServiceMessageTempSendUrl(), accessToken);
		TemplateReceive receive = this.doPost(url, param, TemplateReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive kfAdd(String accessToken, CustomParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomAddUrl(), accessToken);
		return this.kfCommand(url, param);
	}

	@Override
	public ServiceReceive kfModify(String accessToken, CustomParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomUpdateUrl(), accessToken);
		return this.kfCommand(url, param);
	}

	@Override
	public ServiceReceive kfDelete(String accessToken, String account) {
		Assert.notNull(accessToken);
		Assert.notNull(account);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomDeleteUrl(), accessToken, account);
		ServiceReceive receive = this.doGet(url, ServiceReceive.class);
		return receive;
	}
	
	/**
	 * 执行相同参数类型与返回类型的客服方法
	 * @param url URL地址
	 * @param param　请求参数
	 * @return
	 */
	private ServiceReceive kfCommand(String url, CustomParam param){
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public CustomListReceive kfList(String accessToken) {
		Assert.notNull(accessToken);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomListUrl(), accessToken);
		CustomListReceive receive = this.doGet(url, CustomListReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive sendKfMsg(String accessToken, AbstractCustomReply reply) {
		Assert.notNull(accessToken);
		Assert.notNull(reply);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomSendUrl(), accessToken);
		ServiceReceive receive = this.doPost(url, reply, ServiceReceive.class);
		return receive;
	}

	@Override
	public CustomOnlineReceive kfOnline(String accessToken) {
		Assert.notNull(accessToken);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomOnlineUrl(), accessToken);
		CustomOnlineReceive receive = this.doGet(url, CustomOnlineReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive kfModifyHead(String accessToken, String account, InputStream image) {
		Assert.notNull(accessToken);
		Assert.notNull(account);
		Assert.notNull(image);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomHeadUrl(), accessToken, account);
		MultiMedia media = new MultiMedia();
		media.setInputStream(image);
		media.setType(EnumMaterialContentType.image_jpeg);
		
		String fileName = UUID.randomUUID().toString();
		media.setFileName(fileName + WeixinUtil.createFileSuffix(EnumMaterialContentType.image_jpeg));
		MultiMediaParam param = new MultiMediaParam();
		param.setMultiMedia(media);
		ServiceReceive receive = this.doPost(url, null, param, ServiceReceive.class);
		return receive;
	}

	public WeixinURLConfig getConfig() {
		return config;
	}

	public void setConfig(WeixinURLConfig config) {
		this.config = config;
	}

	@Override
	public ServiceReceive createKfSession(String accessToken, CustomSessionParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getServiceCreateSessionUrl(), accessToken);
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive closeKfSession(String accessToken, CustomSessionParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getServiceCloseSessionUrl(), accessToken);
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public ClientSessionReceive clientSession(String accessToken, String openid) {
		Assert.notNull(accessToken);
		Assert.notNull(openid);
		
		String url = MessageFormat.format(this.getConfig().getServiceSessionStatusUrl(), accessToken,openid);
		ClientSessionReceive receive = this.doGet(url, ClientSessionReceive.class);
		return receive;
	}

	@Override
	public CustomClientListReceive kfSessionList(String accessToken, String kfAccount) {
		Assert.notNull(accessToken);
		Assert.notNull(kfAccount);
		
		String url = MessageFormat.format(this.getConfig().getServiceSessionListUrl(), accessToken,kfAccount);
		CustomClientListReceive receive = this.doGet(url, CustomClientListReceive.class);
		return receive;
	}

	@Override
	public CustomClientWaitListReceive clientWaitSessionList(String accessToken) {
		Assert.notNull(accessToken);
		
		String url = MessageFormat.format(this.getConfig().getServiceSessionWaitListUrl(), accessToken);
		CustomClientWaitListReceive receive = this.doGet(url, CustomClientWaitListReceive.class);
		return receive;
	}

	@Override
	public CustomRecordReceive kfRecordList(String accessToken, CustomRecordParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getServiceCustomRecordUrl(), accessToken);
		CustomRecordReceive receive = this.doPost(url, param, CustomRecordReceive.class);
		return receive;
	}
}
