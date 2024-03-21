package com.project.Vertex.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Logger LOGGER = Logger.getLogger(CustomSuccessHandler.class.getName());


	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
		// Retrieve authorities (roles) of the authenticated user
	    var authourities = authentication.getAuthorities();
		var roles = authourities.stream().map(r ->
				r.getAuthority()).findFirst();
		if (roles.orElse("").equals("admin")){
			response.sendRedirect("/main");
		} else if (roles.orElse("").equals("user")) {
			response.sendRedirect("/usersuccess");
		} else {
			response.sendRedirect("/error");
		}
	}
}
