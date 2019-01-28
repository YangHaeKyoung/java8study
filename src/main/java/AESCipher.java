/*
 * @(#) AESCipher.java 2012. 8. 24 
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



/**
 * AES Algorithm을 이용한  암호화 클래스이다.
 * 
 * AES Provider : SunJCE
 * chaining mode : ECB / CBC
 * padding : PKCS5PADDING 
 *
 */
public class AESCipher {
	private final String providerName = "SunJCE";
	private final String algorithmName = "AES";
	private final String transformationNameECB = "AES/ECB/PKCS5PADDING";	// 평문을 1 block 당 순차적으로 암호화 처리, 보안 취약
	
	private Cipher cipher;
	private SecretKeySpec keySpec;
	private IvParameterSpec ivSpec;

	/**
	 * @param key 반드시 128 bit(16bytes)가 되어야한다. (jar 패치하면  다른 bit도 가능하나 패치없이 하기 위해.)
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 */
	public AESCipher(byte[] key) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException {
		
		System.out.println( "key" +  key );
		System.out.println( key.length);
		if (key == null || key.length != 16) {
			throw new InvalidKeyException("유효하지 않은 Key 입니다. Key의 길이는 반드시 16 bytes가 되어야 합니다.");
		}
		
		String transfformationName = transformationNameECB;
	
		
		this.cipher = Cipher.getInstance(transfformationName, providerName);
		this.keySpec = new SecretKeySpec(key, algorithmName);
	}
	
	/**
	 * 복호화
	 * @param message
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException 
	 */
	public byte[] encrypt(byte[] message) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
		return cipher.doFinal(message);
	}

	/**
	 * 암호화
	 * @param encryptedMessage
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException 
	 */
	public byte[] decrypt(byte[] encryptedMessage) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		return cipher.doFinal(encryptedMessage);
	}
	
}
