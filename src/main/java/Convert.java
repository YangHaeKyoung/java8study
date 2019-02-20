/*
 * @(#) Convert.java 2012. 8. 24
 *
 * Copyright 2007 NHN Corp. All rights Reserved.
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;


/**
 * @author chang1216
 *
 * 이 생성된 유형 주석에 대한 템플리트를 변경하려면 다음으로 이동하십시오.
 * 창&gt;환경설정&gt;Java&gt;코드 생성&gt;코드 및 주석
 */
@Component
public class Convert {
	
	private static byte[] cryptAesOutsystemKey;	
	
	private static String keyName = "outsysteminterfa";	//개발
	//private static String keyName = "outsystemIF!@#$%";//운영


	public Convert() {
//		synchronized (this) {
//			Convert.instance = this;
//		}
	}

	@PostConstruct
	public void loadSymkey() throws IOException, GeneralSecurityException {		
		
	}

	 public static void main(String[] args) throws Exception {
		  // TODO Auto-generated method stub
		 cryptAesOutsystemKey = keyName.getBytes();
		 Convert f = new Convert(); 
		 
		 String testResult = f.encryptMsgAES("NB11657");
		  
		  System.out.println("1:" +testResult);
		  
		  System.out.println("2:" +f.decryptMsgAES(testResult));
		  
		  
		  
		  String testResult2 = f.encryptMsgAES("dev-nb11657@navercorp.com");
		  
		  System.out.println("3:" +testResult2);
		  
		  System.out.println("4:" +f.decryptMsgAES(testResult2));
		 
		  
		  
		 }




	 /**
		 * 인사시스템 공통 암호화 처리
		 * @param key
		 * @param msg
		 * @param charset
		 * @return
		 */
		private static String _encryptMsgCoreAES(byte[] key, String msg, Charset charset) {
			String retMessage = "";
			if (StringUtils.isEmpty(msg)) {
				return retMessage;
			}
			try {
				if (charset == null) {
					charset = StandardCharsets.UTF_8;
				}
				
				System.err.println("key==================" + new String(key));

				AESCipher cipher = new AESCipher(key);
				byte[] msgBytes = (charset == null) ? msg.getBytes() : msg.getBytes(charset);
				byte[] encryptedMsg = cipher.encrypt(msgBytes);
				retMessage = byteArrayToHex(encryptedMsg);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return retMessage;
		}

		/**
		 * byte[]를 16진수 문자열로 변환
		 *
		 * @param ba byte array
		 * @return 16진수 문자열
		 */
		private static String byteArrayToHex(byte[] ba) {
			if (ba == null || ba.length == 0) {
				return null;
			}

			StringBuffer sb = new StringBuffer(ba.length * 2);
			String hexNumber;

			for (int x = 0; x < ba.length; x++) {
				hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
				sb.append(hexNumber.substring(hexNumber.length() - 2));
			}

			return sb.toString();
		}
		/**
		 * 인사시스템 공통 복호화 처리
		 * @param key
		 * @param msg
		 * @param charset
		 * @return
		 */
		private static String _decryptMsgCoreAES(byte[] key, String msg, Charset charset) {
			String retMessage = "";
			if (StringUtils.isEmpty(msg)) {
				return retMessage;
			}
			try {
				AESCipher cipher = new AESCipher(key);

				if (charset == null) {
					charset = StandardCharsets.UTF_8;
				}
				byte[] decryptedMsg = cipher.decrypt(hexToByteArray(msg));
				if (charset == null) {
					retMessage = new String(decryptedMsg);
				} else {
					retMessage = new String(decryptedMsg, charset);
				}
			

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return retMessage;
		}
		
		
	/**
	 * 16진수 문자열을 byte[]로 변환
	 *
	 * @param hex 16진수 문자열
	 * @return byte array
	 */
	private static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() == 0) {
			return null;
		}

		byte[] ba = new byte[hex.length() / 2];

		for (int i = 0; i < ba.length; i++) {
			ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}

		return ba;
	}


	/**
	 * AES msg를 암호화 한다.
	 * @param msg
	 * @return
	 */
	public static String encryptMsgAES(String msg) {
		return _encryptMsgCoreAES(Convert.cryptAesOutsystemKey, msg, null);
	}
	public static String encryptMsgAES(String msg, Charset charset) {
		return _encryptMsgCoreAES(Convert.cryptAesOutsystemKey, msg, charset);
	}
	


	/**
	 * AES msg를 복호화 해준다.
	 * @param msg
	 * @return
	 */
	public static String decryptMsgAES(String msg) {
		return _decryptMsgCoreAES(Convert.cryptAesOutsystemKey, msg, null);
	}
	public static String decryptMsgAES(String msg, Charset charset) {
		return _decryptMsgCoreAES(Convert.cryptAesOutsystemKey, msg, charset);
	}
	
	


	/**
	 * 암호화 SHA-256 해시 방식
	 * @param msg
	 * @return
	 
	public static String encryptMsgSHA256(String msg) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(msg.getBytes());
			byte byteData[] = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return sb.toString();
	}*/

	



	/**
	 * 16진수 문자열을 byte[]로 변환
	 *
	 * @param hex 16진수 문자열
	 * @return byte array
	 
	private static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() == 0) {
			return null;
		}

		byte[] ba = new byte[hex.length() / 2];

		for (int i = 0; i < ba.length; i++) {
			ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}

		return ba;
	}*/

	/**
	 * byte[]를 16진수 문자열로 변환
	 *
	 * @param ba byte array
	 * @return 16진수 문자열
	 
	private static String byteArrayToHex(byte[] ba) {
		if (ba == null || ba.length == 0) {
			return null;
		}

		StringBuffer sb = new StringBuffer(ba.length * 2);
		String hexNumber;

		for (int x = 0; x < ba.length; x++) {
			hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
			sb.append(hexNumber.substring(hexNumber.length() - 2));
		}

		return sb.toString();
	}*/
}
