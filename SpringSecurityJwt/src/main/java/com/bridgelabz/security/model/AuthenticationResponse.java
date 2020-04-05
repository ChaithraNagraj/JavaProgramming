package com.bridgelabz.security.model;

import java.io.Serializable;

public class AuthenticationResponse  implements Serializable{

	/**
	 * output structure
	 * here bwe are creating jw web token
	 * 
	 * this will invoke when a proper request get launched
	 * means to send a proper response to client
	 */
	private static final long serialVersionUID=1L;
	
	private final String jwt;
	public AuthenticationResponse(String jwt) {
		this.jwt=jwt;
	}
	public String getJwt() {
		return jwt;
	}
}
