package com.gsp.mastek.rest.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gsp.mastek.common.service.ServiceProcessor;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;
import com.gsp.mastek.rest.client.service.GSPInterfaceClientService;

@Service
public class GSPInterfaceClientServiceImpl implements GSPInterfaceClientService{

	@Autowired
	@Qualifier("ProcessServiceRequest")
	private ServiceProcessor serviceProcessor = null;
	
	@Override
	public OutwardDTO requestService(String serviceName, InwardDTO inwardDTO) throws Exception {
		OutwardDTO outwardDTO = serviceProcessor.requestService(serviceName,inwardDTO);
		return outwardDTO;
	}
	
}
