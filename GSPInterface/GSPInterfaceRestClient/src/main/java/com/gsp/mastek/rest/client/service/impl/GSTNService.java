package com.gsp.mastek.rest.client.service.impl;

import java.util.Map;

import com.gsp.mastek.common.basevo.Result;
import com.gsp.mastek.rest.client.vo.GSTNAuthRequestVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST; 


public interface GSTNService {	
	
	 @POST("v0.2/authenticate")
	 Call<Result<String>> register(@HeaderMap Map<String, String> headers,@Body GSTNAuthRequestVO input);
    
}
