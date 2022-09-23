package com.dxctechproject.busticketbooking.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    /* This is for Exceptions */

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
