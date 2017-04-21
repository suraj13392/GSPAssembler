package com.gsp.mastek.rest.client.util;

import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/******************************************************************************
 * This EncryptionUtil class is used to encrypt the string using a public key
 * 
 * @author suraj13392
 * 
 ******************************************************************************/
public class EncryptionUtil {
	
	public static final String GSTN_PUBLIC_KEY_LOC_KEY = "gstn.credential.publickey.loc";

	private static PublicKey readPublicKey(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(filename);
		CertificateFactory f = CertificateFactory.getInstance("X.509");
		X509Certificate certificate = (X509Certificate) f.generateCertificate(fin);
		PublicKey pk = certificate.getPublicKey();
		return pk;

	}

	/**
	 * This method is used to encrypt the string , passed to it using a public
	 * key provided
	 * 
	 * @param planTextToEncrypt
	 *            : Text to encrypt
	 * @return :encrypted string
	 */
	public static String encrypt(byte[] plaintext) throws Exception, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		PublicKey key = readPublicKey(GSPResourceBundler.getStringResource(GSTN_PUBLIC_KEY_LOC_KEY));
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedByte = cipher.doFinal(plaintext);
		String encodedString = new String(java.util.Base64.getEncoder().encode(encryptedByte));
		return encodedString;
	}

	public static String generateEncAppkey(byte[] key) {
		try {
			return encrypt(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}