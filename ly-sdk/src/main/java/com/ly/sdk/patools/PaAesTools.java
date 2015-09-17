package com.ly.sdk.patools;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.ly.sdk.env.EnvProperties;
import com.ly.sdk.utils.LeyaConstantUtils;

/**
 * 
 * <p>
 * ClassName: PaAesTools
 * </p>
 * <p>
 * Description: 平安加解密通用类
 * </p>
 * <p>
 * Author: Administrator
 * </p>
 * <p>
 * Date: 2015年9月15日
 * </p>
 */
public class PaAesTools {
	/**
	 * z在配置文件中定义的 私钥key值
	 */
	private static final String PA_CHILDREN_DENTAL_KEY = "pa_dental_key";

	// 密钥算法
	private static final String KEY_ALGORITHM = "AES";

	private static final String ENCRYPT_ENCODING = "GBK";

	/**
	 * @description AES加密
	 * @author WANGYAN200
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] encrypt(String content, String password) {
		try {
			Key key = getKey();
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
			byte[] byteContent = content.getBytes(ENCRYPT_ENCODING);
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Key getKey() throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.setSeed(getKeyByStr(getPassword()));
		kgen.init(128, random);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		return new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
	}

	/**
	 * @description AES解密
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] decrypt(byte[] content, String password) {
		try {
			Key key = getKey();
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] getKeyByStr(String str) {
		byte[] bRet = new byte[str.length() / 2];

		for (int i = 0; i < str.length() / 2; i++) {
			Integer itg = new Integer(16 * getChrInt(str.charAt(2 * i))
					+ getChrInt(str.charAt(2 * i + 1)));
			bRet[i] = itg.byteValue();
		}
		return bRet;
	}

	public static int getChrInt(char chr) {

		int iRet = 0;

		if (chr == "0".charAt(0))
			iRet = 0;

		if (chr == "1".charAt(0))
			iRet = 1;

		if (chr == "2".charAt(0))
			iRet = 2;

		if (chr == "3".charAt(0))
			iRet = 3;

		if (chr == "4".charAt(0))
			iRet = 4;

		if (chr == "5".charAt(0))
			iRet = 5;

		if (chr == "6".charAt(0))
			iRet = 6;

		if (chr == "7".charAt(0))
			iRet = 7;

		if (chr == "8".charAt(0))
			iRet = 8;

		if (chr == "9".charAt(0))
			iRet = 9;

		if (chr == "A".charAt(0))
			iRet = 10;

		if (chr == "B".charAt(0))
			iRet = 11;

		if (chr == "C".charAt(0))
			iRet = 12;

		if (chr == "D".charAt(0))
			iRet = 13;

		if (chr == "E".charAt(0))
			iRet = 14;

		if (chr == "F".charAt(0))
			iRet = 15;

		return iRet;
	}

	/**
	 * @description 解密加密串
	 * @param contents
	 *            加密串
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String decryptString(String contents) {
		String data ="";
		try{
			data = new String(decrypt(Base64.decodeBase64(contents), getPassword()),ENCRYPT_ENCODING);
			data = changeCharset(data,ENCRYPT_ENCODING,LeyaConstantUtils.DEFAULT_ENCODING);
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * @description 加密原始串 由于使用UTF-8编码 但是平安加密时使用GBK加密 不能修改
	 *              所以在此现将要加密的字符串进行转成GBK编码再加密
	 * @param contents
	 *            原始字符串
	 * @return
	 */
	public static String encryptString(String contents) {
		contents = changeCharset(contents,LeyaConstantUtils.DEFAULT_ENCODING,ENCRYPT_ENCODING);
		return Base64.encodeBase64String(encrypt(contents, getPassword()));
	}

	public static String getPassword() {
		return EnvProperties.get(PA_CHILDREN_DENTAL_KEY);
	}

	/**
	 * 
	 * @param contents
	 *            转码内容
	 * @return 转码后的内容
	 */
	private static String changeCharset(String contents,String oldChartset,String newChartset) {
		
		try {
			byte[] utfBytes = contents.getBytes(oldChartset);
			contents = new String(utfBytes, oldChartset);
			contents = new String(contents.getBytes(newChartset),newChartset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return contents;
	}

}
