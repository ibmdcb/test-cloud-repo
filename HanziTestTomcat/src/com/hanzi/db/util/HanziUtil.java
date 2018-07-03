package com.hanzi.db.util;

import java.io.UnsupportedEncodingException;

public class HanziUtil {

	public static String convertToUTF (String toRead) throws UnsupportedEncodingException {
		String ret = null;
		if ( toRead != null ){
			byte[] jiema = toRead.getBytes ("iso8859-1"); 
			ret = new String (jiema, "UTF-8");// 
		}
		return ret;
	}
	
	public static String convertStringArray (String[] toRead) {
		String ret = null;
		if ( toRead != null ){
			StringBuffer buf = new StringBuffer(256);
			for ( int i = 0; i < toRead.length; i++) {
				buf.append(toRead[i]);
			}
			ret = buf.toString();
		}
		return ret;
	}
}
