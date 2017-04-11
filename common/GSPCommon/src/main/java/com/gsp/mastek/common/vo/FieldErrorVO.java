package com.gsp.mastek.common.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * Holds a field or form error
 * 
 */
public class FieldErrorVO {

	// Name of the field. Null in case of a form level error.
	private String field;

	// Error code. Typically the I18n message-code or key in property file.
	private String code;

	// Error message ..
	private String message;

	// arguments to be passed in property file while resolving message
	private Object[] args;

	public FieldErrorVO(String field, String code, String message) {
		this.field = field;
		this.code = code;
		this.message = message;
	}

	public FieldErrorVO(String field, String code, String message, Object[] args) {
		this.field = field;
		this.code = code;
		this.message = message;
		this.args = args;
	}

	public String getField() {
		return field;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * @return the args
	 */
	public Object[] getArgs() {
		return args;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FieldErrorVO [field=" + field + ", code=" + code + ", message=" + message + ", args="
				+ Arrays.toString(args) + "]";
	}

	/**
	 * Converts a set of ConstraintViolations to a list of FieldErrors
	 * 
	 * @param constraintViolations
	 */
	public static List<FieldErrorVO> getErrors(Set<ConstraintViolation<?>> constraintViolations) {
		List<FieldErrorVO> fieldErrors = new ArrayList<FieldErrorVO>();
		for (ConstraintViolation<?> obj : constraintViolations) {
			fieldErrors.add(of(obj));
		}
		return fieldErrors;
	}

	/**
	 * Converts a ConstraintViolation to a FieldError
	 */
	private static FieldErrorVO of(ConstraintViolation<?> constraintViolation) {
		String field = constraintViolation.getPropertyPath().toString();

		return new FieldErrorVO(field, constraintViolation.getMessageTemplate(), constraintViolation.getMessage());
	}
}
