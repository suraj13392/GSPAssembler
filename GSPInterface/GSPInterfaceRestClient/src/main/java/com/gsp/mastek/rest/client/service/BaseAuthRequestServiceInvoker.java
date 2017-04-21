package com.gsp.mastek.rest.client.service;

import com.gsp.mastek.rest.client.util.AESEncryption;

public class BaseAuthRequestServiceInvoker{
	protected static AESEncryption AESencObj = new AESEncryption();
	
	protected static String AppKey = AESEncryption.generateSecureKey();

	protected static String appkeyEncrypted = AESencObj.getEncryptedAppKey(AppKey);
}
