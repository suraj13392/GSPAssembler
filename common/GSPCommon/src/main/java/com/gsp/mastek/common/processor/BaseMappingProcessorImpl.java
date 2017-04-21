/**
 * 
 */
package com.gsp.mastek.common.processor;

import com.gsp.mastek.common.mapper.DataEnricher;
import com.gsp.mastek.common.mapper.DataMapper;
import com.gsp.mastek.common.service.ServiceInvoker;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;

public class BaseMappingProcessorImpl implements MappingProcessor {

	private DataMapper dataMapper = null;

	private DataEnricher dataEnricher = null;

	private ServiceInvoker serviceInvoker = null;

	private String serviceName = null;

	public OutwardDTO process(InwardDTO requestIn) throws Exception {
		InwardDTO inwardDTOReq = requestIn;
		OutwardDTO outwardDTOResp = null;
		if (dataEnricher != null) {
			inwardDTOReq = (InwardDTO) dataEnricher.performRequestDataEnrichment(inwardDTOReq);
		}

		Object request = dataMapper.mapRequestData(inwardDTOReq);
		Object response = serviceInvoker.invokeService(request);

		OutwardDTO mappedResponse = dataMapper.mapResponseData(response);
		outwardDTOResp = mappedResponse;

		if (dataEnricher != null) {
			outwardDTOResp = (OutwardDTO) dataEnricher.performResponseDataEnrichment(outwardDTOResp);
		}

		return outwardDTOResp;
	}

	
	public void setDataMapper(DataMapper mapper) {
		this.dataMapper = mapper;
	}

	
	public void setServiceInvoker(ServiceInvoker serviceInvoker) {
		this.serviceInvoker = serviceInvoker;
	}

	
	public void setDataEnricher(DataEnricher dataEnricher) {
		this.dataEnricher = dataEnricher;
	}

	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	
	public String getServiceName() {
		return serviceName;
	}

}
