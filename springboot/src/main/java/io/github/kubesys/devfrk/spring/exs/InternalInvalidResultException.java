/**
 * Copyright (2023, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubesys.devfrk.spring.exs;

import io.github.kubesys.devfrk.spring.constants.ExceptionConstants;
import io.github.kubesys.devfrk.tools.annotations.Description;

/**
 * @author wuheng@iscas.ac.cn
 * @since  2.0.0
 * 
 */
@Description(desc = "返回值错误", id = 303, see = ExceptionConstants.INVALID_REQUEST_RESULT)
public class InternalInvalidResultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1057346529882181459L;
	
	public InternalInvalidResultException() {
		super();
	}

	public InternalInvalidResultException(String message) {
		super(message);
	}

}
