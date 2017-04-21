package com.gsp.mastek.rest.client.otpreq;

import com.gsp.mastek.common.exception.DataMappingException;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.rest.client.common.BaseGSPDataMapper;
import com.gsp.mastek.rest.client.vo.GSTNAuthReqHeaderWrapper;
import com.gsp.mastek.rest.client.vo.GSTNAuthRequestVO;
import com.gsp.mastek.rest.client.vo.OTPRequestVO;

public class OTPReqDataMapper extends BaseGSPDataMapper {

	public Object mapRequestData(InwardDTO inwardDTO) throws DataMappingException {
		OTPRequestVO input = (OTPRequestVO) inwardDTO;
		
		GSTNAuthRequestVO gstnAuthRequestVO = new GSTNAuthRequestVO();
		gstnAuthRequestVO.setUsername(input.getUsername());
		
		GSTNAuthReqHeaderWrapper<GSTNAuthRequestVO> output = new GSTNAuthReqHeaderWrapper<GSTNAuthRequestVO>();
		output.setReqData(gstnAuthRequestVO);
		output.setHeaders(input.getHeaders());		
		return output;
	}

}