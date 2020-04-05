package com.bridgelabz.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.security.model.AuthenticationRequest;
import com.bridgelabz.security.model.AuthenticationResponse;
import com.bridgelabz.security.services.MyUserDetailsService;
import com.bridgelabz.security.util.JwtUtil;
/**
 * @RequestBody, Spring will bind the incoming HTTP request body(for the URL mentioned in 
 * @author admin
 *
 */
@RestController
public class HelloResource {
	@Autowired
	private AuthenticationManager authenticationManager;//member variable

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello world";
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
		System.out.println("Hello");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Incorrect username and password", e);
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
