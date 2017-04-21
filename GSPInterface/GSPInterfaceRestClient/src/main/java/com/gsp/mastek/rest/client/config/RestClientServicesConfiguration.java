package com.gsp.mastek.rest.client.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gsp.mastek.common.mapper.DataMapper;
import com.gsp.mastek.common.processor.BaseMappingProcessorImpl;
import com.gsp.mastek.common.processor.MappingProcessor;
import com.gsp.mastek.common.service.ServiceInvoker;
import com.gsp.mastek.rest.client.common.GSPInterfaceConstant;
import com.gsp.mastek.rest.client.otpreq.OTPReqDataMapper;
import com.gsp.mastek.rest.client.otpreq.OTPRequestServiceInvoker;

@Configuration
public class RestClientServicesConfiguration {	

	@Bean
	public ServiceInvoker OTPRequestServiceInvoker() {
		ServiceInvoker invoker = new OTPRequestServiceInvoker();
		return invoker;
	}

	@Bean
	public DataMapper OTPRequestDataMapper() {
		DataMapper dataMapper = new OTPReqDataMapper();
		return dataMapper;
	}

	@Bean
	public MappingProcessor OTPRequestService() {
		MappingProcessor mappingProcessor = new BaseMappingProcessorImpl();
		mappingProcessor.setServiceName(GSPInterfaceConstant.ServiceName.OTPRequestService);
		mappingProcessor.setDataMapper(OTPRequestDataMapper());
		mappingProcessor.setServiceInvoker(OTPRequestServiceInvoker());
		return mappingProcessor;
	}

	@Bean(name = "gspServiceProcessor")
	public Map<String, MappingProcessor> gspServiceProcessor() {
		Map<String, MappingProcessor> serviceProcessor = new HashMap<String, MappingProcessor>();
		serviceProcessor.put(GSPInterfaceConstant.ServiceName.OTPRequestService, OTPRequestService());
		return serviceProcessor;
	}

}
