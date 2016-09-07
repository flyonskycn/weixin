package com.flyonsky.weixin;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.flyonsky.weixin.data.EnumAuthorizeSource;
import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.user.BatchFetchParam;
import com.flyonsky.weixin.data.user.BatchFetchReceive;
import com.flyonsky.weixin.data.user.BatchMoveGroupParam;
import com.flyonsky.weixin.data.user.CreateGroupReceive;
import com.flyonsky.weixin.data.user.FetchListReceive;
import com.flyonsky.weixin.data.user.Group;
import com.flyonsky.weixin.data.user.GroupListReceive;
import com.flyonsky.weixin.data.user.GroupParam;
import com.flyonsky.weixin.data.user.SimpleParam;
import com.flyonsky.weixin.data.user.UserGroupParam;
import com.flyonsky.weixin.data.user.UserInfo;
import com.flyonsky.weixin.data.user.UserMatchGroupReceive;

/**
 * 微信用户接口实现类
 * @author Administrator
 *
 */
@Component
public class UserHandleImp extends AbstractHandle implements UserHandle{
	
	@Autowired
	private WeixinURLConfig urlConfig;

	@Override
	public UserInfo info(String accessToken, String openid, EnumAuthorizeSource source) {
		Assert.notNull(accessToken);
		Assert.notNull(openid);
		Assert.notNull(source);
		
		String url = null;
		switch(source){
		case SERVICE:
			url = MessageFormat.format(this.getUrlConfig().getServiceUserInfoUrl(),accessToken,openid);
			break;
			default:
				url = MessageFormat.format(this.getUrlConfig().getUserInfoUrl(),accessToken,openid);
				break;
		}
		UserInfo user = this.doGet(url, UserInfo.class);
		return user;
	}

	@Override
	public BatchFetchReceive batchFetch(String accessToken, List<String> openList) {
		Assert.notNull(accessToken);
		Assert.notNull(openList);
		
		BatchFetchParam param = new BatchFetchParam();
		List<SimpleParam> list = new ArrayList<SimpleParam>();
		SimpleParam s = null;
		for(String openid : openList){
			s = new SimpleParam();
			s.setOpenid(openid);
			list.add(s);
		}
		
		param.setUserList(list);
		
		String url = MessageFormat.format(this.getUrlConfig().getServiceUserBatchUrl(), accessToken);
		BatchFetchReceive receive = this.doPost(url, param, BatchFetchReceive.class);
		return receive;
	}

	@Override
	public FetchListReceive batchFetchOpen(String accessToken, String nextOpenid) {
		Assert.notNull(accessToken);
		
		String url = null;
		if(StringUtils.isNotBlank(nextOpenid)){
			url = MessageFormat.format(this.getUrlConfig().getServiceUserListMultiUrl(), accessToken,nextOpenid);
		}else{
			url = MessageFormat.format(this.getUrlConfig().getServiceUserListFirstUrl(), accessToken);
		}
		FetchListReceive data = this.doGet(url, FetchListReceive.class);
		return data;
	}

	@Override
	public CreateGroupReceive createGroup(String accessToken, String groupName) {
		Assert.notNull(accessToken);
		Assert.notNull(groupName);
		
		GroupParam param = new GroupParam();
		Group group = new Group();
		group.setName(groupName);
		param.setGroup(group);
		String url = MessageFormat.format(this.getUrlConfig().getServiceGroupCreateUrl(), accessToken);
		CreateGroupReceive receive = this.doPost(url, param, CreateGroupReceive.class);
		return receive;
	}

	@Override
	public GroupListReceive fetchAllGroup(String accessToken) {
		Assert.notNull(accessToken);
		
		String url = MessageFormat.format(this.getUrlConfig().getServiceGroupListUrl(), accessToken);
		GroupListReceive receive = this.doGet(url, GroupListReceive.class);
		return receive;
	}

	@Override
	public UserMatchGroupReceive matchUserGroup(String accessToken, String openid) {
		Assert.notNull(accessToken);
		Assert.notNull(openid);
		
		UserGroupParam param = new UserGroupParam();
		param.setOpenid(openid);
		String url = MessageFormat.format(this.getUrlConfig().getServiceUserGroupMatchUrl(), accessToken);
		UserMatchGroupReceive receive = this.doPost(url, param, UserMatchGroupReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive modifyGroup(String accessToken, int groupId,String groupName) {
		Assert.notNull(accessToken);
		Assert.notNull(groupName);
		
		GroupParam param = new GroupParam();
		Group group = new Group();
		group.setId(groupId);
		group.setName(groupName);
		param.setGroup(group);
		
		String url = MessageFormat.format(this.getUrlConfig().getServiceGroupModifyUrl(), accessToken);
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive moveUserGroup(String accessToken, String openid, int groupId) {
		Assert.notNull(accessToken);
		
		UserGroupParam param = new UserGroupParam();
		param.setOpenid(openid);
		param.setToGroupid(groupId);
		
		String url = MessageFormat.format(this.getUrlConfig().getServiceUserGroupMoveUrl(), accessToken);
		
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive batchMoveUserGroup(String accessToken, List<String> openList, int groupId) {
		Assert.notNull(accessToken);
		Assert.notNull(openList);
		
		BatchMoveGroupParam param = new BatchMoveGroupParam();
		param.setOpenidList(openList);
		param.setToGroupId(groupId);
		
		String url = MessageFormat.format(this.getUrlConfig().getServiceUserGroupBatchMoveUrl(), accessToken);
		
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive removeGroup(String accessToken, int groupId) {
		Assert.notNull(accessToken);
		
		Group group = new Group();
		group.setId(groupId);
		GroupParam param = new GroupParam();
		param.setGroup(group);
		
		String url = MessageFormat.format(this.getUrlConfig().getServiceGroupDeleteUrl(), accessToken);
		
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive modifyUserRemark(String accessToken, String openid, String remark) {
		Assert.notNull(accessToken);
		Assert.notNull(openid);
		Assert.notNull(remark);
		
		UserInfo user = new UserInfo();
		user.setOpenId(openid);
		user.setRemark(remark);
		
		String url = MessageFormat.format(this.getUrlConfig().getServiceUserModifyUrl(), accessToken);

		ServiceReceive receive = this.doPost(url, user, ServiceReceive.class);
		return receive;
	}

	public WeixinURLConfig getUrlConfig() {
		return urlConfig;
	}

	public void setUrlConfig(WeixinURLConfig urlConfig) {
		this.urlConfig = urlConfig;
	}
}
