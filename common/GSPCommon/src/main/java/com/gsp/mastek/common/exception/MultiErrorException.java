package com.gsp.mastek.common.exception;

import java.util.ArrayList;
import java.util.List;

import com.gsp.mastek.common.vo.FieldErrorVO;


/**
*
 */
public class MultiErrorException extends RuntimeException {

	private static final long serialVersionUID = 6020532846519363456L;

	// list of errors
	private List<FieldErrorVO> errors = new ArrayList<FieldErrorVO>(10);

	public List<FieldErrorVO> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<FieldErrorVO> errors) {
		this.errors = errors;
	}

	/**
	 * Overrides the standard getMessage
	 */
	@Override
	public String getMessage() {

		if (errors.size() == 0)
			return null;

		// return the first message
		return errors.get(0).getMessage();
	}

	/**
	 * Adds a global-error if the given condition isn't true
	 * 
	 * @param valid
	 *            the given condition
	 * @param messageKey
	 *            message key
	 * @param message
	 *            This is optional message if message key's value not defined in
	 *            property file.
	 * 
	 * @return the exception object
	 */
	public MultiErrorException check(boolean valid, String messageKey, String message) {

		// delegate
		return check(null, valid, messageKey, message);
	}

	/**
	 * Adds a field-error if the given condition isn't true
	 * 
	 * @param fieldName
	 *            the name of the associated field
	 * @param valid
	 *            the given condition
	 * @param messageKey
	 *            message key
	 * @param message
	 *            This is optional message if message key's value not defined in
	 *            property file.
	 * 
	 * @return the exception object
	 */
	public MultiErrorException check(String fieldName, boolean valid, String messageKey, String message) {

		if (!valid)
			errors.add(new FieldErrorVO(fieldName, messageKey, message));

		return this;
	}

	
	/**
	 * Factory method for a field-level error
	 * 
	 * @param fieldName
	 *            the name of the associated field
	 * @param messageKey
	 *            message key
	 * 
	 * @return the exception object
	 */
	public static MultiErrorException getExceptionInstanceWithMessageKey(String fieldName, String messageKey) {

		MultiErrorException exception = new MultiErrorException();
		exception.errors.add(new FieldErrorVO(fieldName, messageKey, null));
		return exception;
	}

	/**
	 * Factory method for a field-level error
	 * 
	 * @param fieldName
	 *            the name of the associated field
	 * @param message
	 *            message.
	 * 
	 * @return the exception object
	 */
	public static MultiErrorException getExceptionInstanceWithMessage(String fieldName, String message) {

		MultiErrorException exception = new MultiErrorException();
		exception.errors.add(new FieldErrorVO(fieldName, null, message));
		return exception;
	}
	

	/**
	 * Factory method for a global-level error
	 * 
	 * @param messageKey
	 *            message key
	 * @param message
	 *            This is optional message if message key's value not defined in
	 *            property file.
	 * 
	 * @return the exception object
	 */
	public static MultiErrorException of(List<FieldErrorVO> errors) {
		MultiErrorException exception = new MultiErrorException();
		exception.setErrors(errors);
		return exception;
	}

	/**
	 * Throws the exception, if there are accumulated errors
	 */
	public void go() {
		if (errors.size() > 0)
			throw this;
	}

}
