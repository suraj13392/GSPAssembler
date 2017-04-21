package com.gsp.mastek.common.mapper;

import com.gsp.mastek.common.exception.DataMappingException;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;

public interface DataMapper {
	
	public Object mapRequestData(InwardDTO inwardDTO) throws DataMappingException;
	public OutwardDTO mapResponseData(Object object) throws DataMappingException;

}
