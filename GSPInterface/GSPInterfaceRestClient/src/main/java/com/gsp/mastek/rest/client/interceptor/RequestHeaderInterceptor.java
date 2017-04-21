package com.gsp.mastek.rest.client.interceptor;

import java.io.IOException;

import org.springframework.http.MediaType;

import com.gsp.mastek.rest.client.common.ICConstants.UserCredentials;
import com.gsp.mastek.rest.client.util.GSPResourceBundler;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestHeaderInterceptor implements Interceptor {
	public static final String CONTENT_TYPE_KEY = "Content-Type";
	public static final String CLIENT_ID_KEY = "clientid";
	public static final String CLIENT_SECRET_KEY = "client-secret";
	public static final String TXN_KEY = "txn";
	
	public static final String clientId = GSPResourceBundler.getStringResource("gstn.credential.clientid");
	public static final String clientSecret = GSPResourceBundler.getStringResource("gstn.credential.clientsecret");

	@Override
	public Response intercept(Interceptor.Chain chain) throws IOException {
		Request newRequest = chain.request().newBuilder().addHeader(CONTENT_TYPE_KEY, MediaType.APPLICATION_JSON_VALUE)
				.addHeader(CLIENT_ID_KEY, clientId)
				.addHeader(CLIENT_SECRET_KEY, clientSecret).addHeader(TXN_KEY, UserCredentials.TXN).build();

		return chain.proceed(newRequest);
	}
}