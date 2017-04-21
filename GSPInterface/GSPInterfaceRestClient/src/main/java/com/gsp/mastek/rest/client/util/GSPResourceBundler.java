package com.gsp.mastek.rest.client.util;

import java.util.ResourceBundle;

import com.gsp.mastek.common.CommonUtils;

public class GSPResourceBundler {
	
	public static final String APP_CONFIG_MSGS_BUNDLE_NAME = "env/" + CommonUtils.getEnvironmentName() + "/GSP_AppConfig";
	public static final ResourceBundle resourceBundle = ResourceBundle.getBundle(APP_CONFIG_MSGS_BUNDLE_NAME);
	
	public static String getStringResource(String key) {
		System.out.println("key " + key);
		String ret = "";

		if (resourceBundle.containsKey(key))
			ret = resourceBundle.getString(key);
		else
			ret = key;

		return ret;
	}

}
