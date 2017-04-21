package com.gsp.mastek.rest.client.service.impl;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsp.mastek.rest.client.interceptor.LoggingInterceptor;
import com.gsp.mastek.rest.client.interceptor.RequestHeaderInterceptor;
import com.gsp.mastek.rest.client.util.GSPResourceBundler;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *   
 *   
 */
public class GSTNServiceServer {
	private static final Logger logger = Logger.getLogger(GSTNServiceServer.class);
	
	public static final String proxyEnabled = GSPResourceBundler.getStringResource("proxy.enabled");
	public static final String proxyUrl = GSPResourceBundler.getStringResource("proxy.url");
	public static final String proxyPort = GSPResourceBundler.getStringResource("proxy.port");
	public static final String gstnBaseUrl = GSPResourceBundler.getStringResource("gstn.appl.url");
	
	@Autowired
	private RequestHeaderInterceptor requestHeaderInterceptor;	

	public GSTNService getServer() {	
	    final OkHttpClient okHttpClient = buildOkHttpClient();
		logger.info("okHttpClient built");
		Retrofit server = new Retrofit.Builder().baseUrl(gstnBaseUrl)
				.addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
		logger.info("Retrofit server built");

		GSTNService gstnService = server.create(GSTNService.class);
		logger.info("Returning GSTNService service");
		return gstnService;
	}

	private OkHttpClient buildOkHttpClient() {
		logger.info("proxyEnabled" + proxyEnabled);
		if(Boolean.parseBoolean(proxyEnabled)){
			java.net.Proxy proxy = new Proxy(Proxy.Type.HTTP,
					new InetSocketAddress(proxyUrl, Integer.parseInt(proxyPort)));
			
			return new OkHttpClient.Builder().proxy(proxy).readTimeout(160, TimeUnit.SECONDS)
			.connectTimeout(100, TimeUnit.SECONDS).addInterceptor(new RequestHeaderInterceptor())
			.addInterceptor(new LoggingInterceptor()).build();
			
		}else{
			return new OkHttpClient.Builder().readTimeout(160, TimeUnit.SECONDS)
					.connectTimeout(100, TimeUnit.SECONDS).addInterceptor(new RequestHeaderInterceptor())
					.addInterceptor(new LoggingInterceptor()).build();
		}
		
	}

}
