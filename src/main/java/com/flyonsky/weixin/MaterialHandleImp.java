package com.flyonsky.weixin;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.flyonsky.weixin.data.EnumMaterialContentType;
import com.flyonsky.weixin.data.EnumMaterialType;
import com.flyonsky.weixin.data.MultiMedia;
import com.flyonsky.weixin.data.MultiMediaParam;
import com.flyonsky.weixin.data.MultiMediaReceive;
import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.material.BatchMediaReceive;
import com.flyonsky.weixin.data.material.BatchNewsReceive;
import com.flyonsky.weixin.data.material.BatchParam;
import com.flyonsky.weixin.data.material.BatchReceive;
import com.flyonsky.weixin.data.material.CreateImageReceive;
import com.flyonsky.weixin.data.material.CreateNewReceive;
import com.flyonsky.weixin.data.material.CreateNewsParam;
import com.flyonsky.weixin.data.material.CreateOtherReceive;
import com.flyonsky.weixin.data.material.MaterialCountReceive;
import com.flyonsky.weixin.data.material.ModifyNewsParam;
import com.flyonsky.weixin.data.material.NewsMaterial;
import com.flyonsky.weixin.data.material.SimpleParam;
import com.flyonsky.weixin.data.material.TempMaterialReceive;
import com.flyonsky.weixin.data.material.VideDescription;
import com.flyonsky.weixin.data.material.VideoMaterial;

@Service
public class MaterialHandleImp extends AbstractHandle implements MaterialHandle{
	
	@Autowired
	private WeixinURLConfig config;

	@Override
	public NewsMaterial fetchNewsMaterial(String accessToken, String mediaId) {
		Assert.notNull(accessToken);
		Assert.notNull(mediaId);
		
		SimpleParam param = new SimpleParam();
		param.setMediaId(mediaId);
		
		String url = MessageFormat.format(this.getConfig().getMaterialGetUrl(), accessToken);
		NewsMaterial receive = this.doPost(url, param, NewsMaterial.class);
		return receive;
	}
	
	@Override
	public MaterialCountReceive queryMaterialCount(String accessToken) {
		Assert.notNull(accessToken);
		
		String url = MessageFormat.format(this.getConfig().getMaterialCountUrl(), accessToken);
		MaterialCountReceive receive = null;
		receive = this.doGet(url, MaterialCountReceive.class);
		return receive;
	}

