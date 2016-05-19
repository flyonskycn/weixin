package com.flyonsky.weixin;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

/**
 * 微信相关的工具类
 * @author Administrator
 *
 */
public class WeixinUtil {
	
	private static final String WEIXIN_USER_AGENT = "MicroMessenger";
	
	
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

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
}
