package com.gsp.mastek.common.mapper;

import com.gsp.mastek.common.exception.DataEnrichmentException;
import com.gsp.mastek.common.vo.AdapterBaseDTO;

public interface DataEnricher {
	
	public AdapterBaseDTO performRequestDataEnrichment(AdapterBaseDTO gspClientBaseDTO) throws DataEnrichmentException;
	public AdapterBaseDTO performResponseDataEnrichment(AdapterBaseDTO gspClientBaseDTO) throws DataEnrichmentException;

}