	@Override
	public BatchReceive batchFetchMaterial(String accessToken, BatchParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getMaterialBatchGetUrl(), accessToken);
		BatchReceive receive = null;
		EnumMaterialType type = EnumMaterialType.valueOf(EnumMaterialType.class, param.getType());
		switch(type){
		case news:
			receive = this.doPost(url, param, BatchNewsReceive.class);
			break;
			default:
				receive = this.doPost(url, param, BatchMediaReceive.class);
				break;
		}
		return receive;
	}

	@Override
	public TempMaterialReceive createTempMaterial(String accessToken, EnumMaterialType type, EnumMaterialContentType mimeSubtype,
			InputStream inputStream) {
		Assert.notNull(accessToken);
		Assert.notNull(type);
		Assert.notNull(mimeSubtype);
		Assert.notNull(inputStream);
		
		String url = MessageFormat.format(this.getConfig().getMaterialTempUrl(), accessToken, type.toString());
		MultiMedia media = new MultiMedia();
		media.setInputStream(inputStream);
		media.setType(mimeSubtype);
		
		String fileName = UUID.randomUUID().toString();
		media.setFileName(fileName + WeixinUtil.createFileSuffix(mimeSubtype));
		MultiMediaParam param = new MultiMediaParam();
		param.setMultiMedia(media);
		TempMaterialReceive receive = this.doPost(url, null, param, TempMaterialReceive.class);
		return receive;
	}

	@Override
	public MultiMediaReceive downloadTempMaterial(String accessToken, EnumMaterialType type, String mediaId) {
		Assert.notNull(accessToken);
		Assert.notNull(type);
		Assert.notNull(mediaId);
		Assert.isTrue(!type.equals(EnumMaterialType.news));
		String url = null;
		if(EnumMaterialType.video.equals(type)){
			url = MessageFormat.format(this.getConfig().getMaterialTempVideFetchUrl(), accessToken, mediaId);
		}else{
			url = MessageFormat.format(this.getConfig().getMaterialTempFetchUrl(), accessToken, mediaId);
		}
		MultiMediaReceive receive = this.doGet(url);
		return receive;
	}

	@Override
	public CreateNewReceive createNewsMaterial(String accessToken, CreateNewsParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getMaterialNewsCreateUrl(), accessToken);
		CreateNewReceive receive = this.doPost(url, param, CreateNewReceive.class);
		return receive;
	}

	@Override
	public CreateImageReceive createNewsImage(String accessToken, EnumMaterialContentType imageType, InputStream inputStream) {
		Assert.notNull(accessToken);
		Assert.notNull(imageType);
		Assert.isTrue(imageType.equals(EnumMaterialContentType.image_jpeg) || imageType.equals(EnumMaterialContentType.image_png));
		Assert.notNull(inputStream);
		
		String url = MessageFormat.format(this.getConfig().getMaterialImageCreateUrl(), accessToken);
		
		MultiMediaParam mediaParam = new MultiMediaParam();
		MultiMedia multiMedia = new MultiMedia();
		multiMedia.setInputStream(inputStream);
		multiMedia.setType(imageType);
		String fileName = UUID.randomUUID().toString();
		multiMedia.setFileName(fileName + WeixinUtil.createFileSuffix(imageType));
		mediaParam.setMultiMedia(multiMedia);
		
		CreateImageReceive receive = this.doPost(url, null, mediaParam, CreateImageReceive.class);
		return receive;
	}

	@Override
	public CreateOtherReceive creatOtherMaterial(String accessToken,
			EnumMaterialType materialType,
			EnumMaterialContentType contentType,
			VideDescription description,
			InputStream inputStream) {
		Assert.notNull(accessToken);
		Assert.notNull(materialType);
		Assert.notNull(inputStream);
		Assert.isTrue(!materialType.equals(EnumMaterialType.news));
		
		String url = MessageFormat.format(this.getConfig().getMaterialOtherCreateUrl(), accessToken);
		
		MultiMediaParam mediaParam = new MultiMediaParam();
		MultiMedia multiMedia = new MultiMedia();
		multiMedia.setInputStream(inputStream);
		multiMedia.setType(contentType);
		String fileName = UUID.randomUUID().toString();
		multiMedia.setFileName(fileName + WeixinUtil.createFileSuffix(contentType));
		mediaParam.setMultiMedia(multiMedia);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("description", description);
		
		CreateOtherReceive receive = this.doPost(url, map, mediaParam, CreateOtherReceive.class);
		return receive;
	}

	@Override
	public VideoMaterial fetchVideoMaterial(String accessToken, String mediaId) {
		Assert.notNull(accessToken);
		Assert.notNull(mediaId);
		
		SimpleParam param = new SimpleParam();
		param.setMediaId(mediaId);
		
		String url = MessageFormat.format(this.getConfig().getMaterialGetUrl(), accessToken);
		
		VideoMaterial receive = this.doPost(url, param, VideoMaterial.class);
		return receive;
	}

	@Override
	public MultiMediaReceive fetchOtherMaterial(String accessToken, String mediaId) {
		Assert.notNull(accessToken);
		Assert.notNull(mediaId);
		
		SimpleParam param = new SimpleParam();
		param.setMediaId(mediaId);
		
		String url = MessageFormat.format(this.getConfig().getMaterialGetUrl(), accessToken);
		MultiMediaReceive receive = this.doPost(url, param);
		return receive;
	}

	@Override
	public ServiceReceive removeMaterial(String accessToken, String mediaId) {
		Assert.notNull(accessToken);
		Assert.notNull(mediaId);
		
		SimpleParam param = new SimpleParam();
		param.setMediaId(mediaId);
		
		String url = MessageFormat.format(this.getConfig().getMaterialDeleteUrl(), accessToken);
		ServiceReceive receive = this.doPost(url, param, ServiceReceive.class);
		return receive;
	}

	@Override
	public ServiceReceive modifyNewsMaterial(String accessToken, ModifyNewsParam param) {
		Assert.notNull(accessToken);
		Assert.notNull(param);
		
		String url = MessageFormat.format(this.getConfig().getMaterialNewsModifyUrl(), accessToken);
		ServiceReceive receive = this.doPost(url, param);
		return receive;
	}

	public WeixinURLConfig getConfig() {
		return config;
	}

	public void setConfig(WeixinURLConfig config) {
		this.config = config;
	}
}
