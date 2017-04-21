package com.gsp.mastek.common.service;

import java.util.List;

import javax.naming.ConfigurationException;

import com.gsp.mastek.common.processor.MappingProcessor;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;

public interface ServiceProcessor {
	
	public OutwardDTO requestService(String serviceName, InwardDTO inwardDTO) throws Exception;
	public void setProcessorList(List<MappingProcessor> mappingProcessorList) throws ConfigurationException;	
}
