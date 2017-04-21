package com.gsp.mastek.rest.client.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gsp.mastek.rest.client.interceptor.LoggingInterceptor;
import com.gsp.mastek.rest.client.interceptor.RequestHeaderInterceptor;
import com.gsp.mastek.rest.client.service.impl.GSTNService;
import com.gsp.mastek.rest.client.service.impl.GSTNServiceServer;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfiguration {
    private static final Logger logger = Logger.getLogger(GSTNServiceServer.class);
	
	@Value("${proxy.enabled}")
	private String proxyEnabled;
	
	@Value("${proxy.url}")
	private String proxyUrl;
	
	@Value("${proxy.port}")
	private String proxyPort;
	
	@Value("${gstn.appl.url}")
	private String gstnBaseUrl;
	
	
	@Bean
    public OkHttpClient okHttpClient() {
		final OkHttpClient okHttpClient = buildOkHttpClient();
		logger.info("okHttpClient built");
		return okHttpClient;
    }
	
	@Bean	
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(gstnBaseUrl)
				.addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
    }
	
	@Bean	
    public GSTNService gstnService(Retrofit retrofit) {
        return retrofit.create(GSTNService.class);
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
