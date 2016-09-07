package com.flyonsky.weixin;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.weixin.data.AccessToken;
import com.flyonsky.weixin.data.EnumMaterialContentType;
import com.flyonsky.weixin.data.EnumMaterialType;
import com.flyonsky.weixin.data.MultiMediaReceive;
import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.material.BatchParam;
import com.flyonsky.weixin.data.material.BatchReceive;
import com.flyonsky.weixin.data.material.CreateImageReceive;
import com.flyonsky.weixin.data.material.CreateOtherReceive;
import com.flyonsky.weixin.data.material.MaterialCountReceive;
import com.flyonsky.weixin.data.material.TempMaterialReceive;

/**
 * 素材获取测试
 * @author Administrator
 *
 */
public class MaterialHandleTest extends BaseSpringJUnit{

	@Autowired
	private MaterialHandle materialHandle;
	
	@Autowired
	private ServiceHandle serviceHandle;
	
	// 测试服务号 appid
	@Value("${weixin.coco.service.test.appid}")
	private String appid;
	
	// 测试服务号 secret
	@Value("${weixin.coco.service.test.secret}")
	private String secret;
	
	private String accessToken;
	
	/**
	 * 初始化accessToken
	 */
	@Before
	public void init(){
		AccessToken token = this.serviceHandle.accessToken(appid, secret);
		Assert.assertTrue(token.isSuccess());
		accessToken = token.getAccessToken();
	}
	
	/**
	 * 测试批量获取图文素材
	 */
	@Test
	public void testBatchFetchMaterial(){
		BatchParam param = new BatchParam();
		param.setOffset(0);
		param.setCount(1);
		param.setType(EnumMaterialType.news.toString());
		BatchReceive receive = this.materialHandle.batchFetchMaterial(accessToken, param);
		Assert.assertNotNull(receive);
		Assert.assertTrue(receive.isSuccess());
	}
	
	/**
	 * 测试获取素材的总数
	 */
	@Test
	public void testQueryMaterialCount(){
		MaterialCountReceive receive = this.materialHandle.queryMaterialCount(accessToken);
		Assert.assertNotNull(receive);
		Assert.assertTrue(receive.isSuccess());
	}
	
	/**
	 * 测试上传临时素材
	 */
	@Test
	public void testCreateTempMaterial(){
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("icon.jpg");
		TempMaterialReceive receive = this.materialHandle.createTempMaterial(accessToken,
				EnumMaterialType.image, 
				EnumMaterialContentType.image_jpeg, inputStream);
		Assert.assertNotNull(receive);
		Assert.assertTrue(receive.isSuccess());
		
		MultiMediaReceive data = this.materialHandle.downloadTempMaterial(accessToken, EnumMaterialType.image, receive.getMediaId());
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
		Assert.assertNotNull(data.getFileName());
	}
	
	/**
	 * 测试上传图文消息内的图片获取URL
	 */
	@Test
	public void testCreateNewsImage(){
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("icon.jpg");
		CreateImageReceive receive = this.materialHandle.createNewsImage(accessToken, EnumMaterialContentType.image_jpeg, inputStream);
		Assert.assertNotNull(receive);
		Assert.assertTrue(receive.isSuccess());
		
		Assert.assertNotNull(receive.getUrl());
	}
	
	/**
	 * 测试上传图片永久素材
	 */
	@Test
	public void testCreatOtherMaterial(){
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("icon.jpg");
		CreateOtherReceive receive = this.materialHandle.creatOtherMaterial(accessToken,
				EnumMaterialType.image,
				EnumMaterialContentType.image_jpeg,
				null, inputStream);
		Assert.assertNotNull(receive);
		Assert.assertTrue(receive.isSuccess());
		Assert.assertNotNull(receive.getUrl());
		Assert.assertNotNull(receive.getMediaId());
		
		MultiMediaReceive data = this.materialHandle.fetchOtherMaterial(accessToken, receive.getMediaId());
		Assert.assertNotNull(data);
		Assert.assertTrue(data.isSuccess());
		Assert.assertNotNull(data.getFileName());
		
		ServiceReceive rec = this.materialHandle.removeMaterial(accessToken, receive.getMediaId());
		
		Assert.assertNotNull(rec);
		Assert.assertTrue(rec.isSuccess());
	}
}
