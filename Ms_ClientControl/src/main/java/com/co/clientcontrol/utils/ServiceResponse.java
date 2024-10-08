package com.co.clientcontrol.utils;

import java.io.Serializable;

import lombok.Data;

@Data
public class ServiceResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Data object generated by each method implemented in the microservice
	 */
	private Object object;

	/**
	 * Boolean.
	 * defines the state of the method call
	 */
	private Boolean status;

	/**
	 * code associated with the response
	 */
	private String codeResponse;

	/**
	 * Description associated with each response
	 */
	private String descriptionResponse;

	/**
	 * description associated with the exception
	 */
	private String descriptionException;

	/**
	 * port associated with the microservice. used to verify load balancing between
	 * microservices.
	 */
	private int port;

}
