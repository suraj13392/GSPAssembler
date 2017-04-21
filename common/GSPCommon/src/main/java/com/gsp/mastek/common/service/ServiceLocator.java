/**
 * 
 */
package com.gsp.mastek.common.service;

import java.util.Map;

/**
 * @author shivkumarg
 *
 */

public abstract class ServiceLocator<T> {

	protected Map<T, IService> serviceRegistry;

	/**
	 * returns service for a given payment mode.
	 * 
	 * @param paymentMode
	 * @return
	 */
	public IService getService(T t) {
		return serviceRegistry.get(t);
	}

	public abstract void setServiceRegistry(Map<T, IService> serviceRegistry);

}
