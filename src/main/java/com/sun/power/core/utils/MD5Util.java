package com.sun.power.core.utils;

import java.security.MessageDigest;

public class MD5Util {

	public static String MD5(String s) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// 可逆的加密算法
	public   static  String KL(String inStr) {
		// String s = new String(inStr);
		char [] a = inStr.toCharArray();
		for  ( int  i =  0 ; i < a.length; i++) {
			a[i] = (char ) (a[i] ^  't' );
		}
		String s = new  String(a);
		return  s;
	}

	// 加密后解密
	public   static  String JM(String inStr) {
		char [] a = inStr.toCharArray();
		for  ( int  i =  0 ; i < a.length; i++) {
			a[i] = (char ) (a[i] ^  't' );
		}
		String k = new  String(a);
		return  k;
	}
	
	public static void main(String[] args) {
		String a = "610622199308230319";
		String  b = a.substring(6,14);

		System.out.println(b);
//		String md5 = MD5Util.MD5("123456");
//		System.out.println(md5);
//		String s1="1234sad562321";
//		byte[] buf= Base64.encodeBase64(s1.getBytes());
//		String s2=new String(buf);
//		System.out.println(s2);
//
//		buf=Base64.decodeBase64(buf);
//		String s3= new String(buf);
//		System.out.println(s3);
//
//		System.out.println(UUIDGenerator.generate());
	}
}
