package com.gsp.mastek.rest.client.common;

import java.util.List;
import java.util.Map;

import javax.naming.ConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.gsp.mastek.common.processor.MappingProcessor;
import com.gsp.mastek.common.service.ServiceProcessor;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;

@Service("ProcessServiceRequest")
public class ProcessServiceRequestImpl implements ServiceProcessor {

	@Value("#{gspServiceProcessor}")
	private Map<String, MappingProcessor> serviceProcessor;

	private static final Logger logger = Logger.getLogger(ProcessServiceRequestImpl.class);

	public OutwardDTO requestService(String serviceName, InwardDTO inwardDTO) throws Exception {
		logger.debug("Starting request service : "+serviceName);
		logger.debug("Input Parameters : "+inwardDTO);
		Gson gson = new Gson();
		logger.debug("Inward DTO : "+gson.toJson(inwardDTO));

		OutwardDTO outwardDTO = null;
		if (!serviceProcessor.isEmpty() && serviceProcessor.get(serviceName) != null) {
			MappingProcessor mappingProcessor = serviceProcessor.get(serviceName);
			outwardDTO = mappingProcessor.process(inwardDTO);
		}		
		logger.debug("Output : "+outwardDTO);
		
		logger.debug("Outward DTO : "+gson.toJson(outwardDTO));
		logger.debug("completing request service : "+serviceName+"\n");
		return outwardDTO;
	}

	public void addMappingProcessor(MappingProcessor mappingProcessor) throws ConfigurationException {
		String serviceName = mappingProcessor.getServiceName();
		if (serviceProcessor.get(serviceName) == null) {
			serviceProcessor.put(serviceName, mappingProcessor);
		} else {
			throw new ConfigurationException("Service already configured");
		}
	}

	
	public void setProcessorList(List<MappingProcessor> mappingProcessorList) throws ConfigurationException {
		if (mappingProcessorList != null && mappingProcessorList.size() > 0) {
			for (int i = 0; i < mappingProcessorList.size(); i++) {
				addMappingProcessor(mappingProcessorList.get(i));
			}
		}
	}
}
