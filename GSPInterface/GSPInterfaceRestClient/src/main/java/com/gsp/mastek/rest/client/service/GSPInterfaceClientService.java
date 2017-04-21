package com.gsp.mastek.rest.client.service;

import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;

public interface GSPInterfaceClientService {
	public OutwardDTO requestService(String serviceName, InwardDTO inwardDTO) throws Exception;
}
