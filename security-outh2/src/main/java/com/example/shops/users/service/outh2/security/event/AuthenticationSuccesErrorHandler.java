package com.example.shops.users.service.outh2.security.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccesErrorHandler implements AuthenticationEventPublisher {
	private Logger log = LoggerFactory.getLogger(AuthenticationSuccesErrorHandler.class); 
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
		//if(authentication.getName().equalsIgnoreCase("frontendapp"))
		
		if(authentication.getDetails() instanceof WebAuthenticationDetails){
			return;
		}
		
		UserDetails avatar = (UserDetails) authentication.getPrincipal();
		String mensaje= "Successs Login: " + avatar.getUsername();
		System.out.println("Succes Login: " + avatar.getUsername());
		log.info(mensaje);
		
		
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String mensaje= "Error en el Login: " + exception.getMessage();
		log.error(mensaje);
		System.out.println(mensaje);
		
		
	}

}
