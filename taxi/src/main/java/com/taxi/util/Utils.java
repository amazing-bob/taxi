package com.taxi.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	
	/**
	 * 설  명: MD5 암호
	 * 작성자: 김상헌
	 */
	static public String getHexMD5( String str ) {
		String encodStr = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update( str.getBytes() );
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			
			for ( int i = 0; i < byteData.length; i++ ) {
//				sb.append( String.format("%02x", 0xff&(char)byteData[i]) );
//				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));

				String hex=Integer.toHexString(0xff & byteData[i]);
	            if(hex.length()==1) sb.append('0');
	            sb.append(hex);
			}
			
			encodStr = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encodStr;
	}
}
