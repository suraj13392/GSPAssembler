package com.gsp.mastek.rest.client.otpreq;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsp.mastek.common.basevo.Result;
import com.gsp.mastek.common.service.ServiceInvoker;
import com.gsp.mastek.rest.client.common.ICConstants.APIActions;
import com.gsp.mastek.rest.client.service.BaseAuthRequestServiceInvoker;
import com.gsp.mastek.rest.client.service.impl.GSTNService;
import com.gsp.mastek.rest.client.service.impl.GetGSTNServices;
import com.gsp.mastek.rest.client.vo.GSTNAuthReqHeaderWrapper;
import com.gsp.mastek.rest.client.vo.GSTNAuthRequestVO;

import retrofit2.Response;

public class OTPRequestServiceInvoker extends BaseAuthRequestServiceInvoker implements ServiceInvoker{
	@Autowired
	private GSTNService gstnService;
	
	@Override
	public Object invokeService(Object request) throws Exception {
		GSTNAuthReqHeaderWrapper<GSTNAuthRequestVO> input = (GSTNAuthReqHeaderWrapper<GSTNAuthRequestVO>) request;
		GSTNAuthRequestVO gstnAuthRequestVO = input.getReqData();
		gstnAuthRequestVO.setAction(APIActions.OTPREQUEST);
		gstnAuthRequestVO.setApp_key(appkeyEncrypted);
		Response<Result<String>> result = gstnService.register(input.getHeaders(),gstnAuthRequestVO).execute();
		System.out.println("OTPRequestServiceInvoker : invokeService " + result);
		System.out.println("OTPRequestServiceInvoker : invokeService " + result.message());
		return result;
	}

}
