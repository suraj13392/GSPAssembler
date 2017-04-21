/**
 * 
 */
package com.gsp.mastek.common.service;

import com.gsp.mastek.common.vo.OutwardDTO;

/**
 * @author shivkumarg
 *
 */
public interface IService {

	public String getServiceName();

	public OutwardDTO execute(Object processorVO) throws Exception;
}
