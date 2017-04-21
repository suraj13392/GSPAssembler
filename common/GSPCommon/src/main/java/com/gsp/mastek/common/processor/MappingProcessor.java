package com.gsp.mastek.common.processor;

import com.gsp.mastek.common.mapper.DataEnricher;
import com.gsp.mastek.common.mapper.DataMapper;
import com.gsp.mastek.common.service.ServiceInvoker;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;

public interface MappingProcessor {
	
	public void setDataMapper(DataMapper mapper);
		
	public void setServiceInvoker(ServiceInvoker serviceInvoker);
	
	public void setServiceName(String serviceName);
	
	public String getServiceName();
	
	public OutwardDTO process(InwardDTO inwardDTO) throws Exception;

	public void setDataEnricher(DataEnricher dataEnricher);


}
