package com.flyonsky.weixin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.EnumMaterialContentType;
import com.flyonsky.weixin.data.EnumMsgType;
import com.flyonsky.weixin.data.NoSign;
import com.flyonsky.weixin.data.material.NewsMaterial;
import com.flyonsky.weixin.data.material.NewsMaterialItem;
import com.flyonsky.weixin.data.message.NewsItem;
import com.flyonsky.weixin.data.message.NewsReply;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * 微信相关的工具类
 * @author Administrator
 *
 */
public class WeixinUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(WeixinUtil.class);
	
	private static final String WEIXIN_USER_AGENT = "MicroMessenger";
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};
    
    private static final String TEMPLATE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    // 黒色
    private static final int BLACK = 0xff000000;
    // 白色
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    /**
     * 转换byte到16进制
     * @param b 要转换的byte
     * @return 16进制格式
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

	/**
	 * 微信的sha1摘要
	 * @param s 待摘要内容
	 * @return 摘要
	 */
	public static String sha1(String s) {
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.update(s.getBytes(Charset.forName("UTF-8")));
	        byte messageDigest[] = digest.digest();
	        
	        return byteArrayToHexString(messageDigest);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	
	/**
	 * 微信的MD5摘要
	 * @param origin 待摘要内容
	 * @return 摘要
	 */
    public static String md5(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes(Charset.forName("UTF-8"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
	
	/**
	 * 根据http的head[User-Agent]判断是否为微信内访问
	 * @param userAgent head[User-Agent]信息
	 * @return false:非微信内访问,true:微信内访问
	 */
	public static boolean isWeixinCall(String userAgent){
		boolean flag = false;
		if(!StringUtils.isBlank(userAgent)){
			if(userAgent.contains(WEIXIN_USER_AGENT)){
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 对请求参数按微信的签名规则进行签名
	 * @param data 待签名数据
	 * @param key 签名的key
	 */
	public static String sign(Object data, String key){
		String signVale = signValue(data);
		signVale = signVale + "&key=" + key;
		
		LOG.debug(signVale);
		
		String sign = md5(signVale).toUpperCase();
		LOG.debug(sign);
		return sign;
	}
	
	/**
	 * JS请求参数的sha1签名
	 * @param data 待签名数据
	 * @return
	 */
	public static String jsSign(Object data){
		String signVale = signValue(data);
		LOG.debug(signVale);
		String sign = sha1(signVale);
		LOG.debug(sign);
		return sign;
	}
	
	/**
	 * 将待签名对象转换为待签名字符串
	 * @param data 待签名数据
	 * @return
	 */
	protected static String signValue(Object data){
		Class<?> cls = data.getClass();
		SortedMap<String, String> sortMap = new TreeMap<String, String>();
		Field[] fs = null;
		JsonProperty annot = null;
		NoSign noSign = null;
		Object objValue = null;
		String paramName = null;
		while(!cls.equals(Object.class)){
			fs = cls.getDeclaredFields();
			for(Field f : fs){
				if(Modifier.isStatic(f.getModifiers()))
					break;
				try {
					f.setAccessible(true);
					objValue = f.get(data);
					noSign = f.getAnnotation(NoSign.class);
					if(objValue != null 
							&& StringUtils.isNotBlank(objValue.toString()) 
							&& noSign == null){
						annot = f.getAnnotation(JsonProperty.class);
						if(annot != null){
							paramName = annot.value();
						}else{
							paramName = f.getName();
						}
						sortMap.put(paramName, objValue.toString());
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					LOG.error(e.getMessage());
				}
			}
			cls = cls.getSuperclass();
		}
		StringBuilder sb = new StringBuilder();
		for(Entry<String, String> entry : sortMap.entrySet()){
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		String str = sb.toString();
		return str.substring(0, str.lastIndexOf("&"));
	}
	
	/**
	 * 随机字符串
	 * @param length 随机字符串长度
	 * @return 随机字符串
	 */
	public static String randomString(int length) {      
	    StringBuffer sb = new StringBuffer();    
	    Random r = new Random();    
	    int range = TEMPLATE.length();    
	    for (int i = 0; i < length; i ++) {    
	        sb.append(TEMPLATE.charAt(r.nextInt(range)));    
	    }    
	    return sb.toString();    
	}
	
	/**
	 * 生成二维码
	 * @param content
	 * @param width
	 * @param height
	 * @return
	 */
	public static byte[] qrCode(String content,String fomat,int width,int height){
		// 对内容按指定大小进行编码
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
		} catch (WriterException e) {
			LOG.error(e.getMessage());
		}
		// 生成图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
		     for (int y = 0; y < height; y++) {
		          image.setRGB(x, y, bitMatrix.get(x, y) == true ? BLACK : WHITE);
		     }
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try {
			ImageIO.write(image, fomat, output);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return output.toByteArray();
	}
	
	/**
	 * 将图文素材转换为对应类型的被动回复消息
	 * @param material 图文素材
	 * @return
	 */
	public static NewsReply materialToReply(NewsMaterial material){
		NewsReply reply = null;
		if(material != null){
			reply = new NewsReply();
			NewsItem it = null;
			List<NewsItem> list = new ArrayList<NewsItem>();
			for(NewsMaterialItem item : material.getNewsItem()){
				it = new NewsItem();
				it.setDescription(item.getDigest());
				it.setTitle(item.getTitle());
				it.setPicUrl(item.getThumbUrl());
				it.setUrl(item.getUrl());
				list.add(it);
			}
			reply.setArticles(list);
			reply.setArticleCount(material.getNewsItem().size());
			reply.setMsgType(EnumMsgType.news.toString());
			reply.setCreateTime(Calendar.getInstance().getTimeInMillis());
		}
		return reply;
	}
	
	/**
	 * 新建内容类型
	 * @param type 微信支持的媒体类型枚举
	 * @return 
	 */
	public static ContentType createContentType(EnumMaterialContentType type){
		ContentType contentType = null;
		String chartset = "UTF-8";
		switch(type){
		case image_bmp:
			contentType = ContentType.create("image/bmp",chartset);
			break;
		case audio_amr:
			contentType = ContentType.create("audio/amr",chartset);
			break;
		case audio_mpeg:
			contentType = ContentType.create("audio/mpeg",chartset);
			break;
		case image_gif:
			contentType = ContentType.create("image/gif",chartset);
			break;
		case image_jpeg:
			contentType = ContentType.create("image/jpeg",chartset);
			break;
		case image_png:
			contentType = ContentType.create("image/png",chartset);
			break;
		case video_mp4:
			contentType = ContentType.create("video/mp4",chartset);
			break;
			default:
				contentType = ContentType.create("image/jpeg",chartset);
				break;
		}
		return contentType;
	}
	
	/**
	 * 根据媒体类型生成对应媒体文件的后缀名
	 * @param type 微信支持的媒体类型枚举
	 * @return
	 */
	public static String createFileSuffix(EnumMaterialContentType type){
		String suffixFile = "";
		switch(type){
		case audio_amr:
			suffixFile = ".amr";
			break;
		case audio_mpeg:
			suffixFile = ".mp3";
			break;
		case image_bmp:
			suffixFile = ".bmp";
			break;
		case image_gif:
			suffixFile = ".gif";
			break;
		case image_jpeg:
			suffixFile = ".jpeg";
			break;
		case image_png:
			suffixFile = ".png";
			break;
		case video_mp4:
			suffixFile = ".mp4";
			break;
			default:
				suffixFile = ".jpeg";
				break;
		}
		return suffixFile;
	}
}
