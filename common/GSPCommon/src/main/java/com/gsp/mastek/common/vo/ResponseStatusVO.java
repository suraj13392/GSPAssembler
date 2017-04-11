/**
 * 
 */
package com.gsp.mastek.common.vo;

/**
 * @author shivkumarg
 *
 */
public class ResponseStatusVO {

	private String status;

	private String refNumber;

	/**
	 * 
	 */
	public ResponseStatusVO() {
		super();
	}

	/**
	 * @param status
	 * @param
	 */
	public ResponseStatusVO(String status, String refNumber) {
		super();
		this.status = status;
		this.refNumber = refNumber;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the refNumber
	 */
	public String getRefNumber() {
		return refNumber;
	}

	/**
	 * @param refNumber
	 *            the refNumber to set
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseStatusVO [status=" + status + ", refNumber=" + refNumber + "]";
	}

}
