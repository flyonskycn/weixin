package com.flyonsky.weixin;

import java.io.InputStream;

import com.flyonsky.weixin.data.EnumMaterialContentType;
import com.flyonsky.weixin.data.EnumMaterialType;
import com.flyonsky.weixin.data.MultiMediaReceive;
import com.flyonsky.weixin.data.ServiceReceive;
import com.flyonsky.weixin.data.material.BatchParam;
import com.flyonsky.weixin.data.material.BatchReceive;
import com.flyonsky.weixin.data.material.CreateImageReceive;
import com.flyonsky.weixin.data.material.CreateNewReceive;
import com.flyonsky.weixin.data.material.CreateNewsParam;
import com.flyonsky.weixin.data.material.CreateOtherReceive;
import com.flyonsky.weixin.data.material.MaterialCountReceive;
import com.flyonsky.weixin.data.material.ModifyNewsParam;
import com.flyonsky.weixin.data.material.NewsMaterial;
import com.flyonsky.weixin.data.material.TempMaterialReceive;
import com.flyonsky.weixin.data.material.VideDescription;
import com.flyonsky.weixin.data.material.VideoMaterial;

/**
 * 微信素材管理
 * @author Administrator
 *
 */
public interface MaterialHandle {
	
	/**
	 * 获取单个图文消息素材
	 * @param accessToken 对应公众号的 accessToken
	 * @param mediaId 素材ID
	 * @return
	 */
	NewsMaterial fetchNewsMaterial(String accessToken, String mediaId);
	
	/**
	 * 获取单个视频消息素材
	 * @param accessToken 对应公众号的 accessToken
	 * @param mediaId 素材ID
	 * @return
	 */
	VideoMaterial fetchVideoMaterial(String accessToken, String mediaId);
	
	/**
	 * 获取其他类型的素材消息
	 * @param accessToken 对应公众号的 accessToken
	 * @param mediaId 素材ID
	 * @return
	 */
	MultiMediaReceive fetchOtherMaterial(String accessToken, String mediaId);
	
	/**
	 * 获取素材总数
	 * @param accessToken 对应公众号的 accessToken
	 * @return
	 */
	MaterialCountReceive queryMaterialCount(String accessToken);
	
	/**
	 * 批量获取素材
	 * @param accessToken 对应公从号的 accessToken
	 * @param param 获取素材请求参数
	 * @return
	 */
	BatchReceive batchFetchMaterial(String accessToken, BatchParam param);
	
	/**
	 * 上传临时素材
	 * @param accessToken 对应公从号的 accessToken
	 * @param type 素材类型,只能是：分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param mimeSubtype 素材文件子类型
	 * @param inputStream 素材文件输入流
	 * @return
	 */
	TempMaterialReceive createTempMaterial(String accessToken, EnumMaterialType type, EnumMaterialContentType mimeSubtype, InputStream inputStream);
	
	/**
	 * 获取临时素材
	 * @param accessToken 对应公从号的 accessToken
	 * @param type 素材类型,只能是：分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param mediaId 素材ID
	 * @return
	 */
	MultiMediaReceive downloadTempMaterial(String accessToken,EnumMaterialType type,String mediaId);
	
	/**
	 * 新增永久图文素材 
	 * @param accessToken 对应公从号的 accessToken
	 * @param param 图文素材信息
	 * @return
	 */
	CreateNewReceive createNewsMaterial(String accessToken, CreateNewsParam param);
	
	/**
	 * 上传图文消息内的图片获取URL
	 * @param accessToken 对应公从号的 accessToken
	 * @param imageType 图片类型,只能是image_jpeg,image_png
	 * @param inputStream 图片输入流
	 * @return 
	 */
	CreateImageReceive createNewsImage(String accessToken, EnumMaterialContentType imageType, InputStream inputStream);
	
	
	/**
	 * 新增其他类型永久素材
	 * @param accessToken 对应公从号的 accessToken
	 * @param materialType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param contentType 媒体文件类型
	 * @param description 视频素材的描述
	 * @param inputStream 素材素入流
	 * @return 
	 */
	CreateOtherReceive creatOtherMaterial(String accessToken,
			EnumMaterialType materialType,
			EnumMaterialContentType contentType,
			VideDescription description,
			InputStream inputStream);
	
	/**
	 * 删除永久素材
	 * @param accessToken 对应公从号的 accessToken
	 * @param mediaId 素材ID
	 * @return
	 */
	ServiceReceive removeMaterial(String accessToken, String mediaId);
	
	/**
	 * 更新图文素材
	 * @param accessToken 对应公从号的 accessToken
	 * @param param 更新图文素材请求参数
	 * @return
	 */
	ServiceReceive modifyNewsMaterial(String accessToken, ModifyNewsParam param);
}
